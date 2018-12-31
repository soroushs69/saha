package com.example.yegan.myapplication.menuPage.adapter;


import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yegan.myapplication.R;
import com.example.yegan.myapplication.homePage.model.CategoryMenuItem;
import java.util.Collections;
import java.util.List;

public class CategoryMenuAdapter extends RecyclerView.Adapter<CategoryMenuAdapter.ViewHolder>{

    private List<CategoryMenuItem> navigationDrawerItemList= Collections.emptyList();
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    Context context;
    public CategoryMenuAdapter(Context context,List<CategoryMenuItem> data){

        this.context=context;
        this.mInflater=LayoutInflater.from(context);
        this.navigationDrawerItemList=data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view=mInflater.inflate(R.layout.item_category_menu, parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder,int position){
        CategoryMenuItem current = navigationDrawerItemList.get(position);

        holder.foodName.setText(current.getFoodName());
        holder.time.setText("'" + current.getTime());
        holder.ingredient.setText(current.getIngredient());
        holder.price.setText(current.getPrice());
        holder.price.setPaintFlags(holder.price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.salePrice.setText(current.getSalePrice());
        holder.num.setText(current.getNum() + "");
    }


    @Override
    public int getItemCount(){
        return navigationDrawerItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView foodName, time, price, salePrice, num, ingredient;


        public ViewHolder(final View itemView) {
            super(itemView);

            foodName             = itemView.findViewById(R.id.food_name);
            time                 = itemView.findViewById(R.id.time);
            ingredient           = itemView.findViewById(R.id.ingredient);
            price                = itemView.findViewById(R.id.price);
            salePrice            = itemView.findViewById(R.id.sale_price);
            num                  = itemView.findViewById(R.id.num);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) {
                mClickListener.onItemClick(view, getAdapterPosition());

            }
        }
    }


    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;

    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }



}
