/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

//import view.Agenda;
import java.sql.SQLException;
import view.Agenda;
import view.MenuPrincipal;

/**
 *
 * @author Adriano Pavaneli
 */
public class MenuPrincipalController {
    
    private final MenuPrincipal view;

    public MenuPrincipalController(MenuPrincipal view) {
        this.view = view;
    }
    
    public void navegarParaAgenda() throws SQLException{
        Agenda agenda = new Agenda();
        agenda.setVisible(true);
        
    }
}
