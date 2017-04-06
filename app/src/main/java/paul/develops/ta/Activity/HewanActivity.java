package paul.develops.ta.Activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import paul.develops.ta.Adapter.InformasiAdapter;
import paul.develops.ta.Controller.ControllerInformasi;
import paul.develops.ta.Models.InformasiModel;
import paul.develops.ta.R;
import paul.develops.ta.REST.RestClient;

public class HewanActivity extends AppCompatActivity {
    InformasiAdapter gameAdapater;
    ArrayList<InformasiModel> game;
    ControllerInformasi controllerInformasi;
    RestClient restClient;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hewan);
        GridView gridView = (GridView) findViewById(R.id.grid_view_hewan);

        game= new ArrayList();

        controllerInformasi = new ControllerInformasi(this);

        try {
            //Open connection to db before access the data
            controllerInformasi.open();
            game = controllerInformasi.getDataHewan(1);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Always close connection after open connection
            controllerInformasi.close();
        }

        gameAdapater = new InformasiAdapter(this,game);
        gridView.setAdapter(gameAdapater);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                mediaPlayer = MediaPlayer.create(getApplicationContext(), Uri.parse(restClient.url()+"/raw/"+game.get(position).getUrl_suara()));
                mediaPlayer.start();
//                mediaPlayer.stop();
//                Log.e("nama hewan", game.get(position).getUrl_suara());
                Toast.makeText(getApplicationContext(), "Anda memilih " + game.get(position).getInformasi(), Toast.LENGTH_LONG).show();

//                Intent DetailGame = new Intent(getApplication(),marketplace.marketplace.View.DetailGame.class);
//                String game_name = String.valueOf((game.get(position).getGame_name()));
//                String game_id = String.valueOf((game.get(position).getGame_id()));
//                DetailGame.putExtra("nama",game_name);
//                String genre_id = String.valueOf((game.get(position).getGenre_id()));
//                DetailGame.putExtra("genre_id",genre_id);
//                DetailGame.putExtra("game_id",game_id);
//                startActivity(DetailGame);
            }
        });
    }
}
