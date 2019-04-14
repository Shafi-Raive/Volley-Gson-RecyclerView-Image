package com.example.shafi.apimanage.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shafi.apimanage.Network.StudentList;
import com.example.shafi.apimanage.R;

public class Custom extends RecyclerView.Adapter<Custom.CustomViewHolder> {

    private Context context;
    private StudentList[] data;

    public Custom(Context context, StudentList[] data){

        this.context = context;
        this.data = data;

    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.sample_recycler_view, viewGroup, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {

        StudentList list = data[i];
        customViewHolder.userName.setText(list.getLogin());
        customViewHolder.userId.setText(list.getNodeId());
        customViewHolder.count.setText(String.valueOf(list.getId()));
        Glide.with(customViewHolder.userImage.getContext()).load(list.getAvatarUrl()).into(customViewHolder.userImage);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        ImageView userImage;
        TextView userName, userId, count;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.igProfile);
            userName = itemView.findViewById(R.id.tvName);
            userId = itemView.findViewById(R.id.tvUserId);
            count = itemView.findViewById(R.id.tvId);
        }
    }
}
