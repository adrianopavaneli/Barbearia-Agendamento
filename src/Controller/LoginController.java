/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.LoginHelper;
import Model.Usuario;
import view.Login;
import Controller.LoginController;
import Model.DAO.UsuarioDAO;
import view.MenuPrincipal;

/**
 *
 * @author Adriano Pavaneli
 */
public class LoginController {

    private final Login view;
    private final LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void entrarNoSistema(){
        //Pegar um usuario na view
        Usuario usuario = helper.obterModelo();
        
        //Pesquisar usuario no banco
        UsuarioDAO usuarioDao = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDao.selectPorNomeESenha(usuario);
        if(usuarioAutenticado != null){
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
        }else{
            view.exibeMensagem("Usuário ou senha incorretos!");
        }
    }
    
    public void fizTarefa(){
        System.out.println("Busquei algo no meu banco de dados");
        this.view.exibeMensagem("Executei o fiz tarefa");
    }
    
}
