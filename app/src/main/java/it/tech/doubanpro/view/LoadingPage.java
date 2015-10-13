package it.tech.doubanpro.view;

import android.content.Context;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import it.tech.doubanpro.R;
import it.tech.doubanpro.utils.UIUtils;


/**
 * Created by chenfuduo on 2015/10/2.
 */
public abstract class LoadingPage extends FrameLayout {

    //五种状态
    static final int STATE_UNKOWN = 0;
    static final int STATE_LOADING = 1;
    static final int STATE_ERROR = 2;
    static final int STATE_EMPTY = 3;
    static final int STATE_SUCCESS = 4;

    //不能使用static
    // static int state = STATE_UNKOWN;

    int state = STATE_UNKOWN;


    //四种界面
    //加载中
    private View loadingView;
    //加载失败
    private View errorView;
    //为空
    private View emptyView;
    //加载成功
    private View successView;

    public LoadingPage(Context context) {
        this(context, null);
    }

    public LoadingPage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    //在FrameLayout中添加四种界面。加载成功;加载失败;加载成功,但是没数据;加载中。
    private void init() {
        loadingView = createLoadingView();
        if (loadingView != null) {
            this.addView(loadingView, new LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        }

        errorView = createErrorView();
        if (errorView != null) {
            this.addView(errorView, new LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        }

        emptyView = createEmptyView();
        if (emptyView != null) {
            this.addView(emptyView, new LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        }
        showPage();// 根据不同的状态显示不同的界面
    }

    //根据不同状态,显示不同的界面
    //五种状态,未知;加载中;错误;空;加载成功
    private void showPage() {
        if (loadingView != null) {
            loadingView.setVisibility(
                    state == STATE_UNKOWN || state == STATE_LOADING ? View.VISIBLE : View.INVISIBLE);
        }
        if (errorView != null) {
            errorView.setVisibility(state == STATE_ERROR ? View.VISIBLE : View.INVISIBLE);
        }
        if (emptyView != null) {
            emptyView.setVisibility(state == STATE_EMPTY ? View.VISIBLE : View.INVISIBLE);
        }


        if (state == STATE_SUCCESS) {

            if (successView == null) {
                successView = createSuccessView();
                this.addView(successView, new LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

            }
            successView.setVisibility(View.VISIBLE);
        } else {
            if (successView != null) {
                successView.setVisibility(View.INVISIBLE);
            }
        }
    }

    //加载中的布局
    private View createLoadingView() {
        View view = View.inflate(UIUtils.getContext(), R.layout.loading_page_loading, null);
        return view;
    }

    //加载失败的布局
    private View createErrorView() {
        View view = View.inflate(UIUtils.getContext(), R.layout.loading_page_error, null);
        Button page_bt = (Button) view.findViewById(R.id.page_bt);
        page_bt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
        return view;
    }

    //为空的布局
    private View createEmptyView() {
        View view = View.inflate(UIUtils.getContext(), R.layout.loading_page_empty, null);
        return view;
    }


    //请求服务器,服务器返回只有三种状态
    //错误,空,成功
    public enum LoadResult {
        error(2), empty(3), success(4);
        int value;

        //枚举类的构造器只能使用private
        LoadResult(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    //根据服务器的数据,切换状态
    public void show() {

        if (state == STATE_ERROR || state == STATE_EMPTY) {
            state = STATE_LOADING;
        }
        new MyAsyncTask().execute();

        showPage();
    }




    class MyAsyncTask extends AsyncTask<String, Void, LoadResult> {
        @Override
        protected LoadResult doInBackground(String... params) {
            LoadResult result = load();
            return result;
        }

        @Override
        protected void onPostExecute(LoadResult loadResult) {
            super.onPostExecute(loadResult);
            if (loadResult != null) {
                state = loadResult.getValue();
                showPage();
            }
        }
    }

    /**
     * 请求服务器数据
     *
     * @return
     */
    public abstract LoadResult load();

    /**
     * 创建成功的界面
     *
     * @return
     */
    protected abstract View createSuccessView();


}
