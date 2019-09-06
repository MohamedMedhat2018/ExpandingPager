package com.qslll.expandingpager.fragments;

import android.annotation.SuppressLint;
import android.net.Uri;
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
import android.widget.TextView;

import com.qslll.expandingpager.InfoActivity;
import com.qslll.expandingpager.R;
import com.qslll.expandingpager.model.Register;
import com.qslll.expandingpager.model.Travel;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentBottom extends Fragment {


    final static String ARG_REGISTER = "ARG_REGISTER";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static OnRegisterClick onRegisterClick;
    @Bind(R.id.register_tv)
    TextView registerAs;
    Register register;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    @SuppressLint("ValidFragment")
    public FragmentBottom(Register register, OnRegisterClick onRegisterClick) {
        FragmentBottom.onRegisterClick = onRegisterClick;
        this.register = register;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = new Bundle();
        FragmentBottom fragmentBottom = new FragmentBottom(register, onRegisterClick);
        args.putParcelable(ARG_REGISTER, register);
        fragmentBottom.setArguments(args);


        Bundle args2 = getArguments();
        if (args2 != null) {
            register = args.getParcelable(ARG_REGISTER);
            Log.e(TAG, "onCreateBottom: " + register );
        }
    }
//

//    public static FragmentBottom newInstance(RegisterActivity register) {
//        Bundle args = new Bundle();
//        FragmentBottom fragmentBottom = new FragmentBottom(onRegisterClick);
//        args.putParcelable(ARG_REGISTER, register);
//        fragmentBottom.setArguments(args);
//        return fragmentBottom;
//    }

    private static final String TAG = "FragmentBottom";

//    @OnClick(R.id.register_btn)
//    public void registerBtnClicked(View v) {
//        Log.e(TAG, "registerBtnClicked: " );
//        onRegisterClick.onRegisterClick(v);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom, container, false);
       // ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        registerAs.setText(register.getRegisterAs());

        getView().findViewById(R.id.register_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: uuu" );
                onRegisterClick.onRegisterClick(v);
            }
        });

    }

    @SuppressWarnings("unchecked")
    private void startInfoActivity(View view, Register register) {
        FragmentActivity activity = getActivity();
        ActivityCompat.startActivity(activity,
                InfoActivity.newInstance2(activity, register),
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                        activity,
                        new Pair<>(view, getString(R.string.transition_image)))
                        .toBundle());
    }

    public interface OnRegisterClick {
        void onRegisterClick(View v);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
