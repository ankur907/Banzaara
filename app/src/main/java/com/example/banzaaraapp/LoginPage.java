package com.example.banzaaraapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    private EditText ed1, ed2;
    private Button bt1;
    private FirebaseAuth fb1;
    private TextView tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        bt1=findViewById(R.id.bt1);
        fb1=FirebaseAuth.getInstance();
        tv4=findViewById(R.id.tv4);

        bt1.setOnClickListener(view -> {
            String email=ed1.getText().toString().trim();
            String pass=ed2.getText().toString().trim();

            if(TextUtils.isEmpty(email)){
                ed1.setError("Email required!");
                return;
            }
            if(TextUtils.isEmpty(pass)){
                ed2.setError("Password required");
                return;
            }
            if(pass.length()<6){
                ed2.setError("Password should be more than 6 characters!");
                return;
            }

            //Autheticate User
          fb1.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                       Toast.makeText(LoginPage.this,"Logged In", Toast.LENGTH_SHORT);
                     startActivity(new Intent(getApplicationContext(), Main2Activity.class));
                   }
                 else{
                       Toast.makeText(LoginPage.this, "Error! " +task.getException().getMessage(), Toast.LENGTH_SHORT);
                   }
               }
           });

        //    fb1.signInWithEmailAndPassword(email,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
          //      @Override
        //        public void onSuccess(AuthResult authResult) {
        //                Toast.makeText(LoginPage.this,"Logged In", Toast.LENGTH_SHORT);
        //                startActivity(new Intent(getApplicationContext(), RegisterPage.class));
       //         }
       //     });
        });

        tv4.setOnClickListener(view -> {
            EditText resetMail=new EditText(view.getContext());
            AlertDialog.Builder passResetDialog=new AlertDialog.Builder(view.getContext());
            passResetDialog.setTitle("Reset Password?");
            passResetDialog.setMessage("Enter your Email to reset your password");
            passResetDialog.setView(resetMail);

            passResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    // extract the email and reset the pass

                    String mail=resetMail.getText().toString();
                    fb1.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(LoginPage.this, "Reset Link sent successfully", Toast.LENGTH_SHORT);
                        }
                    });
                }
            });

            passResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            passResetDialog.create().show();
        });
    }
}