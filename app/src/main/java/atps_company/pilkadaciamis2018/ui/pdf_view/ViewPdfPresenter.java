package atps_company.pilkadaciamis2018.ui.pdf_view;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import javax.inject.Inject;

import atps_company.pilkadaciamis2018.di.PerActivity;
import atps_company.pilkadaciamis2018.ui.base.BasePresenter;
import atps_company.pilkadaciamis2018.ui.calon_pasangan.CalonPasanganMvpPresenter;
import atps_company.pilkadaciamis2018.ui.calon_pasangan.CalonPasanganMvpView;
import atps_company.pilkadaciamis2018.ui.main.MainMvpView;

/**
 * Created by emerio on 11/5/17.
 */

@PerActivity
public class ViewPdfPresenter  <V extends ViewPdfMvpView> extends BasePresenter<V> implements ViewPdfMvpPresenter<V> {

    FirebaseStorage storage;
    StorageReference storageReference ;
    FirebaseDatabase firebaseDatabase;
    Context context;
    FirebaseAuth firebaseAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    DatabaseReference dataReferences;

    @Inject
    public ViewPdfPresenter(FirebaseDatabase firebase) {
        this.firebaseDatabase = firebase;
        this.context = context;
        dataReferences=this.firebaseDatabase.getReference("dokumen");
        firebaseAuth = FirebaseAuth.getInstance();
        storage= FirebaseStorage.getInstance();
        storageReference=storage.getReferenceFromUrl("gs://pilkadaciamis2018.appspot.com/");
    }

    @Override
    public void loadPdf() {
        getMvpView().showLoading();
    }

    @Override
    public void hideLoading() {
        getMvpView().hideLoading();
    }

    public void getUrlPdf(String filePath){
        getMvpView().showLoading();
        storageReference.child(filePath).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Log.d("uri",uri.toString());
                getMvpView().showUrlPdf(uri.toString());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });
    }
}
