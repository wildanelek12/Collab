package com.example.e_collabclasroom;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class JobsheetAdapter extends RecyclerView.Adapter<JobsheetAdapter.ListViewHolder> {
    private ArrayList<ModelJobsheet> modelJobsheets;

    public JobsheetAdapter(ArrayList<ModelJobsheet> list) {
        this.modelJobsheets = list;
    }

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_jobsheet, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        ModelJobsheet hero = modelJobsheets.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hero.getGambarJudul())
                .apply(new RequestOptions().override(955, 714))
                .into(holder.imgPhoto);
        holder.tvName.setText(hero.getTxtJudul());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(view.getContext(),WebViewJobsheetActivity.class);
                intent.putExtra("namaModul",hero.getNamaModul());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelJobsheets.size();
    }

    public interface OnItemClickCallback {
        void onItemClicked(ModelJobsheet data);
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;
        CardView cardView;
        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.textViewName);
            cardView = itemView.findViewById(R.id.cardView);


        }
    }
}