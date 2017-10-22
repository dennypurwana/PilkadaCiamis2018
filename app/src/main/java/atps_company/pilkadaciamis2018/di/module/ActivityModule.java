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

package atps_company.pilkadaciamis2018.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import atps_company.pilkadaciamis2018.di.ActivityContext;
import atps_company.pilkadaciamis2018.di.PerActivity;
import atps_company.pilkadaciamis2018.ui.beranda.BerandaMvpPresenter;
import atps_company.pilkadaciamis2018.ui.beranda.BerandaMvpView;
import atps_company.pilkadaciamis2018.ui.beranda.BerandaPresenter;
import atps_company.pilkadaciamis2018.ui.calon_pasangan.CalonPasanganMvpPresenter;
import atps_company.pilkadaciamis2018.ui.calon_pasangan.CalonPasanganMvpView;
import atps_company.pilkadaciamis2018.ui.calon_pasangan.CalonPasanganPresenter;
import atps_company.pilkadaciamis2018.ui.detail_paslon.DetailCalonPasanganMvpPresenter;
import atps_company.pilkadaciamis2018.ui.detail_paslon.DetailCalonPasanganMvpView;
import atps_company.pilkadaciamis2018.ui.detail_paslon.DetailCalonPasanganPresenter;
import atps_company.pilkadaciamis2018.ui.hubungi_kami.HubungiKamiMvpPresenter;
import atps_company.pilkadaciamis2018.ui.hubungi_kami.HubungiKamiMvpView;
import atps_company.pilkadaciamis2018.ui.hubungi_kami.HubungiKamiPresenter;
import atps_company.pilkadaciamis2018.ui.main.MainMvpPresenter;
import atps_company.pilkadaciamis2018.ui.main.MainMvpView;
import atps_company.pilkadaciamis2018.ui.main.MainPresenter;
import atps_company.pilkadaciamis2018.ui.maskot_pilkada.MaskotPilkadaMvpPresenter;
import atps_company.pilkadaciamis2018.ui.maskot_pilkada.MaskotPilkadaMvpView;
import atps_company.pilkadaciamis2018.ui.maskot_pilkada.MaskotPilkadaPresenter;
import atps_company.pilkadaciamis2018.ui.persebaran_tps.PersebaranTpsMvpPresenter;
import atps_company.pilkadaciamis2018.ui.persebaran_tps.PersebaranTpsMvpView;
import atps_company.pilkadaciamis2018.ui.persebaran_tps.PersebaranTpsPresenter;
import atps_company.pilkadaciamis2018.ui.petugas_bawaslu.PetugasBawasluMvpPresenter;
import atps_company.pilkadaciamis2018.ui.petugas_bawaslu.PetugasBawasluMvpView;
import atps_company.pilkadaciamis2018.ui.petugas_bawaslu.PetugasBawasluPresenter;
import atps_company.pilkadaciamis2018.ui.seputar_pilkada.SeputarPilkadaMvpPresenter;
import atps_company.pilkadaciamis2018.ui.seputar_pilkada.SeputarPilkadaMvpView;
import atps_company.pilkadaciamis2018.ui.seputar_pilkada.SeputarPilkadaPresenter;
import atps_company.pilkadaciamis2018.ui.splash_screen.SplashScreenMvpPresenter;
import atps_company.pilkadaciamis2018.ui.splash_screen.SplashScreenMvpView;
import atps_company.pilkadaciamis2018.ui.splash_screen.SplashScreenPresenter;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;


@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    SplashScreenMvpPresenter<SplashScreenMvpView> provideSplashScreenPresenter(
            SplashScreenPresenter<SplashScreenMvpView> presenter) {
        return presenter;
    }
    @Provides
    @PerActivity
    DetailCalonPasanganMvpPresenter<DetailCalonPasanganMvpView> provideDetailPasanganPresenter(
            DetailCalonPasanganPresenter<DetailCalonPasanganMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    SeputarPilkadaMvpPresenter<SeputarPilkadaMvpView> provideSeputarPilkadaPresenter(
            SeputarPilkadaPresenter<SeputarPilkadaMvpView> presenter) {
        return presenter;
    }


    @Provides
    MaskotPilkadaMvpPresenter<MaskotPilkadaMvpView> provideMaskotPilkadaPresenter(
            MaskotPilkadaPresenter<MaskotPilkadaMvpView> presenter) {
        return presenter;
    }

    @Provides
    BerandaMvpPresenter<BerandaMvpView> provideBerandaPresenter(
            BerandaPresenter<BerandaMvpView> presenter) {
        return presenter;
    }


    @Provides
    PersebaranTpsMvpPresenter<PersebaranTpsMvpView> providePersebaranTpsPresenter(
            PersebaranTpsPresenter<PersebaranTpsMvpView> presenter) {
        return presenter;
    }


    @Provides
    HubungiKamiMvpPresenter<HubungiKamiMvpView> provideHubungiKamiPresenter(
            HubungiKamiPresenter<HubungiKamiMvpView> presenter) {
        return presenter;
    }


    @Provides
    PetugasBawasluMvpPresenter<PetugasBawasluMvpView> providePetugasBawasluPresenter(
            PetugasBawasluPresenter<PetugasBawasluMvpView> presenter) {
        return presenter;
    }

    @Provides
    CalonPasanganMvpPresenter<CalonPasanganMvpView> provideCalonPasanganPresenter(
            CalonPasanganPresenter<CalonPasanganMvpView> presenter) {
        return presenter;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
