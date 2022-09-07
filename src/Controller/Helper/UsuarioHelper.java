/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Helper;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import model.Usuario;
import view.CadastroUsuarioView;

/**
 *
 * @author Adriano Pavaneli
 */
public class UsuarioHelper implements IHelper {
     private final CadastroUsuarioView view;
    
    public UsuarioHelper(CadastroUsuarioView view) {
        this.view = view;
    }

    @Override
    public Object obterModelo() {
        String idString = view.getTxtCadId().getText();
        int id = Integer.parseInt(idString);
        String usuariocad = view.getTxtCadUsuario().getText();
        
        String senha = view.getTxtCadSenha().getText();
        
        
        
        
      Usuario usuario = new Usuario(id, usuariocad, senha);
      return usuario;
    }
    
    public void preencherTabela(ArrayList<Usuario> usuarios) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableUsuario().getModel();
        tableModel.setNumRows(0);
        
        //Percorrer a lista preenchendo a tabela
        for (Usuario usuario : usuarios) {
            tableModel.addRow(
            new Object[]{
             usuario.getId(),
             usuario.getUsuario()
             
             
             
             
            });
        }
    }
    

    @Override
    public void limpaTela() {
        view.getTxtCadId().setText("0");
       view.getTxtCadUsuario().setText("");
       view.getTxtCadSenha().setText("");
    }

   
}
