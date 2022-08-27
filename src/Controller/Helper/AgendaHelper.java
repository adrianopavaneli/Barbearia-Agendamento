/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Agendamento;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import view.Agenda;

/**
 *
 * @author Adriano Pavaneli
 */
public class AgendaHelper {
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    public void preencherTabela() {
        
    }

    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableAgendamentos().getModel();
        tableModel.setNumRows(0);
        
        //Percorrer a lista preenchendo a tabela
        for (Agendamento agendamento : agendamentos) {
            tableModel.addRow(
            new Object[]{
             agendamento.getId(),
             agendamento.getCliente().getNome(),
             agendamento.getServico().getDescricao(),
             agendamento.getServico().getValor(),
             agendamento.getDataFormatada(),
             agendamento.getHoraFormatada(),
             agendamento.getObservacao()
             
             
            });
        }
    }
  
    
}
