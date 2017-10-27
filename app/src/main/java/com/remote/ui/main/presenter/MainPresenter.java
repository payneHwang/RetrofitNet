package com.remote.ui.main.presenter;

import com.remote.domain.model.Beauty;
import com.remote.domain.repository.Remote;
import com.remote.net.callBack.IApiCallback;
import com.remote.ui.main.view.MainView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by huang_jin on 2017/10/27.
 */

public class MainPresenter implements IMainPresenter {
    IApiCallback callBack;
    MainView mainView;

    public MainPresenter(MainView view, IApiCallback callBack) {
        this.mainView = view;
        this.callBack = callBack;
    }


    @Override
    public void getBeautyList() {
        mainView.showProgress();
        Remote.getBeautyList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Beauty>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Beauty> responses) {
                        mainView.getDataSuccess(responses);
                    }


                    @Override
                    public void onError(Throwable e) {
                        callBack.failure(e);
                        mainView.dismissProgress();
                    }

                    @Override
                    public void onComplete() {
                        mainView.dismissProgress();
                    }
                });
    }
}
