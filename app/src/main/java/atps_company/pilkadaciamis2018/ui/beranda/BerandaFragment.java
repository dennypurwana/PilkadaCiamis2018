package atps_company.pilkadaciamis2018.ui.beranda;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import atps_company.pilkadaciamis2018.R;
import atps_company.pilkadaciamis2018.di.component.ActivityComponent;
import atps_company.pilkadaciamis2018.model.SeputarPilkada;
import atps_company.pilkadaciamis2018.ui.base.BaseFragment;
import atps_company.pilkadaciamis2018.ui.maskot_pilkada.MaskotPilkadaFragment;
import atps_company.pilkadaciamis2018.ui.maskot_pilkada.MaskotPilkadaMvpPresenter;
import atps_company.pilkadaciamis2018.ui.maskot_pilkada.MaskotPilkadaMvpView;
import atps_company.pilkadaciamis2018.util.NetworkUtils;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by emerio on 10/9/17.
 */

public class BerandaFragment extends BaseFragment implements BerandaMvpView  {
    public static final String TAG = "Beranda";

    @Inject
    BerandaMvpPresenter<BerandaMvpView> mPresenter;
    @BindView(R.id.judul)
    TextView judul;
    @BindView(R.id.deskripsi)
    TextView deskripsi;

    public static BerandaFragment newInstance() {
        Bundle args = new Bundle();
        BerandaFragment fragment = new BerandaFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }

        return view;
    }

    @Override
    protected void setUp(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Beranda");
        if (NetworkUtils.isNetworkConnected(getActivity())){
        mPresenter.loadDataBeranda();
        }else {
         mPresenter.notConnection();
        }


    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void renderDataBeranda(SeputarPilkada seputarPilkada) {
        judul.setText(seputarPilkada.getJudul());
        deskripsi.setText(seputarPilkada.getDeskripsi());
    }

    @Override
    public void statusTimeout(boolean result) {
        if (!result){
            Toast.makeText(getActivity(),"Not Internet Connection.",Toast.LENGTH_LONG).show();
        }
    }
}
