import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScamDetector detector = new ScamDetector();

        System.out.println("--- Sistema de Detecção de Golpes Online ---");
        System.out.println("Digite ou cole a mensagem suspeita para análise (ou 'sair' para encerrar):");

        while (true) {
            System.out.print("\nMensagem: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("sair")) {
                break;
            }

            List<String> detections = detector.analyzeText(input);

            if (detections.isEmpty()) {
                System.out.println("[OK] Nenhuma característica óbvia de golpe detectada.");
            } else {
                System.out.println("⚠️  ALERTA: Possível golpe detectado!");
                for (String detection : detections) {
                    System.out.println(" - " + detection);
                }
                System.out.println("Recomendação: Não clique em links, não forneça dados pessoais e verifique a fonte.");
            }
        }

        System.out.println("Sistema encerrado.");
        scanner.close();
    }
}
