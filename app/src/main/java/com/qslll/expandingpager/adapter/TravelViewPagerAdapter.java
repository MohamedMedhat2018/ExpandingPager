package com.qslll.expandingpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.qslll.expandingpager.R;
import com.qslll.expandingpager.fragments.FragmentBottom;
import com.qslll.expandingpager.fragments.FragmentTop;
import com.qslll.expandingpager.fragments.TravelExpandingFragment;
import com.qslll.expandingpager.model.Register;
import com.qslll.expandingpager.model.Travel;
import com.qslll.library.ExpandingViewPagerAdapter;
import com.qslll.library.fragments.ExpandingFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qs on 16/5/30.
 */
public class TravelViewPagerAdapter extends ExpandingViewPagerAdapter {

    private List<Travel> travels;
    private List<Register> registers;
    private FragmentBottom.OnRegisterClick onRegisterClick;
    private static final String TAG = "TravelViewPagerAdapter";

    public TravelViewPagerAdapter(FragmentManager fm, FragmentBottom.OnRegisterClick onRegisterClick ) {
        super(fm);
        travels = new ArrayList<>();
        registers = new ArrayList<>();
        this.onRegisterClick = onRegisterClick;
    }

    //receive Data from Adapter
    public void addAll(List<Travel> travels, List<Register> registers) {
        this.travels.addAll(travels);
        this.registers.addAll(registers);
        Log.e(TAG, "addAll: " + travels.get(0));
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        Travel travel = travels.get(position);
        Register register = registers.get(position);
        //send data ro fragment which will put it into models and send each one to it's fragment.
//        return TravelExpandingFragment.newInstance(travel, register);
        Log.e(TAG, "getItem: " + travel.getImage() );
        return new TravelExpandingFragment(travel, register, onRegisterClick);
    }

    @Override
    public int getCount() {
        return travels.size();
    }
}
