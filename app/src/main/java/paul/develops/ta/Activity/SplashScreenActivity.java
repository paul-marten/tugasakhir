package paul.develops.ta.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import paul.develops.ta.Controller.ControllerDeskripsi;
import paul.develops.ta.Controller.ControllerInformasi;
import paul.develops.ta.Models.DeskripsiModel;
import paul.develops.ta.Models.InformasiModel;
import paul.develops.ta.R;
import paul.develops.ta.REST.RestClient;
import paul.develops.ta.Response.ResponseDeskripsi;
import paul.develops.ta.Response.ResponseInformasi;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView image = (ImageView) findViewById(R.id.imageView);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        image.startAnimation(animation1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent loginIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(loginIntent);
                finish();
            }
        }, 3000);

        RestClient.get().getInformasi(new Callback<ResponseInformasi>() {
            @Override
            public void success(ResponseInformasi Informasi, Response response) {
                //TODO Auto generated method stub
                if (Informasi.getDaftarInformasi().size() > 0) {
                    ControllerInformasi chb = new ControllerInformasi(getApplicationContext());
                    try{
                        chb.open();
                        chb.deleteData();
                        for (int y = 0; y < Informasi.getDaftarInformasi().size(); y++) {
                            InformasiModel tmpHasil = Informasi.getDaftarInformasi().get(y);
                            chb.insertData(tmpHasil.getId_informasi(),tmpHasil.getId_kategori(),tmpHasil.getUrl_gambar(),tmpHasil.getInformasi(),tmpHasil.getUrl_suara());

                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        chb.close();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "DATA SEDANG TIDAK TERSEDIA", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), "AKSES KE SERVER GAGAL" + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        RestClient.get().getDeskripsi(new Callback<ResponseDeskripsi>() {
            @Override
            public void success(ResponseDeskripsi Deskripsi, Response response) {
                //TODO Auto generated method stub
                if (Deskripsi.getDaftarDeskripsi().size() > 0) {
                    Toast.makeText(getApplicationContext(), "welcome", Toast.LENGTH_LONG).show();
                    Log.e("Paul","Masuk looh Deskripsi" + Deskripsi.getDaftarDeskripsi().size());
                    System.out.println("Jlh Deskripsi: "+Deskripsi.getDaftarDeskripsi().size());
                    ControllerDeskripsi chb = new ControllerDeskripsi(getApplicationContext());
                    try{
                        chb.open();
                        chb.deleteData();
                        for (int y = 0; y < Deskripsi.getDaftarDeskripsi().size(); y++) {
                            DeskripsiModel tmpHasil = Deskripsi.getDaftarDeskripsi().get(y);
                            chb.insertData(tmpHasil.getId_deskripsi(),tmpHasil.getDeskripsi(),tmpHasil.getInggris(),tmpHasil.getBatak(),tmpHasil.getId_informasi(),tmpHasil.getUrl_gambarhuruf(),tmpHasil.getUrl_batak(),tmpHasil.getInggris());
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        chb.close();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "DATA SEDANG TIDAK TERSEDIA", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), "AKSES KE SERVER GAGAL" + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
