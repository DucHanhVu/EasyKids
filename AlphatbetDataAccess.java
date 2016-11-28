package com.example.quynhon.easykids.DataAccess;

import android.content.Context;
import android.database.Cursor;

import com.example.quynhon.easykids.DatabaseHandler.DatabseHandler;
import com.example.quynhon.easykids.Entities.Alphabet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XuanHaoIT on 18/11/2016.
 */

public class AlphatbetDataAccess {
    List<Alphabet> listAlphabet;
    Context context;
    DatabseHandler databseHandler;

    public AlphatbetDataAccess(Context context) {
        this.context = context;
    }
    public List<Alphabet> getListAlphabet()
    {
        databseHandler = new DatabseHandler(context);
        Alphabet alphabet;
        listAlphabet = new ArrayList<>();
        Cursor cursor = databseHandler.getCursor("SELECT * FROM tbl_alphabet");

        if (cursor.moveToFirst()) {
            do
            {
                alphabet = new Alphabet(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
                listAlphabet.add(alphabet);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return listAlphabet;
    }
}
