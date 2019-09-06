package com.qslll.expandingpager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.qslll.expandingpager.adapter.TravelViewPagerAdapter;
import com.qslll.expandingpager.fragments.FragmentBottom;
import com.qslll.expandingpager.model.Register;
import com.qslll.expandingpager.model.Travel;
import com.qslll.library.ExpandingPagerFactory;
import com.qslll.library.fragments.ExpandingFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements
        ExpandingFragment.OnExpandingClickListener,
        FragmentBottom.OnRegisterClick {
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.back)
    ViewGroup back;

    private static final String TAG = "MainActivity";
    Boolean flagClose = true;
    String currentFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupWindowAnimations();

        TravelViewPagerAdapter adapter = new TravelViewPagerAdapter(getSupportFragmentManager(), this);
        //send data to Adapter
        adapter.addAll(generateTravelList(), generateRegisterList());
        viewPager.setAdapter(adapter);

        ExpandingPagerFactory.setupViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            ExpandingFragment expandingFragment;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                expandingFragment.
//                if (expandingFragment != null && expandingFragment.isOpenend()) {
//                    expandingFragment.close();
//                }


                expandingFragment = ExpandingPagerFactory.getCurrentFragment(viewPager);
                if (flagClose){
                    expandingFragment.open();
                    Log.e(TAG, "onPageScrolled: When view pageer load " + expandingFragment);
                }


            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e(TAG, "onPageScrollStateChanged: when swap ");

                ExpandingFragment expandingFragment2 = ExpandingPagerFactory.getCurrentFragment(viewPager);

                if (expandingFragment != null && expandingFragment.isOpenend()) {
                    Log.e(TAG, "onCreate:open fragment 3 " + expandingFragment.toString());
                    expandingFragment.close();
                    currentFragment = expandingFragment.toString();
                    flagClose = false;


                    if (expandingFragment2 != null && expandingFragment2.isOpenend()) {
                        Log.e(TAG, "onPageScrollStateChanged: 5 " + currentFragment);
                        expandingFragment2.close();
//                        flagClose =true;
                    }
                }


            }
        });


    }

    @Override
    public void onBackPressed() {
        if (!ExpandingPagerFactory.onBackPressed(viewPager)) {
            super.onBackPressed();
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations() {
        Explode slideTransition = new Explode();
        getWindow().setReenterTransition(slideTransition);
        getWindow().setExitTransition(slideTransition);
    }

    private List<Travel> generateTravelList() {
        List<Travel> travels = new ArrayList<>();
        for (int i = 0; i < 1; ++i) {
//            Log.e("test1", "generateTravelList: ");
            travels.add(new Travel(R.drawable.customer1));
//            travels.add(new Travel("Shang Hai", R.drawable.worker1));
//            travels.add(new Travel("New York", R.drawable.worker2));
            travels.add(new Travel(R.drawable.worker3));
        }
        return travels;
    }

    private List<Register> generateRegisterList() {
        List<Register> registers = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            registers.add(new Register("Are you customer ?"));
            registers.add(new Register("Are you worker ?"));
        }
        return registers;
    }

    @SuppressWarnings("unchecked")
    private void startInfoActivity(View view, Travel travel) {
        Activity activity = this;
        ActivityCompat.startActivity(activity,
                InfoActivity.newInstance(activity, travel),
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                        activity,
                        new Pair<>(view, getString(R.string.transition_image)))
                        .toBundle());
    }


    @Override
    public void onExpandingClick(View v) {
        //v is expandingfragment layout
        //place which img will transfer from
        View view = v.findViewById(R.id.image);
        View view1 = v.findViewById(R.id.register_btn);
        Travel travel = generateTravelList().get(viewPager.getCurrentItem());
        startInfoActivity(view,travel);
//        Log.e(TAG, "onExpandingClick: " );


    }

    @Override
    public void onRegisterClick(View v) {
        Log.e(TAG, "onRegisterClick: ");

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

}
