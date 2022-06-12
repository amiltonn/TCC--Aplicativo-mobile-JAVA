package com.tcc.zipzop.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;

import com.tcc.zipzop.R;
import com.tcc.zipzop.adapter.ProdutoAdapterActivity;
import com.tcc.zipzop.asynctask.ConsultarProdutoTask;
import com.tcc.zipzop.asynctask.EditarProdutoTask;
import com.tcc.zipzop.asynctask.SalvarProdutoTask;
import com.tcc.zipzop.database.ZipZopDataBase;
import com.tcc.zipzop.database.dao.ProdutoDAO;
import com.tcc.zipzop.entity.Produto;

import java.util.concurrent.ExecutionException;


public class SalvarProdutoActivity extends AppCompatActivity {

    private AppCompatButton btSalvar;
    private ProdutoAdapterActivity adapter;
    private ProdutoDAO dao;
    private Produto produto;
    private EditText    campoNome,
                        campoCustoProducao,
                        campoPrecoVenda,
                        campoQuantidade;
    Intent intent;
    Integer id = 0;
    ProdutoAdapterActivity produtoAdapterActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Actionbar);
        setContentView(R.layout.activity_salvar_produto);
        ZipZopDataBase dataBase = ZipZopDataBase.getInstance(this);
        dao = dataBase.getProdutoDAO();

        inicializaCampos();
        preencheCampos();

        btSalvar = findViewById(R.id.Bt_Cadastrar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalizaFormulario();
            }
        });
    }

    private void inicializaCampos() {
        campoNome = findViewById(R.id.Nome);
        campoCustoProducao = findViewById(R.id.CustoProducao);
        campoPrecoVenda = findViewById(R.id.PrecoVenda);
        campoQuantidade = findViewById(R.id.Quantidade);

    }

    private void preencheCampos() {
        this.intent = getIntent();
        id = intent.getIntExtra("id", 0);
        try {
            produto = new ConsultarProdutoTask(dao, id).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //produto = dao.consultar(id);
        //novo produto
        if(id.equals(0)) {
            produto = new Produto();
        }
        //edita o produto
        else{
            campoNome.setText(produto.getNome());
            campoCustoProducao.setText("" + produto.getCusto());
            campoPrecoVenda.setText("" + produto.getPreco());
            campoQuantidade.setText("" + produto.getQtd());
        }
    }

    private void preencheProduto() {
        String nome = campoNome.getText().toString();
        String auxCustoProducao = campoCustoProducao.getText().toString();
        Float custoProducao = converteFloat(auxCustoProducao);
        String auxPrecoVenda = campoPrecoVenda.getText().toString();
        Float precoVenda = converteFloat(auxPrecoVenda);
        String auxQuantidade = campoQuantidade.getText().toString();
        Integer quantidade = Integer.parseInt(auxQuantidade);

        produto.setNome(nome);
        produto.setCusto(custoProducao);
        produto.setPreco(precoVenda);
        produto.setQtd(quantidade);
    }

    private void finalizaFormulario() {
        preencheProduto();
        //novo produto
        if(id.equals(0)){
            new SalvarProdutoTask(dao, this, produto).execute();
        }
        //edita o produto
        else{
            new EditarProdutoTask(dao, this, produto).execute();
        }

    }
    public Float converteFloat(String valor){
        String retorno = new String();
        int tamanhoString = valor.length();
        for(int i = 0; i < tamanhoString; i++){
            if (valor.charAt(i) == ',') {
                retorno += '.';
            }else {
                retorno += valor.charAt(i);
            }
        }
        return Float.parseFloat(retorno);
    }

    public void salvarComSucesso(){
        finish();

    }

}