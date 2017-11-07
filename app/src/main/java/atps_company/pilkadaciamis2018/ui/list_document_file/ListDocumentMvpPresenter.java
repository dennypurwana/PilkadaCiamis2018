package atps_company.pilkadaciamis2018.ui.list_document_file;

import atps_company.pilkadaciamis2018.di.PerActivity;
import atps_company.pilkadaciamis2018.ui.base.MvpPresenter;
import atps_company.pilkadaciamis2018.ui.calon_pasangan.CalonPasanganMvpView;

/**
 * Created by emerio on 11/6/17.
 */

@PerActivity
public interface ListDocumentMvpPresenter<V extends ListDocumentMvpView> extends MvpPresenter<V> {
    void loadDataFile();
    void notConnection();

}
