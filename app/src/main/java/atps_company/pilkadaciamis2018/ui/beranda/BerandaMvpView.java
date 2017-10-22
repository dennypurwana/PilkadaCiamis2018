package atps_company.pilkadaciamis2018.ui.beranda;

import atps_company.pilkadaciamis2018.model.SeputarPilkada;
import atps_company.pilkadaciamis2018.ui.base.MvpView;

/**
 * Created by emerio on 10/9/17.
 */

public interface BerandaMvpView extends MvpView {
    void renderDataBeranda(SeputarPilkada seputarPilkada);
    void statusTimeout(boolean result);
}
