package com.remote.ui.main;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.remote.R;
import com.remote.domain.model.Beauty;
import com.remote.net.callBack.IApiCallback;
import com.remote.ui.main.presenter.MainPresenter;
import com.remote.ui.main.view.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IApiCallback, MainView {
    private MainPresenter presenter;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        presenter.getBeautyList();
    }

    private void init() {
        presenter = new MainPresenter(this, this);
        dialog = ProgressDialog.show(this, "提示", "loading....");
    }

    @Override
    public void success(List<Beauty> beauties) {

    }

    @Override
    public void failure(Throwable e) {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void networkError() {

    }

    @Override
    public void showProgress() {
        if (dialog != null) {
            dialog.show();
        }

    }

    @Override
    public void dismissProgress() {
        if (dialog != null) {
            dialog.dismiss();
        }

    }

    @Override
    public void showNetWorkError() {

    }

    @Override
    public void getDataSuccess(List<Beauty> beauties) {
        if (beauties != null) {
            Log.e("Main", "请求数据的长度为：" + beauties.size());
        }
    }
}
