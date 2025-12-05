package entities;

import java.math.BigDecimal;

public non-sealed class ContaPoupancaPF extends Conta{
   private BigDecimal taxaRendimento;

   public ContaPoupancaPF(Integer numero, String titular, String cpf, BigDecimal depositoInicial) {
      super(numero, cpf, titular);
      this.taxaRendimento = BigDecimal.valueOf(0.01);
      depositar(depositoInicial);
   }

   public BigDecimal getTaxaRendimento() {
      return taxaRendimento;
   }

   public void setTaxaRendimento(BigDecimal taxaRendimento) {
      this.taxaRendimento = taxaRendimento;
   }

   public void atualizaSaldo(){
      super.depositar(getSaldo().multiply(taxaRendimento));
   }

   @Override
   public String toString() {
      return super.toString() + "\nTaxa de rendimento: " + getTaxaRendimento().multiply(BigDecimal.valueOf(100)) + "%";
   }
}
