package com.qslll.expandingpager.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.Pair;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qslll.expandingpager.InfoActivity;
import com.qslll.expandingpager.R;
import com.qslll.expandingpager.model.Travel;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class FragmentTop extends Fragment {

    static final String ARG_TRAVEL = "ARG_TRAVEL";
    Travel travel;

    ImageView image;
    TextView title;

//    public static FragmentTop newInstance(Travel travel) {
//        Bundle args = new Bundle();
//        FragmentTop fragmentTop = new FragmentTop();
//        args.putParcelable(ARG_TRAVEL, travel);
//        fragmentTop.setArguments(args);
//        return fragmentTop;
//    }


    @SuppressLint("ValidFragment")
    public FragmentTop(Travel travel) {
        this.travel = travel;
        Log.e(TAG, "FragmentTop1: " + travel);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = new Bundle();
        FragmentTop fragmentTop = new FragmentTop(travel);
        args.putParcelable(ARG_TRAVEL, travel);
        fragmentTop.setArguments(args);

        Log.e(TAG, "onCreate:1.2 " + args);

        Bundle args2 = fragmentTop.getArguments();
        Log.e(TAG, "onCreate: " + args2);
        if (args2 != null) {
            travel = args2.getParcelable(ARG_TRAVEL);
            Log.e("Test1.1", "onCreate:4 " + travel);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_front, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        image = (ImageView) view.findViewById(R.id.image);
        title = (TextView) view.findViewById(R.id.title);

//        ButterKnife.bind(FragmentTop.this, view);

        if (travel != null) {
//            Log.e("Test1.11", "onViewCreated:1.3 " + travel.getName());
            image.setImageResource(travel.getImage());
            Log.e(TAG, "onViewCreated: " + image );
//            title.setText(travel.getName());
        }

    }

    @SuppressWarnings("unchecked")
    private void startInfoActivity(View view, Travel travel) {
        FragmentActivity activity = getActivity();
        ActivityCompat.startActivity(activity,
                InfoActivity.newInstance(activity, travel),
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                        activity,
                        new Pair<>(view, getString(R.string.transition_image)))
                        .toBundle());
    }
}
