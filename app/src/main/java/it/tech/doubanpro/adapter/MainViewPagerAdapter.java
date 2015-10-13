package it.tech.doubanpro.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import it.tech.doubanpro.R;
import it.tech.doubanpro.fragment.FragmentFactory;

/**
 * Created by chenfuduo on 2015/10/13.
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private String tabTitles[];
    private Context context;

    public MainViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        tabTitles = context.getResources().getStringArray(R.array.tab_names);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.createFragment(position);
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}
