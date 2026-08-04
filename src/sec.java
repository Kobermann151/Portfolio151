import java.util.Scanner;

public class sec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScamDetector detector = new ScamDetector();

        System.out.println("bem vindo ao site do banco genérico");
        System.out.println("Digite aqui a Mensagem para detecção");

        while (true) {
            System.out.print("\nMensagem: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("sair"));
                break;
            }
    }
}