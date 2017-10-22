package atps_company.pilkadaciamis2018.ui.petugas_bawaslu;

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

import atps_company.pilkadaciamis2018.model.PetugasBawaslu;
import atps_company.pilkadaciamis2018.model.SeputarPilkada;
import atps_company.pilkadaciamis2018.ui.base.BasePresenter;

/**
 * Created by emerio on 10/9/17.
 */

public class PetugasBawasluPresenter <V extends PetugasBawasluMvpView> extends BasePresenter<V> implements PetugasBawasluMvpPresenter<V> {


    FirebaseDatabase firebaseDatabase;
    DatabaseReference dataReferences;
    FirebaseAuth firebaseAuth;
    boolean status=false;


    @Inject
    public PetugasBawasluPresenter(FirebaseDatabase firebaseDatabase){
        this.firebaseDatabase=firebaseDatabase;
        this.firebaseDatabase=FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        dataReferences=this.firebaseDatabase.getReference("petugasBawaslu");
    }

    @Override
    public void loadDataPetugasBawaslu() {
        getMvpView().showLoading();
        dataReferences.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                status=true;
                Log.d("data snapshot: ",dataSnapshot.toString());
                List<PetugasBawaslu> petugasBawasluList=new ArrayList<PetugasBawaslu>();
                PetugasBawaslu petugasBawaslu=null;
                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                    petugasBawaslu = singleSnapshot.getValue(PetugasBawaslu.class);
                    petugasBawasluList.add(petugasBawaslu);
                }
                if (petugasBawasluList.size()>0) {
                    getMvpView().showPetugasBawaslu(petugasBawasluList);
                    getMvpView().hideLoading();
                }else {
                    getMvpView().showMessage("data kosong.");
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                status=true;
                System.out.println("The read failed: " + databaseError.getMessage());
                getMvpView().hideLoading();
            }
        });
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
