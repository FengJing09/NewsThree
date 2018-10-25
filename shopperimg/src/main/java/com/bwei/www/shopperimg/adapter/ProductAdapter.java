package com.bwei.www.shopperimg.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.www.shopperimg.R;
import com.bwei.www.shopperimg.Utils.StringUtils;
import com.bwei.www.shopperimg.bean.product;
import com.bwei.www.shopperimg.weight.AddDecreaseView;

import java.util.List;

/**
 * Created by asus on 2018/10/25.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private Context context;
    private List<product> list;

    public ProductAdapter(Context context, List<product> list) {
        this.context = context;
        this.list = list;
    }
public interface onProductClickListeren{
        void onProductClick(int position,boolean isCkecked);
}
private onProductClickListeren productClickListeren;
    public void setonProductClickListeren(onProductClickListeren listeren){
        this.productClickListeren = listeren;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = View.inflate(context, R.layout.item_product,null);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        product pro = list.get(position);
        String images = pro.getMsg();
        if (!TextUtils.isEmpty(images)){
            String[] strings = images.split("\\|");
            if (strings.length > 0){
                Glide.with(context)
                        .load(StringUtils.http2Http(strings[0]))
                        .into(holder.imgProduct);

            }
        }
        holder.txtProductNmae.setText(pro.getCode());
//        holder.txtSinglePrice.setText(String.valueOf(pro.getCode());
//        holder.advProduct.setNum(pro.g);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        CheckBox cbProduct;
        ImageView imgProduct;
        TextView txtSinglePrice;
        AddDecreaseView advProduct;
        TextView txtProductNmae;
        public ViewHolder(View itemView) {
            super(itemView);
             cbProduct = itemView.findViewById(R.id.cb_product);
           imgProduct = itemView.findViewById(R.id.img_product);
           txtSinglePrice = itemView.findViewById(R.id.txt_single_price);
            advProduct = itemView.findViewById(R.id.adv_product);
       txtProductNmae = itemView.findViewById(R.id.txt_product_name);

        }
    }

}
