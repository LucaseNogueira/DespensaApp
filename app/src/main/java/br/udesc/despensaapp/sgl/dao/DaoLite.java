package br.udesc.despensaapp.sgl.dao;

import android.database.sqlite.SQLiteDatabase;

public abstract class DaoLite {

    protected SQLiteDatabase db;

    public DaoLite() {
        this.db = SQLiteDatabase.openOrCreateDatabase("despensa_app", null);
        this.createTable();
    }

    protected abstract void createTable();
}
