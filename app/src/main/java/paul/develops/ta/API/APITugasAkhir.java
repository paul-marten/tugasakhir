package paul.develops.ta.API;

import paul.develops.ta.Response.ResponseDeskripsi;
import paul.develops.ta.Response.ResponseInformasi;
import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;

/**
 * Created by paulms on 12/6/2016.
 */

public interface APITugasAkhir {
    @GET("/informasi")
    void getInformasi(Callback<ResponseInformasi> callback);
    @GET("/deskripsi")
    void getDeskripsi(Callback<ResponseDeskripsi> callback);
}
