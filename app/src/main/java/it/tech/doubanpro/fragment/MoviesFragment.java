package it.tech.doubanpro.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import it.tech.doubanpro.R;
import it.tech.doubanpro.utils.UIUtils;
import it.tech.doubanpro.view.LoadingPage;

/**
 * Created by chenfuduo on 2015/10/13.
 */
public class MoviesFragment extends BaseFragment {
    @Override
    public LoadingPage.LoadResult load() {
        //只是测试
        return LoadingPage.LoadResult.success;
    }

    @Override
    protected View createSuccessView() {
        TextView tv = new TextView(UIUtils.getContext());
        tv.setText("MoviesFragment");
        tv.setGravity(Gravity.CENTER);
        tv.setTextColor(getActivity().getResources().getColor(R.color.teal_500));
        tv.setTextSize(16);
        return tv;
    }
}
