package atps_company.pilkadaciamis2018.ui.seputar_pilkada;

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
import atps_company.pilkadaciamis2018.util.NetworkUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by emerio on 10/9/17.
 */

public class SeputarPilkadaFragment  extends BaseFragment implements SeputarPilkadaMvpView{
    public static final String TAG = "SeputarPilkadaFragment";

    @Inject
    SeputarPilkadaMvpPresenter<SeputarPilkadaMvpView> mPresenter;
    @BindView(R.id.judul)
    TextView judul;
    @BindView(R.id.deskripsi)
    TextView deskripsi;


    public static SeputarPilkadaFragment newInstance() {
        Bundle args = new Bundle();
        SeputarPilkadaFragment fragment = new SeputarPilkadaFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_seputar_pilkada, container, false);

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
        getActivity().setTitle("Seputar Pilkada");
        if (NetworkUtils.isNetworkConnected(getActivity())){
            mPresenter.loadDataInfoSeputarPilkada();
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
    public void renderDataSeputarPilkada(SeputarPilkada seputarPilkada) {
        judul.setText(seputarPilkada.getJudul());
        deskripsi.setText(seputarPilkada.getDeskripsi());

    }
}
