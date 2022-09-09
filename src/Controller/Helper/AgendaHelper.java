/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Helper;

import model.Agendamento;
import model.Cliente;
import model.Servico;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.Barbeiro;
import view.Agenda;

/**
 *
 * @author Adriano Pavaneli
 */
public class AgendaHelper implements IHelper{
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    public void preencherTabela() {
        
    }

    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableAgendamentos().getModel();
        tableModel.setNumRows(0);
        
        //Percorrer a lista preenchendo a tabela
        for (Agendamento agendamento : agendamentos) {
            tableModel.addRow(
            new Object[]{
             agendamento.getId(),
             agendamento.getBarbeiro().getNome(),
             agendamento.getCliente().getNome(),
             agendamento.getServico().getDescricao(),
             agendamento.getValor(),
             agendamento.getDataFormatada(),
             agendamento.getHoraFormatada(),
             agendamento.getObservacao()
             
             
            });
        }
    }

    public void preencherClientes(ArrayList<Cliente> clientes) {
       DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getTextCliente().getModel();
        for (Cliente cliente : clientes) {
            comboBoxModel.addElement(cliente);
        }
         
    }

    public void preencherServico(ArrayList<Servico> servicos) {
       DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getTextServico().getModel();
        for(Servico servico : servicos) {
            comboBoxModel.addElement(servico);
        }
 
      
    }
    
    public void preencherBarbeiro(ArrayList<Barbeiro> barbeiros) {
       DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getTextBarbeiro().getModel();
        for(Barbeiro barbeiro : barbeiros) {
            comboBoxModel.addElement(barbeiro);
        }
 
      
    }
    public Cliente obterCliente() {
       return (Cliente)view.getTextCliente().getSelectedItem();
    }

    public Servico obterServico() {
       return (Servico)view.getTextServico().getSelectedItem();
    }

    public Barbeiro obterBarbeiro() {
       return (Barbeiro)view.getTextBarbeiro().getSelectedItem();
    }
    public void setarValor(double valor) {
        view.getTextValor().setText(valor + "");
    }

    @Override
    public Object obterModelo() {
        String idString = view.getTextId().getText();
        int id = Integer.parseInt(idString);
        Cliente cliente = obterCliente();
        Servico servico = obterServico();
        Barbeiro barbeiro = obterBarbeiro();
        String valorString = view.getTextValor().getText();
        double valor = Double.parseDouble(valorString);
        String data = view.getTextFormatedData().getText();
        String hora = view.getTextFormatedHora().getText();
        String datahora = data + " " + hora;
        Date datapronta = new Date(datahora);
        String observacao = view.getTextObservacao().getText();
        
        
      Agendamento agendamento = new Agendamento(id, cliente, servico, barbeiro,valor, datapronta, observacao);
      return agendamento;
    }

    @Override
    public void limpaTela() {
       view.getTextId().setText("0");
       view.getTextFormatedData().setText("");
       view.getTextFormatedHora().setText("");
       view.getTextObservacao().setText("");
    }
  
  
  
    
}
