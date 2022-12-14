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
public class Agendamento {
    private int id;
    private Cliente cliente;
    private Servico servico;
    private Barbeiro barbeiro;
    private double valor;
    private Date data;
    private boolean ativo;
    
    private String observacao;

    public Agendamento(int id, Cliente cliente, Servico servico, double valor, String data) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.valor = valor;
        try {
            this.data = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Agendamento(int id, Cliente cliente, Servico servico, Barbeiro barbeiro,double valor, Date data, String observacao) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.barbeiro = barbeiro;
        this.valor = valor;
        this.data = data;
        this.observacao = observacao;
        
    }

   

    public Agendamento(int id, double valor, Date data, String observacao) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.observacao = observacao;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }

 
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public String getDataFormatada(){
      return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
    public String getHoraFormatada(){
       return new SimpleDateFormat("HH:mm").format(data);
    }
    public void setData(Date data) {
        this.data = data;
    }
    public String getDataPronta(){
        
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(data);
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Agendamento{" + "id=" + id + ", cliente=" + cliente + ", servico=" + servico + ", valor=" + valor + ", data=" + data + ", observacao=" + observacao + '}';
    }
    
    
    
}
