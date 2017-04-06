package paul.develops.ta.Activity.Tumbuhan;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import paul.develops.ta.Activity.Body.HeadActivity;
import paul.develops.ta.Activity.DetailActivity;
import paul.develops.ta.R;
import paul.develops.ta.REST.RestClient;

public class MarketActivity extends AppCompatActivity {

    RestClient restClient;
    MediaPlayer mediaPlayer;

    public static final String GAMBAR = "gambar";
    public static final String NAMA = "nama";
    public static final String DESKRIPSI = "deskripsi";
    public static final String ENGLISH = "english";
    public static final String BATAK = "batak";
    public static final String SOUND_BATAK = "sound_batak";
    public static final String SOUND_ENGLISH ="sound_english";
    public static final String SOUND_INDONESIA ="sound_indonesia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        ImageView imgSemangka = (ImageView) findViewById(R.id.imgSemangka);
        ImageView imgJeruk = (ImageView) findViewById(R.id.imgJeruk);
        ImageView imgApel = (ImageView) findViewById(R.id.imgApel);
        ImageView imgPisang1 = (ImageView) findViewById(R.id.imgPisang1);
        ImageView imgPisang2 = (ImageView) findViewById(R.id.imgPisang2);

        imgSemangka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MarketActivity.this, DetailActivity.class);
                intent.putExtra(GAMBAR , "semangka.png");
                intent.putExtra(NAMA , "Semangka");
                intent.putExtra(DESKRIPSI , "Semangka merah manis");
                intent.putExtra(ENGLISH, "Watermelon");
                intent.putExtra(BATAK, "Haramoja");
                intent.putExtra(SOUND_BATAK, "semangkabatak.3gpp");
                intent.putExtra(SOUND_ENGLISH, "watermelon.3gpp");
                startActivity(intent);
            }
        });

        imgJeruk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MarketActivity.this, DetailActivity.class);
                intent.putExtra(GAMBAR , "jeruk.png");
                intent.putExtra(NAMA , "Jeruk");
                intent.putExtra(DESKRIPSI , "Jeruk berastagi");
                intent.putExtra(ENGLISH, "Orange");
                intent.putExtra(BATAK, "Unte");
                intent.putExtra(SOUND_BATAK, "unte.3gpp");
                intent.putExtra(SOUND_ENGLISH, "orange.3gpp");
                startActivity(intent);
            }
        });

        imgApel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MarketActivity.this, DetailActivity.class);
                intent.putExtra(GAMBAR , "apel.png");
                intent.putExtra(NAMA , "Apel");
                intent.putExtra(DESKRIPSI , "Apel merah gunung fuji");
                intent.putExtra(ENGLISH, "Apple");
                intent.putExtra(BATAK, "");
                intent.putExtra(SOUND_BATAK, "");
                intent.putExtra(SOUND_ENGLISH, "apeleng.mp3");
                startActivity(intent);
            }
        });

        imgPisang1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MarketActivity.this, DetailActivity.class);
                intent.putExtra(GAMBAR , "pisang.png");
                intent.putExtra(NAMA , "Pisang");
                intent.putExtra(DESKRIPSI , "Pisang ambon");
                intent.putExtra(ENGLISH, "Banana");
                intent.putExtra(BATAK, "");
                intent.putExtra(SOUND_BATAK, "");
                intent.putExtra(SOUND_ENGLISH, "banana.3gpp");
                startActivity(intent);
            }
        });

        imgPisang2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MarketActivity.this, DetailActivity.class);
                intent.putExtra(GAMBAR , "pisang.png");
                intent.putExtra(NAMA , "Pisang");
                intent.putExtra(DESKRIPSI , "Pisang ambon");
                intent.putExtra(ENGLISH, "Banana");
                intent.putExtra(BATAK, "Pisang");
                intent.putExtra(SOUND_BATAK, "");
                intent.putExtra(SOUND_ENGLISH, "banana.3gpp");
                startActivity(intent);
            }
        });
    }
}
