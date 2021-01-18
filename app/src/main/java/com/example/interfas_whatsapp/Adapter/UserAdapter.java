package com.example.interfas_whatsapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.interfas_whatsapp.Models.user;
import com.example.interfas_whatsapp.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UsuarioViewHolder>{
    private Context Ctx;
    private List<user> lstUsuarios;

    public UserAdapter(Context mCtx, List<user> usuarios) {
        this.lstUsuarios = usuarios;
        Ctx=mCtx;
    }

    @Override
    public UsuarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.item_usuario, null);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsuarioViewHolder holder, int position) {

        user usuario = lstUsuarios.get(position);

        holder.textViewName.setText(usuario.getFirst_name());
        holder.textViewMail.setText("11:40 a.m");
        holder.textViewURLAvatar.setText("Hola estos son mensajes de ejemplo");

        Glide.with(Ctx)
                .load(usuario.getAvatar())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.imageView);

    }


    @Override
    public int getItemCount() {
        return lstUsuarios.size();
    }


    class UsuarioViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewURLAvatar, textViewMail;
        ImageView imageView;

        public UsuarioViewHolder(View itemView) {
            super(itemView);

            textViewName= itemView.findViewById(R.id.txtName);
            textViewURLAvatar = itemView.findViewById(R.id.txtMsj);
            textViewMail = itemView.findViewById(R.id.txtHora);
            imageView = itemView.findViewById(R.id.imgAvatar);
        }
    }

}
