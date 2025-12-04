package application;

import entities.Conta;
import entities.ContaCorrentePF;
import entities.ContaPoupancaPF;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int geraNumeroConta = 1000;
      List<Conta> contas = new ArrayList<>();
      int menu = 0;
      do{
         System.out.println("Selecto option:");
         System.out.println("1. Abrir conta corrente;");
         System.out.println("1. Abrir conta poupança;");
         System.out.println("2. Consultar conta;");
         System.out.println("3. Encerrar conta;");
         System.out.println("4. Sair;");
         switch (sc.nextInt()) {
            case 1:
               try{
                  System.out.println("Digite o nome do titular: ");
                  String titular = sc.nextLine();
                  System.out.println("Digite o cpf do titular: ");
                  String cpf = sc.nextLine();
                  System.out.println("Digite o valor do depósito inicial: ");
                  BigDecimal valorInicial = BigDecimal.valueOf(sc.nextDouble());
                  int numConta = ++geraNumeroConta;
                  contas.add(new ContaPoupancaPF(numConta, cpf, titular));
                  for(Conta conta : contas){
                     if(conta.getNumero() == numConta){
                        conta.depositar(valorInicial);
                        break;
                     }
                  }
               }catch (Exception e){
                  System.out.println(e.getMessage());
               }
            break;
            case 2:
               try{
                  System.out.println("Digite o nome do titular: ");
                  String titular = sc.nextLine();
                  System.out.println("Digite o cpf do titular: ");
                  String cpf = sc.nextLine();
                  System.out.println("Digite o valor do depósito inicial: ");
                  BigDecimal valorInicial = BigDecimal.valueOf(sc.nextDouble());
                  int numConta = ++geraNumeroConta;
                  contas.add(new ContaCorrentePF(numConta, cpf, titular));
                  for(Conta conta : contas){
                     if(conta.getNumero() == numConta){
                        conta.depositar(valorInicial);
                        break;
                     }
                  }
               }catch (Exception e){
                  System.out.println(e.getMessage());
               }
            break;
            case 3:
               if(contas.isEmpty()) {
                  System.out.println("Sem contas a consultar");
                  break;
               }
                  System.out.println("Digite o numero da conta a consultar: ");
               int numConta = sc.nextInt();
               for(Conta conta : contas){
                  if(conta.getNumero() == numConta){
                     System.out.println(conta + "\n");

                  }
               }
            break;
         }
      }while(menu != 0);
      sc.close();
   }
}
