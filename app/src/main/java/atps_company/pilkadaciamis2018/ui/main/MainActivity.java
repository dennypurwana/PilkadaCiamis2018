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

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import android.widget.Toast;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.listeners.ItemRemovedListener;

import java.util.List;

import javax.inject.Inject;

import atps_company.pilkadaciamis2018.R;
import atps_company.pilkadaciamis2018.ui.base.BaseActivity;
import atps_company.pilkadaciamis2018.ui.beranda.BerandaFragment;
import atps_company.pilkadaciamis2018.ui.calon_pasangan.CalonPasanganFragment;
import atps_company.pilkadaciamis2018.ui.hubungi_kami.HubungiKamiFragment;
import atps_company.pilkadaciamis2018.ui.maskot_pilkada.MaskotPilkadaFragment;
import atps_company.pilkadaciamis2018.ui.persebaran_tps.PersebaranTpsFragment;
import atps_company.pilkadaciamis2018.ui.petugas_bawaslu.PetugasBawasluFragment;
import atps_company.pilkadaciamis2018.ui.seputar_pilkada.SeputarPilkadaFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by janisharali on 27/01/17.
 */

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawer;

    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
    Fragment fragment = null;
    private TextView mNameTextView;

    private TextView mEmailTextView;


    private ActionBarDrawerToggle mDrawerToggle;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mDrawer != null)
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onFragmentAttached() {
    }

    @Override
    public void onFragmentDetached(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .remove(fragment)
                    .commitNow();
            unlockDrawer();
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialogCreate();
    }
    @Override
    public void lockDrawer() {
        if (mDrawer != null)
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    @Override
    public void unlockDrawer() {
        if (mDrawer != null)
            mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }





    @Override
    protected void setUp() {
        setSupportActionBar(mToolbar);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawer,
                mToolbar,
                R.string.open_drawer,
                R.string.close_drawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                hideKeyboard();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        mPresenter.onDrawerBerandaClick();
        setupNavMenu();
        mPresenter.onNavMenuCreated();

    }


    void setupNavMenu() {
        View headerLayout = mNavigationView.getHeaderView(0);
        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        mDrawer.closeDrawer(GravityCompat.START);
                        switch (item.getItemId()) {

                            case R.id.nav_seputar_pilkada:
                                mPresenter.onDrawerSeputarPilkadaClick();
                                return true;

                            case R.id.nav_maskot_pilkada:
                                mPresenter.onDrawerMaskotPilkadaClick();
                                return true;

                            case R.id.nav_beranda:
                                mPresenter.onDrawerBerandaClick();
                                return true;

                            case R.id.nav_hubungi_kami:
                                mPresenter.onDrawerHubungiKamiClick();
                                return true;

                            case R.id.nav_persebaran_tps:
                                mPresenter.onDrawerPersebaranTpsClick();
                                return true;

                            case R.id.nav_petugas_bawaslu:
                                mPresenter.onDrawerPetugasBawasluClick();
                                return true;

                            case R.id.nav_calon_pasangan:
                                mPresenter.onDrawerCalonPasanganClick();
                                return true;

                            default:
                                return false;

                        }


                    }


                });
    }


    @Override
    public void showSeputarPilkadaFragment() {
            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .replace(R.id.content_frame, SeputarPilkadaFragment.newInstance(), SeputarPilkadaFragment.TAG)
                    .commit();

    }

    @Override
    public void showMaskotPilkadaFragment() {
            getSupportFragmentManager()
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .replace(R.id.content_frame, MaskotPilkadaFragment.newInstance(), MaskotPilkadaFragment.TAG)
                    .commit();

    }

    @Override
    public void showBerandaFragment() {
            getSupportFragmentManager()
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .replace(R.id.content_frame, BerandaFragment.newInstance(), BerandaFragment.TAG)
                    .commit();

    }

    @Override
    public void showPersebaranTpsFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .replace(R.id.content_frame, PersebaranTpsFragment.newInstance(), PersebaranTpsFragment.TAG)
                .commit();
    }

    @Override
    public void showHubungiKamiFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .replace(R.id.content_frame, HubungiKamiFragment.newInstance(), HubungiKamiFragment.TAG)
                .commit();
    }

    @Override
    public void showPetugasBawasluFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .replace(R.id.content_frame, PetugasBawasluFragment.newInstance(), PetugasBawasluFragment.TAG)
                .commit();
    }

    @Override
    public void showCalonPasanganFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .replace(R.id.content_frame, CalonPasanganFragment.newInstance(), CalonPasanganFragment.TAG)
                .commit();
    }

    @Override
    public void closeNavigationDrawer() {
        if (mDrawer != null) {
            mDrawer.closeDrawer(Gravity.START);
        }
    }


    public void AlertDialogCreate(){
        new AlertDialog.Builder(MainActivity.this,R.style.exitDialog)
                .setIcon(R.drawable.ciatul)
                .setTitle("Pilkada Serentak 2018 \nRabu, 27 Juni 2018")
                .setMessage("Are you sure you want to exit ?")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("EXIT", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Intent toMainHome=new Intent(Intent.ACTION_MAIN);
                        toMainHome.addCategory(Intent.CATEGORY_HOME);
                        toMainHome.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        toMainHome.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        toMainHome.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(toMainHome);
                    }
                }).setCancelable(false)
                .show();
    }
}
