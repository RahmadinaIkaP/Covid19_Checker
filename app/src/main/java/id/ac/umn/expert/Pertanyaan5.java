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

public class Pertanyaan5 extends AppCompatActivity {
    public Button ya;
    public Button tidak;
    String hasil5;
    String hasil4;
    String hasil3;
    String hasil2;
    String hasil1;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan5);
        Intent mainIntent = getIntent();
        hasil1 = mainIntent.getStringExtra("Hasil1");
        hasil2 = mainIntent.getStringExtra("Hasil2");
        hasil3 = mainIntent.getStringExtra("Hasil3");
        hasil4 = mainIntent.getStringExtra("Hasil4");

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ya = findViewById(R.id.buttonYes);

        ya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil5 = "Ya";
                openHasilya();
            }
        });

        tidak = findViewById(R.id.buttonNo);

        tidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil5 = "Tidak";
                openHasiltidak();
            }
        });
    }

    public void openHasilya(){
        Intent hasil = new Intent(Pertanyaan5.this, Result.class);
        hasil.putExtra("Hasil5", hasil5);
        hasil.putExtra("Hasil4", hasil4);
        hasil.putExtra("Hasil3", hasil3);
        hasil.putExtra("Hasil2", hasil2);
        hasil.putExtra("Hasil1", hasil1);
        startActivity(hasil);
    }

    public void openHasiltidak(){
        Intent hasil = new Intent(Pertanyaan5.this, Result.class);
        hasil.putExtra("Hasil5", hasil5);
        hasil.putExtra("Hasil4", hasil4);
        hasil.putExtra("Hasil3", hasil3);
        hasil.putExtra("Hasil2", hasil2);
        hasil.putExtra("Hasil1", hasil1);
        startActivity(hasil);
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
                Intent backToMain = new Intent(Pertanyaan5.this, MainActivity.class);
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