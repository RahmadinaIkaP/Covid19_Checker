package id.ac.umn.expert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button CheckButton;
    public Button CheckButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckButton = findViewById(R.id.buttonNext);
        CheckButton2 = findViewById(R.id.buttonNext2);

        CheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegistrasi();
            }
        });

        CheckButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
    }

    public void openRegistrasi(){
        Intent registrasi = new Intent(MainActivity.this, SignUp.class);
        startActivity(registrasi);
        overridePendingTransition(R.anim.stay, R.anim.stay);
    }

    public void openLogin(){
        Intent login = new Intent(MainActivity.this, Login.class);
        startActivity(login);
        overridePendingTransition(R.anim.stay, R.anim.stay);
    }
}