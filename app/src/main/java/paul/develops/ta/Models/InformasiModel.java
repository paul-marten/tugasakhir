package paul.develops.ta.Models;

/**
 * Created by paulms on 12/6/2016.
 */

public class InformasiModel {
    private int id_informasi;
    private int id_kategori;
    private String url_gambar;
    private String informasi;
    private String url_suara;

    public int getId_informasi() {
        return id_informasi;
    }

    public void setId_informasi(int id_informasi) {
        this.id_informasi = id_informasi;
    }

    public int getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(int id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getUrl_gambar() {
        return url_gambar;
    }

    public void setUrl_gambar(String url_gambar) {
        this.url_gambar = url_gambar;
    }

    public String getInformasi() {
        return informasi;
    }

    public void setInformasi(String informasi) {
        this.informasi = informasi;
    }

    public String getUrl_suara() {
        return url_suara;
    }

    public void setUrl_suara(String url_suara) {
        this.url_suara = url_suara;
    }
}
