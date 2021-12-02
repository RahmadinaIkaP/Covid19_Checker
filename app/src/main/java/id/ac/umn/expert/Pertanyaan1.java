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

public class Pertanyaan1 extends AppCompatActivity {
    public Button ya;
    public Button tidak;
    String hasil1;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan1);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ya = findViewById(R.id.buttonYes);

        ya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil1 = "Ya";
                openPert2ya();
            }
        });

        tidak = findViewById(R.id.buttonNo);

        tidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil1 = "Tidak";
                openPert2tidak();
            }
        });
    }

    public void openPert2ya(){
        Intent pert2 = new Intent(Pertanyaan1.this, Pertanyaan2.class);
        pert2.putExtra("Hasil1", hasil1);
        startActivity(pert2);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void openPert2tidak(){
        Intent pert2 = new Intent(Pertanyaan1.this, Pertanyaan2.class);
        pert2.putExtra("Hasil1", hasil1);
        startActivity(pert2);
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
                Intent backToMain = new Intent(Pertanyaan1.this, MainActivity.class);
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