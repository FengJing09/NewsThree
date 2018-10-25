package com.bwei.www.animator.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.www.animator.R;
import com.bwei.www.animator.bean.RightBean;

import java.util.List;


/**
 * Created by asus on 2018/10/25.
 */

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.ViewHolder> {
   private Context context;
   private List<RightBean.DataBean.ListBean> list;

    public RightAdapter(Context context, List<RightBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.item_right,null);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getIcon()).into(holder.imageright);
        holder.txtRight.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageright;
        TextView txtRight;
        public ViewHolder(View itemView) {
            super(itemView);
          imageright = itemView.findViewById(R.id.img_right);
          txtRight = itemView.findViewById(R.id.txt_right);
        }
    }

}
