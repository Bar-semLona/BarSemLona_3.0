package com.enterprise.barsemlona.barsemlona_20;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CarrinhoSingleton {

    ArrayList<String> nome = new ArrayList<String> ();
    ArrayList<String> preco = new ArrayList<String> ();
    ArrayList<String> desc = new ArrayList<String> ();
    ArrayList<String> cat = new ArrayList<String> ();
    BigDecimal total=new BigDecimal(0);
    int i=0;
    private final static CarrinhoSingleton ourInstance = new CarrinhoSingleton();
    String  nomeProduto;
    private CarrinhoSingleton() {
    }
    public static CarrinhoSingleton getInstance() {
        return ourInstance;
    }
    public void setNome( String nome) { this.nome.add(nome); }
    public  ArrayList<String> getNome() {
        return nome;
    }
    public void setPreco( String preco) { this.preco.add(preco); }
    public  ArrayList<String> getPreco() {
        return preco;
    }
    public void setDescricao( String desc) { this.desc.add(desc); }
    public  ArrayList<String> getDescricao() {
        return desc;
    }
    public void setCat( String cat) { this.cat.add(cat); }
    public  ArrayList<String> getCat() {
        return cat;
    }
    public String getTotal(){
        return Total();
    }
    private String Total(){
        while (i<getPreco().size()){
            total=total.add(new BigDecimal(preco.get(i)));
            i++;
        }
        String s = total.toString();
        return s;
    }
}