package com.tcc.zipzop.asynctask.caixa.caixaFundo;

import android.os.AsyncTask;

import com.tcc.zipzop.database.dao.CaixaFundoDAO;
import com.tcc.zipzop.entity.CaixaFundo;

public class ConsultarCaixaFundoPeloCaixaIdTask extends AsyncTask<Void, Void, CaixaFundo> {
    CaixaFundoDAO dao;
    Integer caixaId;

    public ConsultarCaixaFundoPeloCaixaIdTask(CaixaFundoDAO dao, Integer caixaId) {
        this.dao = dao;
        this.caixaId = caixaId;
    }

    @Override
    protected CaixaFundo doInBackground(Void... voids) {
        return dao.consultarPeloCaixaIdAndDataAlteracaoMax(this.caixaId);
    }
}
