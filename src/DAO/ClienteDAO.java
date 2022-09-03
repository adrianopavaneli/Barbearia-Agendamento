/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Cliente;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Adriano Pavaneli
 */
public class ClienteDAO {
    private final Connection connection;
    
     public ClienteDAO(Connection connection){
        this.connection = connection;
    }
     
public void insert(Cliente cliente) throws SQLException{
                   
        String sql = "insert into cliente(nome,endereco,cep,telefone,email,rg) values(?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getEndereco());
        statement.setString(3, cliente.getCep());
        statement.setString(4, cliente.getTelefone());
        statement.setString(5, cliente.getEmail());
        statement.setString(6, cliente.getRg());
        
        statement.execute();           
            
        
    }   
         
 
 public void update(Cliente cliente) throws SQLException{
        String sql = "update cliente set nome = ?, endereco = ?, cep = ? where id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getEndereco());
        statement.setString(3, cliente.getCep());
        
        statement.setInt(4, cliente.getId());
        statement.execute();
    }

public void insertOuUpdate(Cliente cliente) throws SQLException{
         if(cliente.getId() > 0){
             update(cliente);
             
         }  else{
             insert(cliente);
         }
}

public void delete(Cliente cliente) throws SQLException{
        String sql = "delete from cliente where id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, cliente.getId());
        statement.execute();
            
    }
public ArrayList<Cliente> selectAll() throws SQLException{
         String sql = "select * from cliente";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);        
        
    }
private ArrayList<Cliente> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String endereco = resultSet.getString("endereco");
            String cep = resultSet.getString("cep");
            
            Cliente clienteComDados = new Cliente(id, nome, endereco, cep);
            clientes.add(clienteComDados);
        }
        return clientes;
    }
        
public Cliente selectPorId(Cliente cliente) throws SQLException{
        String sql = "select * from cliente where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, cliente.getId());
        return pesquisa(statement).get(0);
              
        
    }
    
}
