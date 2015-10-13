package it.tech.doubanpro.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import it.tech.doubanpro.utils.UIUtils;
import it.tech.doubanpro.view.LoadingPage;

/**
 * Created by chenfuduo on 2015/10/13.
 */
public class AlbumFragment extends BaseFragment {
    @Override
    public LoadingPage.LoadResult load() {
        //只是测试
        return LoadingPage.LoadResult.empty;
    }

    @Override
    protected View createSuccessView() {
        TextView tv = new TextView(UIUtils.getContext());
        tv.setText("AlbumFragment");
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(16);
        return tv;
    }
}
