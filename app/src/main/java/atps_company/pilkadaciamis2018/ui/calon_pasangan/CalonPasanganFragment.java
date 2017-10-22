package atps_company.pilkadaciamis2018.ui.calon_pasangan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import atps_company.pilkadaciamis2018.R;
import atps_company.pilkadaciamis2018.adapter.CalonPasanganAdapter;
import atps_company.pilkadaciamis2018.adapter.GridAdapter;
import atps_company.pilkadaciamis2018.di.component.ActivityComponent;
import atps_company.pilkadaciamis2018.model.CalonPasangan;
import atps_company.pilkadaciamis2018.ui.base.BaseFragment;
import atps_company.pilkadaciamis2018.ui.detail_paslon.DetailCalonPasanganActivity;
import atps_company.pilkadaciamis2018.util.NetworkUtils;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by emerio on 10/10/17.
 */

public class CalonPasanganFragment extends BaseFragment implements CalonPasanganMvpView,CalonPasanganAdapter.CalonPasanganAdapterCallback {

    public static final String TAG = "CalonPasanganFragment";

    @Inject
    CalonPasanganMvpPresenter<CalonPasanganMvpView> mPresenter;

    @Inject
    CalonPasanganAdapter adapter;

    @BindView(R.id.recycleView)
    RecyclerView recyclerView;

    public static CalonPasanganFragment newInstance() {
        Bundle args = new Bundle();
        CalonPasanganFragment fragment = new CalonPasanganFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calon_pasangan, container, false);

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
        getActivity().setTitle("Calon Pasangan");

        /*grid
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(getActivity(), 2, 10, true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        */
        if (NetworkUtils.isNetworkConnected(getActivity())){
            mPresenter.loadDataCalonPasangan();
        }else {
            mPresenter.notConnection();
        }
        adapter.setCallback(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void showDataPasangan(List<CalonPasangan> list) {
        Log.d("list",String.valueOf(list.size()));
        adapter.setCalonPasangan(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onCalonPasanganClicked(CalonPasangan calonPasangan) {
        Log.d("actin","test");
        Intent i=new Intent(getActivity(), DetailCalonPasanganActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("calonPasangan", calonPasangan);
        i.putExtras(bundle);
        startActivity(i);
    }
}
