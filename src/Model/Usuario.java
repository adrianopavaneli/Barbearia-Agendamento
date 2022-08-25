/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Adriano Pavaneli
 */
public class Usuario {
    private int id;
    private String nome;
    private String senha;
    private String nivelAcesso;
    private char sexo;
    private Date dataNascimento;
    private String rg;
    private String email;
    private String telefone;

    public Usuario(int id, String nome, String senha, String nivelAcesso, char sexo, Date dataNascimento, String rg, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.email = email;
        this.telefone = telefone;
    }

    public Usuario(int id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", senha=" + senha + ", nivelAcesso=" + nivelAcesso + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento + ", rg=" + rg + ", email=" + email + ", telefone=" + telefone + '}';
    }
    
    
    
}
