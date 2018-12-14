package com.example.karen.cinema;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class HallViewAdapter extends RecyclerView.Adapter<HallViewAdapter.ViewHolder> {

    private List<Place> data;
    private Context context;

    private Point[] reservedPlaces;
    private int  reservedPlacesCount = -1;


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

        final Place place = data.get(viewHolder.getAdapterPosition());

        viewHolder.place.setText(place.getNumberOfColl()+":"+place.getNumberOfRow());

        viewHolder.place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.place.setBackgroundColor(Color.GREEN);
                reservedPlacesCount++;

                LayoutInflater li = LayoutInflater.from(context);
                View reserveDialogView = li.inflate(R.layout.reserve_alertdialog_item, null);


                AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);

                mDialogBuilder.setView(reserveDialogView);

                final EditText userNameInput = (EditText) reserveDialogView.findViewById(R.id.userNameInput);
                final EditText userSurnameInput = (EditText) reserveDialogView.findViewById(R.id.userSurnameInput);

                mDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        String userName = userNameInput.getText().toString();
                                        String userSurname = userSurnameInput.getText().toString();
                                        int numerOfRow = place.getNumberOfRow();
                                        int numberOfCol = place.getNumberOfColl();
                                        place.soldThisPlace(new User(userName,userSurname,numerOfRow,numberOfCol));
                                        viewHolder.place.setBackgroundColor(Color.RED);
                                        viewHolder.place.setEnabled(false);
                                    }
                                })
                        .setNegativeButton("CANCEL",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });


                AlertDialog alertDialog = mDialogBuilder.create();


                alertDialog.show();

            }
        });


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
