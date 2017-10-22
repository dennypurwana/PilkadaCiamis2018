package atps_company.pilkadaciamis2018.ui.maskot_pilkada;

import atps_company.pilkadaciamis2018.di.PerActivity;
import atps_company.pilkadaciamis2018.ui.base.MvpPresenter;

/**
 * Created by emerio on 10/9/17.
 */

@PerActivity
public interface MaskotPilkadaMvpPresenter <V extends MaskotPilkadaMvpView> extends MvpPresenter<V> {
    void loadDataMaskotPilkada();
    void notConnection();
}
