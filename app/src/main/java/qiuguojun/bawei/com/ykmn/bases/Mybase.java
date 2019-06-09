package qiuguojun.bawei.com.ykmn.bases;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import qiuguojun.bawei.com.ykmn.R;
import qiuguojun.bawei.com.ykmn.bean.LBean;

public class Mybase extends RecyclerView.Adapter<Mybase.oneHolder>{
 private List<LBean.ResultBean> list;
 private Context context;
private int index=-1;
    public Mybase(List<LBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public oneHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context,R.layout.base,null);
        oneHolder holder=new oneHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final oneHolder oneHolder, final int i) {
oneHolder.t_name.setText(list.get(i).getName());
    oneHolder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             setonclickItem.onclickItem(oneHolder.itemView, i);

        }
    });
    if (i==index){
        oneHolder.t_name.setTextColor(Color.RED);
    }else {
        oneHolder.t_name.setTextColor(Color.BLACK);
    }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class oneHolder extends RecyclerView.ViewHolder{
        private TextView t_name;
        public oneHolder(@NonNull View itemView) {
            super(itemView);
            t_name=itemView.findViewById(R.id.name);
        }
    }
   private SetonclickItem setonclickItem;
    public interface SetonclickItem{
        void  onclickItem(View view,int position);
    }
    public void setSetonclickItem(SetonclickItem setonclickItem){
        this.setonclickItem=setonclickItem;
    }

    public void setTextColor(int position){
        this.index=position;
        notifyDataSetChanged();
    }
}
