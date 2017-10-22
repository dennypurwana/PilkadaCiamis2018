package atps_company.pilkadaciamis2018.ui.detail_paslon;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import atps_company.pilkadaciamis2018.R;
import atps_company.pilkadaciamis2018.model.CalonPasangan;
import atps_company.pilkadaciamis2018.ui.base.BaseActivity;
import atps_company.pilkadaciamis2018.ui.splash_screen.SplashScreenMvpPresenter;
import atps_company.pilkadaciamis2018.ui.splash_screen.SplashScreenMvpView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by emerio on 10/20/17.
 */

public class DetailCalonPasanganActivity extends BaseActivity implements DetailCalonPasanganMvpView{
    @Inject
    DetailCalonPasanganMvpPresenter<DetailCalonPasanganMvpView> mPresenter;
    CalonPasangan calonPasangan;
    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @BindView(R.id.nama)
    TextView namaCalon;

    @BindView(R.id.biodata)
    TextView data;

    @BindView(R.id.tvMisi)
    TextView tvMisi;

    @BindView(R.id.tvVisi)
    TextView tvVisi;

    @BindView(R.id.visi)
    TextView visi;

    @BindView(R.id.misi)
    TextView misi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_paslon);
        getSupportActionBar().setTitle("Detail Calon Pasangan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
        setUp();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void setUp() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
                calonPasangan = (CalonPasangan) getIntent().getSerializableExtra("calonPasangan");
                namaCalon.setText(calonPasangan.getNama());
                data.setText(calonPasangan.getBiodata());
                data.setVisibility(View.VISIBLE);
        }
        setupTabLayout();

    }
    private void setupTabLayout() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tabLayout.getSelectedTabPosition() == 0){
                   data.setText(calonPasangan.getBiodata());
                    data.setVisibility(View.VISIBLE);
                    tvMisi.setVisibility(View.GONE);
                    tvVisi.setVisibility(View.GONE);
                    visi.setVisibility(View.GONE);
                    misi.setVisibility(View.GONE);
                }else if(tabLayout.getSelectedTabPosition() == 1){
                    data.setVisibility(View.GONE);
                   tvMisi.setVisibility(View.VISIBLE);
                    tvVisi.setVisibility(View.VISIBLE);
                    visi.setVisibility(View.VISIBLE);
                    misi.setVisibility(View.VISIBLE);
                    visi.setText(calonPasangan.getVisi());
                    misi.setText(calonPasangan.getMisi());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void onTabTapped(int position) {
        switch (position) {
            case 0:
                Toast.makeText(getApplicationContext(), "Tapped " + position, Toast.LENGTH_SHORT);
                break;
            case 1:
                Toast.makeText(getApplicationContext(), "Tapped " + position, Toast.LENGTH_SHORT);
                break;
            default:
                Toast.makeText(this, "Tapped " + position, Toast.LENGTH_SHORT);
        }
    }


}
