package application;

import entities.Conta;
import entities.ContaCorrentePF;
import entities.ContaPoupancaPF;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
   static int geraNumeroConta = 1000;
   public static void main(String[] args) {
      List<Conta> contas = new ArrayList<>();
      Scanner sc = new Scanner(System.in);
      int menu = -1;
      do{
         System.out.println("Selecto option:");
         System.out.println("1. Abrir conta corrente;");
         System.out.println("2. Abrir conta poupança;");
         System.out.println("3. Consultar conta;");
         System.out.println("4. Depositar;");
         System.out.println("5. Sacar;");
         System.out.println("6. Encerrar conta;");
         System.out.println("0. Sair;");
         int numConta = 0;
         switch (sc.nextInt()) {
            case 1:
               contas.add(abrirConta("c"));
            break;
            case 2:
               contas.add(abrirConta("p"));
            break;
            case 3:
               System.out.println("Digite o numero da conta: ");
               numConta = sc.nextInt();

            break;
            case 4:
               System.out.println("Digite a conta para realizar o depósito: ");
               numConta = sc.nextInt();

            case 0:
               menu = 0;
               break;
            default:
               System.out.println("Opção inválida.");
         }
      }while(menu != 0);
      sc.close();
   }
   public static Conta abrirConta(String tipo){
      Scanner sc = new Scanner(System.in);
      System.out.println("Digite o nome do titular: ");
      String titular = sc.nextLine();
      System.out.println("Digite o cpf do titular: ");
      String cpf = sc.nextLine();
      System.out.println("Digite o valor do depósito inicial: ");
      BigDecimal valorInicial = sc.nextBigDecimal();
      int numConta = ++geraNumeroConta;
      sc.close();
      if(tipo.equalsIgnoreCase("c"))return new ContaCorrentePF(numConta, titular, cpf, valorInicial);
      if(tipo.equalsIgnoreCase("p"))return new ContaPoupancaPF(numConta, titular, cpf, valorInicial);
      return null;
   }
}
