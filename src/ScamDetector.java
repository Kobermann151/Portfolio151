import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScamDetector {
    private final Map<String, List<String>> scamCategories;

    public ScamDetector() {
        scamCategories = new HashMap<>();
        initializeKeywords();
    }

    private void initializeKeywords() {
        // Promoções Falsas
        List<String> promoKeywords = new ArrayList<>();
        promoKeywords.add("ganhou");
        promoKeywords.add("prêmio");
        promoKeywords.add("sorteio");
        promoKeywords.add("grátis");
        promoKeywords.add("promoção");
        promoKeywords.add("imperdível");
        promoKeywords.add("desconto exclusivo");
        promoKeywords.add("vagas limitadas");
        scamCategories.put("Promoção Falsa", promoKeywords);

        // Golpes Bancários
        List<String> bankKeywords = new ArrayList<>();
        bankKeywords.add("atualização");
        bankKeywords.add("senha");
        bankKeywords.add("conta bloqueada");
        bankKeywords.add("token");
        bankKeywords.add("segurança");
        bankKeywords.add("irregularidade");
        bankKeywords.add("banco");
        bankKeywords.add("clique no link");
        bankKeywords.add("agência");
        scamCategories.put("Golpe Bancário", bankKeywords);

        // Pedidos de Ajuda Falsos
        List<String> helpKeywords = new ArrayList<>();
        helpKeywords.add("preciso de ajuda");
        helpKeywords.add("dinheiro");
        helpKeywords.add("urgente");
        helpKeywords.add("pix");
        helpKeywords.add("transferência");
        helpKeywords.add("emergência");
        helpKeywords.add("hospital");
        helpKeywords.add("pagar uma conta");
        scamCategories.put("Pedido de Ajuda Falso", helpKeywords);
    }

    public List<String> analyzeText(String text) {
        List<String> detections = new ArrayList<>();
        String lowerText = text.toLowerCase();

        for (Map.Entry<String, List<String>> entry : scamCategories.entrySet()) {
            String category = entry.getKey();
            List<String> keywords = entry.getValue();
            
            for (String keyword : keywords) {
                if (lowerText.contains(keyword.toLowerCase())) {
                    detections.add(category + " (Palavra-chave detectada: " + keyword + ")");
                    // Uma detecção por categoria já é suficiente para o alerta
                    break;
                }
            }
        }
        return detections;
    }
}
