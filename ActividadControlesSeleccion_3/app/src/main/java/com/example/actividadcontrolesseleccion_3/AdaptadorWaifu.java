package com.example.actividadcontrolesseleccion_3;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdaptadorWaifu extends ArrayAdapter<Waifu> {
    public AdaptadorWaifu(@NonNull Context context, @NonNull Waifu[] objects) {
        super(context, R.layout.waifu_layout, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Waifu waifu = getItem(position);
        ViewHolder holder;

        View item = convertView;
        if (item == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.waifu_layout, null);
            holder = new ViewHolder();
            holder.img = item.findViewById(R.id.ivImgWaifu);
            holder.nom = item.findViewById(R.id.tvNombreWaifu);
            holder.serie = item.findViewById(R.id.tvSerie);
            holder.btnSearch = item.findViewById(R.id.btnSearch);
            item.setTag(holder);
        } else {
            holder = (ViewHolder) item.getTag();
        }

        ImageView img = holder.img;
        img.setImageResource(waifu.getImg());
        TextView nom = holder.nom;
        nom.setText(waifu.getNom());
        TextView serie = holder.serie;
        serie.setText(waifu.getSerie());
        ImageButton btnSearch = holder.btnSearch;
        if (waifu.getInfoLink() != null && !waifu.getInfoLink().isEmpty()) {
            btnSearch.setVisibility(View.VISIBLE);
            btnSearch.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(waifu.getInfoLink()));
                getContext().startActivity(intent);
            });
        } else {
            btnSearch.setVisibility(View.INVISIBLE);
        }
        return item;
    }

    private static class ViewHolder {
        ImageView img;
        TextView nom, serie;
        ImageButton btnSearch;
    }
}
