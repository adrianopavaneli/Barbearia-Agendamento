/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Helper;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Barbeiro;

import view.CadastroBarbeiroView;


/**
 *
 * @author Adriano Pavaneli
 */
public class BarbeiroHelper implements IHelper {
private final CadastroBarbeiroView view;
    
    public BarbeiroHelper(CadastroBarbeiroView view) {
        this.view = view;
    }

    @Override
    public Object obterModelo() {
        String idString = view.getTxtCadId().getText();
        int id = Integer.parseInt(idString);
        String nome = view.getTxtCadNome().getText();
        
             
        
      Barbeiro barbeiro = new Barbeiro(id, nome);
      return barbeiro;
    }
    public void preencherTabela(ArrayList<Barbeiro> barbeiros) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableBarbeiro().getModel();
        tableModel.setNumRows(0);
        
        //Percorrer a lista preenchendo a tabela
        for (Barbeiro barbeiro : barbeiros) {
            tableModel.addRow(
            new Object[]{
             barbeiro.getId(),
             barbeiro.getNome() 
             
             
             
            });
        }
    }
    @Override
    public void limpaTela() {
        view.getTxtCadId().setText("0");
       view.getTxtCadNome().setText("");
       
       
    }
    
}
