package it.tech.doubanpro.fragment;

import android.support.v4.util.ArrayMap;
import android.util.Log;


/**
 * Created by chenfuduo on 2015/10/1.
 */
public class FragmentFactory {

    private static final String TAG = FragmentFactory.class.getSimpleName();
    private static ArrayMap<Integer, BaseFragment> fragmentArrayMap = new ArrayMap<>();

    //ArrayMap和SparseArray都能达到优化
    // private static SparseArray<Fragment> sparseFragments = new SparseArray<>();

    public static BaseFragment createFragment(int position) {
        BaseFragment fragment;
        fragment = fragmentArrayMap.get(position);
        //sparseFragments.get(position);
        // sparseFragments.put(position,fragment);
        if (fragment == null) {

            Log.e(TAG, "createFragment " + "Fragment为null执行");

            if (position == 0) {
                fragment = new BooksFragment();
            } else if (position == 1) {
                fragment = new MoviesFragment();
            } else if (position == 2) {
                fragment = new MusicFragment();
            } else if (position == 3) {
                fragment = new CityFragment();
            } else if (position == 4) {
                fragment = new BroadcastFragment();
            } else if (position == 5) {
                fragment = new UsersFragment();
            } else if (position == 6) {
                fragment = new DiaryFragment();
            } else if (position == 7) {
                fragment = new AlbumFragment();
            } else if (position == 8) {
                fragment = new ActivityFragment();
            } else if (position == 9) {
                fragment = new ForumFragment();
            } else if (position == 10) {
                fragment = new ReplyFragment();
            } else if (position == 11) {
                fragment = new TravelFragment();
            }
            if (fragment != null) {
                fragmentArrayMap.put(position, fragment);
            }
        }
        return fragment;
    }
}
