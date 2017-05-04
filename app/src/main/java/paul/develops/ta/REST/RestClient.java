package paul.develops.ta.REST;

import paul.develops.ta.API.APITugasAkhir;
import retrofit.RestAdapter;

/**
 * Created by paulms on 12/6/2016.
 */

public class RestClient {
        private static APITugasAkhir REST_CLIENT;
//        private static String URL_TUGASAKHIR = "http://192.168.43.230:81/tugasakhirAPI";
//        private static String URL_TUGASAKHIR = "http://192.168.43.214:81/tugasakhirAPI";
//        private static String URL_TUGASAKHIR = "http://10.108.155.247:81/tugasakhirAPI";
//        private static String URL_TUGASAKHIR = "http://10.114.1d.61:81/tugasakhirAPI";
        private static String URL_TUGASAKHIR = "http://10.114.56.86:81/tugasakhirAPI";
//        private static String URL_TUGASAKHIR = "http://172.27.43.132:81/tugasakhirAPI";
//        private static String URL_TUGASAKHIR = "http://10.108.36.254:81/tugasakhirAPI";

        static {
            //dieksekusi sebelum constructor, tapi hanya sekaliuntuk semuainstans
            setupRestClient();
        }

        private RestClient() {}

        public static String url(){
                return URL_TUGASAKHIR;
        }


        public static APITugasAkhir get() {
            return REST_CLIENT;
        }

        private static void setupRestClient() {
        RestAdapter builder = new RestAdapter.Builder().setEndpoint(URL_TUGASAKHIR).build();
        REST_CLIENT = builder.create(APITugasAkhir.class);

        }
}
