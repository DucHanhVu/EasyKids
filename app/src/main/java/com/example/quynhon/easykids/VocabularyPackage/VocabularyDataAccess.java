package com.example.quynhon.easykids.VocabularyPackage;

import android.content.Context;
import android.database.Cursor;

import com.example.quynhon.easykids.DatabaseHandler.DatabseHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XuanHaoIT on 02/12/2016.
 */

public class VocabularyDataAccess {
    List<Vocabulary> listVocabulary;
    Context context;
    DatabseHandler databseHandler;
    public VocabularyDataAccess(Context context)
    {
        this.context = context;
    }
    public List<Vocabulary> getListHoaQua()
    {
        databseHandler = new DatabseHandler(context);
        Vocabulary vocabulary;
        listVocabulary = new ArrayList<>();
        Cursor cursor = databseHandler.getCursor("SELECT * FROM tbl_word WHERE TopicID = 'HoaQua'");

        if (cursor.moveToFirst()) {
            do
            {
                vocabulary = new Vocabulary(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
                listVocabulary.add(vocabulary);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return listVocabulary;
    }
    public List<Vocabulary> getListHinhHoc()
    {
        databseHandler = new DatabseHandler(context);
        Vocabulary vocabulary;
        listVocabulary = new ArrayList<>();
        Cursor cursor = databseHandler.getCursor("SELECT * FROM tbl_word WHERE TopicID = 'HinhHoc'");

        if (cursor.moveToFirst()) {
            do
            {
                vocabulary = new Vocabulary(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
                listVocabulary.add(vocabulary);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return listVocabulary;
    }
    public List<Vocabulary> getListMauSac()
    {
        databseHandler = new DatabseHandler(context);
        Vocabulary vocabulary;
        listVocabulary = new ArrayList<>();
        Cursor cursor = databseHandler.getCursor("SELECT * FROM tbl_word WHERE TopicID = 'MauSac'");

        if (cursor.moveToFirst()) {
            do
            {
                vocabulary = new Vocabulary(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
                listVocabulary.add(vocabulary);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return listVocabulary;
    }
    public List<Vocabulary> getListThucAn()
    {
        databseHandler = new DatabseHandler(context);
        Vocabulary vocabulary;
        listVocabulary = new ArrayList<>();
        Cursor cursor = databseHandler.getCursor("SELECT * FROM tbl_word WHERE TopicID = 'DoAn'");

        if (cursor.moveToFirst()) {
            do
            {
                vocabulary = new Vocabulary(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
                listVocabulary.add(vocabulary);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return listVocabulary;
    }
    public List<Vocabulary> getListThoiTiet()
    {
        databseHandler = new DatabseHandler(context);
        Vocabulary vocabulary;
        listVocabulary = new ArrayList<>();
        Cursor cursor = databseHandler.getCursor("SELECT * FROM tbl_word WHERE TopicID = 'ThoiTiet'");

        if (cursor.moveToFirst()) {
            do
            {
                vocabulary = new Vocabulary(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
                listVocabulary.add(vocabulary);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return listVocabulary;
    }
}
