package qiuguojun.bawei.com.ykmn.utils;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class VolleyUtil {
    private VolleyUtil(){
        }
    private static class HolderVolley{
        private final static VolleyUtil VOLLEYUTIL=new VolleyUtil();
    }
    public static VolleyUtil getInstance(){
        return HolderVolley.VOLLEYUTIL;
    }
    public void getUrl(String url, Context context, final volleyCallBack volleyCallBack){
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest sr=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                volleyCallBack.setResult(response);
            }
        }, null);
        requestQueue.add(sr);
    }
    public interface volleyCallBack{
        void setResult(String jsonstr);
    }
}
