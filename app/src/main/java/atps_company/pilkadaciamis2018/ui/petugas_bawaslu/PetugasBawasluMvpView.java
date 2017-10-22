package atps_company.pilkadaciamis2018.ui.petugas_bawaslu;

import java.util.List;

import atps_company.pilkadaciamis2018.model.PetugasBawaslu;
import atps_company.pilkadaciamis2018.ui.base.MvpView;

/**
 * Created by emerio on 10/9/17.
 */

public interface PetugasBawasluMvpView extends MvpView {

    void showPetugasBawaslu(List<PetugasBawaslu> petugasBawaslus);


}
