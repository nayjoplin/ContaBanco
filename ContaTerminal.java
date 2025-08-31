import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        Locale localeBR = new Locale("pt", "BR");
        NumberFormat moedaBR = NumberFormat.getCurrencyInstance(localeBR);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Por favor, digite o número da Agência: ");
            String agencia = scanner.nextLine().trim();

            System.out.print("Por favor, digite o número da Conta: ");
            int numero = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Por favor, digite o Nome do Cliente: ");
            String nomeCliente = scanner.nextLine().trim();

            System.out.print("Por favor, digite o Saldo inicial: ");
            String saldoStr = scanner.nextLine().trim().replace(",", ".");
            BigDecimal saldo = new BigDecimal(saldoStr);

            String saldoFormatado = moedaBR.format(saldo);

            String mensagem = "Olá " + nomeCliente
                    + ", obrigado por criar uma conta em nosso banco, sua agência é "
                    + agencia + ", conta " + numero
                    + " e seu saldo " + saldoFormatado
                    + " já está disponível para saque.";

            System.out.println();
            System.out.println(mensagem);
        } catch (NumberFormatException e) {
            System.out.println("\nEntrada inválida para número da conta. Tente novamente usando apenas dígitos.");
        } catch (Exception e) {
            System.out.println("\nOcorreu um erro: " + e.getMessage());
        }
    }
}
