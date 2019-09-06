package com.qslll.expandingpager.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.qslll.expandingpager.model.Register;
import com.qslll.expandingpager.model.Travel;
import com.qslll.library.fragments.ExpandingFragment;

/**
 * this is control fragment , Top and Bottom is child in it.
 * <p>
 * Created by florentchampigny on 21/06/2016.
 */
@SuppressLint("ValidFragment")
public class TravelExpandingFragment extends ExpandingFragment {

    static final String ARG_TRAVEL = "ARG_TRAVEL";
    static final String ARG_REGISTER = "ARG_REGISTER";
    Travel travel;
    Register register;
    private static final String TAG = "TravelExpandingFragment";

    FragmentBottom.OnRegisterClick onRegisterClick;

    @SuppressLint("ValidFragment")
    public TravelExpandingFragment(Travel travel, Register register, FragmentBottom.OnRegisterClick onRegisterClick) {
        this.travel = travel;
        this.register = register;
        this.onRegisterClick = onRegisterClick;

    }

    public TravelExpandingFragment() {
    }

    //    public static TravelExpandingFragment newInstance(Travel travel, RegisterActivity register) {
//        TravelExpandingFragment fragment = new TravelExpandingFragment();
//        Bundle args = new Bundle();
//        args.putParcelable(ARG_TRAVEL, travel);
//        args.putParcelable(ARG_REGISTER, register);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TravelExpandingFragment fragment = new TravelExpandingFragment(travel, register, onRegisterClick);
        Bundle args = new Bundle();
        args.putParcelable(ARG_TRAVEL, travel);
        args.putParcelable(ARG_REGISTER, register);
        fragment.setArguments(args);

        Log.e(TAG, "onCreate: " + args );

        Bundle args3 = fragment.getArguments();
        Log.e("Test1.1", "onCreate:1 " + args3);
        if (args3 != null) {
            travel = args3.getParcelable(ARG_TRAVEL);
            register = args3.getParcelable(ARG_REGISTER);
            Log.e("Test1.1", "onCreate1.1: " + travel.getImage());
        }
    }

    /**
     * include TopFragment
     *
     * @return
     */
    //will put data into it's fields
    @Override
    public Fragment getFragmentTop() {
//        return FragmentTop.newInstance(travel);
        return new FragmentTop(travel);
    }

    /**
     * include BottomFragment
     *
     * @return
     */
    @Override
    public Fragment getFragmentBottom() {
//        return FragmentBottom.newInstance(register);
        return new FragmentBottom(register, onRegisterClick);
    }
}
