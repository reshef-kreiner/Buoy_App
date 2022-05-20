package com.example.buay_app;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class HistoryAdapter extends FirebaseRecyclerAdapter<HomeModel, HistoryAdapter.myViewHolder>   {

    public HistoryAdapter(@NonNull FirebaseRecyclerOptions<HomeModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull HomeModel model) {
        holder.name.setText(model.getName());
        holder.title.setText(model.getTitle());
      //  holder.description.setText(model.getDescription());

        Glide.with(holder.img.getContext())
                .load(model.getVurl())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chatviewlayout,parent,false);
        return new myViewHolder(view);
    }

        class myViewHolder extends RecyclerView.ViewHolder{
            ImageView img;
            TextView name, title, description, Uid;

            public myViewHolder(@NonNull View itemView) {
                super(itemView);
                img = itemView.findViewById(R.id.imgChat);
                name = (TextView) itemView.findViewById(R.id.nameTextChat);
                title = (TextView) itemView.findViewById(R.id.titleTextChat);
               // Uid = (TextView) itemView.findViewById(R.id.Uid);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(v.getContext(),SpecificChat.class);
                        HomeModel homeModel = new HomeModel(name.toString(),title.toString(),description.toString(),img.toString(), Uid.toString());
                        intent.putExtra("name",homeModel.getName());
                        intent.putExtra("vurl",homeModel.getVurl());
                        //      intent.putExtra("uid",homeModel.getUid());
                        v.getContext().startActivity(intent);

                    }
                });

            }
        }
    }