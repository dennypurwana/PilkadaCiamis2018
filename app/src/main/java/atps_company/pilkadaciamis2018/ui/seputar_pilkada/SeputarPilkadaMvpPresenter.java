package atps_company.pilkadaciamis2018.ui.seputar_pilkada;

import atps_company.pilkadaciamis2018.di.PerActivity;
import atps_company.pilkadaciamis2018.ui.base.MvpPresenter;


@PerActivity
public interface SeputarPilkadaMvpPresenter <V extends SeputarPilkadaMvpView> extends MvpPresenter<V>{

    void loadDataInfoSeputarPilkada();
    void notConnection();
}
