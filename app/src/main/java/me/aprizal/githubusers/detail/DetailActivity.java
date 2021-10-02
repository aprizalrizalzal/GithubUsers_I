package me.aprizal.githubusers.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;
import me.aprizal.githubusers.R;
import me.aprizal.githubusers.model.UserModel;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_USERS = "extra_users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        CircleImageView img_avatar = findViewById(R.id.img_avatar);
        TextView name = findViewById(R.id.tv_name);
        TextView username = findViewById(R.id.tv_username);
        TextView follower = findViewById(R.id.tv_follower);
        TextView following = findViewById(R.id.tv_following);
        TextView company = findViewById(R.id.tv_company);
        TextView location = findViewById(R.id.tv_location);
        TextView repository = findViewById(R.id.tv_repository);
        Button btnLink = findViewById(R.id.btn_link);

        UserModel userModel = getIntent().getParcelableExtra(EXTRA_USERS);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(userModel.getName());
        }

        Glide.with(this).load(userModel.getAvatar()).centerCrop().placeholder(R.drawable.ic_baseline_account_circle_24).into(img_avatar);
        name.setText(userModel.getName());

        username.setText(getString(R.string.username, userModel.getUsername()));
        follower.setText(getString(R.string.follower, userModel.getFollower()));
        following.setText(getString(R.string.following, userModel.getFollowing()));
        company.setText(getString(R.string.company, userModel.getCompany()));
        location.setText(getString(R.string.location, userModel.getLocation()));
        repository.setText(getString(R.string.repository, userModel.getRepository()));

        btnLink.setOnClickListener(v -> {
            Toast.makeText(this, "Buka Tautan User " + userModel.getName(), Toast.LENGTH_SHORT).show();
            String url = "http://github.com/" + userModel.getUsername();
            Intent link = new Intent(Intent.ACTION_VIEW);
            link.setData(Uri.parse(url));
            startActivity(link);
        });
    }
}