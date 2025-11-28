package entities;

import java.util.Objects;

public class ContaPoupancaPF extends Conta{
   private final String cpf;

   public ContaPoupancaPF(Integer numero, String titular, String cpf) {
      super(numero, titular);
      this.cpf = cpf;
   }

   public String getCpf() {
      return cpf;
   }

   @Override
   public boolean equals(Object o) {
      if (o == null || getClass() != o.getClass()) return false;
      ContaPoupancaPF that = (ContaPoupancaPF) o;
      return Objects.equals(getCpf(), that.getCpf()) && Objects.equals(getNumero(), that.getNumero());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getCpf(), super.getNumero());
   }
}
