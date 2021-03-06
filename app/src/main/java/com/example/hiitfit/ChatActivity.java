package com.example.hiitfit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hiitfit.Fragments.ChatsFragment;
import com.example.hiitfit.Fragments.UsersFragment;
import com.example.hiitfit.Model.User;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatActivity extends AppCompatActivity {
CircleImageView img;
TextView tv;

FirebaseUser user;
DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        img = (CircleImageView)findViewById(R.id.chat_profile_image);
        tv = (TextView)findViewById(R.id.chat_userName);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("users").child(user.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
User user = snapshot.getValue(User.class);
tv.setText(user.getfName());
Glide.with(ChatActivity.this).load(user.getProfileImageUrl()).into(img);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.view_pager);

            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

            viewPagerAdapter.addFragment(new ChatsFragment(),"Chats");
            viewPagerAdapter.addFragment(new UsersFragment(),"Users");

            viewPager.setAdapter(viewPagerAdapter);

            tabLayout.setupWithViewPager(viewPager);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter{
private ArrayList<Fragment> fragments;
private ArrayList<String> titles;

ViewPagerAdapter(FragmentManager fm){
    super(fm);
    this.fragments = new ArrayList<>();
    this.titles = new ArrayList<>();
}
        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        public void addFragment(Fragment fragment, String title){
    fragments.add(fragment);
    titles.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}