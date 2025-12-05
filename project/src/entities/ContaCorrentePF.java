package entities;

import java.math.BigDecimal;

public non-sealed class ContaCorrentePF extends Conta{
   private BigDecimal chequeEspecial;

   public ContaCorrentePF(Integer numero, String titular, String cpf, BigDecimal depositoInicial) {
      super(numero, cpf, titular);
      if(depositoInicial.compareTo(BigDecimal.valueOf(500))<=0){
         this.chequeEspecial = BigDecimal.valueOf(50);
      }else{
         this.chequeEspecial = depositoInicial.multiply(BigDecimal.valueOf(0.5));
      }
      this.depositar(depositoInicial);
   }

   public BigDecimal getChequeEspecial() {
      return chequeEspecial;
   }

   public void setChequeEspecial(BigDecimal chequeEspecial) {
      this.chequeEspecial = chequeEspecial;
   }

   @Override
   public void sacar(BigDecimal valor){
      if (valor.compareTo(getSaldo().add(chequeEspecial)) < 0){
         super.sacar(valor);
      }else{
         throw new IllegalArgumentException("Saldo insuficiente");
      }
   }

   @Override
   public void depositar(BigDecimal valor){
      if (chesEmUso()) {
         BigDecimal taxa = (super.getSaldo().multiply(BigDecimal.valueOf(-0.2)));
         super.depositar(valor);
         super.sacar(taxa);
      }else {
         super.depositar(valor);
      }
   }

   public boolean chesEmUso(){
      return super.getSaldo().compareTo(BigDecimal.ZERO) < 0;
   }

   public BigDecimal chesDisponivel(){
      if (super.getSaldo().compareTo(BigDecimal.ZERO) > -1){
         return getChequeEspecial();
      }else{
         return getChequeEspecial().add(super.getSaldo());
      }
   }

   @Override
   public String toString() {
      return super.toString() + "\nLimite chesque especial: " + getChequeEspecial() + " | Ches em uso?" + chesEmUso();
   }
}
