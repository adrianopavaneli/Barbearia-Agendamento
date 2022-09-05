/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.Helper.AgendaHelper;
import controller.Helper.IHelper;
import dao.AgendamentoDAO;
import dao.ClienteDAO;
import dao.Conexao;
import dao.ServicoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Agendamento;
import model.Cliente;

import model.Servico;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import view.Agenda;

/**
 *
 * @author Adriano Pavaneli
 */
public class AgendaController {
    
    private final Agenda view;
    private final AgendaHelper helper;
    
    
    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    public void atualizaTabela() throws SQLException{


        //buscar lista com agendamentos
        Connection conexao = new Conexao().getConnection();
        AgendamentoDAO agendamentoDao = new AgendamentoDAO(conexao);
        ArrayList<Agendamento> agendamentos = agendamentoDao.selectAll();
        //exibir lista na view
        helper.preencherTabela(agendamentos);
        
    }
    
    public void atualizaCliente() throws SQLException{
//        //buscar banco de dados
        Connection conexao = new Conexao().getConnection();
        ClienteDAO clienteDao = new ClienteDAO(conexao);
        ArrayList<Cliente> clientes = clienteDao.selectAll();
        //exibir clientes nos combobox
        helper.preencherClientes(clientes);
        
        
    }
     public void atualizaServico() throws SQLException{
        //buscar banco de dados
        Connection conexao = new Conexao().getConnection();
        ServicoDAO servicoDao = new ServicoDAO(conexao);
        ArrayList<Servico> servicos = servicoDao.selectAll();
//        //exibir clientes nos combobox
        
        helper.preencherServico(servicos);
        
        
    }
     public void atualizaValor() throws SQLException{
         Connection conexao = new Conexao().getConnection();
         ServicoDAO servicoDao = new ServicoDAO(conexao);
                 
         
         List<Servico> servicos = servicoDao.selectAll();
         for (int i=0; i < servicos.size();i++) {
         double valor = servicos.get(i).getValor();  
         helper.setarValor(valor);
         
         Servico servico = helper.obterServico();
         helper.setarValor(servico.getValor());
         
         }
         
          
          
        
        
       
         
         
     }
     public void agendar() throws SQLException{
         Connection conexao = new Conexao().getConnection();
         Agendamento agendamento = (Agendamento) helper.obterModelo();
         
         new AgendamentoDAO(conexao).insert(agendamento);

         atualizaTabela();
         helper.limpaTela();
//         
         
     }


    
    
    
}
