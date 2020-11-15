package com.rattra.navigationdrawertechno.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.rattra.navigationdrawertechno.DashBoard;
import com.rattra.navigationdrawertechno.Google_Class;
import com.rattra.navigationdrawertechno.MainActivity;
import com.rattra.navigationdrawertechno.NoticeActivity;
import com.rattra.navigationdrawertechno.R;

public class HomeFragment extends Fragment {

    Button btn_Notice;
    Button btn_class;
    Button btn_Gclass;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);


        btn_Notice = root.findViewById(R.id.button_notice);
        btn_class = root.findViewById(R.id.button_class);
        btn_Gclass = root.findViewById(R.id.button_gclass);

        btn_Notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View root) {
                startActivity(new Intent(getActivity(), NoticeActivity.class));
            }
        });

        btn_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DashBoard.class));
            }
        });

        btn_Gclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Google_Class.class));
            }
        });

        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;

    }
}