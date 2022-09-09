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

import model.Barbeiro;

/**
 *
 * @author Adriano Pavaneli
 */
public class BarbeiroDAO {
     private final Connection connection;
    
    public BarbeiroDAO(Connection connection){
        this.connection = connection;
    }
    
    public void insert(Barbeiro barbeiro) throws SQLException{
                   
        String sql = "insert into barbeiro(nome) values(?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, barbeiro.getNome());
        
        statement.execute();           
            
        
    }
    
    public void update(Barbeiro barbeiro) throws SQLException{
        String sql = "update barbeiro set nome = ?, where id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, barbeiro.getNome());        
        statement.setInt(2, barbeiro.getId());
        statement.execute();
    }
    
    public void insertOuUpdate(Barbeiro barbeiro) throws SQLException{
         if(barbeiro.getId() > 0){
             update(barbeiro);
             
         }  else{
             insert(barbeiro);
         }
        
    }
    public void delete(Barbeiro barbeiro) throws SQLException{
        String sql = "delete from barbeiro where id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, barbeiro.getId());
        statement.execute();
            
    }
    public ArrayList<Barbeiro> selectAll() throws SQLException{
         String sql = "select * from barbeiro order by nome";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);        
        
    }

    private ArrayList<Barbeiro> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Barbeiro> barbeiros = new ArrayList<Barbeiro>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String descricao = resultSet.getString("nome");
            
            
            Barbeiro barbeiroComDados = new Barbeiro(id, descricao);
            barbeiros.add(barbeiroComDados);
        }
        return barbeiros;
    }
    
    
    public Barbeiro selectPorId(Barbeiro barbeiro) throws SQLException{
        String sql = "select * from barbeiro where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, barbeiro.getId());
        return pesquisa(statement).get(0);
              
        
    }


    
}
