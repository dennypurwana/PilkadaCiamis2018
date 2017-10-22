package atps_company.pilkadaciamis2018.ui.maskot_pilkada;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import atps_company.pilkadaciamis2018.model.SeputarPilkada;
import atps_company.pilkadaciamis2018.ui.base.BasePresenter;
import atps_company.pilkadaciamis2018.ui.seputar_pilkada.SeputarPilkadaMvpView;

/**
 * Created by emerio on 10/9/17.
 */

public class MaskotPilkadaPresenter <V extends MaskotPilkadaMvpView> extends BasePresenter<V>
implements MaskotPilkadaMvpPresenter<V> {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference dataReferences;
    FirebaseAuth firebaseAuth;
    boolean status=false;

    @Inject
    public MaskotPilkadaPresenter(FirebaseDatabase firebaseDatabase){
        this.firebaseDatabase=firebaseDatabase;
        this.firebaseDatabase=FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        dataReferences=this.firebaseDatabase.getReference("maskotPilkada");
    }

    @Override
    public void loadDataMaskotPilkada() {
        getMvpView().showLoading();
        dataReferences.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                status=true;
                Log.d("data snapshot: ",dataSnapshot.toString());
                SeputarPilkada seputarPilkada = dataSnapshot.getValue(SeputarPilkada.class);
                if (seputarPilkada!=null) {
                    getMvpView().renderDataMaskotPilkada(seputarPilkada);
                }
                getMvpView().hideLoading();
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
