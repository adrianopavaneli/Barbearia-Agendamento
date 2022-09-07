/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.Helper.UsuarioHelper;
import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.CadastroUsuarioView;

/**
 *
 * @author Adriano Pavaneli
 */
public class CadastroUsuarioController {
    private CadastroUsuarioView view;
    private final UsuarioHelper helper;

    public CadastroUsuarioController(CadastroUsuarioView view) {
        this.view = view;
        this.helper = new UsuarioHelper(view);
    }
    
     public void atualizaTabela() throws SQLException{


        //buscar lista com servicos
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        ArrayList<Usuario> usuarios = usuarioDao.selectAll();
        //exibir lista na view
        helper.preencherTabela(usuarios);
        
    }
    public void salvaUsuario(){
        Usuario usuario = new Usuario(view.getTxtCadUsuario().getText() ,view.getTxtCadSenha().getText());
        
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            usuarioDao.insert(usuario);
            atualizaTabela();
            helper.limpaTela();
            JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
}
