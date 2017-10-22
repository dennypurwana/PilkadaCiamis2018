package atps_company.pilkadaciamis2018.ui.petugas_bawaslu;

import atps_company.pilkadaciamis2018.di.PerActivity;
import atps_company.pilkadaciamis2018.ui.base.MvpPresenter;

/**
 * Created by emerio on 10/9/17.
 */

@PerActivity
public interface PetugasBawasluMvpPresenter <V extends PetugasBawasluMvpView> extends MvpPresenter<V> {

    void loadDataPetugasBawaslu();
    void notConnection();
}
