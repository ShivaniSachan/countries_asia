package com.example.countries_asia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
       return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);

        holder.textViewHead.setText(listItem.getHead());
        holder.textViewDesc.setText(listItem.getDesc());
        holder.textViewsubreg.setText(listItem.getSubreg());
        holder.textViewpopu.setText(listItem.getPopulation());
        holder.textViewborder.setText(listItem.getBorder());
        holder.textViewlang.setText(listItem.getLanguages());


        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);



        Glide.with(context).load(listItem.getImgUrl()).apply(options).into(holder.imageView);

        Picasso.get()
                .load(listItem.getImgUrl())
                 .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHead;
        public TextView textViewDesc;
        public TextView textViewsubreg;
        public TextView textViewpopu;
        public TextView textViewborder;
        public TextView textViewlang;


        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewHead =(TextView) itemView.findViewById(R.id.TextViewHead);
            textViewDesc =(TextView) itemView.findViewById(R.id.TextViewDisc);
            textViewsubreg =(TextView) itemView.findViewById(R.id.TextViewsubreg);
            textViewpopu =(TextView) itemView.findViewById(R.id.TextViewpopu);
            textViewborder =(TextView) itemView.findViewById(R.id.TextViewborder);
            textViewlang =(TextView) itemView.findViewById(R.id.TextViewlang);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);

        }
    }
}
