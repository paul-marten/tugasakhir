package paul.develops.ta.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import paul.develops.ta.Helper.DBHelper;
import paul.develops.ta.Models.InformasiModel;

/**
 * Created by paulms on 12/6/2016.
 */

public class ControllerInformasi {
    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public static final String TABLE_NAME = "informasi";
    public static final String ID_INFORMASI = "id_informasi";
    public static final String ID_KATEGORI = "id_kategori";
    public static final String URL_GAMBAR = "url_gambar";
    public static final String INFORMASI = "informasi";
    public static final String URL_SUARA = "url_suara";

    public static final String CREATE_INFORMASI = "CREATE TABLE "+TABLE_NAME+" "+
            "("+ID_INFORMASI+" integer primary key, "+ ID_KATEGORI+" VARCHAR(100), "+URL_GAMBAR+" VARCHAR(200), "+
            INFORMASI+" VARCHAR(200), "+ URL_SUARA+" VARCHAR(200) )";

    private String[] TABLE_COLUMNS = {ID_INFORMASI,ID_KATEGORI,URL_GAMBAR,INFORMASI, URL_SUARA};

    public ControllerInformasi(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void deleteData (){
        database.delete(TABLE_NAME, null, null);
    }


    public void insertData(int id_informasi, int id_kategori, String url_gambar, String informasi, String url_suara){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_INFORMASI, id_informasi);
        contentValues.put(ID_KATEGORI, id_kategori);
        contentValues.put(URL_GAMBAR, url_gambar);
        contentValues.put(INFORMASI, informasi);
        contentValues.put(URL_SUARA, url_suara);

        database.insert(TABLE_NAME, null, contentValues);
    }

    public ArrayList<InformasiModel> getData() {
        ArrayList<InformasiModel> allData = new ArrayList<InformasiModel>();
        Cursor cursor = null;

        cursor = database.query(TABLE_NAME, TABLE_COLUMNS, null, null, null, null,ID_INFORMASI + " ASC");

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            allData.add(parseData(cursor));
            cursor.moveToNext();
        }

        cursor.close();
        return allData;
    }

    public ArrayList<InformasiModel> getDataHewan(int kategori) {
        ArrayList<InformasiModel> allData = new ArrayList<InformasiModel>();
        Cursor cursor = null;

//        cursor = database.query(TABLE_NAME, TABLE_COLUMNS, null, null, null, null,ID_INFORMASI + " ASC");
        Log.e("masukan ga??" , new Integer(kategori).toString());
//        cursor = database.rawQuery("select * from informasi where id_kategori = '"+ kategori +" order by id_informasi ASC ",null);
        cursor = database.rawQuery("select * from informasi where id_kategori = '"+ kategori +"' order by id_informasi asc",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            allData.add(parseData(cursor));
            cursor.moveToNext();
        }

        cursor.close();
        return allData;
    }

    private InformasiModel parseData(Cursor cursor){
        InformasiModel curData = new InformasiModel();
        curData.setId_informasi(cursor.getInt(0));
        curData.setId_kategori(cursor.getInt(1));
        curData.setUrl_gambar(cursor.getString(2));
        curData.setInformasi(cursor.getString(3));
        curData.setUrl_suara(cursor.getString(4));
        return curData;
    }
}
