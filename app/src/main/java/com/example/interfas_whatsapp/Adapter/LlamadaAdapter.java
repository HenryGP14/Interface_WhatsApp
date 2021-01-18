package com.example.interfas_whatsapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.interfas_whatsapp.Models.user;
import com.example.interfas_whatsapp.R;

import java.util.List;

public class LlamadaAdapter extends RecyclerView.Adapter<LlamadaAdapter.LlamadaViewHolder>{
    private Context Ctx;
    private List<user> lstUsuarios;

    public LlamadaAdapter(Context mCtx, List<user> usuarios) {
        this.lstUsuarios = usuarios;
        Ctx = mCtx;
    }

    @Override
    public LlamadaAdapter.LlamadaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        View view;
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        view = inflater.inflate(R.layout.item_llamada, null);
        return new LlamadaAdapter.LlamadaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LlamadaAdapter.LlamadaViewHolder holder, int position) {
        user usuario = lstUsuarios.get(position);

        holder.textViewName.setText(usuario.getFirst_name());
        holder.textTime.setText("Ayer 7:00 p.m");


        Glide.with(Ctx)
                .load(usuario.getAvatar())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return lstUsuarios.size();
    }


    class LlamadaViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewMessage, textViewHora, textTime;
        ImageView imageView;

        public LlamadaViewHolder(View itemView) {
            super(itemView);

            textTime = itemView.findViewById(R.id.txtTime);
            textViewName= itemView.findViewById(R.id.txtName);
            imageView = itemView.findViewById(R.id.imgAvatar);
        }
    }
}
