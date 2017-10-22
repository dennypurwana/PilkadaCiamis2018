package atps_company.pilkadaciamis2018.ui.hubungi_kami;

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
import atps_company.pilkadaciamis2018.ui.maskot_pilkada.MaskotPilkadaFragment;
import atps_company.pilkadaciamis2018.ui.maskot_pilkada.MaskotPilkadaMvpPresenter;
import atps_company.pilkadaciamis2018.ui.maskot_pilkada.MaskotPilkadaMvpView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by emerio on 10/9/17.
 */

public class HubungiKamiFragment extends BaseFragment implements HubungiKamiMvpView{

    public static final String TAG = "HubungiKamiFragment";

    @Inject
    HubungiKamiMvpPresenter<HubungiKamiMvpView> mPresenter;
    @BindView(R.id.igKPU)
    TextView tvIgKPU;
    @BindView(R.id.twitterKPU)
    TextView tvTwitterKPU;
    @BindView(R.id.fbKPU)
    TextView tvFbKPU;

    public static HubungiKamiFragment newInstance() {
        Bundle args = new Bundle();
        HubungiKamiFragment fragment = new HubungiKamiFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hubungi_kami, container, false);

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
        getActivity().setTitle("Hubungi Kami");
        tvIgKPU.setText("@kpukabupatebciamis");
        tvFbKPU.setText("@kpukabciamis");
        tvTwitterKPU.setText("@kpu_ciamis");
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

}
