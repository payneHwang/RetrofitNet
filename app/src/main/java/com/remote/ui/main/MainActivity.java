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
    private static final String TAG = "MainActivity";
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
        Log.e(TAG, "callback:---success");
    }

    @Override
    public void failure(Throwable e) {
        Log.e(TAG, "callback:---failure" + e.toString());
    }

    @Override
    public void cancel() {
        Log.e(TAG, "callback:---cancel");
    }

    @Override
    public void networkError() {
        Log.e(TAG, "view:---networkError");
    }

    @Override
    public void showProgress() {
        Log.e(TAG, "view:---showProgress");
        if (dialog != null) {
            dialog.show();
        }

    }

    @Override
    public void dismissProgress() {
        Log.e(TAG, "callback:---dismissProgress");
        if (dialog != null) {
            dialog.dismiss();
        }

    }

    @Override
    public void showNetWorkError() {
        Log.e(TAG, "view:---showNetWorkError");
    }

    @Override
    public void getDataSuccess(List<Beauty> beauties) {
        if (beauties != null) {
            Log.e("Main", "请求数据的长度为：" + beauties.size());
        }
    }
}
