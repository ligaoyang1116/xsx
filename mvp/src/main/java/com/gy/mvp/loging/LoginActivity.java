package com.gy.mvp.loging;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gy.mvp.MainActivity;
import com.gy.mvp.R;
import com.gy.mvp.loging.presenter.presenterLoginimpl;
import com.gy.mvp.loging.view.IviewLogin;

public class LoginActivity extends AppCompatActivity implements IviewLogin {

    private EditText log_username_et;
    private EditText log_paswd_et;
    private Button log_login_bt;
    private Button log_resgin_bt;
    private com.gy.mvp.loging.presenter.presenterLoginimpl presenterLoginimpl;
    private String log_username;
    private String log_paswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //控件
        log_username_et = findViewById(R.id.log_username_et);
        log_paswd_et = findViewById(R.id.log_paswd_et);
        log_login_bt = findViewById(R.id.log_login_bt);
        log_resgin_bt = findViewById(R.id.log_resgin_bt);
        //得到输入框的值
        log_username = log_username_et.getText().toString();
        log_paswd = log_paswd_et.getText().toString();
        //初始化presenter
        presenterLoginimpl = new presenterLoginimpl(this);
        //获取方法
        //登录监听按钮
        log_login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判空
                if (!log_username.isEmpty()&&!log_paswd.isEmpty()){
                    presenterLoginimpl.getpreData(log_username,log_paswd);
                }
            }
        });
    }

    @Override
    public void showSuccessMsg(String msg) {
        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedMsg(String msg) {
        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hiddenLoading() {

    }

    @Override
    public void jumpActivity() {
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
    }
}
