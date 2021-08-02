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

public class PdfOfflineAdapter extends RecyclerView.Adapter<PdfOfflineAdapter.ListViewHolderCollabCollab> {
    private ArrayList<ModelCollab> modelCollab;

    public PdfOfflineAdapter(ArrayList<ModelCollab> list) {
        this.modelCollab = list;
    }

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolderCollabCollab onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_collab, viewGroup, false);
        return new ListViewHolderCollabCollab(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolderCollabCollab holder, int position) {
        ModelCollab hero = modelCollab.get(position);
        holder.tvName.setText(hero.getTxtJudul());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(view.getContext(),PdfViewer.class);
                intent.putExtra("nama",hero.getTxtLink());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelCollab.size();
    }

    public interface OnItemClickCallback {
        void onItemClicked(ModelCollab data);
    }

    class ListViewHolderCollabCollab extends RecyclerView.ViewHolder {
        TextView tvName;
        CardView cardView;
        ListViewHolderCollabCollab(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.textViewName);
            cardView = itemView.findViewById(R.id.cardView);


        }
    }
}