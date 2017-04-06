package paul.develops.ta.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import paul.develops.ta.Activity.Body.BodyActivity;
import paul.develops.ta.Activity.Body.HeadActivity;
import paul.develops.ta.Activity.Body.LeftHandActivity;
import paul.develops.ta.Activity.Body.LowerBodyActivity;
import paul.develops.ta.Activity.Body.RightHandActivity;
import paul.develops.ta.R;

public class TubuhActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tubuh);

        ImageView imgHead = (ImageView)findViewById(R.id.imgHead);
        ImageView imgUpBody = (ImageView) findViewById(R.id.imgUpperBody);
        ImageView imgDownBody = (ImageView) findViewById(R.id.imgLowerBody);
        ImageView imgLeftHand = (ImageView) findViewById(R.id.imgLeftHand);
        ImageView imgRightHand = (ImageView) findViewById(R.id.imgRightHand);

        imgHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent head = new Intent(TubuhActivity.this, HeadActivity.class);
                startActivity(head);
            }
        });

        imgDownBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent downBody = new Intent(TubuhActivity.this, LowerBodyActivity.class);
                startActivity(downBody);
            }
        });

        imgUpBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent upBody = new Intent(TubuhActivity.this, BodyActivity.class);
                startActivity(upBody);
            }
        });

        imgLeftHand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leftHand =  new Intent(TubuhActivity.this, LeftHandActivity.class);
                startActivity(leftHand);
            }
        });

        imgRightHand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rightHand =  new Intent(TubuhActivity.this, RightHandActivity.class);
                startActivity(rightHand);
            }
        });
    }
}
