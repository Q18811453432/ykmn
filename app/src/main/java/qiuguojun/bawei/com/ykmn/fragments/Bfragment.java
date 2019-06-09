package qiuguojun.bawei.com.ykmn.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import qiuguojun.bawei.com.ykmn.MainActivitys;
import qiuguojun.bawei.com.ykmn.R;
import qiuguojun.bawei.com.ykmn.bases.Mybase;
import qiuguojun.bawei.com.ykmn.bases.Mybases;
import qiuguojun.bawei.com.ykmn.bean.BBean;
import qiuguojun.bawei.com.ykmn.bean.GBean;
import qiuguojun.bawei.com.ykmn.bean.LBean;
import qiuguojun.bawei.com.ykmn.mvp.IContact;
import qiuguojun.bawei.com.ykmn.mvp.Presenter;

public class Bfragment extends Fragment implements IContact.IView{
    private RecyclerView LinnerList;
    private Banner banner;
    private RecyclerView gridList;
 public static Context contexts;
 private String path="http://172.17.8.100/small/commodity/v1/findFirstCategory";
 private String path1="http://172.17.8.100/small/commodity/v1/findSecondCategory?firstCategoryId=";
 private String paths="http://172.17.8.100/small/commodity/v1/findSecondCategory?firstCategoryId=1001002";
    private String b_path = "http://172.17.8.100/movieApi/movie/v1/findHotMovieList?page=1&count=10";
 private Presenter presenter;

 private ArrayList<String> list=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.bfragment, container, false);
        initView(inflate);
        contexts=getActivity();
        presenter=new Presenter(this);
        presenter.startRequest(path);
        presenter.startRequests(paths);
        presenter.startRequestss(b_path);
        return inflate;
    }

    private void initView(View inflate) {
        LinnerList = (RecyclerView) inflate.findViewById(R.id.LinnerList);
        gridList = (RecyclerView) inflate.findViewById(R.id.gridList);
        banner=inflate.findViewById(R.id.banner);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(contexts, 2);
        gridList.setLayoutManager(gridLayoutManager);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(contexts);
        LinnerList.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void getData(String json) {
        Gson gson=new Gson();
        LBean lBean = gson.fromJson(json, LBean.class);
        final List<LBean.ResultBean> result = lBean.getResult();
        final Mybase adapter=new Mybase(result, contexts);
        LinnerList.setAdapter(adapter);
        adapter.setSetonclickItem(new Mybase.SetonclickItem() {
            @Override
            public void onclickItem(View view, int position) {
                adapter.setTextColor(position);
                String params=path1+result.get(position).getId();
                presenter.startRequests(params);
            }
        });

    }

    @Override
    public void getDatas(String json) {
       Gson gson=new Gson();
        GBean gBean = gson.fromJson(json, GBean.class);
        List<GBean.ResultBean> results = gBean.getResult();
        Mybases adapters=new Mybases(results, contexts);
        gridList.setAdapter(adapters);
        adapters.setclicks(new Mybases.SetonclickItem() {
            @Override
            public void onclickItem(View view, int position) {
                Intent intent=new Intent(getActivity(),MainActivitys.class);
                startActivity(intent);
            }
        });
    }

   @Override
   public void getDatass(String json) {

        Gson gson=new Gson();
        BBean bBean = gson.fromJson(json, BBean.class);
        List<BBean.Result> result = bBean.getResult();

        list=new ArrayList<>();
        for (int i = 0; i <result.size(); i++) {
            list.add(result.get(i).getImageUrl());
        }
       Log.i("B",list.size()+"");
        banner.isAutoPlay(true);
        banner.setDelayTime(2000);
        banner.setImages(list);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        }).start();
    }


}
