package com.example.karen.cinema;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class HallViewAdapter extends RecyclerView.Adapter<HallViewAdapter.ViewHolder> {

    private List<Place> data;
    private Context context;

    public HallViewAdapter(List<Place> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public HallViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.place_recycler_item, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {

        Place place = data.get(viewHolder.getAdapterPosition());

        viewHolder.place.setText(place.getNumberOfColl()+":"+place.getNumberOfRow());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView place;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            place = itemView.findViewById(R.id.place);


        }


    }


}
