package qiuguojun.bawei.com.ykmn.mvp;

public interface IContact{
    interface IModel{
      void getData(String url,CallBack callBack);
    }
    interface IView{
        void getData(String json);
        void getDatas(String json);
        void getDatass(String json);
    }
    interface IPresenter{
        void startRequest(String url);
        void onDetach();
        void startRequests(String urls);
        void startRequestss(String urlss);
    }
    interface CallBack{
        void saveData(String json);
    }
}
