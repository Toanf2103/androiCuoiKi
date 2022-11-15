package com.example.cuoi_ki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    CheckBox cbRemember;
    EditText edtEmail,edtPass;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dangNhap();
            }
        });
    }
    private void init(){
        btnLogin=findViewById(R.id.loginBtn);
        cbRemember=findViewById(R.id.rememberCb);
        edtEmail=findViewById(R.id.emailEdt);
        edtPass=findViewById(R.id.passEdt);


        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        edtEmail.setText(sharedPreferences.getString("email",""));
        edtPass.setText(sharedPreferences.getString("pass",""));
        cbRemember.setChecked(sharedPreferences.getBoolean("nho",false));
    }

    private void dangNhap(){
        String email = edtEmail.getText().toString();
        String pass = edtPass.getText().toString();
        if(email.equals("")||pass.equals("")){
            Toast.makeText(this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
        }else if(email.equals("toan")||pass.equals("123")){
            Toast.makeText(this, "Sai tài khoản mật khẩu", Toast.LENGTH_SHORT).show();
        }else{
            if(cbRemember.isChecked()){
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("email", email);
                editor.putString("pass", pass);
                editor.putBoolean("nho", true);
                editor.commit();
            }else{
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("email");
                editor.remove("pass");
                editor.remove("nho");
                editor.commit();
            }
            Intent i = new Intent(MainActivity.this, ListInformationPolice.class);
            startActivity(i);
            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
        }
    }
}