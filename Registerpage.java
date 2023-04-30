package com.example.trip;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Registerpage extends AppCompatActivity {
    EditText mUser,mEmail,mPassword;
    Button mRegister,mLogin;
    CheckBox b2;
    FirebaseAuth fAuth;

    FirebaseFirestore fStore ;
    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);
        mUser=findViewById(R.id.editTextTextPersonName3);
        mEmail=findViewById(R.id.editTextTextPersonName2);
        mPassword=findViewById(R.id.editTextTextPassword2);
        mRegister=findViewById(R.id.button2);
        mLogin=findViewById(R.id.button5);
        fAuth=FirebaseAuth.getInstance();
        fStore=FirebaseFirestore.getInstance();
        b2=findViewById(R.id.checkBox);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= mEmail.getText().toString().trim();
                String pass=mPassword.getText().toString().trim();
                String Name=mUser.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    mPassword.setError("Passowrd is required");
                    return;
                }
                if(mPassword.length()<6){
                    mPassword.setError("Password Must be >=6 Character");
                    return;
                }
                if(b2.isChecked()==false){
                    b2.setError("Agree T&C");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                     if(task.isSuccessful()){
                         Toast.makeText(Registerpage.this,"User Created",Toast.LENGTH_SHORT).show();
                         userID= fAuth.getCurrentUser().getUid();
                         DocumentReference documentReference=fStore.collection("users").document(userID);
                         Map<String,Object> user=new HashMap<>();
                         user.put("Name",Name);
                         user.put("Email",email);
                         documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                             @Override
                             public void onSuccess(Void unused) {
                                 Log.d(TAG, "onSuccess: user Profile is created for "+userID);
                             }
                         });
                         startActivity(new Intent(getApplicationContext(),MainHomePage.class));
                     }
                     else
                     {
                        Toast.makeText(Registerpage.this,"Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                     }
                    }
                });
            }
        });
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registerpage.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}