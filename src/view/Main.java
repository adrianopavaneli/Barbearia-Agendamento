/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Model.Cliente;
import Model.Servico;
import Model.Usuario;

/**
 *
 * @author Didi
 */
public class Main {
    public static void main(String[] args) {
        String nome = "teste";
        System.out.println(nome);
        Servico barba = new Servico(1, "barba", 30);
        System.out.println(barba);
        
        Cliente cliente = new Cliente(1, "Adriano", "rua tal", "15600");
        System.out.println(cliente);
        
         Usuario usuario = new Usuario(2, "adriano", "1234");
        System.out.println(usuario);
    }
    
}
