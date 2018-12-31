


package com.example.yegan.myapplication.homePage.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.yegan.myapplication.R;
import com.example.yegan.myapplication.homePage.model.RestuarantItem;


import java.util.Collections;
import java.util.List;
public class RestuarantMenuAdapter extends RecyclerView.Adapter<RestuarantMenuAdapter.ViewHolder> {

    private List<RestuarantItem> navigationDrawerItemList = Collections.emptyList();
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    Context context;

    public RestuarantMenuAdapter(Context context, List<RestuarantItem> data) {

        this.context   = context;
        this.mInflater = LayoutInflater.from(context);
        this.navigationDrawerItemList  = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_restuarant, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        RestuarantItem current = navigationDrawerItemList.get(position);
        holder.name.setText(current.getName());
        holder.type.setText(current.getType());
        holder.logo.setImageResource(current.getLogoId());
        holder.background.setBackgroundResource(current.getBackgroundId());



    }
    @Override
    public int getItemCount() {
        return navigationDrawerItemList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ConstraintLayout background;
        public TextView name, type;
        public ImageView logo;
        public RatingBar rate;

        public ViewHolder(final View itemView) {
            super(itemView);

            background = itemView.findViewById(R.id.background);
            name       = itemView.findViewById(R.id.restuarant_name);
            type       = itemView.findViewById(R.id.restuarant_type);
            rate       = itemView.findViewById(R.id.rate);
            logo       = itemView.findViewById(R.id.logo);
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

