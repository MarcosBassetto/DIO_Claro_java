import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura da primeira linha de entrada
        String[] entrada1 = scanner.nextLine().trim().split(",");
        double[] valoresServicos = Arrays.stream(entrada1)
                .mapToDouble(Double::parseDouble)
                .toArray();

        // Leitura da segunda linha de entrada
        String[] entrada2 = scanner.nextLine().trim().split(",");
        double[] descontos = Arrays.stream(entrada2)
                .mapToDouble(Double::parseDouble)
                .toArray();

        // Criando objetos Servico
        Servico[] servicos = new Servico[valoresServicos.length];
        for (int i = 0; i < valoresServicos.length; i++) {
            servicos[i] = new Servico(valoresServicos[i]);
        }

        // Criando o combo de serviços
        ComboServicos combo = new ComboServicos(servicos, descontos);

        // Calculando e imprimindo o valor total com desconto
        double valorTotal = combo.calcularValorTotal();
        System.out.printf("%.2f\n", valorTotal);

        scanner.close();
    }
}