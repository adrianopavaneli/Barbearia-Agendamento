/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Helper;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import model.Agendamento;

import model.Servico;
import view.CadastroServicoView;

/**
 *
 * @author Adriano Pavaneli
 */
public class ServicoHelper implements IHelper{
    private final CadastroServicoView view;
    
    public ServicoHelper(CadastroServicoView view) {
        this.view = view;
    }

    @Override
    public Object obterModelo() {
        String idString = view.getTxtCadId().getText();
        int id = Integer.parseInt(idString);
        String descricao = view.getTxtCadDescricao().getText();
        
        String valorString = view.getTxtCadValor().getText();
        double valor = Double.parseDouble(valorString);
        
        
        
      Servico servico = new Servico(id, descricao, valor);
      return servico;
    }
    public void preencherTabela(ArrayList<Servico> servicos) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableServicos().getModel();
        tableModel.setNumRows(0);
        
        //Percorrer a lista preenchendo a tabela
        for (Servico servico : servicos) {
            tableModel.addRow(
            new Object[]{
             servico.getId(),
             servico.getDescricao(),
             servico.getValor()
             
             
             
            });
        }
    }
    @Override
    public void limpaTela() {
        view.getTxtCadId().setText("0");
       view.getTxtCadDescricao().setText("");
       view.getTxtCadValor().setText("");
       
    }
    
}
