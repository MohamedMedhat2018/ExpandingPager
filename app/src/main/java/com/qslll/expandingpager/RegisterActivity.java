package com.qslll.expandingpager;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Register extends AppCompatActivity {

    @Bind(R.id.login_btn)
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);


    }

    @OnClick(R.id.login_btn)
    void loginFromRegister (View view){
        Intent intent = new Intent(Register.this, LoginActivity.class);
//        overridePendingTransition();
    }


    @Override
    public View onCreateView(View view, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(view, name, context, attrs);


    }


}
