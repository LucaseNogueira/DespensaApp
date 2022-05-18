package br.udesc.despensaapp.sus.model;

public class ModelUsuario {

    private int    codigo;
    private String email;
    private String senha;

    public ModelUsuario(){}

    public ModelUsuario(int codigo, String email, String senha) {
        this.codigo = codigo;
        this.email = email;
        this.senha = senha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
