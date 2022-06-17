package br.com.rafael.q10;


import br.com.rafael.q09.Produto;
import br.com.rafael.q09.ProdutoDAO;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.Scanner;




public class principal
{

    static  FuncionarioDAO dao;

   static String voltaEmocao(int contagemH,int contagemS){

        if (contagemH > contagemS){
            return "divertido";
        } else if (contagemS > contagemH) {
            return "chateado";
        }else {
            return  "neutro";
        }

    }

    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().recuperarConexao();
        dao = new FuncionarioDAO(connection);
        String input = " ";
        int contagemH = 0;
        int contagemS = 0;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();

//        DatabaseMetaData md = connection.getMetaData();
//        ResultSet rs = md.getTables(null, null, "%", null);
//        while (rs.next()) {
//            System.out.println(rs.getString(3));
//        }
        if (input.contains(":-)") || input.contains(":-(")){


            contagemH = StringUtils.countMatches(input, ":-)");
            contagemS = StringUtils.countMatches(input, ":-(");
            String resp;

            resp = voltaEmocao(contagemH,contagemS);
            System.out.println(resp);

        dao.insert(input,resp);


        }else{
            System.out.println("neutro");
        }





        }
    }

