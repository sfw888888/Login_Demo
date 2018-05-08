package com.bawie.sunfuwei.sunfuwei_login.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawie.sunfuwei.sunfuwei_login.R;
import com.bawie.sunfuwei.sunfuwei_login.model.ModelImpel;
import com.bawie.sunfuwei.sunfuwei_login.presenter.PresenterImpel;

public class MainActivity extends AppCompatActivity implements IMainView{

    private EditText userName;
    private EditText pass;
    private Button login;
    private Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化界面
        initViews();
    }

    private void initViews() {
        userName = findViewById(R.id.name);
        pass = findViewById(R.id.pwd);
        login = findViewById(R.id.login);
        reg = findViewById(R.id.reg);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PresenterImpel presenterImpel = new PresenterImpel();

                presenterImpel.loginPresenter (new ModelImpel (),MainActivity.this);
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegActivity.class));
            }
        });
    }

    @Override
    public String getMobile() {
        return userName.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return pass.getText().toString();
    }

    @Override
    public void loginSuccess() {

        Toast.makeText(this, "登录成功--", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "登录失败--", Toast.LENGTH_SHORT).show();
    }
}
