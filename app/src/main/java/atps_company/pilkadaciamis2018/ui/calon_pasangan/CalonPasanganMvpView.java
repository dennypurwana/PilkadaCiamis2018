package atps_company.pilkadaciamis2018.ui.calon_pasangan;

import java.util.List;

import atps_company.pilkadaciamis2018.model.CalonPasangan;
import atps_company.pilkadaciamis2018.ui.base.MvpView;

/**
 * Created by emerio on 10/10/17.
 */

public interface CalonPasanganMvpView extends MvpView {

    void showDataPasangan(List<CalonPasangan> list);
}
