package com.rattra.navigationdrawertechno.ui.slideshow;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.rattra.navigationdrawertechno.R;

public class SlideshowFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel = ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);


        TextView textView1 = root.findViewById(R.id.text_slideclick1);
        textView1.setMovementMethod(LinkMovementMethod.getInstance());

        TextView textView2 = root.findViewById(R.id.text_slideclick2);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());


        final TextView textView = root.findViewById(R.id.text_slideloc);
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}