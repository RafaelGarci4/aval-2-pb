package br.com.rafael.q10;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;




public class principal
{

   static String voltaEmocao(int contagemH,int contagemS){

        if (contagemH > contagemS){
            return "divertido";
        } else if (contagemS > contagemH) {
            return "chateado";
        }else {
            return  "neutro";
        }

    }

    public static void main(String[] args) {
        String input = " ";
        int contagemH = 0;
        int contagemS = 0;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();


        if (input.contains(":-)") || input.contains(":-(")){


            contagemH = StringUtils.countMatches(input, ":-)");
            contagemS = StringUtils.countMatches(input, ":-(");
            String resp = voltaEmocao(contagemH,contagemS);
            System.out.println(resp);
        }else{
            System.out.println("neutro");
        }
    }
}
