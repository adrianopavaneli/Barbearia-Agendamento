/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Servico;


/**
 *
 * @author Adriano Pavaneli
 */
public class ServicoDAO {
     private final Connection connection;
    
    public ServicoDAO(Connection connection){
        this.connection = connection;
    }
    
    public void insert(Servico servico) throws SQLException{
                   
        String sql = "insert into servico(descricao,valor) values(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, servico.getDescricao());
        statement.setDouble(2, servico.getValor());
        statement.execute();           
            
        
    }
    
    public void update(Servico servico) throws SQLException{
        String sql = "update servico set descricao = ?, valor = ? where id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, servico.getDescricao());
        statement.setDouble(2, servico.getValor());
        statement.setInt(3, servico.getId());
        statement.execute();
    }
    
    public void insertOuUpdate(Servico servico) throws SQLException{
         if(servico.getId() > 0){
             update(servico);
             
         }  else{
             insert(servico);
         }
        
    }
    public void delete(Servico servico) throws SQLException{
        String sql = "delete from servico where id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, servico.getId());
        statement.execute();
            
    }
    public ArrayList<Servico> selectAll() throws SQLException{
         String sql = "select * from servico";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);        
        
    }

    private ArrayList<Servico> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Servico> servicos = new ArrayList<Servico>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String descricao = resultSet.getString("descricao");
            Float valor = resultSet.getFloat("valor");
            
            Servico servicoComDados = new Servico(id, descricao, valor);
            servicos.add(servicoComDados);
        }
        return servicos;
    }
    
    
    public Servico selectPorId(Servico servico) throws SQLException{
        String sql = "select * from servico where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, servico.getId());
        return pesquisa(statement).get(0);
              
        
    }


    
}
