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

public class EstadoAdapter extends RecyclerView.Adapter<EstadoAdapter.EstadoViewHolder>{
    private Context Ctx;
    private List<user> lstUsuarios;

    public EstadoAdapter(Context mCtx, List<user> usuarios) {
        this.lstUsuarios = usuarios;
        Ctx = mCtx;
    }

    @Override
    public EstadoAdapter.EstadoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        View view;
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        view = inflater.inflate(R.layout.item_estado, null);
        return new EstadoAdapter.EstadoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EstadoViewHolder holder, int position) {
        user usuario = lstUsuarios.get(position);

        holder.textViewName.setText(usuario.getFirst_name());
        holder.textTime.setText("hace " + position + "0" + " minutos");


        Glide.with(Ctx)
                .load(usuario.getAvatar())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return lstUsuarios.size();
    }


    class EstadoViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewMessage, textViewHora, textTime;
        ImageView imageView;

        public EstadoViewHolder(View itemView) {
            super(itemView);

            textTime = itemView.findViewById(R.id.txtTime);
            textViewName= itemView.findViewById(R.id.txtName);
            imageView = itemView.findViewById(R.id.imgAvatar);
        }
    }
}
