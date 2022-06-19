package br.com.rafael.q09;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.*;
/*
  ! CREATE TABLE `loja_aval2`.`produto_aval2` (
  ! `NOME` VARCHAR(45) NOT NULL,
  ! `DESCRICAO` VARCHAR(45) NOT NULL,
  ! `DESCONTO` DOUBLE NOT NULL,
  ! `PRECO` DOUBLE NOT NULL,
  ! `DATA_INICIO` DATE NOT NULL,
  !  PRIMARY KEY (`ID`));
*/

public class principal {
    static Scanner scanner = new Scanner(System.in);


  static   ProdutoDAO dao ;

    static public void opcao1() throws SQLException{
        String nome  = " ";
        String descricao = " ";
        double desconto = 00.00;
        double preco = 00.00;
        boolean flag;
        Produto produto = new Produto();
       if (dao.testeEmpty()){
           do {
               try {

                   System.out.print("Nome :");
                   nome = scanner.nextLine();
                   produto.setNome(nome);

                   System.out.print("Descricao :");
                   descricao = scanner.nextLine();
                   produto.setDescricao(descricao);

                   System.out.print("Desconto :");
                   desconto = scanner.nextFloat();
                   produto.setDesconto(desconto);

                   System.out.print("Preco :");
                   preco = scanner.nextFloat();
                   produto.setPreco(preco);

                   flag = true;

                   //Pega valores vazios
                   if (nome.isEmpty() || descricao.isEmpty()){
                       throw new InputMismatchException();

                   }

                   //Insere na tabela;
                   dao.insert(produto);

                   //Pega valores invalidos
               }catch (InputMismatchException e){

                   System.out.println("Entre com valores validos");
                   flag = false;

                   //! LIMPANDO O BUFFER DO SCANNER
                   scanner.nextLine();
               }
               //se alguma flag for disparada repete o while
           }while (!flag);
       }else{
           Produto p1 = new Produto("Notebook samsung","otimo notebook gamer",250,6000);
           dao.insert(p1);
           Produto p2 = new Produto("Monitor Asus","Monitor gamer com 240hz",100,3500);
           dao.insert(p2);
           Produto p3 = new Produto("Iphone 13","e um iphone 13 ne",10,9000);
           dao.insert(p3);
       }




    }

    static public void opcao2() throws  SQLException{
      int id ;

       boolean flag;
        do {
            try {
                System.out.print("Entre com um ID de produto a ser atualizado: ");
                id = scanner.nextInt();


                flag = true;

               if (dao.checkByID(id)) {
                   dao.selectFromID(id);
               }else{
                   System.out.println("nao foi encontrado um produto por esse ID, redirecionando para a area de cadastro ->");
                   scanner.nextLine();
                   opcao1();

               }

            }catch(InputMismatchException e){
                System.out.println("Insira um valor valido para ID's");
                flag = false;
                scanner.nextLine();
            }
        }while (!flag);


  }

    static public void opcao3() throws SQLException{
        int id ;

        boolean flag;
        do {
            try {
                System.out.print("Entre com um ID de produto a ser excluido: ");
                id  =  scanner.nextInt();
                flag = true;
                dao.deleteFromID(id);

            }catch(InputMismatchException e){
                System.out.println("Insira um valor valido para ID's");
                flag = false;
                scanner.nextLine();
            }
        }while (!flag);


    }

    static public void opcao4()throws SQLException{
        String palavraChave ;
        List<String> listaPalavraC = new ArrayList();
        System.out.print("Entre com uma palavra chave de pesquisa: ");
        palavraChave  =  scanner.nextLine();
        listaPalavraC  = Arrays.asList(palavraChave.split(" "));
        for (String s : listaPalavraC) {
            dao.listarTodos(s);
        }


    }



    public static void main(String[] args) throws SQLException{

        Connection connection = new ConnectionFactory().recuperarConexao();
        dao = new ProdutoDAO(connection);
       // connection.setAutoCommit(false);

        String option;
        do {
            System.out.println("===========| Rafael Menu |===========");
            System.out.println("     | 1) Cadastro de ofertas |");
            System.out.println("     | 2) Atualizar Oferta    |");
            System.out.println("     | 3) Excluir Oferta      |");
            System.out.println("     | 4) Listar Produtos     |");
            System.out.println("     | 0) SAIR                |\n");
            System.out.print("Opcao: ");
            option = scanner.nextLine();

           try {
               switch (option) {
                   case "1":
                       opcao1();
                       break;
                   case "2":
                       opcao2();
                       break;
                   case "3":
                       opcao3();
                       break;
                   case "4":
                       opcao4();
                       break;
                   default:
                       System.out.println("Por favor selecione uma das Opcoes");
                      //Limpa lixo
                       scanner.nextLine();


               }
           }catch (SQLException e){
               System.out.println("erro de conexao");
           }

        } while (!option.equals("0"));
        connection.close();
    }
}
