package com.bwei.www.shopperimg.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwei.www.shopperimg.R;

/**
 * Created by asus on 2018/10/25.
 */

public class AddDecreaseView extends RelativeLayout implements View.OnClickListener {
    private int num;
    private TextView txtAdd;
    private TextView txtDecrease;
    private TextView txtNum;



    public interface OnAddDecreaseClickListeren{
        void add(int num);
        void decrease(int num);
    }
    public OnAddDecreaseClickListeren listeren;

    public void setOnAddDecreaseClickListeren (OnAddDecreaseClickListeren listeren){
        this.listeren = listeren;
    }

    public AddDecreaseView(Context context) {
        this(context,null);
    }

    public AddDecreaseView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AddDecreaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View.inflate(context, R.layout.iten_add_decrease,this);
        txtAdd = findViewById(R.id.txt_add);
        txtDecrease = findViewById(R.id.txt_decrease);
        txtNum = findViewById(R.id.txt_num);

        txtNum.setText("1");

        txtAdd.setOnClickListener(this);
        txtDecrease.setOnClickListener(this);
    }
    public void setNum(int num){
        this.num = num;
        txtNum.setText(num+"");
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt_add:
                num++;
                txtNum.setText(num+"");

                if (listeren != null){
                    listeren.add(num);
                }
                break;

            case R.id.txt_decrease:

                if (num>1){
                    num--;
                }
                txtNum.setText(num+"");
                if (listeren!= null){
                    listeren.decrease(num);
                }
                break;
        }
    }

}
