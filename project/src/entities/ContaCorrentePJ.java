package entities;

import java.util.Objects;

public class ContaCorrentePJ extends Conta{
   private final String cnpj;

   public ContaCorrentePJ(Integer numero, String titular, String cnpj) {
      super(numero, titular);
      this.cnpj = cnpj;
   }

   public String getCnpj() {
      return cnpj;
   }

   @Override
   public boolean equals(Object o) {
      if (o == null || getClass() != o.getClass()) return false;
      ContaCorrentePJ that = (ContaCorrentePJ) o;
      return Objects.equals(getCnpj(), that.getCnpj()) && Objects.equals(getNumero(), that.getNumero());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getCnpj(), getNumero());
   }
}
