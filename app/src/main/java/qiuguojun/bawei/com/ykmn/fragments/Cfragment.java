package qiuguojun.bawei.com.ykmn.fragments;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import qiuguojun.bawei.com.ykmn.R;

public class Cfragment extends Fragment {
    private EditText edit;
    private Button bt1;
    private Button bt2;
    private TagFlowLayout MyFlow;
    private ArrayList<String> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.cfragment, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        edit = (EditText) inflate.findViewById(R.id.edit);
        bt1 = (Button) inflate.findViewById(R.id.bt1);
        bt2 = (Button) inflate.findViewById(R.id.bt2);
        MyFlow = inflate.findViewById(R.id.MyFlow);
        list=new ArrayList<>();
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edit.getText().toString();
                ObjectAnimator translationX = ObjectAnimator.ofFloat(MyFlow, "translationX", 1000f, 0f);
                AnimatorSet animatorSet=new AnimatorSet();
                animatorSet.play(translationX);
                animatorSet.start();
                animatorSet.setDuration(2000);
                list.add(s);
          getdata();
          edit.setText(null);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         list.clear();
         getdata();
            }
        });

    }
public void getdata(){
      MyFlow.setAdapter(new TagAdapter(list) {
          @Override
          public View getView(FlowLayout parent, int position, Object o) {
              TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.item, MyFlow, false);
             textView.setText(list.get(position));
              return textView;
          }
      });
}



}
