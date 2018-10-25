package com.bwei.www.animator.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwei.www.animator.R;
import com.bwei.www.animator.bean.LeftBean;

import java.util.List;

/**
 * Created by asus on 2018/10/25.
 */

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolder> {
    private Context context;
    private List<LeftBean.DataBean> list;

    public LeftAdapter(Context context, List<LeftBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }
    public interface OnItemClickListeren{
        void onItemClick(View itemviiew,int position);
    }
    public OnItemClickListeren clickListeren;

    public void setOnItemClickListeren(OnItemClickListeren clickListeren){
        this.clickListeren = clickListeren;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v = View.inflate(context, R.layout.item_list,null);
      LeftAdapter.ViewHolder holder = new LeftAdapter.ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txtleft.setText(list.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListeren != null){
                    clickListeren.onItemClick(v,position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtleft;
        public ViewHolder(View itemView) {
            super(itemView);
             txtleft = itemView.findViewById(R.id.txt_left);
        }
    }
}
