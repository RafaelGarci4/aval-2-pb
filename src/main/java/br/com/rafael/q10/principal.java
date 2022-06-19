package br.com.rafael.q10;


import java.sql.*;
import java.util.Scanner;




public class principal {

    static FuncionarioDAO dao;

    static String contagemChars(String input) {
        int contagemCharsFelizes = 0;
        int contagemCharsTristes = 0;
        String resp;

        for (int i = 0; i <= input.length() - 1; i++) {
            if (input.charAt(i) == ':') {
                if (input.charAt(i + 1) == '-' && input.charAt(i + 2) == ')') {
                    contagemCharsFelizes++;
                    i = i + 1;
                }
                if (input.charAt(i + 1) == '-' && input.charAt(i + 2) == '(') {
                    contagemCharsTristes++;
                    i = i + 2;
                }

            }

        }


        resp = voltaEmocao(contagemCharsFelizes, contagemCharsTristes);
        return resp;
    }

    static String voltaEmocao(int contagemH, int contagemS) {

        if (contagemH > contagemS) {
            return "divertido";
        } else if (contagemS > contagemH) {
            return "chateado";
        } else {
            return "neutro";
        }

    }

    public static void main(String[] args) throws SQLException {

        //Estabelece a con com o BD
        Connection connection = new ConnectionFactory().recuperarConexao();
        boolean flag;
        //instancia a DAO para podermos chamar seus metodos
        dao = new FuncionarioDAO(connection);

        //Frase a ser lida
        String input = " ";
        //Nome do funcionario
        String nomeFuncionario = " ";
        //Contagem de sequencias :-)
        int contagemH = 0;
        //contagem de sequencias :-(
        int contagemS = 0;

        //Scanner instanciado e input lido do terminal
        Scanner scanner = new Scanner(System.in);
       do {
           try{
               System.out.println("Entre com seu nome: ");
               nomeFuncionario = scanner.nextLine();
               System.out.println("Entre com sua frase");
               input = scanner.nextLine();

               if (nomeFuncionario.isEmpty() ||input.isEmpty() ){
                   throw new IllegalArgumentException();
               }
               flag = true;

           }catch (IllegalArgumentException e){
               flag = false;
               System.out.println("Nao aceitamos campos vazios");

           }
       }while (!flag);



        String resp;

        resp = contagemChars(input);



        dao.insert(nomeFuncionario, input, resp);


    }
}
