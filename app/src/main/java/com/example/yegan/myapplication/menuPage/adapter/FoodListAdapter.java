package com.example.yegan.myapplication.menuPage.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yegan.myapplication.R;
import com.example.yegan.myapplication.homePage.model.FoodItem;

import java.util.Collections;
import java.util.List;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.ViewHolder>{

    private List<FoodItem> navigationDrawerItemList= Collections.emptyList();
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
            Context context;
    public FoodListAdapter(Context context,List<FoodItem> data){

            this.context=context;
            this.mInflater=LayoutInflater.from(context);
            this.navigationDrawerItemList=data;
            }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            View view=mInflater.inflate(R.layout.item_food,parent,false);
            ViewHolder viewHolder=new ViewHolder(view);
            return viewHolder;
            }
    @Override
    public void onBindViewHolder(final ViewHolder holder,int position){
                FoodItem current = navigationDrawerItemList.get(position);
                holder.photo.setImageResource(current.getImageId());
                holder.foodName.setText(current.getFoodName());
                holder.restuarantName.setText(current.getRestuarantName());
                holder.time.setText( "'" + current.getTimeRemain() );
                holder.price.setText(current.getPrice());
                holder.price.setPaintFlags(holder.price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                holder.salePrice.setText(current.getSalePrice());
                holder.num.setText(current.getHowMany() + "");

            }


    @Override
    public int getItemCount(){
            return navigationDrawerItemList.size();
            }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView photo;
        public TextView foodName, restuarantName, time, price, salePrice, num;


        public ViewHolder(final View itemView) {
            super(itemView);

            photo                =  itemView.findViewById(R.id.photo);
            foodName             = itemView.findViewById(R.id.food_name);
            restuarantName       = itemView.findViewById(R.id.restuarant_name);
            time                 = itemView.findViewById(R.id.time);
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
