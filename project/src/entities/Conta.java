package entities;

import java.math.BigDecimal;
import java.util.Objects;

public sealed class Conta permits ContaCorrentePF, ContaPoupancaPF {
   private final Integer numero;
   private final String cpf;
   private String titular;
   private BigDecimal saldo;

   public Conta(Integer numero, String cpf, String titular) {
      this.numero = numero;
      this.cpf = cpf;
      this.titular = titular;
      this.saldo = BigDecimal.ZERO;
   }

   public String getCpf() {
      return cpf;
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

   public void sacar(BigDecimal valor){
      if (valor.compareTo(getSaldo()) < 1){
         this.saldo = saldo.subtract(valor);
      } else{
         throw new IllegalArgumentException("Saldo insificiente");
      }
   }

   public void depositar(BigDecimal valor){
      this.saldo = this.saldo.add(valor);
   }

   @Override
   public boolean equals(Object o) {
      if (o == null || getClass() != o.getClass()) return false;
      Conta conta = (Conta) o;
      return Objects.equals(getNumero(), conta.getNumero()) && Objects.equals(getCpf(), conta.getCpf());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getNumero(), getCpf());
   }

   @Override
   public String toString() {
      return "#" + getNumero() + " | Titular: " + getTitular() + " | Saldo: " + getSaldo();
   }
}
