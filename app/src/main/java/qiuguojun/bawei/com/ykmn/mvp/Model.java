package qiuguojun.bawei.com.ykmn.mvp;

import qiuguojun.bawei.com.ykmn.fragments.Bfragment;
import qiuguojun.bawei.com.ykmn.utils.VolleyUtil;

public class Model implements IContact.IModel{
    @Override
    public void getData(String url, final IContact.CallBack callBack) {
        VolleyUtil.getInstance().getUrl(url, Bfragment.contexts, new VolleyUtil.volleyCallBack() {
            @Override
            public void setResult(String jsonstr) {
                callBack.saveData(jsonstr);
            }
        });
    }
}
