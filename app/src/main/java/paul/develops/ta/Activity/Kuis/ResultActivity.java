package paul.develops.ta.Activity.Kuis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import paul.develops.ta.Activity.MainActivity;
import paul.develops.ta.R;
import paul.develops.ta.REST.RestClient;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView textResult = (TextView) findViewById(R.id.textResult);

        Bundle b = getIntent().getExtras();

        int score = b.getInt("score");

        textResult.setText("Your score is " + " " + score + ". Thanks for playing my game.");

    }

    public void playagain(View o) {
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        String nilai = Integer.toString(score);
        RestClient.get().createnewnilai("Kuis gambar 1", nilai, new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {
                Intent intent = new Intent(ResultActivity.this, KuisActivity.class);
                startActivity(intent);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(),"Ga masuk",Toast.LENGTH_LONG).show();
                Intent fail = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(fail);
            }
        });
    }
}
