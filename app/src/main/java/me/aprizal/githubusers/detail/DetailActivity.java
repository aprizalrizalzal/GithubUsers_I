package me.aprizal.githubusers.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import me.aprizal.githubusers.R;
import me.aprizal.githubusers.databinding.ActivityDetailBinding;
import me.aprizal.githubusers.model.UserModel;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_USERS = "extra_users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        UserModel userModel = getIntent().getParcelableExtra(EXTRA_USERS);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(userModel.getName());
        }

        Glide.with(this).load(userModel.getAvatar()).centerCrop().placeholder(R.drawable.ic_baseline_account_circle_24).into(binding.imgAvatar);
        binding.tvName.setText(userModel.getName());

        binding.tvUsername.setText(getString(R.string.username, userModel.getUsername()));
        binding.tvFollower.setText(getString(R.string.follower, userModel.getFollower()));
        binding.tvFollowing.setText(getString(R.string.following, userModel.getFollowing()));
        binding.tvCompany.setText(getString(R.string.company, userModel.getCompany()));
        binding.tvLocation.setText(getString(R.string.location, userModel.getLocation()));
        binding.tvRepository.setText(getString(R.string.repository, userModel.getRepository()));

        binding.btnLink.setOnClickListener(v -> {
            Toast.makeText(this, "Buka Tautan User " + userModel.getName(), Toast.LENGTH_SHORT).show();
            String url = "http://github.com/" + userModel.getUsername();
            Intent link = new Intent(Intent.ACTION_VIEW);
            link.setData(Uri.parse(url));
            startActivity(link);
        });
    }
}