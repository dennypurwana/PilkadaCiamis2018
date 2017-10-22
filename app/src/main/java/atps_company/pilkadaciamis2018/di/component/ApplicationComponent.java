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

import android.app.Application;
import android.content.Context;

import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Singleton;

import atps_company.pilkadaciamis2018.MvpApp;
import atps_company.pilkadaciamis2018.di.ApplicationContext;
import atps_company.pilkadaciamis2018.di.module.ApplicationModule;
import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);


    @ApplicationContext
    Context context();

    Application application();

    FirebaseDatabase firebase();

}