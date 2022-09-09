/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adriano Pavaneli
 */
public class Cliente {
    private int id;
    private String nome;
    private String sexo;
    private Date dataNascimento;
    private String telefone;
    private String email;
    private String rg;
    private String endereco;
    private String cep;
    private String cidade;

    public Cliente(int id, String nome, String sexo, Date dataNascimento, String telefone, String email, String rg, String endereco, String cep, String cidade) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.rg = rg;
        this.endereco = endereco;
        this.cep = cep;
        this.cidade = cidade;
    }

    public Cliente(int id) {
        this.id = id;
    }
    
    

    public Cliente(int id, String nome, String sexo,String dataNascimento, String telefone, String email, String rg, String endereco, String cep) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        try {
            this.dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
        } catch (ParseException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.telefone = telefone;
        this.email = email;
        this.rg = rg;
        this.endereco = endereco;
        this.cep = cep;
    }

    public Cliente(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }
    

    public Cliente(String nome, String endereco, String cep, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.telefone = telefone;
    }

    public Cliente(String nome, String telefone, String email, String rg, String endereco, String cep, Date dataNascimento, String sexo) {
        this.nome = nome;        
        this.telefone = telefone;
        this.email = email;
        this.rg = rg;
        this.endereco = endereco;
        this.cep = cep;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        
    }
    
    
    public Cliente(){
        
    }

   

    public Cliente(int id, String nome, String endereco, String cep ) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
    }

    public int getId() {
        return id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    

   

    @Override
    public String toString() {
        return nome;
    }
    
    

}
    
    

