/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.Helper.BarbeiroHelper;

import dao.BarbeiroDAO;
import dao.Conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Barbeiro;

import view.CadastroBarbeiroView;


/**
 *
 * @author Adriano Pavaneli
 */
public class CadastroBarbeiroController {
    
private CadastroBarbeiroView view;
    private final BarbeiroHelper helper;
    

    public CadastroBarbeiroController(CadastroBarbeiroView view) {
        this.view = view;
        this.helper = new BarbeiroHelper(view);
    }
    
     public void atualizaTabela() throws SQLException{


        //buscar lista com servicos
        Connection conexao = new Conexao().getConnection();
        BarbeiroDAO barbeiroDao = new BarbeiroDAO(conexao);
        ArrayList<Barbeiro> barbeiros = barbeiroDao.selectAll();
        //exibir lista na view
        helper.preencherTabela(barbeiros);
        
        
    }
    
    public void salvaBarbeiro(){
        int id = Integer.parseInt(view.getTxtCadId().getText());
        String nome = view.getTxtCadNome().getText();
        
        Barbeiro barbeiro = new Barbeiro(id,nome);
        
        try {
            Connection conexao = new Conexao().getConnection();
           BarbeiroDAO barbeiroDao = new BarbeiroDAO(conexao);
            barbeiroDao.insertOuUpdate(barbeiro);
            atualizaTabela();
            helper.limpaTela();
            JOptionPane.showMessageDialog(null, "Barbeiro salvo com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroBarbeiroView.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    public void deletaBarbeiro() throws SQLException{
          int id = Integer.parseInt(view.getTxtCadId().getText());          
       Barbeiro barbeiro = new Barbeiro(id ,view.getTxtCadNome().getText());
          
           Connection conexao = new Conexao().getConnection();
            BarbeiroDAO barbeiroDao = new BarbeiroDAO(conexao);
            barbeiroDao.delete(barbeiro);
            atualizaTabela();
            
        }
    
}
