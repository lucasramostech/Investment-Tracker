import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DadosLotes {

    private final Map<String, BigDecimal> cotacoes = new HashMap<>();

    // Função para criar o obj
    public Map<String, BigDecimal> Buffer(String ticker, BigDecimal cotacao) {
        if (ticker != null && cotacao != null) {
            cotacoes.put(ticker, cotacao);
        }
        return cotacoes;
    }

    // Função para chamar o salvar dados e salvar em lotes
    public void loteador(Map<String, BigDecimal> cotacoes) {

        // Chama o salvar dados em lote
    }
}