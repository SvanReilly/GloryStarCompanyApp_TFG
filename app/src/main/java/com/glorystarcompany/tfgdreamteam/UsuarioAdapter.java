package com.glorystarcompany.tfgdreamteam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {
    private ArrayList<Usuario> listaUsuario;
    public UsuarioAdapter(ArrayList<Usuario> listaUsuario) {this.listaUsuario = listaUsuario;}
    public void setListaUsuario(ArrayList<Usuario> listaUsuario) {this.listaUsuario = listaUsuario;}

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item_for_activity_settings, parent, false);
        return new UsuarioViewHolder(view, parent.getContext());
    }
    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        holder.BindUsuario(this.listaUsuario.get(position));
    }

    @Override
    public int getItemCount() {
        return this.listaUsuario.size();
    }

    public static class UsuarioViewHolder extends RecyclerView.ViewHolder {

        public TextView nombreView, mailView, winsView, defeatsView, gcAmountView;

        private Context context;

        public UsuarioViewHolder(View view, Context context) {
            super(view);
            this.context = context;

            nombreView = view.findViewById(R.id.usernameTextView);
            mailView = view.findViewById(R.id.mailTextView);
            winsView = view.findViewById(R.id.winsTextView);
            defeatsView = view.findViewById(R.id.defeatsTextView);
            gcAmountView = view.findViewById(R.id.gloryCoinAmountTextView);
        }

        public void BindUsuario(Usuario usuario) {
            nombreView.setText(usuario.getName());
            mailView.setText(usuario.getMail());
            winsView.setText(usuario.getWins());
            defeatsView.setText(usuario.getDefeats());
            gcAmountView.setText(usuario.getGcAmount());

        }
    }
}
