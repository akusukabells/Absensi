package com.wendot.absensi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wendot.absensi.model.SessionManager;
import com.wendot.absensi.model.UsersModel;

public class LoginActivity extends AppCompatActivity {
    EditText et_nip, et_password;
    Button btn_login;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nip = et_nip.getText().toString();
                String password = et_password.getText().toString();
                if(checkValidasiEmpty(nip, password)){
                    checkpassword(nip, password);
                }
            }
        });

    }

    private void checkpassword(String nip, String password) {
        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference("Users");
        mRef.child(nip).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getChildrenCount() != 0 ){
                    UsersModel user = new UsersModel();
                    user = snapshot.getValue(UsersModel.class);
                    if(user.getNip().equals(nip) && user.getPassword().equals(password)){
                        sessionManager.createSession(user.getNip(), user.getNama(), user.getRole());
                        sessionManager.checkLogin();
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "NIP atau Password Salah", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "NIP tidak di temukan", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    //check validasi jika kosong
    private boolean checkValidasiEmpty(String nip, String password) {
        if(nip.isEmpty()){
            et_nip.setError("NIP tidak boleh kosong");
            et_nip.requestFocus();
            return false;
        }
        if(password.isEmpty()){
            et_password.setError("Password tidak boleh kosong");
            et_password.requestFocus();
            return false;
        }
        return true;
    }


    //inisial variable
    private void initView() {
        sessionManager = new SessionManager(this);
        et_nip = findViewById(R.id.et_login_nip);
        et_password = findViewById(R.id.et_login_password);
        btn_login = findViewById(R.id.btn_login);
    }
}