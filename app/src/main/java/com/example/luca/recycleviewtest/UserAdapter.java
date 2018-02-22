package com.example.luca.recycleviewtest;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Luca on 16/02/2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private List<User> usersList;
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserAdapter.MyViewHolder holder, int position) {
        User user = usersList.get(position);
        holder.nome.setText(user.getNome());
        holder.cognome.setText(user.getCognome());
        holder.eta.setText(user.getEta());
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public UserAdapter(List<User> usersList) {
        this.usersList = usersList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nome,cognome,eta;

        public MyViewHolder(View itemView) {
            super(itemView);
            nome = (TextView) itemView.findViewById(R.id.nome);
            cognome = (TextView) itemView.findViewById(R.id.cognome);
            eta = (TextView) itemView.findViewById(R.id.eta);
        }
    }
}
