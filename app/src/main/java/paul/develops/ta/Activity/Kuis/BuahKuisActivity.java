package paul.develops.ta.Activity.Kuis;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.concurrent.TimeUnit;

import paul.develops.ta.Helper.DBHelper;
import paul.develops.ta.Models.BuahKuis;
import paul.develops.ta.Models.KeluargaKuis;
import paul.develops.ta.R;
import paul.develops.ta.REST.RestClient;

public class BuahKuisActivity extends AppCompatActivity {

    List<BuahKuis> quesList;
    int score = 0;
    int qid = 0;

    RestClient restClient;

    BuahKuis currentQ;
    TextView times, scored;
    ImageView imgHewan;
    Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buah_kuis);DBHelper db = new DBHelper(this);  // my question bank class
        quesList = db.getAllKuisBuah();  // this will fetch all quetonall questions
        currentQ = quesList.get(qid); // the current question

//        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        imgHewan = (ImageView) findViewById(R.id.imgBuahKuis);
        // the textview in which the question will be displayed

        // the three buttons,
        // the idea is to set the text of three buttons with the options from question bank
        button1 = (Button) findViewById(R.id.button1BuahKuis);
        button2 = (Button) findViewById(R.id.button2BuahKuis);
        button3 = (Button) findViewById(R.id.button3BuahKuis);

        // the textview in which score will be displayed
        scored = (TextView) findViewById(R.id.scoreBuahKuis);

        // the timer
        times = (TextView) findViewById(R.id.timersBuahKuis);

        // method which will set the things up for our game
        setQuestionView();
        times.setText("00:01:00");

        // A timer of 60 seconds to play for, with an interval of 1 second (1000 milliseconds)
        CounterClass timer = new CounterClass(60000, 1000);
        timer.start();

        // button click listeners
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // passing the button text to other method
                // to check whether the anser is correct or not
                // same for all three buttons
                getAnswer(button1.getText().toString());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button2.getText().toString());
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button3.getText().toString());
            }
        });
    }

    public void getAnswer(String AnswerString) {
        if (currentQ.getANSWER().equals(AnswerString)) {

            // if conditions matches increase the int (score) by 1
            // and set the text of the score view
            score++;
            scored.setText("Score : " + score);
        } else {

            // if unlucky start activity and finish the game

            Intent intent = new Intent(BuahKuisActivity.this,
                    ResultActivity.class);

            // passing the int value
            Bundle b = new Bundle();
            b.putInt("score", score); // Your score
            intent.putExtras(b); // Put your score to your next
            startActivity(intent);
            finish();
        }
        if (qid < 4) {

            // if questions are not over then do this
            currentQ = quesList.get(qid);
            setQuestionView();
        } else {

            // if over do this
            Intent intent = new Intent(BuahKuisActivity.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); // Your score
            intent.putExtras(b); // Put your score to your next
            startActivity(intent);
            finish();
        }

    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onFinish() {
            times.setText("Time is up");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub

            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            times.setText(hms);
        }

    }

    private void setQuestionView() {

        // the method which will put all things together
        Picasso.with(imgHewan.getContext())
                .load(restClient.url()+"/images/gameicon/"+currentQ.getQUESTION()).resize(400, 400).centerCrop()
                .placeholder(R.drawable.sayuran2)
                .error(R.drawable.keluarga2)
                .into(imgHewan);

        button1.setText(currentQ.getOPTA());
        button2.setText(currentQ.getOPTB());
        button3.setText(currentQ.getOPTC());

        qid++;
    }

}