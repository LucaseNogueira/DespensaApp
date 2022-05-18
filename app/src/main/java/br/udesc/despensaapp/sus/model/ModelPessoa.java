package br.udesc.despensaapp.sus.model;

import br.udesc.despensaapp.sgl.model.Arquivo;

public class ModelPessoa {

    private int          codigo;
    private String       nome;
    private Arquivo ModelArquivo;

    public ModelPessoa(){}

    public ModelPessoa(int codigo, String nome, Arquivo modelArquivo) {
        this.codigo  = codigo;
        this.nome    = nome;
        ModelArquivo = modelArquivo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Arquivo getModelArquivo() {
        return ModelArquivo;
    }

    public void setModelArquivo(Arquivo modelArquivo) {
        ModelArquivo = modelArquivo;
    }
}
