package paul.develops.ta.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import paul.develops.ta.Controller.ControllerDeskripsi;
import paul.develops.ta.Controller.ControllerInformasi;

/**
 * Created by paulms on 12/6/2016.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "aplikasita.db";
    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(ControllerInformasi.CREATE_INFORMASI);
        db.execSQL(ControllerDeskripsi.CREATE_DESKRIPSI);
//        db.execSQL(ControllerReleaseCategory.CREATE_RELEASE_CATEGORY);
//        db.execSQL(ControllerGenre.CREATE_GENRE);
//        db.execSQL(ControllerPlatfrom.CREATE_PLATFORM);
//        db.execSQL(ControllerGamePlatform.CREATE_GAME_PLATFORM);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO Auto-generated method stub
    }
}

