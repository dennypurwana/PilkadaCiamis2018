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

package atps_company.pilkadaciamis2018;

import android.app.Application;
import android.os.Handler;
import android.os.StrictMode;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor.Level;

import java.io.File;

import javax.inject.Inject;

import atps_company.pilkadaciamis2018.di.component.ApplicationComponent;
import atps_company.pilkadaciamis2018.di.component.DaggerApplicationComponent;
import atps_company.pilkadaciamis2018.di.module.ApplicationModule;
import atps_company.pilkadaciamis2018.ui.base.MvpView;
import es.voghdev.pdfviewpager.library.asset.CopyAsset;
import es.voghdev.pdfviewpager.library.asset.CopyAssetThreadImpl;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


/**
 * Created by janisharali on 27/01/17.
 */

public class MvpApp extends Application {
    final String[] sampleAssets = {"adobe.pdf", "sample.pdf", "moby.pdf"};
    @Inject
    CalligraphyConfig mCalligraphyConfig;

    private ApplicationComponent mApplicationComponent;
    private static MvpApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).applicationModule(new ApplicationModule("https://pilkadaciamis2018.firebaseio.com/")).build();
        mApplicationComponent.inject(this);
        mInstance=this;

        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(Level.BODY);
        }

        CalligraphyConfig.initDefault(mCalligraphyConfig);
        initSampleAssets();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

    private void initSampleAssets() {
        CopyAsset copyAsset = new CopyAssetThreadImpl(this, new Handler());
        for (String asset : sampleAssets) {
            copyAsset.copy(asset, new File(getCacheDir(), asset).getAbsolutePath());
        }
    }
}
