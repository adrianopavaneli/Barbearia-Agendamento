/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Helper;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import view.CadastroClienteView;

/**
 *
 * @author Adriano Pavaneli
 */
public class ClienteHelper implements IHelper{
     private final CadastroClienteView view;
    
    public ClienteHelper(CadastroClienteView view) {
        this.view = view;
    }

    @Override
    public Object obterModelo() {
        String idString = view.getTxtCadCliId().getText();
        int id = Integer.parseInt(idString);
        String nome = view.getTxtCadCliNome().getText();        
        String telefone = view.getTxtCadCliTelefone().getText();
        String rg = view.getTxtCadCliRg().getText();       
        String endereco = view.getTxtCadCliEndereco().getText();
        String cep = view.getTxtCadCliCep().getText();
        String email = view.getTxtCadCliEmail().getText();
        String sexo = view.getTxtCadcliSexo().getText();        
        String nascimento = view.getTxtCadCliNascimento().getText();
        Date nascimentodata = new Date(nascimento);
        String cidade = view.getTxtCadCliCidade().getText();
       
        
        
        
        
      Cliente cliente = new Cliente(id, nome, sexo,nascimentodata, telefone,email,rg,endereco,cep,cidade);
      return cliente;
    }
    public void preencherTabela(ArrayList<Cliente> clientes) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableCliente().getModel();
        tableModel.setNumRows(0);
        
        //Percorrer a lista preenchendo a tabela
        for (Cliente cliente : clientes) {
            tableModel.addRow(
            new Object[]{
             cliente.getId(),
             cliente.getNome(),
             cliente.getEndereco(),
             cliente.getCep(),
             cliente.getCidade(),
             cliente.getTelefone(),
             cliente.getEmail(),
             cliente.getDataNascimento(),
             cliente.getSexo(),
             cliente.getRg()
             
             
             
             
            });
        }
    }

    @Override
    public void limpaTela() {
        view.getTxtCadCliId().setText("0");
        view.getTxtCadCliRg().setText("");
       view.getTxtCadCliNome().setText("");
       view.getTxtCadCliEndereco().setText("");
       view.getTxtCadCliCep().setText("");
       view.getTxtCadCliEmail().setText("");
       view.getTxtCadcliSexo().setText("");
       view.getTxtCadCliNascimento().setText("");
       view.getTxtCadCliCidade().setText("");
       view.getTxtCadCliTelefone().setText("");
    }
    
}
