/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package atps_company.pilkadaciamis2018.di.component;

import atps_company.pilkadaciamis2018.di.PerActivity;
import atps_company.pilkadaciamis2018.di.module.ActivityModule;
import atps_company.pilkadaciamis2018.ui.beranda.BerandaFragment;
import atps_company.pilkadaciamis2018.ui.calon_pasangan.CalonPasanganFragment;
import atps_company.pilkadaciamis2018.ui.detail_paslon.DetailCalonPasanganActivity;
import atps_company.pilkadaciamis2018.ui.hubungi_kami.HubungiKamiFragment;
import atps_company.pilkadaciamis2018.ui.main.MainActivity;
import atps_company.pilkadaciamis2018.ui.maskot_pilkada.MaskotPilkadaFragment;
import atps_company.pilkadaciamis2018.ui.persebaran_tps.PersebaranTpsFragment;
import atps_company.pilkadaciamis2018.ui.petugas_bawaslu.PetugasBawasluFragment;
import atps_company.pilkadaciamis2018.ui.petugas_bawaslu.PetugasBawasluPresenter;
import atps_company.pilkadaciamis2018.ui.seputar_pilkada.SeputarPilkadaFragment;
import atps_company.pilkadaciamis2018.ui.splash_screen.SplashScreenActivity;
import dagger.Component;

/**
 * Created by janisharali on 27/01/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashScreenActivity activity);

    void inject(MainActivity activity);
    void inject(DetailCalonPasanganActivity activity);

    void inject(SeputarPilkadaFragment fragment);

    void inject(MaskotPilkadaFragment fragment);

    void inject(BerandaFragment fragment);

    void inject(PersebaranTpsFragment fragment);

    void inject(HubungiKamiFragment fragment);

    void inject(PetugasBawasluFragment fragment);

    void inject(CalonPasanganFragment fragment);


}
