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
}