package com.nearsoft.banigram.app;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.nearsoft.banigram.app.adapters.TabsAdapter;
import com.nearsoft.banigram.app.fragments.AndroidMediaFragment;
import com.nearsoft.banigram.app.fragments.IosMediaFragment;
import com.nearsoft.banigram.app.fragments.PopularMediaFragment;

import static android.app.ActionBar.*;


@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Main extends FragmentActivity implements TabListener {
    private ViewPager mViewPager;
    private TabsAdapter mTabsAdapter;
    private ActionBar mActionBar;
    private String[] mTabsNames = {"Popular","Android","iOS"};

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.mainViewPager);
        mActionBar = getActionBar();
        mTabsAdapter = new TabsAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mTabsAdapter);
        mViewPager.setOffscreenPageLimit(2);
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setNavigationMode(NAVIGATION_MODE_TABS);
        mActionBar.setDisplayShowTitleEnabled(false);

        for(String tabName : mTabsNames){
            mActionBar.addTab(mActionBar.newTab().setText(tabName).setTabListener(this));
        }
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mActionBar.setSelectedNavigationItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.refreshMediaList) {
            updateMedia();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateMedia() {
        Fragment currentViewPagerFragment =(Fragment)mViewPager.getAdapter()
                .instantiateItem(mViewPager, mViewPager.getCurrentItem());
        if(currentViewPagerFragment instanceof PopularMediaFragment){
            ((PopularMediaFragment)currentViewPagerFragment).update();
        }else if(currentViewPagerFragment instanceof AndroidMediaFragment){
            ((AndroidMediaFragment) currentViewPagerFragment).update();
        }else if(currentViewPagerFragment instanceof IosMediaFragment){
            ((IosMediaFragment) currentViewPagerFragment).update();
        }
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {

    }
}
