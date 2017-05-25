package com.enterprise.barsemlona.barsemlona_20;

import java.util.ArrayList;


public class CategoriaSingleton {
    ArrayList<String> nome = new ArrayList<String> ();
    ArrayList<String> id = new ArrayList<String> ();
    ArrayList<String> desc = new ArrayList<String> ();


    private final static CategoriaSingleton ourInstance = new CategoriaSingleton();
    String  nomeProduto;
    private CategoriaSingleton() {
    }
    public static CategoriaSingleton getInstance() {
        return ourInstance;
    }
    public void setNome( String nome) { this.nome.add(nome); }
    public  ArrayList<String> getNome() {
        return nome;
    }
    public void setId( String id) { this.id.add(id); }
    public  ArrayList<String> getId() {
        return id;
    }
    public void setDescricao( String desc) { this.desc.add(desc); }
    public  ArrayList<String> getDescricao() {
        return desc;
    }


}
