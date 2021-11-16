package com.example.banzaaraapp.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.banzaaraapp.R;
import com.example.banzaaraapp.model.RecentsData;

import java.util.List;

public class RecentsAdapter extends RecyclerView.Adapter<RecentsAdapter.RecentsViewHolder> {

    Context context;
    List<RecentsData> recentsDataList;

    @NonNull
    @Override
    public RecentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.recents_row_item, parent,false);
        return new RecentsViewHolder(view);
    }

    public RecentsAdapter(Context context, List<RecentsData> recentsDataList) {
        this.context = context;
        this.recentsDataList = recentsDataList;
    }

    @Override
    public void onBindViewHolder(@NonNull RecentsViewHolder holder, int position) {

        holder.countryName.setText(recentsDataList.get(position).getCountryName());
        holder.placeName.setText(recentsDataList.get(position).getPlaceName());
        holder.price.setText(recentsDataList.get(position).getPrice());
        holder.placeImage.setImageResource(recentsDataList.get(position).getImageURL());
    }

    @Override
    public int getItemCount() {
        return recentsDataList.size();
    }

    public static final class RecentsViewHolder extends RecyclerView.ViewHolder{

        ImageView placeImage;
        TextView placeName, countryName, price;


        public RecentsViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage=itemView.findViewById(R.id.placeImage);
            placeName=itemView.findViewById(R.id.placeName);
            countryName=itemView.findViewById(R.id.countryName);
            price=itemView.findViewById(R.id.price);

        }
    }



}
