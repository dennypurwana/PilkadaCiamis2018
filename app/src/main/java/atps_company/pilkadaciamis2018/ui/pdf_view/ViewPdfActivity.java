package atps_company.pilkadaciamis2018.ui.pdf_view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import javax.inject.Inject;

import atps_company.pilkadaciamis2018.R;
import atps_company.pilkadaciamis2018.model.CalonPasangan;
import atps_company.pilkadaciamis2018.model.Dokumen;
import atps_company.pilkadaciamis2018.ui.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.RemotePDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.BasePDFPagerAdapter;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.remote.DownloadFile;
import es.voghdev.pdfviewpager.library.util.FileUtil;

/**
 * Created by emerio on 11/6/17.
 */

public class ViewPdfActivity extends BaseActivity implements ViewPdfMvpView, DownloadFile.Listener {

    @Inject
    ViewPdfPresenter<ViewPdfMvpView> mPresenter;

   // @BindView(R.id.pdfViewPagerZoom)
    //PDFViewPager pdfViewPager;


    @BindView(R.id.remote_pdf_root)
    LinearLayout root;

    PDFPagerAdapter adapter;

    RemotePDFViewPager remotePDFViewPager;

    Dokumen dokumen;

    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_view_pdf);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            dokumen = (Dokumen) getIntent().getSerializableExtra("dokumen");
            url=dokumen.getFilePath();
        }
        getSupportActionBar().setTitle(dokumen.getFileName());
        //url="https://firebasestorage.googleapis.com/v0/b/pilkadaciamis2018.appspot.com/o/peraturan_kpu_1.pdf?alt=media&token=330ab73f-64b7-40c0-a664-dc018b6ecd2f";
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
        mPresenter.getUrlPdf(url);
    }

    @Override
    protected void setUp() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (adapter != null) {
            adapter.close();
        }
    }

    protected void getPdfFromFirebase(String urlPdf) {
        final Context ctx = this;
        final DownloadFile.Listener listener = this;
        remotePDFViewPager = new RemotePDFViewPager(ctx, urlPdf, listener);
        remotePDFViewPager.setId(R.id.pdfViewPager);

    }


    public void updateLayout() {
        root.removeAllViewsInLayout();
        root.addView(remotePDFViewPager,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onSuccess(String url, String destinationPath) {
        adapter = new PDFPagerAdapter(this, FileUtil.extractFileNameFromURL(url));
        remotePDFViewPager.setAdapter(adapter);
        updateLayout();
        mPresenter.hideLoading();
    }

    @Override
    public void onFailure(Exception e) {
        e.printStackTrace();
    }

    @Override
    public void onProgressUpdate(int progress, int total) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void showUrlPdf(String uri) {
        Log.d("URL nya : ",uri);
        getPdfFromFirebase(uri);
    }
}
