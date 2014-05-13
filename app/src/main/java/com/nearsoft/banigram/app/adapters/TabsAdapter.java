package com.nearsoft.banigram.app.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;

import com.nearsoft.banigram.app.fragments.AndroidMediaFragment;
import com.nearsoft.banigram.app.fragments.IosMediaFragment;
import com.nearsoft.banigram.app.fragments.PopularMediaFragment;

/**
 * Created by Baniares on 5/12/14.
 */
public class TabsAdapter extends FragmentStatePagerAdapter {
    SparseArray<Fragment> mFragments = new SparseArray<Fragment>();
    public TabsAdapter(FragmentManager fm){super(fm);
        mFragments.put(0,new PopularMediaFragment());
        mFragments.put(1,new AndroidMediaFragment());
        mFragments.put(2,new IosMediaFragment());
    }


    @Override
    public Fragment getItem(int position) {
        if(position < mFragments.size()){return mFragments.get(position);}
        return null;
    }


    @Override
    public int getCount() {return 3;}
}
