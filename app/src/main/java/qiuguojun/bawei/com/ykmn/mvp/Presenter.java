package qiuguojun.bawei.com.ykmn.mvp;

import java.lang.ref.SoftReference;

public class Presenter implements IContact.IPresenter{
    private Model model;
    private IContact.IView iView;
    private SoftReference<IContact.IView> softReference;

    public Presenter(IContact.IView iView) {
       model=new Model();
        this.iView = iView;
      softReference=new SoftReference<>(iView);
    }

    @Override
    public void startRequest(String url) {
         model.getData(url, new IContact.CallBack() {
             @Override
             public void saveData(String json) {
                 iView.getData(json);
             }
         });
    }

    @Override
    public void onDetach() {
        if (softReference!=null){
            softReference.clear();
        }
             if (model!=null){
                 model=null;
             }
    }

    @Override
    public void startRequests(String urls) {
        model.getData(urls, new IContact.CallBack() {
            @Override
            public void saveData(String json) {
                iView.getDatas(json);
            }
        });
    }

    @Override
    public void startRequestss(String urlss) {
        model.getData(urlss, new IContact.CallBack() {
            @Override
            public void saveData(String json) {
                iView.getDatass(json);
            }
        });
    }
}
