package paul.develops.ta.Models;

/**
 * Created by paulms on 2/24/2017.
 */

public class MainDetail {
    private int thumbnail;
    private String name;

    public MainDetail(){

    }

    public MainDetail(String name, int thumbnail){
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
