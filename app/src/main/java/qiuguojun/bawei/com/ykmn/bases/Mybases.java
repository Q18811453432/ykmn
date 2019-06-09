package qiuguojun.bawei.com.ykmn.bases;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import qiuguojun.bawei.com.ykmn.R;
import qiuguojun.bawei.com.ykmn.bean.GBean;

public class Mybases extends RecyclerView.Adapter<Mybases.twoHolder> {
    private List<GBean.ResultBean> list;
    private Context context;

    public Mybases(List<GBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public twoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.bases, null);
        twoHolder twoHolder = new twoHolder(view);
        return twoHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final twoHolder twoHolder, final int i) {
        twoHolder.t_name.setText(list.get(i).getName());
        twoHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               setonclickItem.onclickItem(twoHolder.itemView,i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class twoHolder extends RecyclerView.ViewHolder {
        private TextView t_name;

        public twoHolder(@NonNull View itemView) {
            super(itemView);
            t_name = itemView.findViewById(R.id.name);

        }
    }
    private SetonclickItem setonclickItem;
    public interface SetonclickItem{
        void onclickItem(View view,int position);
    }
    public void setclicks(SetonclickItem setonclickItem){
         this.setonclickItem=setonclickItem;
    }
}
