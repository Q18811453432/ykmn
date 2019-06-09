package qiuguojun.bawei.com.ykmn;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import qiuguojun.bawei.com.ykmn.fragments.Afragment;
import qiuguojun.bawei.com.ykmn.fragments.Bfragment;
import qiuguojun.bawei.com.ykmn.fragments.Cfragment;
import qiuguojun.bawei.com.ykmn.fragments.Dfragment;
import qiuguojun.bawei.com.ykmn.fragments.Efragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private RadioButton btn1;
    private RadioButton btn2;
    private RadioButton btn3;
    private RadioButton btn4;
    private RadioButton btn5;
    private RadioGroup group;
    private Afragment afragment;
    private Bfragment bfragment;
    private Cfragment cfragment;
    private Dfragment dfragment;
    private Efragment efragment;
    private List<Fragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        btn1 = (RadioButton) findViewById(R.id.btn1);
        btn2 = (RadioButton) findViewById(R.id.btn2);
        btn3 = (RadioButton) findViewById(R.id.btn3);
        btn4 = (RadioButton) findViewById(R.id.btn4);
        btn5 = (RadioButton) findViewById(R.id.btn5);
        group = (RadioGroup) findViewById(R.id.group);
        afragment=new Afragment();
        bfragment=new Bfragment();
        cfragment=new Cfragment();
        dfragment=new Dfragment();
        efragment=new Efragment();
        list=new ArrayList<>();
        list.add(afragment);
        list.add(bfragment);
        list.add(cfragment);
        list.add(dfragment);
        list.add(efragment);
       vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
           @Override
           public Fragment getItem(int i) {
               return list.get(i);
           }

           @Override
           public int getCount() {
               return list.size();
           }
       });



       group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               switch (checkedId){
                   case R.id.btn1:
                       vp.setCurrentItem(0);
                       break;
                   case R.id.btn2:
                       vp.setCurrentItem(1);
                       break;
                   case R.id.btn3:
                       vp.setCurrentItem(2);
                       break;
                   case R.id.btn4:
                       vp.setCurrentItem(3);
                       break;
                   case R.id.btn5:
                       vp.setCurrentItem(4);
                       break;

               }
           }
       });
    }
}
