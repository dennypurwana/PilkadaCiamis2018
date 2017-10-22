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

package atps_company.pilkadaciamis2018.ui.main;

import com.androidnetworking.error.ANError;

import java.util.List;

import javax.inject.Inject;

import atps_company.pilkadaciamis2018.ui.base.BasePresenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;


/**
 * Created by janisharali on 27/01/17.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    private static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter() {
        super();
    }


    @Override
    public void onDrawerSeputarPilkadaClick() {
        getMvpView().closeNavigationDrawer();
        getMvpView().showSeputarPilkadaFragment();
    }

    @Override
    public void onDrawerMaskotPilkadaClick() {
        getMvpView().closeNavigationDrawer();
        getMvpView().showMaskotPilkadaFragment();
    }

    @Override
    public void onDrawerBerandaClick() {
        getMvpView().closeNavigationDrawer();
        getMvpView().showBerandaFragment();
    }

    @Override
    public void onDrawerPersebaranTpsClick() {
        getMvpView().closeNavigationDrawer();
        getMvpView().showPersebaranTpsFragment();
    }

    @Override
    public void onDrawerHubungiKamiClick() {
        getMvpView().closeNavigationDrawer();
        getMvpView().showHubungiKamiFragment();
    }

    @Override
    public void onDrawerPetugasBawasluClick() {
        getMvpView().closeNavigationDrawer();
        getMvpView().showPetugasBawasluFragment();
    }

    @Override
    public void onDrawerCalonPasanganClick() {
        getMvpView().closeNavigationDrawer();
        getMvpView().showCalonPasanganFragment();
    }

    @Override
    public void onNavMenuCreated() {
        if (!isViewAttached()) {
            return;
        }

    }


}
