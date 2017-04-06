package paul.develops.ta.Activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import paul.develops.ta.R;
import paul.develops.ta.REST.RestClient;

public class DetailActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    RestClient restClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageButton imgDetail = (ImageButton) findViewById(R.id.imgButDet);
        TextView txtNama = (TextView) findViewById(R.id.txtDeskripsiNama);
        TextView txtInfo = (TextView) findViewById(R.id.txtDeskripsiInfo);
        TextView txtEnglish = (TextView) findViewById(R.id.txtEnglish);
        TextView txtBatak = (TextView) findViewById(R.id.txtBatak);
        ImageButton butEng = (ImageButton) findViewById(R.id.butEnglish);
        ImageButton butBat = (ImageButton) findViewById(R.id.butBatak);
        Intent intent = getIntent();

        //animationforimg
        TranslateAnimation animation = new TranslateAnimation(0.0f, 100.0f,
                0.0f, 0.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation.setDuration(1000);  // animation duration
        animation.setRepeatCount(Animation.INFINITE);  // animation repeat count
        animation.setRepeatMode(2);   // repeat animation (left to right, right to left )
        animation.setFillEnabled(true);
        animation.setFillAfter(true);
        imgDetail.startAnimation(animation);

        //currentRotation
        int currentRotation = 0;
        RotateAnimation anim = new RotateAnimation(currentRotation, (360*4),
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        currentRotation = (currentRotation + 45) % 360;
        anim.setInterpolator(new LinearInterpolator());
        anim.setDuration(4000);
        // anim.setRepeatMode(Animation.INFINITE);
        anim.setRepeatCount(1);
        anim.setFillEnabled(true);
        anim.setFillAfter(true);
        butBat.startAnimation(anim);
        butEng.startAnimation(anim);


        //mengisi detail
        txtNama.setText(intent.getStringExtra(TestActivity.NAMA));
        txtInfo.setText(intent.getStringExtra(TestActivity.DESKRIPSI));
        txtEnglish.setText(intent.getStringExtra(TestActivity.ENGLISH));
        txtBatak.setText(intent.getStringExtra(TestActivity.BATAK));
        Picasso.with(imgDetail.getContext())
                .load(restClient.url()+"/images/gameicon/"+intent.getStringExtra(TestActivity.GAMBAR)).resize(400, 400).centerCrop()
                .placeholder(R.drawable.sayuran2)
                .error(R.drawable.keluarga2)
                .into(imgDetail);

        imgDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                mediaPlayer = MediaPlayer.create(getApplicationContext(), Uri.parse(restClient.url()+"/raw/"+intent1.getStringExtra(TestActivity.SOUND_ENGLISH)));
                mediaPlayer.start();
            }
        });

        butEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                mediaPlayer = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier(intent1.getStringExtra(TestActivity.SOUND_ENGLISH), "raw", getPackageName()));
                mediaPlayer.start();
            }
        });

//        butBat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent1 = getIntent();
//                mediaPlayer = MediaPlayer.create(getApplicationContext(), Uri.parse(restClient.url()+"/raw/"+intent1.getStringExtra(TestActivity.SOUND_BATAK)));
//                mediaPlayer.start();
//            }
//        });


        butBat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                mediaPlayer = MediaPlayer.create(getApplicationContext(),getResources().getIdentifier(intent1.getStringExtra(TestActivity.SOUND_BATAK), "raw", getPackageName()));
                mediaPlayer.start();
            }
        });
    }
}
