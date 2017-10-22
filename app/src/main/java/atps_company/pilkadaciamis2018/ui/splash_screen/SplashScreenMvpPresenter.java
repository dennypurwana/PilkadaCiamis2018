package atps_company.pilkadaciamis2018.ui.splash_screen;

import atps_company.pilkadaciamis2018.di.PerActivity;
import atps_company.pilkadaciamis2018.ui.base.BasePresenter;
import atps_company.pilkadaciamis2018.ui.base.MvpPresenter;

/**
 * Created by emerio on 10/9/17.
 */

@PerActivity
public interface SplashScreenMvpPresenter<V extends SplashScreenMvpView> extends MvpPresenter<V> {

    void toMainActivity();
}
