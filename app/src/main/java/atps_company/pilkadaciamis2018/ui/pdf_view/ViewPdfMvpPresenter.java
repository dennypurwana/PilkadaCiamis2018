package atps_company.pilkadaciamis2018.ui.pdf_view;

import atps_company.pilkadaciamis2018.ui.base.MvpPresenter;
import atps_company.pilkadaciamis2018.ui.calon_pasangan.CalonPasanganMvpView;
import atps_company.pilkadaciamis2018.ui.main.MainMvpView;

/**
 * Created by emerio on 11/5/17.
 */

public interface ViewPdfMvpPresenter<V extends ViewPdfMvpView> extends MvpPresenter<V> {
    void loadPdf();
    void hideLoading();
}
