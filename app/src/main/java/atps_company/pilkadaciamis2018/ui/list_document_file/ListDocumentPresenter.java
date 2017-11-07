package atps_company.pilkadaciamis2018.ui.list_document_file;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import atps_company.pilkadaciamis2018.model.CalonPasangan;
import atps_company.pilkadaciamis2018.model.Dokumen;
import atps_company.pilkadaciamis2018.ui.base.BasePresenter;
import atps_company.pilkadaciamis2018.ui.calon_pasangan.CalonPasanganMvpPresenter;
import atps_company.pilkadaciamis2018.ui.calon_pasangan.CalonPasanganMvpView;

/**
 * Created by emerio on 11/6/17.
 */

public class ListDocumentPresenter  <V extends ListDocumentMvpView> extends BasePresenter<V> implements ListDocumentMvpPresenter<V> {

    FirebaseDatabase firebaseDatabase;
    boolean status=false;
    FirebaseAuth firebaseAuth;
    DatabaseReference dataReferences;

    @Inject
    public ListDocumentPresenter(FirebaseDatabase firebaseDatabase) {
        this.firebaseDatabase=firebaseDatabase;
        this.firebaseDatabase=FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        dataReferences=this.firebaseDatabase.getReference("dokumen");
    }

    @Override
    public void loadDataFile() {
        getMvpView().showLoading();
        final ValueEventListener dataFetchEventListener =new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                status=true;
                Log.d("data calon pas: ",dataSnapshot.toString());
                List<Dokumen> dokumenList=new ArrayList<Dokumen>();
                Dokumen dokumen=null;
                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                    dokumen = singleSnapshot.getValue(Dokumen.class);
                    dokumenList.add(dokumen);
                }
                if (dokumenList.size()>0) {
                    getMvpView().showDataFile(dokumenList);
                    getMvpView().hideLoading();
                }else {
                    getMvpView().showMessage("data kosong.");
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                status = true;
                System.out.println("The read failed: " + databaseError.getMessage());
                getMvpView().hideLoading();
            }
        };
        dataReferences.addListenerForSingleValueEvent(dataFetchEventListener);
        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (!status){
                    getMvpView().hideLoading();
                    getMvpView().onError("not internet connection, please try again.");
                    Log.d("status",String.valueOf(status));
                }
            }
        };
        timer.schedule(timerTask, 10000L);
    }


    @Override
    public void notConnection() {
        getMvpView().onError("Not Connection Internet.");
    }

}
