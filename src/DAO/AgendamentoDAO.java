/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import model.Agendamento;
import java.util.ArrayList;
import java.util.Date;
import model.Barbeiro;
import model.Cliente;
import model.Servico;



/**
 *
 * @author Adriano Pavaneli
 */
public class AgendamentoDAO {
    private final Connection connection;
    
    
     public AgendamentoDAO(Connection connection){
        this.connection = connection;
        
    }
     
     public void atualizaDataAgendamento() throws SQLException{
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStamp = date.format(new Date());        
        String sql = "UPDATE  agendamento SET ativo = false WHERE dataagenda < " + "'" + timeStamp + "'";        
        PreparedStatement statement = connection.prepareStatement(sql);
        

        statement.execute();
    }
    
     
     public ArrayList<Agendamento> selectAll() throws SQLException{
        String sql = "select p.id as pid, p.valor as pvalor, dataagenda, observacao, \n" +
"id_cliente, id_servico,ativo, id_barbeiro, c.id as cid, c.nome as cnome, sexo, \n" +
"datanascimento, telefone, email, rg, endereco, cep, s.id as sid, descricao,\n" +
"s.valor as svalor, b.id as bid, b.nome as bnome from agendamento p inner join cliente c ON c.id = \n" +
"p.id_cliente inner join servico s on s.id = p.id_servico inner join barbeiro b ON b.id = p.id_barbeiro where ativo = true order by dataagenda";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);        
        
    }
     private ArrayList<Agendamento> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Agendamento> agendamentos = new ArrayList<Agendamento>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            int id = resultSet.getInt("pid");
            double valor = resultSet.getDouble("pvalor");
            Cliente cliente = new Cliente();
            cliente.setId(resultSet.getInt("cid"));
            cliente.setNome(resultSet.getString("cnome"));            
            Servico servico = new Servico();
            servico.setId(resultSet.getInt("sid"));
            servico.setDescricao(resultSet.getString("descricao"));
            Barbeiro barbeiro = new Barbeiro();
            barbeiro.setId(resultSet.getInt("bid"));
            barbeiro.setNome(resultSet.getString("bnome"));            
            java.sql.Timestamp dataagenda = resultSet.getTimestamp("dataagenda");            
            String observacao = resultSet.getString("observacao");
            
            Agendamento agendamentoComDados = new Agendamento(id, cliente, servico,barbeiro,valor,dataagenda, observacao);
            agendamentos.add(agendamentoComDados);
        }
        return agendamentos;
    }
    
    /**
     * Insere um agendamento dentro do banco de dados
     * @param agendamento exige que seja passado um objeto do tipo agendamento
     */
     
     public void insert(Agendamento agendamento) throws SQLException{
                   
        String sql = "insert into agendamento(valor,dataagenda,observacao,id_cliente,id_servico,id_barbeiro,ativo) values(?,?,?,?,?,?,true)";
        PreparedStatement statement = connection.prepareStatement(sql);        
        statement.setDouble(1, agendamento.getValor());         
        java.util.Date dataUtil = new java.util.Date();
        dataUtil = agendamento.getData();
        java.sql.Timestamp dataSql = new java.sql.Timestamp(dataUtil.getTime());         
        statement.setTimestamp(2, dataSql);        
        statement.setString(3, agendamento.getObservacao());
        statement.setInt(4, agendamento.getCliente().getId());
        statement.setInt(5, agendamento.getServico().getId());
        statement.setInt(6, agendamento.getBarbeiro().getId());
        
        statement.execute();           
             
    }     
        
    
  
    
   
    }
    

