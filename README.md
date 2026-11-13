# Investment Tracker

Aplicação de acompanhamento de investimentos desenvolvida com Spring Boot.

Este projeto nasceu de uma dor real de investidores: acompanhar diferentes
ativos e entender, de forma simples, como as variações do mercado podem
impactar uma carteira ao longo do tempo. A proposta é centralizar informações
de investimentos e transformar dados de mercado em uma visão mais clara para
apoiar o acompanhamento e a tomada de decisões.

O projeto consulta cotações por meio de APIs externas e está sendo estruturado
para acompanhar ações brasileiras, ações americanas e criptomoedas.

## Versão 0.1

A versão inicial implementa a integração básica com a Twelve Data, a Brapi e a
CoinGecko. As consultas são executadas automaticamente em segundo plano pelo
Spring Scheduler.

Nesta versão:

- Um ticker da Twelve Data é consultado por vez;
- Um ticker da Brapi é consultado junto com cada ticker da Twelve Data;
- A consulta seguinte acontece após 15 segundos;
- Depois que todos os tickers da lista são consultados, a CoinGecko é
  consultada;
- As respostas das APIs são exibidas no console da aplicação;
- O endpoint `GET /cotacao` está disponível para testes e retorna
  `teste`;

## Tecnologias

- Java 25;
- Spring Boot 4.1.2;
- Spring Web MVC;
- Maven;
- PostgreSQL (dependência disponível para as próximas etapas);
- Twelve Data;
- CoinGecko;
- Brapi.

## APIs utilizadas

- Twelve Data;
- CoinGecko;
- Brapi.

## Como executar

Aguarde a versão 1.0 para deploy


## Estrutura principal

```text
demo/
├── pom.xml
├── .env
└── src/
    ├── main/
    │   ├── java/com/example/demo/
    │   │   ├── ApiFolder/
    │   │   │   ├── BrapiRequest.java
    │   │   │   ├── CoinGeckoRequest.java
    │   │   │   └── TwelveDataRequest.java
    │   │   ├── Controllers/
    │   │   │   └── PortController.java
    │   │   ├── Scheduleds/
    │   │   │   └── ScheduledFile.java
    │   │   └── DemoApplication.java
    │   └── resources/
    │       └── application.properties
    └── test/
        └── java/com/example/demo/
            └── DemoApplicationTests.java
```

## Testes

Para executar os testes:

```bash
./mvnw test
```

## Licença

Este projeto está disponível sob a
[Licença MIT](./demo/LICENSE).
