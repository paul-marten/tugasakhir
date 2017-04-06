package paul.develops.ta.Activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.squareup.picasso.Picasso;

import paul.develops.ta.R;
import paul.develops.ta.REST.RestClient;

public class Test2Activity extends AppCompatActivity {

    RestClient restClient;
    MediaPlayer mediaPlayer;

    public static final String GAMBAR = "gambar";
    public static final String NAMA = "nama";
    public static final String DESKRIPSI = "deskripsi";
    public static final String ENGLISH = "english";
    public static final String BATAK = "batak";
    public static final String SOUND_BATAK = "sound_batak";
    public static final String SOUND_ENGLISH ="sound_english";
    public static final String SOUND_INDONESI ="sound_indonesia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        ImageButton img2 = (ImageButton) findViewById(R.id.img2Dessert);
        ImageButton img1 = (ImageButton) findViewById(R.id.img1Dessert);

        Picasso.with(img2.getContext())
                .load(restClient.url()+"/images/gameicon/snake3.png").resize(250, 150).centerCrop()
                .placeholder(R.drawable.sayuran2)
                .error(R.drawable.keluarga2)
                .into(img2);

        Picasso.with(img1.getContext())
                .load(restClient.url()+"/images/gameicon/camel4.png").resize(250, 150).centerCrop()
                .placeholder(R.drawable.sayuran2)
                .error(R.drawable.keluarga2)
                .into(img1);

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("snake1", "raw", getPackageName()));
                mediaPlayer.start();
                Intent intent = new Intent(Test2Activity.this, DetailActivity.class);
                //Adding book details to intent
                intent.putExtra(GAMBAR , "snake3.png");
                intent.putExtra(NAMA , "ular");
                intent.putExtra(DESKRIPSI , "ular pasir");
                intent.putExtra(ENGLISH, "snake");
                intent.putExtra(BATAK, "ulok");
                intent.putExtra(SOUND_BATAK, "ulok");
                intent.putExtra(SOUND_ENGLISH, "snake");
                startActivity(intent);
            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Test2Activity.this, DetailActivity.class);
                //Adding book details to intent
                intent.putExtra(GAMBAR , "camel4.png");
                intent.putExtra(NAMA , "Unta");
                intent.putExtra(DESKRIPSI , "Unta padang pasir");
                intent.putExtra(ENGLISH, "Camel");
                intent.putExtra(BATAK, " ");
                intent.putExtra(SOUND_BATAK, "");
                intent.putExtra(SOUND_ENGLISH, "");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.backsound4);
        mediaPlayer.start();
    }

    @Override
    public void onPause(){
        super.onPause();
        mediaPlayer.stop();
    }
}
