package paul.develops.ta.Response;

import java.util.List;

import paul.develops.ta.Models.InformasiModel;

/**
 * Created by paulms on 12/6/2016.
 */

public class ResponseInformasi {
    private String error;
    private List<InformasiModel> hasil;
    public String getError(){
        return  this.error;
    }
    public void setError(String error){
        this.error = error;
    }
    public List <InformasiModel> getDaftarInformasi(){
        return this.hasil;
    }
    public  void setGame(List<InformasiModel> hasil){ this.hasil= hasil;}
}
