package br.com.rafael.q10;

import br.com.rafael.q09.Produto;

import java.sql.*;


public class FuncionarioDAO {

    private Connection connection;


    public FuncionarioDAO(Connection connection){
        this.connection = connection;
    }



    public void insert(String nomeFuncionario,String input,String emocao) throws SQLException{
        String sql = "INSERT INTO emocao (NOME, MENSAGEM, SENTIMENTO) VALUES (?, ?, ?)";

        try(PreparedStatement pstm2 = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            pstm2.setString(1,nomeFuncionario);
            pstm2.setString(2,input);
            pstm2.setString(3,emocao);


            pstm2.execute();
        }
    }

//    public void insert(Produto produto) throws SQLException{
//        PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO,DESCONTO,PRECO,DATA_INICIO) VALUES (?, ?, ?, ?, ?)");
//
//
//        adicionarVariavel(produto.getNome(),produto.getDescricao(),produto.getDesconto(), produto.getPreco(), (Date) produto.getData(),stm);
//        connection.commit();
//        stm.close();
//        connection.close();
//
//
//    }
//
//
//    private static void adicionarVariavel(String nome,String descricao,double desconto,double preco, Date data, PreparedStatement stm) throws SQLException{
//        stm.setString(1,nome);
//        stm.setString(2,descricao);
//        stm.setDouble(3,desconto);
//        stm.setDouble(4,preco);
//        stm.setDate(5,data);
//
//
//        stm.execute();
//
//        ResultSet rst = stm.getGeneratedKeys();
//
//        while (rst.next()){
//            Integer id = rst.getInt(1);
//            System.out.println("o id criado foi: "+id);
//
//        }
//
//    }

}
