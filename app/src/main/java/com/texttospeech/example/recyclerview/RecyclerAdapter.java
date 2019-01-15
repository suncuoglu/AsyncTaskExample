package com.texttospeech.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ContactViewHolder>{

    ArrayList<ViewModel> adapter_list;
    MainActivity mainActivity;
    Context ctx;
    public RecyclerAdapter(ArrayList<ViewModel>adapter_list, Context ctx)
    {
        this.adapter_list=adapter_list;
        this.ctx=ctx;
        mainActivity=(MainActivity) ctx;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout,parent,false);
        ContactViewHolder contactViewHolder=new ContactViewHolder(view,mainActivity);

        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

        final ViewModel currentObject = adapter_list.get(position);
        holder.img.setImageResource(currentObject.getRes());
        holder.name.setText(currentObject.getName());
        holder.email.setText(currentObject.getMail());

        //in some cases, it will prevent unwanted situations
        holder.checkBox.setOnCheckedChangeListener(null);

        //if true, your checkbox will be selected, else unselected
        holder.checkBox.setChecked(currentObject.isChecked());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //set your object's last status
                currentObject.setChecked(isChecked);
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, InfoActivity.class);
                intent.putExtra("data",currentObject);
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return adapter_list.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder
    {
       ImageView img;
       TextView name,email;
       CheckBox checkBox;
       MainActivity mainActivity;
       CardView cardView;

       public ContactViewHolder(View itemView,MainActivity mainActivity) {
            super(itemView);
            img=itemView.findViewById(R.id.img_id);
            name=itemView.findViewById(R.id.name);
            email=itemView.findViewById(R.id.email);
            checkBox=itemView.findViewById(R.id.cbSelect);
            cardView=itemView.findViewById(R.id.cardview);
            this.mainActivity=mainActivity;
        }
    }
}
