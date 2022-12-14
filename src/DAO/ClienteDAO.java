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
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.text.ParseException;


/**
 *
 * @author Adriano Pavaneli
 */
public class ClienteDAO {
    private final Connection connection;
    
    
     public ClienteDAO(Connection connection){
        this.connection = connection;
        
    }
     
public void insert(Cliente cliente) throws SQLException, ParseException{
                   
        String sql = "insert into cliente(nome,endereco,cep,telefone,email,rg,datanascimento,sexo,cidade) values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getEndereco());
        statement.setString(3, cliente.getCep());
        statement.setString(4, cliente.getTelefone());
        statement.setString(5, cliente.getEmail());
        statement.setString(6, cliente.getRg());        
        java.util.Date dataUtil = new java.util.Date();
        dataUtil = cliente.getDataNascimento();
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");            
        statement.setDate(7, dataSql);
        statement.setString(8, cliente.getSexo()); 
        statement.setString(9, cliente.getCidade());
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

public void insertOuUpdate(Cliente cliente) throws SQLException, ParseException{
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
            String cidade = resultSet.getString("cidade");
            String telefone = resultSet.getString("telefone");
            String email = resultSet.getString("email");
            java.sql.Date datanascimento = resultSet.getDate("datanascimento");
            String sexo = resultSet.getString("sexo");
            String rg = resultSet.getString("rg");
            
            Cliente clienteComDados = new Cliente(id, nome, sexo,datanascimento,telefone,email,rg,endereco, cep,cidade);
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
