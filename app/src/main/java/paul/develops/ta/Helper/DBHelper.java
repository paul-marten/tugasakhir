package paul.develops.ta.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import paul.develops.ta.Controller.ControllerDeskripsi;
import paul.develops.ta.Controller.ControllerInformasi;
import paul.develops.ta.Models.BuahKuis;
import paul.develops.ta.Models.KeluargaKuis;
import paul.develops.ta.Models.KeluargaSuara;
import paul.develops.ta.Models.Question;
import paul.develops.ta.Models.QuestionKuisSuara;

/**
 * Created by paulms on 12/6/2016.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "aplikasita.db";

    //quest untuk gambar 1
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "qid";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; // correct option
    private static final String KEY_OPTA = "opta"; // option a
    private static final String KEY_OPTB = "optb"; // option b
    private static final String KEY_OPTC = "optc"; // option c

    //quest untuk suara hewan
    private static final String TABLE_SUARA_HEWAN = "kuis1suara";
    // tasks Table Columns names
    private static final String KEY_ID_SUARA_HEWAN = "qid1suara";
    private static final String KEY_QUES_SUARA_HEWAN = "question1suara";
    private static final String KEY_ANSWER_SUARA_HEWAN = "answer1suara"; // correct option
    private static final String KEY_OPTA_SUARA_HEWAN = "opta1suara"; // option a
    private static final String KEY_OPTB_SUARA_HEWAN = "optb1suara"; // option b
    private static final String KEY_OPTC_SUARA_HEWAN = "optc1suara"; // option c

    //quest untuk kuis keluarga
    private static final String TABLE_KUIS_KELUARGA = "kuiskeluarga";
    // tasks Table Columns names
    private static final String KEY_ID_KUIS_KELUARGA = "kidkeluarga";
    private static final String KEY_KUIS_KELUARGA = "questionkeluarga";
    private static final String KEY_ANSWER_KELUARGA = "answerkeluarga"; // correct option
    private static final String KEY_OPTA_KELUARGA = "opta1keluarga"; // option a
    private static final String KEY_OPTB_KELUARGA = "optb1keluarga"; // option b
    private static final String KEY_OPTC_KELUARGA = "optc1keluarga"; // option c


    //quest untuk suara keluarga
    private static final String TABLE_SUARA_KELUARGA = "suarakeluarga";
    // tasks Table Columns names
    private static final String KEY_ID_SUARA_KELUARGA = "kidsuarakeluarga";
    private static final String KEY_SUARA_KELUARGA = "questionsuarakeluarga";
    private static final String KEY_ANSWER_SUARA_KELUARGA = "answersuarakeluarga"; // correct option
    private static final String KEY_OPTA_SUARA_KELUARGA = "opta1suarakeluarga"; // option a
    private static final String KEY_OPTB_SUARA_KELUARGA = "optb1suarakeluarga"; // option b
    private static final String KEY_OPTC_SUARA_KELUARGA = "optc1suarakeluarga"; // option c

    //buah kuis
    private static final String TABLE_KUIS_BUAH = "kuisbuah";
    // tasks Table Columns names
    private static final String KEY_ID_KUIS_BUAH = "kidkuisbuah";
    private static final String KEY_KUIS_BUAH = "questionkuisbuah";
    private static final String KEY_ANSWER_KUIS_BUAH = "answerkuisbuah"; // correct option
    private static final String KEY_OPTA_KUIS_BUAH = "opta1kuisbuah"; // option a
    private static final String KEY_OPTB_KUIS_BUAH = "optb1kuisbuah"; // option b
    private static final String KEY_OPTC_KUIS_BUAH = "optc1kuisbuah"; // option c

    private SQLiteDatabase dbase;

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(ControllerInformasi.CREATE_INFORMASI);
        db.execSQL(ControllerDeskripsi.CREATE_DESKRIPSI);
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";

        String sql1hewan = "CREATE TABLE IF NOT EXISTS " + TABLE_SUARA_HEWAN + " ( "
                + KEY_ID_SUARA_HEWAN + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES_SUARA_HEWAN
                + " TEXT, " + KEY_ANSWER_SUARA_HEWAN + " TEXT, " + KEY_OPTA_SUARA_HEWAN + " TEXT, "
                + KEY_OPTB_SUARA_HEWAN + " TEXT, " + KEY_OPTC_SUARA_HEWAN + " TEXT)";

        String sqlkeluarga = "CREATE TABLE IF NOT EXISTS " + TABLE_KUIS_KELUARGA + " ( "
                + KEY_ID_KUIS_KELUARGA + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_KUIS_KELUARGA
                + " TEXT, " + KEY_ANSWER_KELUARGA + " TEXT, " + KEY_OPTA_KELUARGA + " TEXT, "
                + KEY_OPTB_KELUARGA + " TEXT, " + KEY_OPTC_KELUARGA + " TEXT)";

        String sqlsuarakeluarga = "CREATE TABLE IF NOT EXISTS " + TABLE_SUARA_KELUARGA + " ( "
                + KEY_ID_SUARA_KELUARGA + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_SUARA_KELUARGA
                + " TEXT, " + KEY_ANSWER_SUARA_KELUARGA + " TEXT, " + KEY_OPTA_SUARA_KELUARGA + " TEXT, "
                + KEY_OPTB_SUARA_KELUARGA + " TEXT, " + KEY_OPTC_SUARA_KELUARGA + " TEXT)";

        String sqlkuisbuah = "CREATE TABLE IF NOT EXISTS " + TABLE_KUIS_BUAH + " ( "
                + KEY_ID_KUIS_BUAH + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_KUIS_BUAH
                + " TEXT, " + KEY_ANSWER_KUIS_BUAH + " TEXT, " + KEY_OPTA_KUIS_BUAH + " TEXT, "
                + KEY_OPTB_KUIS_BUAH + " TEXT, " + KEY_OPTC_KUIS_BUAH + " TEXT)";

        db.execSQL(sql);
        addQuestion();

        db.execSQL(sql1hewan);
        addQuestionSuaraHewan();

        db.execSQL(sqlkeluarga);
        addKuisKeluarga();

        db.execSQL(sqlsuarakeluarga);
        addSuaraKeluarga();

        db.execSQL(sqlkuisbuah);
        addBuahKuis();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUARA_HEWAN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KUIS_KELUARGA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUARA_KELUARGA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KUIS_BUAH);
    }


    private void addQuestion() {
        Question q1 = new Question("dog3.png", "dog", "cat", "snake", "dog");
        this.addQuestion(q1);
        Question q2 = new Question("cat2.png", "biang", "huting", "ulok", "huting");
        this.addQuestion(q2);
        Question q3 = new Question("snake3.png", "unta", "ular", "anjing", "ular");
        this.addQuestion(q3);
        Question q4 = new Question("camel4.png", "camel", "lion", "tiger", "camel");
        this.addQuestion(q4);
        Question q5 = new Question("ikan2.png", "snake", "cat", "fish", "fish");
        this.addQuestion(q5);
        Question q6 = new Question("dog3.png", "anjing", "kucing", "burung", "anjing");
        this.addQuestion(q6);
        Question q7 = new Question("snake3.png", "ulok", "babiat", "huting", "ulok");
        this.addQuestion(q7);
//        Question q8 = new Question("3+6 = ?", "8", "7", "9", "9");
//        this.addQuestion(q8);
//        Question q9 = new Question("1+5 = ?", "6", "7", "5", "6");
//        this.addQuestion(q9);
//        Question q10 = new Question("7-5 = ?", "3", "2", "6", "2");
//        this.addQuestion(q10);
//        Question q11 = new Question("7-2 = ?", "7", "6", "5", "5");
//        this.addQuestion(q11);
//        Question q12 = new Question("3+5 = ?", "8", "7", "5", "8");
//        this.addQuestion(q12);
//        Question q13 = new Question("0+6 = ?", "7", "6", "5", "6");
//        this.addQuestion(q13);
//        Question q14 = new Question("12-10 = ?", "1", "2", "3", "2");
//        this.addQuestion(q14);
//        Question q15 = new Question("12+2 = ?", "14", "15", "16", "14");
//        this.addQuestion(q15);
//        Question q16 = new Question("2-1 = ?", "2", "1", "0", "1");
//        this.addQuestion(q16);
//        Question q17 = new Question("6-6 = ?", "6", "12", "0", "0");
//        this.addQuestion(q17);
//        Question q18 = new Question("5-1 = ?", "4", "3", "2", "4");
//        this.addQuestion(q18);
//        Question q19 = new Question("4+2 = ?", "6", "7", "5", "6");
//        this.addQuestion(q19);
//        Question q20 = new Question("5+1 = ?", "6", "7", "5", "6");
//        this.addQuestion(q20);
//        Question q21 = new Question("5-4 = ?", "5", "4", "1", "1");
//        this.addQuestion(q21);
        // END
    }

    //masukan untuk kuis suara
    private void addQuestionSuaraHewan() {
        QuestionKuisSuara q1 = new QuestionKuisSuara("dog1", "dog", "cat", "snake", "dog");
        this.addQuestionSuaraHewan(q1);
        QuestionKuisSuara q2 = new QuestionKuisSuara("cat1", "dog", "cat", "snake", "cat");
        this.addQuestionSuaraHewan(q2);
        QuestionKuisSuara q3 = new QuestionKuisSuara("snake1", "horse", "snake", "camel", "snake");
        this.addQuestionSuaraHewan(q3);
        QuestionKuisSuara q4 = new QuestionKuisSuara("bigbubbles", "fish", "lion", "tiger", "fish");
        this.addQuestionSuaraHewan(q4);
        QuestionKuisSuara q5 = new QuestionKuisSuara("cat1", "biang", "ulok", "huting", "huting");
        this.addQuestionSuaraHewan(q5);
        QuestionKuisSuara q6 = new QuestionKuisSuara("dog1", "anjing", "kucing", "burung", "anjing");
        this.addQuestionSuaraHewan(q6);
//        Question q7 = new Question("9-9 = ?", "0", "9", "1", "0");
//        this.addQuestion(q7);
//        Question q8 = new Question("3+6 = ?", "8", "7", "9", "9");
//        this.addQuestion(q8);
//        Question q9 = new Question("1+5 = ?", "6", "7", "5", "6");
//        this.addQuestion(q9);
//        Question q10 = new Question("7-5 = ?", "3", "2", "6", "2");
//        this.addQuestion(q10);
//        Question q11 = new Question("7-2 = ?", "7", "6", "5", "5");
//        this.addQuestion(q11);
//        Question q12 = new Question("3+5 = ?", "8", "7", "5", "8");
//        this.addQuestion(q12);
//        Question q13 = new Question("0+6 = ?", "7", "6", "5", "6");
//        this.addQuestion(q13);
//        Question q14 = new Question("12-10 = ?", "1", "2", "3", "2");
//        this.addQuestion(q14);
//        Question q15 = new Question("12+2 = ?", "14", "15", "16", "14");
//        this.addQuestion(q15);
//        Question q16 = new Question("2-1 = ?", "2", "1", "0", "1");
//        this.addQuestion(q16);
//        Question q17 = new Question("6-6 = ?", "6", "12", "0", "0");
//        this.addQuestion(q17);
//        Question q18 = new Question("5-1 = ?", "4", "3", "2", "4");
//        this.addQuestion(q18);
//        Question q19 = new Question("4+2 = ?", "6", "7", "5", "6");
//        this.addQuestion(q19);
//        Question q20 = new Question("5+1 = ?", "6", "7", "5", "6");
//        this.addQuestion(q20);
//        Question q21 = new Question("5-4 = ?", "5", "4", "1", "1");
//        this.addQuestion(q21);
        // END
    }

    private void addKuisKeluarga() {
        KeluargaKuis q1 = new KeluargaKuis("bapak2.png", "ayah", "ibu", "adik perempuan", "ayah");
        this.addKuisKeluarga(q1);
        KeluargaKuis q2 = new KeluargaKuis("brother2.png", "sister", "brother", "father", "brother");
        this.addKuisKeluarga(q2);
        KeluargaKuis q3 = new KeluargaKuis("nenek2.png", "kakek", "nenek", "adik", "nenek");
        this.addKuisKeluarga(q3);
        KeluargaKuis q4 = new KeluargaKuis("mommy2.png", "mother", "father", "brother", "mother");
        this.addKuisKeluarga(q4);
        KeluargaKuis q5 = new KeluargaKuis("kakek2.png", "ompung boru", "amang", "ompung doli", "ompung doli");
        this.addKuisKeluarga(q5);
//        KeluargaKuis q6 = new KeluargaKuis("dog3.png", "anjing", "kucing", "burung", "anjing");
//        this.addKuisKeluarga(q6);
//        KeluargaKuis q7 = new KeluargaKuis("snake3.png", "ulok", "babiat", "huting", "ulok");
//        this.addKuisKeluarga(q7);
//        Question q8 = new Question("3+6 = ?", "8", "7", "9", "9");
//        this.addQuestion(q8);
//        Question q9 = new Question("1+5 = ?", "6", "7", "5", "6");
//        this.addQuestion(q9);
//        Question q10 = new Question("7-5 = ?", "3", "2", "6", "2");
//        this.addQuestion(q10);
//        Question q11 = new Question("7-2 = ?", "7", "6", "5", "5");
//        this.addQuestion(q11);
//        Question q12 = new Question("3+5 = ?", "8", "7", "5", "8");
//        this.addQuestion(q12);
//        Question q13 = new Question("0+6 = ?", "7", "6", "5", "6");
//        this.addQuestion(q13);
//        Question q14 = new Question("12-10 = ?", "1", "2", "3", "2");
//        this.addQuestion(q14);
//        Question q15 = new Question("12+2 = ?", "14", "15", "16", "14");
//        this.addQuestion(q15);
//        Question q16 = new Question("2-1 = ?", "2", "1", "0", "1");
//        this.addQuestion(q16);
//        Question q17 = new Question("6-6 = ?", "6", "12", "0", "0");
//        this.addQuestion(q17);
//        Question q18 = new Question("5-1 = ?", "4", "3", "2", "4");
//        this.addQuestion(q18);
//        Question q19 = new Question("4+2 = ?", "6", "7", "5", "6");
//        this.addQuestion(q19);
//        Question q20 = new Question("5+1 = ?", "6", "7", "5", "6");
//        this.addQuestion(q20);
//        Question q21 = new Question("5-4 = ?", "5", "4", "1", "1");
//        this.addQuestion(q21);
        // END
    }

    //masukan untuk kuis suara
    private void addSuaraKeluarga() {
        KeluargaSuara q1 = new KeluargaSuara("ama", "ama", "inang", "ompungdoli", "ama");
        this.addSuaraKeluarga(q1);
        KeluargaSuara q2 = new KeluargaSuara("grandfather", "grand mother", "grand father", "father", "grand father");
        this.addSuaraKeluarga(q2);
        KeluargaSuara q3 = new KeluargaSuara("mother", "ayah", "ibu", "nenek", "ibu");
        this.addSuaraKeluarga(q3);
        KeluargaSuara q4 = new KeluargaSuara("grandmother", "nenek", "kakek", "ayah", "nenek");
        this.addSuaraKeluarga(q4);
//        KeluargaSuara q5 = new KeluargaSuara("cat1", "biang", "ulok", "huting", "huting");
//        this.addSuaraKeluarga(q5);
//        KeluargaSuara q6 = new KeluargaSuara("dog1", "anjing", "kucing", "burung", "anjing");
//        this.addSuaraKeluarga(q6);
//        Question q7 = new Question("9-9 = ?", "0", "9", "1", "0");
//        this.addQuestion(q7);
//        Question q8 = new Question("3+6 = ?", "8", "7", "9", "9");
//        this.addQuestion(q8);
//        Question q9 = new Question("1+5 = ?", "6", "7", "5", "6");
//        this.addQuestion(q9);
//        Question q10 = new Question("7-5 = ?", "3", "2", "6", "2");
//        this.addQuestion(q10);
//        Question q11 = new Question("7-2 = ?", "7", "6", "5", "5");
//        this.addQuestion(q11);
//        Question q12 = new Question("3+5 = ?", "8", "7", "5", "8");
//        this.addQuestion(q12);
//        Question q13 = new Question("0+6 = ?", "7", "6", "5", "6");
//        this.addQuestion(q13);
//        Question q14 = new Question("12-10 = ?", "1", "2", "3", "2");
//        this.addQuestion(q14);
//        Question q15 = new Question("12+2 = ?", "14", "15", "16", "14");
//        this.addQuestion(q15);
//        Question q16 = new Question("2-1 = ?", "2", "1", "0", "1");
//        this.addQuestion(q16);
//        Question q17 = new Question("6-6 = ?", "6", "12", "0", "0");
//        this.addQuestion(q17);
//        Question q18 = new Question("5-1 = ?", "4", "3", "2", "4");
//        this.addQuestion(q18);
//        Question q19 = new Question("4+2 = ?", "6", "7", "5", "6");
//        this.addQuestion(q19);
//        Question q20 = new Question("5+1 = ?", "6", "7", "5", "6");
//        this.addQuestion(q20);
//        Question q21 = new Question("5-4 = ?", "5", "4", "1", "1");
//        this.addQuestion(q21);
        // END
    }

    //masukan untuk kuis suara
    private void addBuahKuis() {
        BuahKuis q1 = new BuahKuis("apel.png", "apel", "durian", "nenas", "apel");
        this.addKuisBuah(q1);
        BuahKuis q2 = new BuahKuis("jeruk.png", "manggis", "jeruk", "apel", "jeruk");
        this.addKuisBuah(q2);
        BuahKuis q3 = new BuahKuis("pisang.png", "jambu", "pisang", "pete", "pisang");
        this.addKuisBuah(q3);
        BuahKuis q4 = new BuahKuis("semangka.png", "semangka", "melon", "nangka", "semangka");
        this.addKuisBuah(q4);
//        KeluargaSuara q5 = new KeluargaSuara("cat1", "biang", "ulok", "huting", "huting");
//        this.addSuaraKeluarga(q5);
//        KeluargaSuara q6 = new KeluargaSuara("dog1", "anjing", "kucing", "burung", "anjing");
//        this.addSuaraKeluarga(q6);
//        Question q7 = new Question("9-9 = ?", "0", "9", "1", "0");
//        this.addQuestion(q7);
//        Question q8 = new Question("3+6 = ?", "8", "7", "9", "9");
//        this.addQuestion(q8);
//        Question q9 = new Question("1+5 = ?", "6", "7", "5", "6");
//        this.addQuestion(q9);
//        Question q10 = new Question("7-5 = ?", "3", "2", "6", "2");
//        this.addQuestion(q10);
//        Question q11 = new Question("7-2 = ?", "7", "6", "5", "5");
//        this.addQuestion(q11);
//        Question q12 = new Question("3+5 = ?", "8", "7", "5", "8");
//        this.addQuestion(q12);
//        Question q13 = new Question("0+6 = ?", "7", "6", "5", "6");
//        this.addQuestion(q13);
//        Question q14 = new Question("12-10 = ?", "1", "2", "3", "2");
//        this.addQuestion(q14);
//        Question q15 = new Question("12+2 = ?", "14", "15", "16", "14");
//        this.addQuestion(q15);
//        Question q16 = new Question("2-1 = ?", "2", "1", "0", "1");
//        this.addQuestion(q16);
//        Question q17 = new Question("6-6 = ?", "6", "12", "0", "0");
//        this.addQuestion(q17);
//        Question q18 = new Question("5-1 = ?", "4", "3", "2", "4");
//        this.addQuestion(q18);
//        Question q19 = new Question("4+2 = ?", "6", "7", "5", "6");
//        this.addQuestion(q19);
//        Question q20 = new Question("5+1 = ?", "6", "7", "5", "6");
//        this.addQuestion(q20);
//        Question q21 = new Question("5-4 = ?", "5", "4", "1", "1");
//        this.addQuestion(q21);
        // END
    }

    // Adding new question one kuis keluarga
    public void addKuisKeluarga(KeluargaKuis quest) {
        // SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_KUIS_KELUARGA, quest.getQUESTION());
        values.put(KEY_ANSWER_KELUARGA, quest.getANSWER());
        values.put(KEY_OPTA_KELUARGA, quest.getOPTA());
        values.put(KEY_OPTB_KELUARGA, quest.getOPTB());
        values.put(KEY_OPTC_KELUARGA, quest.getOPTC());

        // Inserting Row
        dbase.insert(TABLE_KUIS_KELUARGA, null, values);
        Log.e("masuk", quest.getANSWER());
    }

    // Adding new question one suara keluarga
    public void addSuaraKeluarga(KeluargaSuara quest) {
        // SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_SUARA_KELUARGA, quest.getQUESTION());
        values.put(KEY_ANSWER_SUARA_KELUARGA, quest.getANSWER());
        values.put(KEY_OPTA_SUARA_KELUARGA, quest.getOPTA());
        values.put(KEY_OPTB_SUARA_KELUARGA, quest.getOPTB());
        values.put(KEY_OPTC_SUARA_KELUARGA, quest.getOPTC());

        // Inserting Row
        dbase.insert(TABLE_SUARA_KELUARGA, null, values);
        Log.e("masuk", quest.getQUESTION());
    }

    // Adding new question one kuis suara 1
    public void addQuestionSuaraHewan(QuestionKuisSuara quest) {
        // SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES_SUARA_HEWAN, quest.getQUESTION());
        values.put(KEY_ANSWER_SUARA_HEWAN, quest.getANSWER());
        values.put(KEY_OPTA_SUARA_HEWAN, quest.getOPTA());
        values.put(KEY_OPTB_SUARA_HEWAN, quest.getOPTB());
        values.put(KEY_OPTC_SUARA_HEWAN, quest.getOPTC());

        // Inserting Row
        dbase.insert(TABLE_SUARA_HEWAN, null, values);
        Log.e("masuk", quest.getANSWER());
    }

    // Adding new question one kuis gambar 1
    public void addQuestion(Question quest) {
        // SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());

        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
        Log.e("masuk", quest.getANSWER());
    }

    // Adding new question one kuis gambar 1
    public void addKuisBuah(BuahKuis quest) {
        // SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_KUIS_BUAH, quest.getQUESTION());
        values.put(KEY_ANSWER_KUIS_BUAH, quest.getANSWER());
        values.put(KEY_OPTA_KUIS_BUAH, quest.getOPTA());
        values.put(KEY_OPTB_KUIS_BUAH, quest.getOPTB());
        values.put(KEY_OPTC_KUIS_BUAH, quest.getOPTC());

        // Inserting Row
        dbase.insert(TABLE_KUIS_BUAH, null, values);
        Log.e("masuk", quest.getANSWER());
    }


    //kuis gambar hewan 1
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    //kuis keluarga
    public List<KeluargaKuis> getAllKuisKeluarga() {
        List<KeluargaKuis> quesList = new ArrayList<KeluargaKuis>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_KUIS_KELUARGA;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                KeluargaKuis quest = new KeluargaKuis();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }


    //kuis suara keluarga
    public List<KeluargaSuara> getAllSuaraKeluarga() {
        List<KeluargaSuara> quesList = new ArrayList<KeluargaSuara>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_SUARA_KELUARGA;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                KeluargaSuara quest = new KeluargaSuara();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    //kuis suara hewan 1
    public List<QuestionKuisSuara> getAllQuestionsSuara() {
        List<QuestionKuisSuara> quesList = new ArrayList<QuestionKuisSuara>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_SUARA_HEWAN;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuestionKuisSuara quest = new QuestionKuisSuara();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    //kuis suara hewan 1
    public List<BuahKuis> getAllKuisBuah() {
        List<BuahKuis> quesList = new ArrayList<BuahKuis>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_KUIS_BUAH;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                BuahKuis quest = new BuahKuis();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

}

