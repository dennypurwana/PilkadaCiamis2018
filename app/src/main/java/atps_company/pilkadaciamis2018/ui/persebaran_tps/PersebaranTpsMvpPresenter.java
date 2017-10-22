package atps_company.pilkadaciamis2018.ui.persebaran_tps;

import atps_company.pilkadaciamis2018.di.PerActivity;
import atps_company.pilkadaciamis2018.ui.base.MvpPresenter;

/**
 * Created by emerio on 10/9/17.
 */


@PerActivity
public interface PersebaranTpsMvpPresenter<V extends PersebaranTpsMvpView> extends MvpPresenter<V> {

    void loadDataPersebaranTps();
    void notConnection();
}
