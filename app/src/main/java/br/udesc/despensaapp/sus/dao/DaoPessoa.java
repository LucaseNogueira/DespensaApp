package br.udesc.despensaapp.sus.dao;

import android.database.sqlite.SQLiteDatabase;

import br.udesc.despensaapp.sgl.dao.DaoLite;

public class DaoPessoa extends DaoLite {

    @Override
    protected void createTable() {
        this.db.execSQL(
                "CREATE TABLE IF NOT EXISTS tbpessoa(" +
                "pescodigo INTEGER PRIMARY KEY AUTOINCREMENT," +
                "pesnome VARCHAR)"
        );
    }
}
