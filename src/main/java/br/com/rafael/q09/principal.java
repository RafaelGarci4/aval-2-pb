package br.com.rafael.q09;

import java.util.Scanner;
/*
  ! CREATE TABLE `loja_aval2`.`produto_aval2` (
  ! `NOME` VARCHAR(45) NOT NULL,
  ! `DESCRICAO` VARCHAR(45) NOT NULL,
  ! `DESCONTO` DOUBLE NOT NULL,
  ! `PRECO` DOUBLE NOT NULL,
  ! `DATA_INICIO` DATETIME NOT NULL,
  !  PRIMARY KEY (`ID`));
*/
public class principal {

    public static void main(String[] args) {

        Produto produto = new Produto();
        Scanner scanner = new Scanner(System.in);

        String option;
        do {
            System.out.println("===========| Rafael Menu |===========");
            System.out.println("     | 1) Cadastro de ofertas |");
            System.out.println("     | 2) Atualizar Oferta    |");
            System.out.println("     | 3) Excluir Oferta      |");
            System.out.println("     | 4) Listar Produtos     |");
            System.out.println("     | 0) SAIR                |\n");
            System.out.println("Opcao: ");
            option = scanner.nextLine();
            switch (option){
                case "1" :
                    System.out.println("do 1");
                    break;
                case "2" :
                    System.out.println("do 2");
                    break;
                case "3" :
                    System.out.println("do 3");
                    break;
                case "4" :
                    System.out.println("do 4");
                    break;
                default:
                    System.out.println("Por favor selecione uma das Opcoes");


            }


        } while (!option.equals("0"));

    }
}
