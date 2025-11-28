package entities;

import java.math.BigDecimal;

public class Conta {
   private final Integer numero;
   private String titular;
   private BigDecimal saldo;

   public Conta(Integer numero, String titular) {
      this.numero = numero;
      this.titular = titular;
      this.saldo = BigDecimal.ZERO;
   }

   public void setTitular(String titular) {
      this.titular = titular;
   }

   public Integer getNumero() {
      return numero;
   }

   public String getTitular() {
      return titular;
   }

   public BigDecimal getSaldo() {
      return saldo;
   }

   public void sacar(Double valor){
      if (valor <= saldo.doubleValue()){
         this.saldo = saldo.subtract(BigDecimal.valueOf(valor));
      } else{
         throw new IllegalArgumentException("Saldo insificiente");
      }
   }

   public void depositar(Double valor){
      this.saldo = this.saldo.add(BigDecimal.valueOf(valor));
   }
}
