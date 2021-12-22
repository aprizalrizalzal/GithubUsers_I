package me.aprizal.githubusers.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import me.aprizal.githubusers.databinding.ListRowUsersBinding;
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
        ListRowUsersBinding binding = ListRowUsersBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        return new ViewHolder(binding);
    }


    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull UserAdapter.ViewHolder holder, int position) {
        UserModel userModel = userModels.get(position);
        holder.bind(userModel);
        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(userModels.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return userModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ListRowUsersBinding binding;

        public ViewHolder(ListRowUsersBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bind(UserModel userModel) {
            Glide.with(itemView).load(userModel.getAvatar()).placeholder(R.drawable.ic_baseline_account_circle_24).into(binding.imgUsers);
            binding.tvName.setText(userModel.getName());
            binding.tvUsername.setText(userModel.getUsername());
            binding.btnShare.setOnClickListener(v -> {
                Toast.makeText(v.getContext(),"Share",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, userModel.getName());
                intent.putExtra(Intent.EXTRA_TEXT, v.getResources().getString(R.string.link,userModel.getUsername()));
                v.getContext().startActivity(Intent.createChooser(intent, "Share Via"));
            });
        }
    }
}
