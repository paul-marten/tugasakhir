package paul.develops.ta.Activity;

import android.app.ActionBar;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import paul.develops.ta.R;
import paul.develops.ta.REST.RestClient;

public class TestActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_test);

//        View decorView = getWindow().getDecorView();
//        // Hide the status bar.
//                int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//                decorView.setSystemUiVisibility(uiOptions);
//        // Remember that you should never show the action bar if the
//        // status bar is hidden, so hide that too if necessary.
//        ActionBar actionBar = getActionBar();
//        actionBar.hide();

        ImageButton img1 = (ImageButton) findViewById(R.id.img1);
        ImageButton img2 = (ImageButton) findViewById(R.id.img2);
        ImageView imgBird = (ImageView) findViewById(R.id.imgBgBird);


        Picasso.with(imgBird.getContext())
                .load(restClient.url()+"/images/gameicon/bird2.png").resize(400, 400).centerCrop()
                .placeholder(R.drawable.sayuran2)
                .error(R.drawable.keluarga2)
                .into(imgBird);

        //animationforimg
        TranslateAnimation animation = new TranslateAnimation(0.0f, -620.0f,
                0.0f, 0.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation.setDuration(5000);  // animation duration
        animation.setRepeatCount(Animation.INFINITE);  // animation repeat count
        animation.setRepeatMode(Animation.RESTART);   // repeat animation (left to right, right to left )
        animation.setFillEnabled(true);
        animation.setFillAfter(true);
        imgBird.startAnimation(animation);

        Picasso.with(img1.getContext())
                .load(restClient.url()+"/images/gameicon/cat2.png").resize(400, 400).centerCrop()
                .placeholder(R.drawable.sayuran2)
                .error(R.drawable.keluarga2)
                .into(img1);

        Picasso.with(img2.getContext())
                .load(restClient.url()+"/images/gameicon/dog3.png").resize(400, 400).centerCrop()
                .placeholder(R.drawable.sayuran2)
                .error(R.drawable.keluarga2)
                .into(img2);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("cat1", "raw", getPackageName()));
                mediaPlayer.start();
                Intent intent = new Intent(TestActivity.this, DetailActivity.class);

                //Adding book details to intent
                intent.putExtra(GAMBAR , "cat2.png");
                intent.putExtra(NAMA , "kucing");
                intent.putExtra(DESKRIPSI , "kucing rumah");
                intent.putExtra(ENGLISH, "cat");
                intent.putExtra(BATAK, "huting");
                intent.putExtra(SOUND_BATAK, "huting");
                intent.putExtra(SOUND_ENGLISH, "cat");
                startActivity(intent);


            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier("dog1", "raw", getPackageName()));
                mediaPlayer.start();
                Intent intent = new Intent(TestActivity.this, DetailActivity.class);
                //Adding book details to intent
                intent.putExtra(GAMBAR , "dog3.png");
                intent.putExtra(NAMA , "anjing");
                intent.putExtra(DESKRIPSI , "anjing jantan");
                intent.putExtra(ENGLISH, "dog");
                intent.putExtra(BATAK, "biang");
                intent.putExtra(SOUND_BATAK, "biang");
                intent.putExtra(SOUND_ENGLISH, "dog");
                startActivity(intent);
            }
        });
    }
}
