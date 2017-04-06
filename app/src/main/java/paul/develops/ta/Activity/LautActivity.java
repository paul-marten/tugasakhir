package paul.develops.ta.Activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import paul.develops.ta.R;
import paul.develops.ta.REST.RestClient;

public class LautActivity extends AppCompatActivity {

    RestClient restClient;
    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer2;

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
        setContentView(R.layout.activity_laut);

        ImageButton img1 = (ImageButton) findViewById(R.id.img1Laut);
        ImageView imgBubble = (ImageView) findViewById(R.id.imgBubble);
        ImageView imgBigBubble = (ImageView) findViewById(R.id.imgBigBubble);
//        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bubbles);

        //animationforimg
        TranslateAnimation animation = new TranslateAnimation(0.0f, 0.0f,
                0.0f, -550.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation.setDuration(5000);  // animation duration
        animation.setRepeatCount(Animation.INFINITE);  // animation repeat count
        animation.setRepeatMode(Animation.RESTART);   // repeat animation (left to right, right to left )
        animation.setFillEnabled(true);
        animation.setFillAfter(true);
        imgBubble.startAnimation(animation);
        imgBigBubble.startAnimation(animation);

        Picasso.with(img1.getContext())
                .load(restClient.url()+"/images/gameicon/ikan2.png").resize(400, 400).centerCrop()
                .placeholder(R.drawable.sayuran2)
                .error(R.drawable.keluarga2)
                .into(img1);

        //animation
        TranslateAnimation animation2 = new TranslateAnimation(0.0f, 100.0f,
                0.0f, 0.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation2.setDuration(1000);  // animation duration
        animation2.setRepeatCount(Animation.INFINITE);  // animation repeat count
        animation2.setRepeatMode(Animation.REVERSE);   // repeat animation (left to right, right to left )
        animation2.setFillEnabled(true);
        animation2.setFillAfter(true);
//        img1.startAnimation(animation2);

        AnimationSet s = new AnimationSet(false);
        s.addAnimation(animation2);
        img1.startAnimation(s);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LautActivity.this, DetailActivity.class);
                //Adding book details to intent
                intent.putExtra(GAMBAR , "ikan2.png");
                intent.putExtra(NAMA , "Ikan");
                intent.putExtra(DESKRIPSI , "Ikan Karang");
                intent.putExtra(ENGLISH, "Fish");
                intent.putExtra(BATAK, "Dengke");
                intent.putExtra(SOUND_BATAK, "dengke");
                intent.putExtra(SOUND_ENGLISH, "fish");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.pantai);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        mediaPlayer2 = MediaPlayer.create(getApplicationContext(), R.raw.bubbles);
        mediaPlayer2.setLooping(true);
        mediaPlayer2.start();
    }

    @Override
    public void onPause(){
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer2.stop();
    }
}
