package com.example.karen.cinema;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.ViewHolder> {

    private List<Film> data;
    private Context context;

    public FilmsAdapter(List<Film> data, Context context) {
        this.data = data;
        this.context = context;
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

        final Film film = data.get(viewHolder.getAdapterPosition());
        viewHolder.filmName.setText(film.getFilmName());

        viewHolder.seansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SeansesActivity.class);
                intent.putExtra("currentFilm",film);
                context.startActivity(intent);
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
        private Button seansBtn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

           filmImg = itemView.findViewById(R.id.filmIcon);
           filmName = itemView.findViewById(R.id.filmName);
           seansBtn = itemView.findViewById(R.id.seansBtn);

        }


    }

}
