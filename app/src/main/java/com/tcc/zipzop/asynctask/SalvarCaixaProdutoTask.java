package com.tcc.zipzop.asynctask;

import android.os.AsyncTask;

import com.tcc.zipzop.database.dao.CaixaProdutoDAO;
import com.tcc.zipzop.entity.CaixaProduto;

public class SalvarCaixaProdutoTask extends AsyncTask<Void, Void, Void> {
    private CaixaProdutoDAO dao;
    private CaixaProduto caixaProduto;

    public SalvarCaixaProdutoTask(CaixaProdutoDAO dao, CaixaProduto caixaProduto){
        this.dao = dao;
        this.caixaProduto = caixaProduto;
    }
    @Override
    protected Void doInBackground(Void... voids) {
        dao.salvar(caixaProduto);
        return null;
    }
}
