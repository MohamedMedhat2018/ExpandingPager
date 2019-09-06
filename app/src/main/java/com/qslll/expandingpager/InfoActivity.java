package com.qslll.expandingpager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.qslll.expandingpager.model.Register;
import com.qslll.expandingpager.model.Travel;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InfoActivity extends AppCompatActivity {

    private static final String EXTRA_TRAVEL = "EXTRA_TRAVEL";
    private static final String EXTRA_REGISTER = "EXTRA_REGISTER";
    @Bind(R.id.image)
    ImageView image;
    @Bind(R.id.title)
    TextView title;

    //if u want to use the data from the the page u came from TopFragment
    public static Intent newInstance(Context context, Travel travel) {
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra(EXTRA_TRAVEL, travel);
        return intent;
    }
    //if u want to use the data from the the page u came from Bottom Fragment
    public static Intent newInstance2(Context context,Register register) {
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra(EXTRA_REGISTER, register);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);

        Travel travel = getIntent().getParcelableExtra(EXTRA_TRAVEL);
        if (travel != null) {
            image.setImageResource(travel.getImage());
//            title.setText(travel.getName());
        }
    }
}