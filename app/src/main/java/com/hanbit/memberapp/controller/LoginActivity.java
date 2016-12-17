package com.hanbit.memberapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanbit.memberapp.R;
import com.hanbit.memberapp.domain.MemberBean;
import com.hanbit.memberapp.service.MemberService;
import com.hanbit.memberapp.service.MemeberServiceImpl;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etID, etPass;
    Button btLogin, btCancel;
    MemberService service; // 이 자리로 오라고 호출
    MemberBean member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etID = (EditText) findViewById(R.id.etID);
        etPass = (EditText) findViewById(R.id.etPass);
        btLogin = (Button) findViewById(R.id.btLogin);
        btCancel= (Button) findViewById(R.id.btCancel);

        btLogin.setOnClickListener(this);
        btCancel.setOnClickListener(this);
        service = new MemeberServiceImpl(this.getApplicationContext()); //alt+enter로 자동생성
        // 다형성 서비스의 객체가 생성됨 위치값을 줘야함 (로그인 액티비티로 객체생성) 오라는 뜻
        member = new MemberBean();
    }

    @Override
    public void onClick(View v) {
        String id = etID.getText().toString();
        String pass =etPass.getText().toString();
        Log.d("넘어온 ID: ",id);
        Log.d("넘어온 PASS: ", pass);
        member.setId(id);
        member.setPass(pass);

    switch(v.getId()){
        case R.id.btLogin:
           boolean flag = service.login(member);
            if(flag){
                Toast.makeText(LoginActivity.this,"Login Success",Toast.LENGTH_LONG).show();
                this.startActivity(new Intent(LoginActivity.this, ListActivity.class));
            }else{
                Toast.makeText(LoginActivity.this,"Login Fail",Toast.LENGTH_LONG).show();
            }
            service.login(member);
            break;
        case R.id.btCancel: break;

    }

    }
}


