package id.ac.umn.expert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Pertanyaan2 extends AppCompatActivity {
    public Button ya;
    public Button tidak;
    String hasil2;
    String hasil1;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan2);
        Intent mainIntent = getIntent();
        hasil1 = mainIntent.getStringExtra("Hasil1");

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ya = findViewById(R.id.buttonYes);

        ya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil2 = "Ya";
                openPert3ya();
            }
        });

        tidak = findViewById(R.id.buttonNo);

        tidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil2 = "Tidak";
                openPert3tidak();
            }
        });
    }

    public void openPert3ya(){
        Intent pert3 = new Intent(Pertanyaan2.this, Pertanyaan3.class);
        pert3.putExtra("Hasil2", hasil2);
        pert3.putExtra("Hasil1", hasil1);
        startActivity(pert3);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void openPert3tidak(){
        Intent pert3 = new Intent(Pertanyaan2.this, Pertanyaan3.class);
        pert3.putExtra("Hasil2", hasil2);
        pert3.putExtra("Hasil1", hasil1);
        startActivity(pert3);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.backtoHome:
                Intent backToMain = new Intent(Pertanyaan2.this, MainActivity.class);
                backToMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(backToMain);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(0,0);
    }
}