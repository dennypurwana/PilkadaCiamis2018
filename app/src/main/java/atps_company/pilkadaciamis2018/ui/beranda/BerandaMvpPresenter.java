package atps_company.pilkadaciamis2018.ui.beranda;

import atps_company.pilkadaciamis2018.di.PerActivity;
import atps_company.pilkadaciamis2018.ui.base.BasePresenter;
import atps_company.pilkadaciamis2018.ui.base.MvpPresenter;

/**
 * Created by emerio on 10/9/17.
 */

@PerActivity
public interface BerandaMvpPresenter<V extends BerandaMvpView>  extends MvpPresenter<V> {
    void loadDataBeranda();
    void notConnection();

}
