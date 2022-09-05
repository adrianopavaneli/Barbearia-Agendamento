/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Agendamento;
import java.util.ArrayList;
import java.util.Date;
import model.Cliente;
import model.Usuario;


/**
 *
 * @author Adriano Pavaneli
 */
public class AgendamentoDAO {
    private final Connection connection;
    
    
     public AgendamentoDAO(Connection connection){
        this.connection = connection;
        
    }

    
     
     public ArrayList<Agendamento> selectAll() throws SQLException{
        String sql = "select p.id as pid, valor, dataagenda, observacao, id_cliente, id_servico, c.id as cid, nome from agendamento p inner join cliente c ON c.id = p.id_cliente;";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);        
        
    }
     private ArrayList<Agendamento> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Agendamento> agendamentos = new ArrayList<Agendamento>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            int id = resultSet.getInt("pid");
            double valor = resultSet.getDouble("valor");
            Cliente cliente = new Cliente();
            cliente.setId(resultSet.getInt("cid"));
            cliente.setNome(resultSet.getString("nome"));
            
            String cliente1 = resultSet.getString("nome");
//            Date dataagenda = resultSet.getDate("dataagenda");
//            SimpleDateFormat stf = new SimpleDateFormat("dd/MM/yyyy");
//            Date dataformatada = stf.parse(dataagenda);
            
            String observacao = resultSet.getString("observacao");
                        
            Agendamento agendamentoComDados = new Agendamento(id, cliente,valor, observacao);
            agendamentos.add(agendamentoComDados);
        }
        return agendamentos;
    }
    
    /**
     * Insere um agendamento dentro do banco de dados
     * @param agendamento exige que seja passado um objeto do tipo agendamento
     */
     
     public void insert(Agendamento agendamento) throws SQLException{
                   
        String sql = "insert into agendamento(valor,dataagenda,observacao,id_cliente,id_servico) values(?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);        
        statement.setDouble(1, agendamento.getValor());         
        java.util.Date dataUtil = new java.util.Date();
        dataUtil = agendamento.getData();
        java.sql.Timestamp dataSql = new java.sql.Timestamp(dataUtil.getTime());         
        statement.setTimestamp(2, dataSql);        
        statement.setString(3, agendamento.getObservacao());
        statement.setInt(4, agendamento.getCliente().getId());
        statement.setInt(5, agendamento.getServico().getId());
        
        statement.execute();           
             
    }
     
        
    }
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param agendamento
     * @return 
     */
//    public boolean update(Agendamento agendamento){
        
//        for (int i = 0; i < Banco.agendamento.size(); i++) {
//            if(idSaoIguais(Banco.agendamento.get(i),agendamento)){
//                Banco.agendamento.set(i, agendamento);
//                return true;
//            }
//        }
//        return false;      

//    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do agendamento passado
     * @param agendamento
     * @return 
     */
//    public boolean delete(Agendamento agendamento){
//        for (Agendamento agendamentoLista : Banco.agendamento) {
//            if(idSaoIguais(agendamentoLista,agendamento)){
//                Banco.agendamento.remove(agendamentoLista);
//                return true;
//            }
//        }
//        return false;
//    }
    
    /**
     * Retorna um arraylist com todos os agendamentos do banco de dados
     * @return uma lista com todos os registros do banco
     */
//    public ArrayList<Agendamento> selectAll(){
//        return Banco.agendamento;
//    }
//    
//    /**
//     * Compara se dois objetos tem a propriedade id igual
//     * @param agendamento
//     * @param agendamentoAComparar
//     * @return verdadeiro caso os id forem iguais e falso se nao forem
//     */
//    private boolean idSaoIguais(Agendamento agendamento, Agendamento agendamentoAComparar) {
//        return agendamento.getId() ==  agendamentoAComparar.getId();
//    }
//    
//    private int proximoId(){
//        
//        int maiorId = 0;
//        
//        for (Agendamento agendamento : Banco.agendamento) {           
//           int id = agendamento.getId();
//            
//            if(maiorId < id){
//                maiorId = id;
//            }
//            
//        }
//        
//        return maiorId + 1;
//    }
    
//}
