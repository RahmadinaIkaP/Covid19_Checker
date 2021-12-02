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

public class Pertanyaan3 extends AppCompatActivity {
    public Button ya;
    public Button tidak;
    String hasil3;
    String hasil2;
    String hasil1;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan3);
        Intent mainIntent = getIntent();
        hasil1 = mainIntent.getStringExtra("Hasil1");
        hasil2 = mainIntent.getStringExtra("Hasil2");

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ya = findViewById(R.id.buttonYes);

        ya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil3 = "Ya";
                openPert4ya();
            }
        });

        tidak = findViewById(R.id.buttonNo);

        tidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil3 = "Tidak";
                openPert4tidak();
            }
        });
    }

    public void openPert4ya(){
        Intent pert4 = new Intent(Pertanyaan3.this, Pertanyaan4.class);
        pert4.putExtra("Hasil3", hasil3);
        pert4.putExtra("Hasil2", hasil2);
        pert4.putExtra("Hasil1", hasil1);
        startActivity(pert4);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void openPert4tidak(){
        Intent pert4 = new Intent(Pertanyaan3.this, Pertanyaan4.class);
        pert4.putExtra("Hasil3", hasil3);
        pert4.putExtra("Hasil2", hasil2);
        pert4.putExtra("Hasil1", hasil1);
        startActivity(pert4);
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
                Intent backToMain = new Intent(Pertanyaan3.this, MainActivity.class);
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