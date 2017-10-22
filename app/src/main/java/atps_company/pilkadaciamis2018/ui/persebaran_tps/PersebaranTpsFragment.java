package atps_company.pilkadaciamis2018.ui.persebaran_tps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import atps_company.pilkadaciamis2018.R;
import atps_company.pilkadaciamis2018.di.component.ActivityComponent;
import atps_company.pilkadaciamis2018.model.SeputarPilkada;
import atps_company.pilkadaciamis2018.ui.base.BaseFragment;
import atps_company.pilkadaciamis2018.ui.seputar_pilkada.SeputarPilkadaFragment;
import atps_company.pilkadaciamis2018.ui.seputar_pilkada.SeputarPilkadaMvpPresenter;
import atps_company.pilkadaciamis2018.ui.seputar_pilkada.SeputarPilkadaMvpView;
import atps_company.pilkadaciamis2018.util.NetworkUtils;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by emerio on 10/9/17.
 */

public class PersebaranTpsFragment extends BaseFragment implements PersebaranTpsMvpView {


    public static final String TAG = "Persebaran TPS";

    @Inject
    PersebaranTpsMvpPresenter<PersebaranTpsMvpView> mPresenter;

    @BindView(R.id.judul)
    TextView judul;
    @BindView(R.id.deskripsi)
    TextView deskripsi;


    public static PersebaranTpsFragment newInstance() {
        Bundle args = new Bundle();
        PersebaranTpsFragment fragment = new PersebaranTpsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_persebaran_tps, container, false);

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
        getActivity().setTitle("Persebaran TPS");
        if (NetworkUtils.isNetworkConnected(getActivity())){
            mPresenter.loadDataPersebaranTps();
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
    public void renderPersebaranTps(SeputarPilkada seputarPilkada) {
        judul.setText(seputarPilkada.getJudul());
        deskripsi.setText(seputarPilkada.getDeskripsi());
    }


}
