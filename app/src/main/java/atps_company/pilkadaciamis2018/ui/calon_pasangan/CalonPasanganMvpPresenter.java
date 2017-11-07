package atps_company.pilkadaciamis2018.ui.calon_pasangan;

import android.content.Context;

import atps_company.pilkadaciamis2018.di.PerActivity;
import atps_company.pilkadaciamis2018.ui.base.MvpPresenter;

/**
 * Created by emerio on 10/10/17.
 */


@PerActivity
public interface CalonPasanganMvpPresenter<V extends CalonPasanganMvpView> extends MvpPresenter<V> {

    void loadDataCalonPasangan();
    void notConnection();

}
