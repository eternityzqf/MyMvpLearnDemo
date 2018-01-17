package com.zqf.mymvplearndemo.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zqf.mymvplearndemo.R;
import com.zqf.mymvplearndemo.model.bean.TabBean;
import com.zqf.mymvplearndemo.presenter.TabPresenter;
import com.zqf.mymvplearndemo.presenter.TabViewInterface;

public class MainActivity extends AppCompatActivity implements TabViewInterface {
    private TabPresenter mTabPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabPresenter = new TabPresenter(this, this);
    }

    /**
     * 加载中mTabPresenter.ClickRequest();
     */
    @Override
    public void requestLoading() {

    }

    @Override
    public void resultSuccess(TabBean result) {

    }

    @Override
    public void resultFailure(String result) {

    }
}
