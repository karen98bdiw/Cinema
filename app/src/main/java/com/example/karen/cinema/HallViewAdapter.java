package com.example.karen.cinema;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.graphics.Color;
import android.graphics.Point;
import android.preference.PreferenceManager;
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
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class HallViewAdapter extends RecyclerView.Adapter<HallViewAdapter.ViewHolder> {

    private List<Place> data;
    private Context context;

    interface OnPlaceClikedListener{
        void onPlaceClick(Place place);
    }

    OnPlaceClikedListener onPlaceClikedListener;

    public void setOnPlaceClikedListener(OnPlaceClikedListener onPlaceClikedListener) {
        this.onPlaceClikedListener = onPlaceClikedListener;
    }

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

//        try {
//            FileInputStream fin = context.openFileInput("place.plc");
//            int c;
//
//            while( (c = fin.read()) != -1){
//               data.get(c).setReserved(true);
//            }
//            Toast.makeText(context,"file read",Toast.LENGTH_SHORT).show();
//        }
//        catch(Exception e){
//        }



        final Place place = data.get(viewHolder.getAdapterPosition());
//        if(place.isReserved()){
//            viewHolder.place.setBackgroundColor(Color.RED);
//        }
        viewHolder.place.setText(place.getNumberOfColl()+":"+place.getNumberOfRow());

        viewHolder.place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onPlaceClikedListener.onPlaceClick(place);

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
                                        int numberOfRow = place.getNumberOfRow();
                                        int numberOfCol = place.getNumberOfColl();
                                        User curentUser = new User(userName,userSurname,numberOfRow,numberOfCol,(numberOfRow+numberOfCol));
                                        place.soldThisPlace(curentUser);
                                        place.setReserverId(curentUser.getUserId());
                                        viewHolder.place.setBackgroundColor(Color.RED);
                                        viewHolder.place.setEnabled(false);
//                                        try {
//                                            fos = new FileOutputStream(placeFile);
//                                            fos.write(numberOfRow);
//                                        } catch (FileNotFoundException e) {
//                                            e.printStackTrace();
//                                        } catch (IOException e) {
//                                            e.printStackTrace();
//                                        }

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
