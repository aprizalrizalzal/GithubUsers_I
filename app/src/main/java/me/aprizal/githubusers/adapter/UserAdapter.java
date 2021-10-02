package me.aprizal.githubusers.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import me.aprizal.githubusers.detail.DetailActivity;
import me.aprizal.githubusers.R;
import me.aprizal.githubusers.model.UserModel;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private final List<UserModel> userModels;

    public UserAdapter(List<UserModel> userModels) {
        this.userModels = userModels;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_users, parent,false);
        return new ViewHolder(view);
    }


    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull UserAdapter.ViewHolder holder, int position) {
        UserModel userModel = userModels.get(position);
        holder.bind(userModel);
        holder.itemView.setOnClickListener(v -> {
            onItemClickCallback.onItemClicked(userModels.get(holder.getAdapterPosition()));
        });
    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgAvatar;
        private final TextView tvName;
        private final TextView tvUsername;
        private final Button btnLink;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgAvatar=itemView.findViewById(R.id.img_users);
            tvName=itemView.findViewById(R.id.tv_name);
            tvUsername=itemView.findViewById(R.id.tv_username);
            btnLink=itemView.findViewById(R.id.btn_share);
        }

        public void bind(UserModel userModel) {
            Glide.with(itemView).load(userModel.getAvatar()).placeholder(R.drawable.ic_baseline_account_circle_24).into(imgAvatar);
            tvName.setText(userModel.getName());
            tvUsername.setText(userModel.getUsername());
            btnLink.setOnClickListener(v -> {
                Toast.makeText(v.getContext(),"Share",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, userModel.getName());
                intent.putExtra(Intent.EXTRA_TEXT, v.getResources().getString(R.string.link,userModel.getUsername()));
                v.getContext().startActivity(Intent.createChooser(intent, "Share Via"));
            });

            /*itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);

                UserModel model = new UserModel();
                model.setAvatar(userModel.getAvatar());
                model.setName(userModel.getName());
                model.setUsername(userModel.getUsername());
                model.setFollower(userModel.getFollower());
                model.setFollowing(userModel.getFollowing());
                model.setCompany(userModel.getCompany());
                model.setLocation(userModel.getLocation());
                model.setRepository(userModel.getRepository());

                intent.putExtra(DetailActivity.EXTRA_USERS,model);
                itemView.getContext().startActivity(intent);
            });*/
        }
    }
}
