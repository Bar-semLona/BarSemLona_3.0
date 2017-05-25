package com.enterprise.barsemlona.barsemlona_20;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private ViewGroup mensagens;
    String msg,prc,desc,cat,desconto,id;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View homeFragment = (View) inflater.inflate(R.layout.fragment_home, container, false);
        mensagens = (ViewGroup) homeFragment.findViewById(R.id.container);

        Bundle bundle = this.getArguments();
        ArrayList<String> idProd = bundle.getStringArrayList("idProduto");
        ArrayList<String> nome = bundle.getStringArrayList("nomeProduto");
        ArrayList<String> preco = bundle.getStringArrayList("precoProduto");
        ArrayList<String> desciption = bundle.getStringArrayList("descProduto");
        ArrayList<String> categoria = bundle.getStringArrayList("categoriaProduto");
        ArrayList<String> descontoP = bundle.getStringArrayList("descontoProduto");
        for (int i = 0; i < preco.size(); i++) {
            msg = nome.get(i);
            prc = preco.get(i);
            desc = desciption.get(i);
            cat = categoria.get(i);
            desconto = descontoP.get(i);
            id = idProd.get(i);
            addItem(msg, desc,prc,cat,desconto,id);
        }
        return  homeFragment;
    }
    private void addItem(final String nomeProduto,final String desc ,final String precoProduto,final String categoria,final String desconto,final String id) {
        CardView cardView = (CardView) LayoutInflater.from(getContext()).inflate(R.layout.card_file_product, mensagens, false);
        TextView titulo = (TextView) cardView.findViewById(R.id.titulo);
        TextView mensagem = (TextView) cardView.findViewById(R.id.mensagem);
        titulo.setText(nomeProduto);
        mensagem.setText(precoProduto);
        mensagens.addView(cardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentDetalhe = new DetalheFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame, fragmentDetalhe);
                Bundle bundle = new Bundle();
                bundle.putString("idProduto", id);
                bundle.putString("nomeProduto", nomeProduto);
                bundle.putString("precoProduto",precoProduto );
                bundle.putString("descProduto", desc);
                bundle.putString("categoriaProduto", categoria);
                bundle.putString("descontoProduto",desconto);
                fragmentDetalhe.setArguments(bundle);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        }) ;
    }
}