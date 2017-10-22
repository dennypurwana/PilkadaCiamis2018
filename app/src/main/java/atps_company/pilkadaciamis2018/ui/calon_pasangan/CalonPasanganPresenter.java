package atps_company.pilkadaciamis2018.ui.calon_pasangan;

import android.content.Context;
import android.net.ConnectivityManager;
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

import atps_company.pilkadaciamis2018.ui.base.BasePresenter;
import atps_company.pilkadaciamis2018.util.NetworkUtils;

/**
 * Created by emerio on 10/10/17.
 */

public class CalonPasanganPresenter <V extends CalonPasanganMvpView> extends BasePresenter<V> implements CalonPasanganMvpPresenter<V> {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference dataReferences;
    FirebaseAuth firebaseAuth;
    boolean status=false;

    @Inject
    public CalonPasanganPresenter(FirebaseDatabase firebaseDatabase){
        this.firebaseDatabase=firebaseDatabase;
        this.firebaseDatabase=FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        dataReferences=this.firebaseDatabase.getReference("calonPasangan");

    }

    @Override
    public void loadDataCalonPasangan() {
        getMvpView().showLoading();
       final  ValueEventListener dataFetchEventListener =new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                status=true;
                Log.d("data calon pas: ",dataSnapshot.toString());
                List<CalonPasangan> calonPasanganList=new ArrayList<CalonPasangan>();
                CalonPasangan calonPasangan=null;
                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                    calonPasangan = singleSnapshot.getValue(CalonPasangan.class);
                    calonPasanganList.add(calonPasangan);
                }
                if (calonPasanganList.size()>0) {
                    getMvpView().showDataPasangan(calonPasanganList);
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
