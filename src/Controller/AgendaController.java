/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import java.util.ArrayList;
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
    
    public void atualizaTabela(){
        //buscar lista com agendamentos
        AgendamentoDAO agendamentoDao = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDao.selectAll();
        //exibir lista na view
        helper.preencherTabela(agendamentos);
        
    }
    
    public void atualizaCliente(){
        //buscar banco de dados
        ClienteDAO clienteDao = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDao.selectAll();
        //exibir clientes nos combobox
        helper.preencherClientes(clientes);
        
        
    }
     public void atualizaServico(){
        //buscar banco de dados
        ServicoDAO servicoDao = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDao.selectAll();
        //exibir clientes nos combobox
        helper.preencherServico(servicos);
        
        
    }
    
    
    
}
