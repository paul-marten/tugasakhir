package paul.develops.ta.Activity.Body;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import paul.develops.ta.Activity.DetailActivity;
import paul.develops.ta.Activity.Test2Activity;
import paul.develops.ta.R;
import paul.develops.ta.REST.RestClient;

public class HeadActivity extends AppCompatActivity {

    RestClient restClient;
    MediaPlayer mediaPlayer;

    public static final String GAMBAR = "gambar";
    public static final String NAMA = "nama";
    public static final String DESKRIPSI = "deskripsi";
    public static final String ENGLISH = "english";
    public static final String BATAK = "batak";
    public static final String SOUND_BATAK = "sound_batak";
    public static final String SOUND_ENGLISH ="sound_english";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);

        ImageView imgEyeRight = (ImageView) findViewById(R.id.imgRightEye);
        ImageView imgEyeLeft = (ImageView) findViewById(R.id.imgLeftEye);
        ImageView imgMouth = (ImageView) findViewById(R.id.imgMouth);
        ImageView imgNose = (ImageView) findViewById(R.id.imgNose);

        imgEyeRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HeadActivity.this, DetailActivity.class);
                intent.putExtra(GAMBAR , "eye.png");
                intent.putExtra(NAMA , "Mata");
                intent.putExtra(DESKRIPSI , "Kedua Mata");
                intent.putExtra(ENGLISH, "eyes");
                intent.putExtra(BATAK, "simalolong");
                intent.putExtra(SOUND_BATAK, "simalolong");
                intent.putExtra(SOUND_ENGLISH, "eye");
                startActivity(intent);
            }
        });

        imgEyeLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HeadActivity.this, DetailActivity.class);
                intent.putExtra(GAMBAR , "eye.png");
                intent.putExtra(NAMA , "Mata");
                intent.putExtra(DESKRIPSI , "Kedua Mata");
                intent.putExtra(ENGLISH, "Eyes");
                intent.putExtra(BATAK, "Simalolong");
                intent.putExtra(SOUND_BATAK, "simalolong");
                intent.putExtra(SOUND_ENGLISH, "eye");
                startActivity(intent);
            }
        });

        imgMouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HeadActivity.this, DetailActivity.class);
                intent.putExtra(GAMBAR , "mouth.png");
                intent.putExtra(NAMA , "Mulut");
                intent.putExtra(DESKRIPSI , "Mulut bersih");
                intent.putExtra(ENGLISH, "Mouth");
                intent.putExtra(BATAK, "Baba");
                intent.putExtra(SOUND_BATAK, "baba");
                intent.putExtra(SOUND_ENGLISH, "mouth");
                startActivity(intent);
            }
        });

        imgNose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HeadActivity.this, DetailActivity.class);
                intent.putExtra(GAMBAR , "nose.png");
                intent.putExtra(NAMA , "Hidung");
                intent.putExtra(DESKRIPSI , "Bagian tubuh hidung manusia");
                intent.putExtra(ENGLISH, "Nose");
                intent.putExtra(BATAK, "Igung");
                intent.putExtra(SOUND_BATAK, "igung");
                intent.putExtra(SOUND_ENGLISH, "nose");
                startActivity(intent);
            }
        });
    }
}
