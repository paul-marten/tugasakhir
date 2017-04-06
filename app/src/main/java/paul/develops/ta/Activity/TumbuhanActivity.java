package paul.develops.ta.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import paul.develops.ta.Activity.Tumbuhan.MarketActivity;
import paul.develops.ta.Activity.Tumbuhan.SawahActivity;
import paul.develops.ta.R;

public class TumbuhanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tumbuhan);

        ImageButton imgButMarket = (ImageButton) findViewById(R.id.butImgMarket);
        ImageButton imgButSawah = (ImageButton) findViewById(R.id.butImgSawah);

        imgButMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TumbuhanActivity.this,"Anda Memilih Pasar", Toast.LENGTH_LONG).show();
                Intent market = new Intent(TumbuhanActivity.this, MarketActivity.class);
                startActivity(market);
            }
        });

        imgButSawah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TumbuhanActivity.this,"Anda Memilih Sawah", Toast.LENGTH_LONG).show();
                Intent sawahIntent = new Intent(TumbuhanActivity.this, SawahActivity.class);
                startActivity(sawahIntent);
            }
        });
    }
}
