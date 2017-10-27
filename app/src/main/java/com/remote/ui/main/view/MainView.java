package com.remote.ui.main.view;

import com.remote.base.IBaseView;
import com.remote.domain.model.Beauty;

import java.util.List;

/**
 * Created by huang_jin on 2017/10/27.
 */

public interface MainView extends IBaseView {

    public void getDataSuccess(List<Beauty> beauties);

}
