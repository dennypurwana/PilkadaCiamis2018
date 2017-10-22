package atps_company.pilkadaciamis2018.ui.detail_paslon;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Inject;

import atps_company.pilkadaciamis2018.ui.base.BasePresenter;
import atps_company.pilkadaciamis2018.ui.calon_pasangan.CalonPasanganMvpPresenter;
import atps_company.pilkadaciamis2018.ui.calon_pasangan.CalonPasanganMvpView;

/**
 * Created by emerio on 10/20/17.
 */

public class DetailCalonPasanganPresenter  <V extends DetailCalonPasanganMvpView> extends BasePresenter<V> implements DetailCalonPasanganMvpPresenter<V> {
    @Inject
    public DetailCalonPasanganPresenter(){

    }
}
