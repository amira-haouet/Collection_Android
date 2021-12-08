package com.example.productmanagerwithui;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView. Adapter<Adapter.MyViewHolder>{

    private List<Etudiant> etudiantList;
    public Adapter(List<Etudiant> y) {
        etudiantList = y;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw,parent, false);
        return new MyViewHolder(v);
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView t;
        public TextView i,s;
        public MyViewHolder(View view) {
            super(view);
            t = view.findViewById(R.id.name);
            i  = view.findViewById(R.id.lastName);
            s = view.findViewById(R.id.Class);
            // t  = view.findViewById(R.id.type);

        }
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Etudiant c = etudiantList.get(position);
        holder.i.setText(c.getSname().toString());
        // holder.y.setText(c.getYear());
        holder.t.setText(c.getFname());
        holder.s.setText(c.getCls());
    }
    @Override
    public int getItemCount() {
        return etudiantList.size();
    }

}