package com.enterprise.barsemlona.barsemlona_20;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class DetalheFragment extends Fragment {

    TextView nome,preco,descricao,cat,desconto,id;
    Button carrinho;

    public DetalheFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View Detalhe = (View) inflater.inflate(R.layout.fragment_detalhe, container, false);


        nome = (TextView) Detalhe.findViewById(R.id.nm_detalhe);
        preco = (TextView) Detalhe.findViewById(R.id.price_detalhe);
        descricao = (TextView) Detalhe.findViewById(R.id.txt_detalhe);
        desconto = (TextView) Detalhe.findViewById(R.id.price_por_detalhe);
        cat = (TextView) Detalhe.findViewById(R.id.category_detalhe);

        CategoriaSingleton categoriaSingleton = CategoriaSingleton.getInstance();

        Bundle bundle = this.getArguments();
        final String idC = bundle.getString("categoriaProduto");

        for (int i = 0; i < categoriaSingleton.getId().size(); i++) {
            if(idC.equals(categoriaSingleton.getId().get(i))) {
                cat.setText("Categoria: " + categoriaSingleton.getNome().get(i));
                break;
            }
        }
        nome.setText(bundle.getString("nomeProduto"));
        preco.setText(bundle.getString("precoProduto"));
        descricao.setText(bundle.getString("descProduto"));

        desconto.setText(bundle.getString("descontoProduto"));

        carrinho = (Button) Detalhe.findViewById(R.id.btn_comprar);
        carrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarrinhoSingleton carrinho = CarrinhoSingleton.getInstance();
                carrinho.setNome(nome.getText().toString());
                carrinho.setPreco(preco.getText().toString());
                carrinho.setDescricao(descricao.getText().toString());
                carrinho.setCat(idC);/*
                carrinho.setDesconto(desconto.getText().toString());
                carrinho.setId(bundle.getString("descontoProduto"));
        */
            }
        });

        return Detalhe;
    }

}
