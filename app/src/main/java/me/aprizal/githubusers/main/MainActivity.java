package me.aprizal.githubusers.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import me.aprizal.githubusers.adapter.UserAdapter;
import me.aprizal.githubusers.data.UserData;
import me.aprizal.githubusers.databinding.ActivityMainBinding;
import me.aprizal.githubusers.detail.DetailActivity;
import me.aprizal.githubusers.model.UserModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final ArrayList<UserModel> userModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvUsers.setHasFixedSize(true);
        userModels.addAll(UserData.userModelList());
        showListUsers();
    }

    private void showListUsers() {
        binding.rvUsers.setLayoutManager(new LinearLayoutManager(this));
        UserAdapter userAdapter = new UserAdapter(userModels);
        binding.rvUsers.setAdapter(userAdapter);
        userAdapter.setOnItemClickCallback(this::showSelectedUsers);
    }

    private void showSelectedUsers(UserModel userModel) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);

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
        startActivity(intent);
    }
}