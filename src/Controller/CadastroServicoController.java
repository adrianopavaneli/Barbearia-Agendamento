/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import controller.Helper.ServicoHelper;

import dao.Conexao;
import dao.ServicoDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import model.Servico;

import view.CadastroServicoView;


/**
 *
 * @author Adriano Pavaneli
 */
public class CadastroServicoController {
    private CadastroServicoView view;
    private final ServicoHelper helper;
    

    public CadastroServicoController(CadastroServicoView view) {
        this.view = view;
        this.helper = new ServicoHelper(view);
    }
    
     public void atualizaTabela() throws SQLException{


        //buscar lista com servicos
        Connection conexao = new Conexao().getConnection();
        ServicoDAO servicoDao = new ServicoDAO(conexao);
        ArrayList<Servico> servicos = servicoDao.selectAll();
        //exibir lista na view
        helper.preencherTabela(servicos);
        
    }
    
    public void salvaServico(){
        int id = Integer.parseInt(view.getTxtCadId().getText());
        double valor = Double.parseDouble(view.getTxtCadValor().getText());
        Servico servico = new Servico(id,view.getTxtCadDescricao().getText() , valor);
        
        try {
            Connection conexao = new Conexao().getConnection();
           ServicoDAO servicoDao = new ServicoDAO(conexao);
            servicoDao.insertOuUpdate(servico);
            atualizaTabela();
            helper.limpaTela();
            JOptionPane.showMessageDialog(null, "Servico salvo com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroServicoView.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    public void deletaServico() throws SQLException{
          int id = Integer.parseInt(view.getTxtCadId().getText());
          double valor = Double.parseDouble(view.getTxtCadValor().getText());
        Servico servico = new Servico(id ,view.getTxtCadDescricao().getText(),valor);
          
           Connection conexao = new Conexao().getConnection();
            ServicoDAO servicoDao = new ServicoDAO(conexao);
            servicoDao.delete(servico);
            atualizaTabela();
            
        }
    
}
