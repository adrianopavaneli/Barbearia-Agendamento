/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexao;
import dao.ServicoDAO;

import java.sql.Connection;
import java.sql.SQLException;
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

    public CadastroServicoController(CadastroServicoView view) {
        this.view = view;
    }
    
    public void salvaServico(){
        double valor = Double.parseDouble(view.getTxtCadValor().getText());
        Servico servico = new Servico(view.getTxtCadDescricao().getText() , valor);
        
        try {
            Connection conexao = new Conexao().getConnection();
           ServicoDAO servicoDao = new ServicoDAO(conexao);
            servicoDao.insert(servico);
            JOptionPane.showMessageDialog(null, "Servico salvo com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroServicoView.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
}
