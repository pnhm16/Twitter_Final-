package vn.edu.usth.twitter;

import androidx.appcompat.app.AppCompatActivity;

import vn.edu.usth.twitter.databinding.ActivitySignUpBinding;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignUp extends AppCompatActivity {
    private ActivitySignUpBinding binding;
    private String email ="", password = "";
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this, LogIn.class));
            }
        });
        //init firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();
        binding.SignUpBuReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this, MainActivity.class));
            }
        });
    }
    private void validateData() {
        //getData
        email = binding.enterEmail.getText().toString().trim();
        password = binding.enterPasswordReg.getText().toString().trim();

        //validated
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.enterEmail.setError("Invalid Email");
        }
        else if (TextUtils.isEmpty(password)) {
            binding.enterPasswordReg.setError("Enter Password");
        }
        else if (password.length()<6){
            binding.enterPasswordReg.setError("Password must at least 6 characters long");
        }
        else {
            //valid
            firebaseSignUp();
        }
    }
    private void firebaseSignUp() {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                    String email = firebaseUser.getEmail();
                    Toast.makeText(SignUp.this, "Account Created\n" + email, Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(SignUp.this , MainActivity.class));
                    finish();
                })
                .addOnFailureListener(e -> Toast.makeText(SignUp.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show());
    }
}