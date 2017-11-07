package atps_company.pilkadaciamis2018.ui.list_document_file;

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
import atps_company.pilkadaciamis2018.adapter.DokumenAdapter;
import atps_company.pilkadaciamis2018.di.component.ActivityComponent;
import atps_company.pilkadaciamis2018.model.CalonPasangan;
import atps_company.pilkadaciamis2018.model.Dokumen;
import atps_company.pilkadaciamis2018.ui.base.BaseFragment;
import atps_company.pilkadaciamis2018.ui.calon_pasangan.CalonPasanganFragment;
import atps_company.pilkadaciamis2018.ui.calon_pasangan.CalonPasanganMvpPresenter;
import atps_company.pilkadaciamis2018.ui.calon_pasangan.CalonPasanganMvpView;
import atps_company.pilkadaciamis2018.ui.detail_paslon.DetailCalonPasanganActivity;
import atps_company.pilkadaciamis2018.ui.pdf_view.ViewPdfActivity;
import atps_company.pilkadaciamis2018.util.NetworkUtils;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by emerio on 11/6/17.
 */

public class ListDocumentFragment extends BaseFragment implements ListDocumentMvpView,DokumenAdapter.DokumenAdapterCallback{

    public static final String TAG = "ListDocumentFragment";

    @Inject
    ListDocumentMvpPresenter<ListDocumentMvpView> mPresenter;

    @Inject
    DokumenAdapter adapter;


    @BindView(R.id.recycleView)
    RecyclerView recyclerView;

    public static ListDocumentFragment newInstance() {
        Bundle args = new Bundle();
        ListDocumentFragment fragment = new ListDocumentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_document, container, false);

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
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("File/Dokumen");
        if (NetworkUtils.isNetworkConnected(getActivity())){
            mPresenter.loadDataFile();
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
    public void showDataFile(List<Dokumen> list) {
        Log.d("list",String.valueOf(list.size()));
        adapter.setDokumen(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDokumenClicked(Dokumen dokumen) {
        Intent i=new Intent(getActivity(), ViewPdfActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("dokumen", dokumen);
        i.putExtras(bundle);
        startActivity(i);
    }
}
