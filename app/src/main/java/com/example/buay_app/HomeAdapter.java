package com.example.buay_app;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeAdapter extends FirebaseRecyclerAdapter<HomeModel, HomeAdapter.myViewHolder>  {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public HomeAdapter(@NonNull FirebaseRecyclerOptions<HomeModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull HomeModel model) {
        holder.name.setText(model.getName());
        holder.title.setText(model.getTitle());
        holder.description.setText(model.getDescription());
        //holder.counter.setText(model.getCounter());

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        CircleImageView img;
        TextView name, title, description, counter;
        ImageView likeImageView;
        boolean isLiked= false;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (CircleImageView) itemView.findViewById(R.id.img1);
            name = (TextView) itemView.findViewById(R.id.nameText);
            title = (TextView) itemView.findViewById(R.id.titleText);
            description = (TextView) itemView.findViewById(R.id.descriptionText);
            //counter = (TextView) itemView.findViewById(R.id.counterText);


            //the like image view "button"
            likeImageView = itemView.findViewById(R.id.like_imageView);
            likeImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isLiked == false){
                        likeImageView.setImageResource(R.drawable.like_picture_full);
                        isLiked = true;
                    } else {
                        likeImageView.setImageResource(R.drawable.like_picture_empty);
                        isLiked = false;
                    }
                }
            });

            //chat button
            ImageView chatImageView = itemView.findViewById(R.id.chat_imageView);
            chatImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.getContext().startActivity(new Intent(v.getContext(),ChatActivity.class));

                }
            });

        }
    }
}