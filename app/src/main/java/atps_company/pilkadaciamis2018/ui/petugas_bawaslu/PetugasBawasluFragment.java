package atps_company.pilkadaciamis2018.ui.petugas_bawaslu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import atps_company.pilkadaciamis2018.R;
import atps_company.pilkadaciamis2018.adapter.PetugasBawasluAdapter;
import atps_company.pilkadaciamis2018.di.component.ActivityComponent;
import atps_company.pilkadaciamis2018.model.PetugasBawaslu;
import atps_company.pilkadaciamis2018.model.SeputarPilkada;
import atps_company.pilkadaciamis2018.ui.base.BaseFragment;
import atps_company.pilkadaciamis2018.ui.base.MvpView;
import atps_company.pilkadaciamis2018.ui.maskot_pilkada.MaskotPilkadaFragment;
import atps_company.pilkadaciamis2018.ui.maskot_pilkada.MaskotPilkadaMvpPresenter;
import atps_company.pilkadaciamis2018.ui.maskot_pilkada.MaskotPilkadaMvpView;
import atps_company.pilkadaciamis2018.util.NetworkUtils;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by emerio on 10/9/17.
 */

public class PetugasBawasluFragment extends BaseFragment implements PetugasBawasluMvpView,PetugasBawasluAdapter.PetugasBawasluAdapterCallback {

    public static final String TAG = "SeputarPilkadaFragment";

    @Inject
    PetugasBawasluMvpPresenter<PetugasBawasluMvpView> mPresenter;

    @Inject
    PetugasBawasluAdapter petugasBawasluAdapter;

    @BindView(R.id.recycler_view_petugas_bawaslu)
    RecyclerView recyclerView;

    public static PetugasBawasluFragment newInstance() {
        Bundle args = new Bundle();
        PetugasBawasluFragment fragment = new PetugasBawasluFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_petugas_bawaslu, container, false);

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
        getActivity().setTitle("Petugas Bawaslu");
        if (NetworkUtils.isNetworkConnected(getActivity())){
            mPresenter.loadDataPetugasBawaslu();
        }else {
            mPresenter.notConnection();
        }
        petugasBawasluAdapter.setCallback(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(petugasBawasluAdapter);
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }


    @Override
    public void showPetugasBawaslu(List<PetugasBawaslu> petugasBawaslus) {
        petugasBawasluAdapter.setPetugasBawaslu(petugasBawaslus);
        petugasBawasluAdapter.notifyDataSetChanged();

    }

    @Override
    public void onPetugasBawasluClicked(PetugasBawaslu petugasBawaslu) {
        Toast.makeText(getActivity(),"test",Toast.LENGTH_LONG).show();
    }
}
