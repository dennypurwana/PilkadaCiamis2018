package atps_company.pilkadaciamis2018.ui.splash_screen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import javax.inject.Inject;

import atps_company.pilkadaciamis2018.R;
import atps_company.pilkadaciamis2018.ui.base.BaseActivity;
import atps_company.pilkadaciamis2018.ui.main.MainActivity;
import atps_company.pilkadaciamis2018.ui.main.MainMvpPresenter;
import atps_company.pilkadaciamis2018.ui.main.MainMvpView;
import butterknife.ButterKnife;

/**
 * Created by emerio on 10/9/17.
 */

public class SplashScreenActivity extends BaseActivity implements SplashScreenMvpView{

    @Inject
    SplashScreenMvpPresenter<SplashScreenMvpView> mPresenter;

    private static int SPLASH_TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
        setUp();
    }
    @Override
    protected void setUp() {
      mPresenter.toMainActivity();
    }

    @Override
    public void showMainActivity() {

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                    Intent i=new Intent(SplashScreenActivity.this,MainActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);

            }
        }, SPLASH_TIME_OUT);

    }
}
