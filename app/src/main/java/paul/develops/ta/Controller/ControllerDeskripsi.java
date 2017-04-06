package paul.develops.ta.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import paul.develops.ta.Helper.DBHelper;
import paul.develops.ta.Models.DeskripsiModel;
import paul.develops.ta.Models.InformasiModel;

/**
 * Created by paulms on 1/5/2017.
 */

public class ControllerDeskripsi {
    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public static final String TABLE_NAME = "deskripsi_isi";
    public static final String ID_DESKRIPSI = "id_deskripsi";
    public static final String DESKRIPSI = "deskripsi";
    public static final String INGGRIS = "inggris";
    public static final String BATAK = "batak";
    public static final String ID_INFORMASI = "id_informasi";
    public static final String URL_GAMBARHURUF = "url_gambarhuruf";
    public static final String URL_BATAK = "url_batak";
    public static final String URL_INGGRIS = "url_inggris";

    public static final String CREATE_DESKRIPSI = "CREATE TABLE "+TABLE_NAME+" "+
            "("+ID_DESKRIPSI+" integer primary key, "+ DESKRIPSI+" VARCHAR(200), "+INGGRIS+" VARCHAR(100), "+
            BATAK+" VARCHAR(100), "+ ID_INFORMASI+" VARCHAR(200), "+ URL_GAMBARHURUF+" VARCHAR(200), "+ URL_BATAK+" VARCHAR(200), "+ URL_INGGRIS+" VARCHAR(200) )";

    private String[] TABLE_COLUMNS = {ID_DESKRIPSI,DESKRIPSI,INGGRIS,BATAK, ID_INFORMASI,URL_GAMBARHURUF,URL_BATAK,URL_INGGRIS};

    public ControllerDeskripsi(Context context) {
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


    public void insertData(int id_deskripsi, String deskripsi, String inggris, String batak, int id_informasi, String url_gambarhuruf, String url_batak, String url_inggris){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_DESKRIPSI, id_deskripsi);
        contentValues.put(DESKRIPSI, deskripsi);
        contentValues.put(INGGRIS, inggris);
        contentValues.put(BATAK, batak);
        contentValues.put(ID_INFORMASI, id_informasi);
        contentValues.put(URL_GAMBARHURUF, url_gambarhuruf);
        contentValues.put(URL_BATAK, url_batak);
        contentValues.put(URL_INGGRIS, url_inggris);
        database.insert(TABLE_NAME, null, contentValues);
    }

    public ArrayList<DeskripsiModel> getData() {
        ArrayList<DeskripsiModel> allData = new ArrayList<DeskripsiModel>();
        Cursor cursor = null;

        cursor = database.query(TABLE_NAME, TABLE_COLUMNS, null, null, null, null,ID_DESKRIPSI + " ASC");

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            allData.add(parseData(cursor));
            cursor.moveToNext();
        }

        cursor.close();
        return allData;
    }

    public ArrayList<DeskripsiModel> getDataHewan(int kategori) {
        ArrayList<DeskripsiModel> allData = new ArrayList<DeskripsiModel>();
        Cursor cursor = null;

//        cursor = database.query(TABLE_NAME, TABLE_COLUMNS, null, null, null, null,ID_INFORMASI + " ASC");
        Log.e("masukan ga??" , new Integer(kategori).toString());
//        cursor = database.rawQuery("select * from informasi where id_kategori = '"+ kategori +" order by id_informasi ASC ",null);
        cursor = database.rawQuery("select * from deskripsi_isi where id_kategori = '"+ kategori +"' order by id_informasi asc",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            allData.add(parseData(cursor));
            cursor.moveToNext();
        }

        cursor.close();
        return allData;
    }

    private DeskripsiModel parseData(Cursor cursor){
        DeskripsiModel curData = new DeskripsiModel();
        curData.setId_deskripsi(cursor.getInt(0));
        curData.setDeskripsi(cursor.getString(1));
        curData.setInggris(cursor.getString(2));
        curData.setBatak(cursor.getString(3));
        curData.setId_informasi(cursor.getInt(4));
        curData.setUrl_gambarhuruf(cursor.getString(5));
        curData.setUrl_batak(cursor.getString(6));
        curData.setUrl_english(cursor.getString(7));
        return curData;
    }
}
