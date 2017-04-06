package paul.develops.ta.Activity.AnggotaKeluarga;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import paul.develops.ta.Activity.TestActivity;
import paul.develops.ta.R;
import paul.develops.ta.REST.RestClient;

public class DetailKeluargaActivity extends AppCompatActivity {

    RestClient restClient;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_keluarga);

        ImageView imgDetail = (ImageView) findViewById(R.id.imgIconKeluarga);
        TextView txtEnglish = (TextView) findViewById(R.id.txtKeluargaEng);
        TextView txtIndo = (TextView) findViewById(R.id.txtKeluargaIndo);
        TextView txtBatak = (TextView) findViewById(R.id.txtKeluargaBat);
        ImageView imgEnglish = (ImageView) findViewById(R.id.imgSoundEng);
        ImageView imgBatak = (ImageView) findViewById(R.id.imgSoundBatak);
        Intent intent = getIntent();


        //mengisi detail
        txtEnglish.setText(intent.getStringExtra(ListKeluargaActivity.ENGLISH));
        txtIndo.setText(intent.getStringExtra(ListKeluargaActivity.INDONESIA));
        txtBatak.setText(intent.getStringExtra(ListKeluargaActivity.BATAK));

        Picasso.with(imgDetail.getContext())
                .load(restClient.url()+"/images/gameicon/"+intent.getStringExtra(TestActivity.GAMBAR)).resize(400, 400).centerCrop()
                .placeholder(R.drawable.sayuran2)
                .error(R.drawable.keluarga2)
                .into(imgDetail);

        imgEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                mediaPlayer = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier(intent1.getStringExtra(TestActivity.SOUND_ENGLISH), "raw", getPackageName()));
                mediaPlayer.start();
            }
        });

        imgBatak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                mediaPlayer = MediaPlayer.create(getApplicationContext(), getResources().getIdentifier(intent1.getStringExtra(TestActivity.SOUND_BATAK), "raw", getPackageName()));
                mediaPlayer.start();
            }
        });
    }
}
