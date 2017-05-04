package paul.develops.ta.Activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import paul.develops.ta.Activity.Kuis.HewanKuisActivity;
import paul.develops.ta.Activity.Kuis.HewanKuisSuaraActivity;
import paul.develops.ta.Activity.Kuis.KuisActivity;
import paul.develops.ta.R;

public class ListTempatActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tempat);

        ImageButton imgButTaman = (ImageButton) findViewById(R.id.butImgTaman);
        ImageButton imgButGurun = (ImageButton) findViewById(R.id.butImgGurun);
        ImageButton imgButLaut = (ImageButton) findViewById(R.id.butImgLaut);
        ImageButton imgButFarm = (ImageButton) findViewById(R.id.butImgFarm);
        Button btnKuisGambar = (Button) findViewById(R.id.btnKuisGambar);
        Button btnKuisSuara = (Button) findViewById(R.id.btnKuisSuara);

        imgButTaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ListTempatActivity.this,"Anda Memilih Taman", Toast.LENGTH_LONG).show();
                Intent tumbuhanIntent = new Intent(ListTempatActivity.this, TestActivity.class);
                startActivity(tumbuhanIntent);
            }
        });

        imgButGurun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ListTempatActivity.this,"Anda Memilih Padang Gurun", Toast.LENGTH_LONG).show();
                Intent gurunIntent = new Intent(ListTempatActivity.this, Test2Activity.class);
                startActivity(gurunIntent);
            }
        });

        imgButLaut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ListTempatActivity.this,"Anda Memilih Laut", Toast.LENGTH_LONG).show();
                Intent lautIntent = new Intent(ListTempatActivity.this, LautActivity.class);
                startActivity(lautIntent);
            }
        });

        imgButFarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ListTempatActivity.this,"Anda Memilih Peternakan", Toast.LENGTH_LONG).show();
                Intent farmIntent = new Intent(ListTempatActivity.this, HewanKuisActivity.class);
                startActivity(farmIntent);
            }
        });

        btnKuisGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ListTempatActivity.this,"Anda Memilih Kuis Gambar", Toast.LENGTH_LONG).show();
                Intent kuis1Gambar = new Intent(ListTempatActivity.this, HewanKuisActivity.class);
                startActivity(kuis1Gambar);
            }
        });

        btnKuisSuara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ListTempatActivity.this,"Anda Memilih Kuis Gambar", Toast.LENGTH_LONG).show();
                Intent kuis1Suara = new Intent(ListTempatActivity.this, HewanKuisSuaraActivity.class);
                startActivity(kuis1Suara);
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bensoundukulele);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    @Override
    public void onPause(){
        super.onPause();
        mediaPlayer.stop();
    }
}
