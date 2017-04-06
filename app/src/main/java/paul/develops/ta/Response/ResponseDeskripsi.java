package paul.develops.ta.Response;

import java.util.List;

import paul.develops.ta.Models.DeskripsiModel;

/**
 * Created by paulms on 1/4/2017.
 */

public class ResponseDeskripsi {
    private String error;
    private List<DeskripsiModel> hasil;
    public String getError(){
        return  this.error;
    }
    public void setError(String error){
        this.error = error;
    }
    public List <DeskripsiModel> getDaftarDeskripsi(){
        return this.hasil;
    }
    public  void setGame(List<DeskripsiModel> hasil){ this.hasil= hasil;}
}
