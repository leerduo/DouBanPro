package it.tech.doubanpro.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import it.tech.doubanpro.R;
import it.tech.doubanpro.utils.UIUtils;
import it.tech.doubanpro.view.LoadingPage;

/**
 * Created by chenfuduo on 2015/10/13.
 * 活动
 */
public class ActivityFragment extends BaseFragment {
    @Override
    public LoadingPage.LoadResult load() {
        //只是测试
        return LoadingPage.LoadResult.empty;
    }

    @Override
    protected View createSuccessView() {
        TextView tv = new TextView(UIUtils.getContext());
        tv.setText("ActivityFragment");
        tv.setTextColor(getActivity().getResources().getColor(R.color.teal_500));
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(16);
        return tv;
    }
}
