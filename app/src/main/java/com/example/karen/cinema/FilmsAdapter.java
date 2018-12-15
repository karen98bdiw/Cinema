package com.example.karen.cinema;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {

    private List<Film> data;
    private Context context;
    private Hall[] halls;
    private Hall currentHall;
    private String seansPriceFromAddSeans;
    private EditText takeSeansPriceFromAddSeans;
    private boolean isAdmin;

    public FilmsAdapter(List<Film> data, Context context,boolean isAdmin) {
        this.data = data;
        this.context = context;
        this.isAdmin = isAdmin;
    }

    @NonNull
    @Override
    public FilmsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.films_recycler_item, viewGroup, false);
        return new FilmsAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final FilmsAdapter.ViewHolder viewHolder, final int position) {

        if (isAdmin){
            viewHolder.addSeansBtn.setVisibility(View.VISIBLE);
        }

        final Film film = data.get(viewHolder.getAdapterPosition());
        viewHolder.filmName.setText(film.getFilmName());

        viewHolder.watchSeansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SeansesActivity.class);
                intent.putExtra("currentFilm",film);
                context.startActivity(intent);
            }
        });

        viewHolder.addSeansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater li = LayoutInflater.from(context);
                final View reserveDialogView = li.inflate(R.layout.activity_add_new_seans, null);

                AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);

                mDialogBuilder.setView(reserveDialogView);
                halls = new Hall[]{
                        Hall.HALL_1,
                        Hall.HALL_1,
                        Hall.HALL_2,
                        Hall.HALL_3,
                        Hall.VIP_HALL
                };

                takeSeansPriceFromAddSeans  = reserveDialogView.findViewById(R.id.seansPriceFromAddSeans);

                String[] data = {"SELECT HALL", "Hall_1", "Hall_2","HALL_3","VIP_HALL"};

                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, data);
                adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);

                Spinner spinner = (Spinner) reserveDialogView.findViewById(R.id.chooseHallSpinnerFromFilmActivity);

                spinner.setAdapter(adapter);

                spinner.setPrompt("Title");

                spinner.setSelected(false);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view,
                                               int position, long id) {
                        currentHall = halls[position];
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {

                    }
                });

                mDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        seansPriceFromAddSeans = takeSeansPriceFromAddSeans.getText().toString();
                                        film.addSeans(new Seans(currentHall, new Date(2018,12,25,18,0,0),
                                                seansPriceFromAddSeans));
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

        private ImageView filmImg;
        private TextView filmName;
        private Button watchSeansBtn;
        private Button addSeansBtn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

           filmImg = itemView.findViewById(R.id.filmIcon);
           filmName = itemView.findViewById(R.id.filmName);
           watchSeansBtn = itemView.findViewById(R.id.watchSeansBtn);
           addSeansBtn = itemView.findViewById(R.id.addSeansBtn);


        }


    }

}
