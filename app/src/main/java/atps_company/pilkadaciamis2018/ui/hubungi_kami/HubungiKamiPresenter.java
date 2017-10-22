package atps_company.pilkadaciamis2018.ui.hubungi_kami;

import javax.inject.Inject;

import atps_company.pilkadaciamis2018.ui.base.BasePresenter;
import atps_company.pilkadaciamis2018.ui.maskot_pilkada.MaskotPilkadaMvpView;

/**
 * Created by emerio on 10/9/17.
 */

public class HubungiKamiPresenter  <V extends HubungiKamiMvpView> extends BasePresenter<V>
implements HubungiKamiMvpPresenter<V> {

    @Inject
    public HubungiKamiPresenter() {
        super();
    }
}
