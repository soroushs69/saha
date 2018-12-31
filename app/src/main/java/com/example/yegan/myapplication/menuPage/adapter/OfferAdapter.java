package com.example.yegan.myapplication.menuPage.adapter;

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

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {

    private List<RestaurantSliderItem> navigationDrawerItemList = Collections.emptyList();
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    public static Integer MyCounter = 0;
    public String[] Titles = {"غذا های خوشمزه را از ما انتظار داشته باشید", "برترین غذا های این هفته ","غذاه های پیشنهادی امروز" ,  "تخفیفات امروز" , "برترین ها بر اساس امتیاز", "طرز تهیه استیک گوشت", "نحوه طبخ زرشک پلو با مرغ", "خوشمزه"};
    Context context;

    public OfferAdapter(Context context, List<RestaurantSliderItem> data) {
        MyCounter = 0;
        this.context   = context;
        this.mInflater = LayoutInflater.from(context);
        this.navigationDrawerItemList  = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_offer, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        RestaurantSliderItem current = navigationDrawerItemList.get(position);
        holder.background.setBackgroundResource(current.getImageId());
        holder.label.setText(Titles[MyCounter]);
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
            MyCounter++;
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

