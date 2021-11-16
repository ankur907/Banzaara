package com.example.banzaaraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class RegisterPage extends AppCompatActivity {
    private EditText ed1, ed2, ed3, ed4;
    private TextView tv3;
    private Button bt1;
    FirebaseAuth fb1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        ed3=findViewById(R.id.ed3);
        ed4=findViewById(R.id.ed4);
        tv3=findViewById(R.id.tv3);
        bt1=findViewById(R.id.bt1);
        fb1=FirebaseAuth.getInstance();

        bt1.setOnClickListener(view -> {
            String email=ed2.getText().toString().trim();
            String pass=ed3.getText().toString().trim();

            if(TextUtils.isEmpty(email)){
                ed2.setError("Email is required!");
                return;
            }
            if(TextUtils.isEmpty(pass)){
                ed3.setError("Password is required!");
            }
            if(pass.length()<6){
                ed3.setError("Password should be more than 6 characters!");
            }

            //register the user

            fb1.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(RegisterPage.this, "User Created", Toast.LENGTH_LONG).show();

                   startActivity(new Intent(getApplicationContext(), LoginPage.class ));
                    }
                    else{
                        Toast.makeText(RegisterPage.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT );
                    }
                }
            });
        });

        tv3.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Main2Activity.class));
        });

    }

}