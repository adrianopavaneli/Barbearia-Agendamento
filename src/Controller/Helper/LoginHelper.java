/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Usuario;
import view.Login;

/**
 *
 * @author Adriano Pavaneli
 */
public class LoginHelper {
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public Usuario obterModelo(){
        String nome = view.getTxtUsuario().getText();
        String senha = view.getTxtSenha().getText();
        Usuario modelo = new Usuario(0, nome, senha);
        return modelo;
    }

    
    public void setarModelo(Usuario modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha();
        view.getTxtUsuario().setText(nome);
        view.getTxtSenha().setText(senha);
        
    }
    public void limpaTela(){
        view.getTxtUsuario().setText("");
        view.getTxtSenha().setText("");
    }
    
}
