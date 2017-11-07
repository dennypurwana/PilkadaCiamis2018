package atps_company.pilkadaciamis2018.ui.list_document_file;

import java.util.List;

import atps_company.pilkadaciamis2018.model.CalonPasangan;
import atps_company.pilkadaciamis2018.model.Dokumen;
import atps_company.pilkadaciamis2018.ui.base.MvpView;

/**
 * Created by emerio on 11/6/17.
 */

public interface ListDocumentMvpView extends MvpView {
    void showDataFile(List<Dokumen> list);
}
