package atps_company.pilkadaciamis2018.ui.splash_screen;

import javax.inject.Inject;

import atps_company.pilkadaciamis2018.ui.base.BasePresenter;

/**
 * Created by emerio on 10/9/17.
 */

public class SplashScreenPresenter<V extends SplashScreenMvpView> extends BasePresenter<V> implements SplashScreenMvpPresenter<V> {

    @Inject
    public SplashScreenPresenter() {
        super();
    }


    @Override
    public void toMainActivity() {
             getMvpView().showMainActivity();
    }
}
