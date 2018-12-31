//آداپتر برای اسلایدر صفحه اصلی

package com.example.yegan.myapplication.homePage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yegan.myapplication.R;
import com.example.yegan.myapplication.homePage.model.RestaurantSliderItem;

import java.util.Collections;
import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.ViewHolder> {

    private List<RestaurantSliderItem> navigationDrawerItemList = Collections.emptyList();
    ////private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    ////public static Integer MyCounter = 0;
    ////public String[] Titles = {"غذا های خوشمزه را از ما انتظار داشته باشید", "برترین غذا های این هفته ","غذاه های پیشنهادی امروز" ,  "تخفیفات امروز" , "برترین ها بر اساس امتیاز"};
    ////Context context;

    public SliderAdapter(List<RestaurantSliderItem> data) {
        ////MyCounter = 0;
        ////this.context   = context;
        ////this.mInflater = LayoutInflater.from(context);
        if(data != null)
            this.navigationDrawerItemList  = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_slider, parent, false);
        ////ViewHolder viewHolder = new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bind(navigationDrawerItemList.get(position));
        ////RestaurantSliderItem current = navigationDrawerItemList.get(position);
        ////holder.background.setBackgroundResource(current.getImageId());
        ////holder.label.setText(Titles[MyCounter]);
    }
    @Override
    public int getItemCount() {
        return navigationDrawerItemList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public LinearLayout background;
        TextView label;

        public ViewHolder(final View itemView) {
            super(itemView);
            background = itemView.findViewById(R.id.background);
            label      = itemView.findViewById(R.id.slider_lable);
            itemView.setOnClickListener(this);
            ////MyCounter++;
        }

        public void bind(RestaurantSliderItem data){
            background.setBackgroundResource(data.getImageId());
            label.setText(data.getTitle());
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

