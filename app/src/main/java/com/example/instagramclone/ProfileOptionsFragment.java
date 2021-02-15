package com.example.instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.instagramclone.LoginActivity;
import com.example.instagramclone.R;
import com.example.instagramclone.fragments.ProfileFragment;
import com.parse.ParseUser;

public class ProfileOptionsFragment extends Fragment {
    private View btnProfilePosts;
    private View btnLogOut;

    public ProfileOptionsFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnProfilePosts = view.findViewById(R.id.btnProfilePosts);
        btnLogOut = view.findViewById(R.id.btnLogOut);

        btnProfilePosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileFragment nextFrag= new ProfileFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(((ViewGroup)getView().getParent()).getId(), nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();

            }
        });

        //queryPosts();
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                Intent i = new Intent(getActivity(),LoginActivity.class);
                getActivity().startActivity(i);
            }
        });
    }
}
