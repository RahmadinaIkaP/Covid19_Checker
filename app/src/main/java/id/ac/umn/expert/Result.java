package id.ac.umn.expert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    String hasil5;
    String hasil4;
    String hasil3;
    String hasil2;
    String hasil1;
    TextView hasilCovid, hasilCovid2, Penjelasan;
    AppCompatButton btnCheckUlang, btnHalamanAwal;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent mainIntent = getIntent();
        hasil1 = mainIntent.getStringExtra("Hasil1");
        hasil2 = mainIntent.getStringExtra("Hasil2");
        hasil3 = mainIntent.getStringExtra("Hasil3");
        hasil4 = mainIntent.getStringExtra("Hasil4");
        hasil5 = mainIntent.getStringExtra("Hasil5");

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        hasilCovid = findViewById(R.id.hasilcovid);
        hasilCovid2 = findViewById(R.id.hasilcovid2);
        Penjelasan = findViewById(R.id.penjelasan);
        btnCheckUlang = findViewById(R.id.btnCheckUlang);
        btnHalamanAwal = findViewById(R.id.btnHalamanAwal);
        hasilCheck();

        btnCheckUlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToCheckIntent = new Intent(Result.this, Pertanyaan1.class);
                backToCheckIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(backToCheckIntent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        btnHalamanAwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToMainIntent = new Intent(Result.this, MainActivity.class);
                backToMainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(backToMainIntent);
                finish();
            }
        });
    }

    public void hasilCheck(){
        if(hasil1.equals("Ya") && hasil2.equals("Ya") && hasil3.equals("Ya") && hasil4.equals("Ya") && hasil5.equals("Ya")) {
            hasilCheckPositif();
        }else if(hasil1.equals("Ya") && hasil2.equals("Ya") && hasil3.equals("Ya") && hasil4.equals("Ya") && hasil5.equals("Tidak")){
            hasilCheckPositif();
        }else if(hasil1.equals("Ya") && hasil2.equals("Ya") && hasil3.equals("Ya") && hasil4.equals("Tidak") && hasil5.equals("Tidak")){
            hasilCheckNegatif();
        }else if(hasil1.equals("Ya") && hasil2.equals("Ya") && hasil3.equals("Tidak") && hasil4.equals("Tidak") && hasil5.equals("Tidak")){
            hasilCheckNegatif();
        }else if (hasil1.equals("Ya") && hasil2.equals("Tidak") && hasil3.equals("Tidak") && hasil4.equals("Tidak") && hasil5.equals("Tidak")){
            hasilCheckNegatif();
        }else if (hasil1.equals("Tidak") && hasil2.equals("Tidak") && hasil3.equals("Tidak") && hasil4.equals("Tidak") && hasil5.equals("Tidak")){
            hasilCheckNegatif();
        }else if(hasil1.equals("Ya") && hasil2.equals("Tidak") && hasil3.equals("Ya") && hasil4.equals("Ya") && hasil5.equals("Ya")){
            hasilCheckPositif();
        }else if (hasil1.equals("Tidak") && hasil2.equals("Ya") && hasil3.equals("Ya") && hasil4.equals("Ya") && hasil5.equals("Ya")){
            hasilCheckPositif();
        }else if (hasil1.equals("Tidak") && hasil2.equals("Tidak") && hasil3.equals("Ya") && hasil4.equals("Tidak") && hasil5.equals("Tidak")){
            hasilCheckNegatif();
        }else if(hasil1.equals("Tidak") && hasil2.equals("Tidak") && hasil3.equals("Tidak") && hasil4.equals("Ya") && hasil5.equals("Tidak")){
            hasilCheckNegatif();
        }else if(hasil1.equals("Tidak") && hasil2.equals("Tidak") && hasil3.equals("Tidak") && hasil4.equals("Tidak") && hasil5.equals("Ya")){
            hasilCheckNegatif();
        }else if(hasil1.equals("Ya") && hasil2.equals("Ya") && hasil3.equals("Tidak") && hasil4.equals("Ya") && hasil5.equals("Ya")){
            hasilCheckPositif();
        }else if(hasil1.equals("Ya") && hasil2.equals("Ya") && hasil3.equals("Ya") && hasil4.equals("Tidak") && hasil5.equals("Ya")){
            hasilCheckPositif();
        }else if(hasil1.equals("Ya") && hasil2.equals("Tidak") && hasil3.equals("Ya") && hasil4.equals("Tidak") && hasil5.equals("Ya")){
            hasilCheckPositif();
        }else if(hasil1.equals("Tidak") && hasil2.equals("Ya") && hasil3.equals("Tidak") && hasil4.equals("Ya") && hasil5.equals("Tidak")){
            hasilCheckNegatif();
        }
    }

    public void hasilCheckPositif(){
        hasilCovid.setText("Bahaya");
        hasilCovid.setTextColor(getResources().getColor(R.color.red_light));
        hasilCovid2.setText("Anda POSITIF Covid-19");
        hasilCovid2.setTextColor(getResources().getColor(R.color.red_light));
        Penjelasan.setText("Langkah Perawatan:\n" +
                "1. Cari bantuan pada dokter atau layanan kesehatan\n" +
                "2. Lakukan isolasi mandiri\n" +
                "3. Putuskan siapa yang akan merawat anda\n" +
                "4. Perhatikan jenis perawatan yang dibutuhkan\n" +
                "5. Waspadai gejala yang muncul\n" +
                "6. Persiapkan diri untuk efek jangka panjang\n");
    }

    public void hasilCheckNegatif(){
        hasilCovid2.setText("Anda NEGATIF Covid-19");
        hasilCovid2.setTextColor(getResources().getColor(R.color.green_light));
        Penjelasan.setText("Langkah Pencegahan:\n" +
                "1. Menjaga jarak apabila sedang berada diluar ruangan.\n" +
                "2. Sering membersihkan tangan dengan sabun.\n" +
                "3. Tetap gunakan masker.\n" +
                "4. Hindari penyentuhan area wajah, hidung atau mulut.\n" +
                "5. Konsumsi vitamin untuk meningkatkan daya tahan tubuh.\n" +
                "6. Membersihkan permukaan benda yang sering digunakan.\n" +
                "7. Lakukan PCR dan Swab Test jika hasil tidak memungkinkan."
        );
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
                Intent backToMain = new Intent(Result.this, MainActivity.class);
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