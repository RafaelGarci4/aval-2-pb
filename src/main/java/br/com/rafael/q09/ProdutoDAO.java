package br.com.rafael.q09;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;


public class ProdutoDAO {

    private Connection connection;


    public ProdutoDAO(Connection connection){
        this.connection = connection;
    }



    public void insert(Produto produto) throws SQLException{
        String sql = "INSERT INTO produto_aval2 (NOME, DESCRICAO, DESCONTO, PRECO, DATA_INICIO) VALUES (?, ?, ?, ?, ?)";

        LocalDateTime data = LocalDateTime.now();
       // DateTimeFormatter  robson = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            pstm.setString(1,produto.getNome());
            pstm.setString(2,produto.getDescricao());
            pstm.setDouble(3,produto.getDesconto());
            pstm.setDouble(4,produto.getPreco());
            pstm.setObject(5, data);

            pstm.execute();
        }
    }


    public void selectFromID(int id) throws SQLException{
        String sql = "SELECT * FROM produto_aval2 WHERE ID = ?";

        //LocalDateTime data = LocalDateTime.now();
        // DateTimeFormatter  robson = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            pstm.setInt(1,id);

            pstm.execute();


            ResultSet rst = pstm.getResultSet();

            while (rst.next()){
                Integer showID = rst.getInt("ID");
                System.out.println("ID: "+showID);

                String nome = rst.getString("NOME");
                System.out.println("Nome: "+nome);

                String descricao = rst.getString("DESCRICAO");
                System.out.println("Descricao: "+descricao);

                double desconto = rst.getDouble("DESCONTO");
                System.out.println("Desconto: "+desconto);

                double preco = rst.getDouble("PRECO");
                System.out.println("Preco: "+preco);

                Date data = rst.getDate("DATA_INICIO");
                System.out.println("Data: "+data);
            }


        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Novo valor do desconto: ");
        double newDesconto = scanner.nextDouble();

        System.out.print("Novo valor do preco");
        double newPreco = scanner.nextDouble();

        sql = "UPDATE produto_aval2 SET DESCONTO = ?, PRECO = ? WHERE ID = ?  ";
        PreparedStatement pstm = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        pstm.setDouble(1,newDesconto);
        pstm.setDouble(2,newPreco);
        pstm.setInt(3,id);

        pstm.execute();
    }


    public void deleteFromID(int id) throws SQLException{
        String sql = "DELETE FROM produto_aval2 WHERE ID = ?";


        try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            pstm.setInt(1,id);

            pstm.execute();




        }

    }

    public void listarTodos(String chave) throws SQLException{
        String sql = "SELECT * FROM produto_aval2 WHERE NOME LIKE ?";


        try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

           pstm.setString(1,chave);
            pstm.execute();

            ResultSet rst = pstm.getResultSet();

            while (rst.next()){

                Integer showID = rst.getInt("ID");
                System.out.println("ID: "+showID);

                String nome = rst.getString("NOME");
                System.out.println("Nome: "+nome);

                String descricao = rst.getString("DESCRICAO");
                System.out.println("Descricao: "+descricao);

                double desconto = rst.getDouble("DESCONTO");
                System.out.println("Desconto: "+desconto);

                double preco = rst.getDouble("PRECO");
                System.out.println("Preco: "+preco);

                Date data = rst.getDate("DATA_INICIO");
                System.out.println("Data: "+data);
                System.out.println("======================");
            }

        }

    }


}
