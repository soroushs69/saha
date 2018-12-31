package com.example.yegan.myapplication.menuPage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.Collections;
import java.util.List;
import com.example.yegan.myapplication.R;
import com.example.yegan.myapplication.homePage.model.FoodTypeItem;


public class FoodTypeAdapter extends RecyclerView.Adapter<FoodTypeAdapter.ViewHolder> {

    private List<FoodTypeItem> navigationDrawerItemList = Collections.emptyList();
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    Context context;

    public FoodTypeAdapter(Context context, List<FoodTypeItem> data) {

        this.context   = context;
        this.mInflater = LayoutInflater.from(context);
        this.navigationDrawerItemList  = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_food_type, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        FoodTypeItem current = navigationDrawerItemList.get(position);
        holder.name.setText(current.getName());
        holder.icon.setImageResource(current.getImageId());



    }
    @Override
    public int getItemCount() {
        return navigationDrawerItemList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView name;
        public ImageView icon;

        public ViewHolder(final View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.food_type_item_name);
            icon = itemView.findViewById(R.id.food_type_item_icon);


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


