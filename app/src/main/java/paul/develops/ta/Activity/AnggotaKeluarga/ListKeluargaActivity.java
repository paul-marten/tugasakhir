package paul.develops.ta.Activity.AnggotaKeluarga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import paul.develops.ta.Activity.DetailActivity;
import paul.develops.ta.Activity.Test2Activity;
import paul.develops.ta.Activity.TestActivity;
import paul.develops.ta.R;
import paul.develops.ta.REST.RestClient;

public class ListKeluargaActivity extends AppCompatActivity {

    RestClient restClient;

    public static final String GAMBAR = "gambar";
    public static final String INDONESIA = "indonesia";
    public static final String BATAK = "batak";
    public static final String ENGLISH = "english";
    public static final String SOUND_BATAK = "sound_batak";
    public static final String SOUND_ENGLISH ="sound_english";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_keluarga);

        ImageView imgDad = (ImageView) findViewById(R.id.imgKelDad);
        ImageView imgMom = (ImageView) findViewById(R.id.imgKelMom);
        ImageView imgKakek = (ImageView) findViewById(R.id.imgKelKakek);
        ImageView imgNenek = (ImageView) findViewById(R.id.imgKelNenek);

        Picasso.with(imgDad.getContext())
                .load(restClient.url()+"/images/gameicon/bapak2.png").resize(400, 400).centerCrop()
                .placeholder(R.drawable.sayuran2)
                .error(R.drawable.keluarga2)
                .into(imgDad);

        imgDad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListKeluargaActivity.this, DetailKeluargaActivity.class);
                //Adding book details to intent
                intent.putExtra(GAMBAR , "bapak2.png");
                intent.putExtra(INDONESIA , "Ayah");
                intent.putExtra(BATAK , "Ama");
                intent.putExtra(ENGLISH, "Father");
                intent.putExtra(SOUND_BATAK, "ama");
                intent.putExtra(SOUND_ENGLISH, "father");
                startActivity(intent);
            }
        });

        Picasso.with(imgMom.getContext())
                .load(restClient.url()+"/images/gameicon/mommy2.png").resize(400, 400).centerCrop()
                .placeholder(R.drawable.sayuran2)
                .error(R.drawable.keluarga2)
                .into(imgMom);

        imgMom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListKeluargaActivity.this, DetailKeluargaActivity.class);
                //Adding book details to intent
                intent.putExtra(GAMBAR , "mommy2.png");
                intent.putExtra(INDONESIA , "Ibu");
                intent.putExtra(BATAK , "Inang");
                intent.putExtra(ENGLISH, "Mother");
                intent.putExtra(SOUND_BATAK, "inang");
                intent.putExtra(SOUND_ENGLISH, "mother");
                startActivity(intent);
            }
        });

        Picasso.with(imgKakek.getContext())
                .load(restClient.url()+"/images/gameicon/kakek2.png").resize(400, 400).centerCrop()
                .placeholder(R.drawable.sayuran2)
                .error(R.drawable.keluarga2)
                .into(imgKakek);

        imgKakek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListKeluargaActivity.this, DetailKeluargaActivity.class);
                //Adding book details to intent
                intent.putExtra(GAMBAR , "kakek2.png");
                intent.putExtra(INDONESIA , "Kakek");
                intent.putExtra(BATAK , "Ompung Doli");
                intent.putExtra(ENGLISH, "Grandfather");
                intent.putExtra(SOUND_BATAK, "ompungdoli");
                intent.putExtra(SOUND_ENGLISH, "grandfather");
                startActivity(intent);
            }
        });

        Picasso.with(imgNenek.getContext())
                .load(restClient.url()+"/images/gameicon/nenek2.png").resize(400, 400).centerCrop()
                .placeholder(R.drawable.sayuran2)
                .error(R.drawable.keluarga2)
                .into(imgNenek);

        imgNenek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListKeluargaActivity.this, DetailKeluargaActivity.class);
                //Adding book details to intent
                intent.putExtra(GAMBAR , "nenek2.png");
                intent.putExtra(INDONESIA , "Nenek");
                intent.putExtra(BATAK , "Ompung Boru");
                intent.putExtra(ENGLISH, "Grandmother");
                intent.putExtra(SOUND_BATAK, "ompungboru");
                intent.putExtra(SOUND_ENGLISH, "grandmother");
                startActivity(intent);
            }
        });
    }
}
