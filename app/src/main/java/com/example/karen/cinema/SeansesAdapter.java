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

public class SeansesAdapter extends RecyclerView.Adapter<SeansesAdapter.ViewHolder> {

    private List<Seans> data;
    private Context context;

    public SeansesAdapter(List<Seans> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public SeansesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.seanses_recycler_item, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {

        viewHolder.seansPrice.setText("price is:"+data.get(viewHolder.getAdapterPosition()).getPrice());
        viewHolder.seansDate.setText("date is:"+data.get(viewHolder.getAdapterPosition()).getSeansDate().toString());
        viewHolder.seansHallname.setText("In the" + " " + data.get(viewHolder.getAdapterPosition()).getHall().getHallName());

        viewHolder.setSeansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,HallViewActivity.class);
                intent.putExtra("currentHall",data.get(viewHolder.getAdapterPosition()).getHall());
                intent.putExtra("seansPrice",data.get(viewHolder.getAdapterPosition()).getPrice());
                context.startActivity(intent);

            }
        });
        }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView seansDate;
        private TextView seansHallname;
        private TextView seansPrice;
        private Button setSeansBtn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            seansDate = itemView.findViewById(R.id.seansDate);
            seansHallname = itemView.findViewById(R.id.seansHallname);
            seansPrice = itemView.findViewById(R.id.seansPrice);
            setSeansBtn = itemView.findViewById(R.id.setSeansBtn);


        }


    }


}
