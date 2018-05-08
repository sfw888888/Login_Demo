package com.bawie.sunfuwei.sunfuwei_login.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawie.sunfuwei.sunfuwei_login.R;
import com.bawie.sunfuwei.sunfuwei_login.model.ModelImpel;
import com.bawie.sunfuwei.sunfuwei_login.presenter.PresenterImpel;


public class RegActivity extends AppCompatActivity implements IRegView{

    private EditText userName;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        initViews();
    }

    private void initViews() {
        userName = findViewById(R.id.name);

        pass = findViewById(R.id.pwd);

        Button reg = findViewById(R.id.reg);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PresenterImpel presenterImpel = new PresenterImpel();

                presenterImpel.regPresenter(new ModelImpel (),RegActivity.this);
            }
        });
    }

    @Override
    public String getMobile() {
        return userName.getText().toString();
    }

    @Override
    public String getPwd() {
        return pass.getText().toString();
    }

    @Override
    public void RegSuccess() {
        Toast.makeText(this,"注册成功,请进入登录界面！",Toast.LENGTH_SHORT).show();

        startActivity(new Intent(RegActivity.this,MainActivity.class));
    }

    @Override
    public void RegError() {
        Toast.makeText(this,"注册失败",Toast.LENGTH_SHORT).show();
    }
}
