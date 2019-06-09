package qiuguojun.bawei.com.ykmn.fragments;

import android.content.Intent;
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
import android.widget.RadioGroup;
import android.widget.Toast;

import qiuguojun.bawei.com.ykmn.R;

public class Afragment extends Fragment{
    private EditText edit;
    private Button bt1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.afragment, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        edit = (EditText) inflate.findViewById(R.id.edit);
        bt1 = (Button) inflate.findViewById(R.id.bt1);
        edit.setOnClickListener(new View.OnClickListener() {
            private RadioGroup rg;

            @Override
            public void onClick(View v) {
                rg = (RadioGroup) getActivity().findViewById(R.id.group);
                rg.check(R.id.btn3);
                Toast.makeText(getContext(), "asd", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
