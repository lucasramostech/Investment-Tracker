# Investment Tracker

Aplicação de acompanhamento de investimentos desenvolvida com Spring Boot.

Este projeto nasceu de uma dor real de investidores: acompanhar diferentes
ativos e entender, de forma simples, como as variações do mercado podem
impactar uma carteira ao longo do tempo. A proposta é centralizar informações
de investimentos e transformar dados de mercado em uma visão mais clara para
apoiar o acompanhamento e a tomada de decisões.

O projeto consulta cotações por meio de APIs externas e está sendo estruturado
para acompanhar ações brasileiras, ações americanas e criptomoedas.

## Versão 0.5

A versão 0.5 mantém a integração com a Twelve Data, a Brapi e a CoinGecko,
organiza a persistência dos ativos com Spring Data JPA e amplia o acompanhamento
para mais de 300 ativos. Nesta etapa, a configuração contém 314 ativos únicos
entre ações, ETFs, FIIs e criptomoedas.

Esta versão concentra o consumo das APIs e a atualização dos preços no banco de
dados. Os testes unitários e de integração podem ser implementados em uma etapa
posterior do desenvolvimento.

Nesta versão:

- O projeto acompanha mais de 300 ativos;
- A Twelve Data acompanha 138 ações e ETFs;
- A CoinGecko acompanha 48 criptomoedas;
- A Brapi acompanha 133 ações e FIIs;
- Um ticker da Twelve Data é consultado por vez;
- Um ticker da Brapi é consultado junto com cada ticker da Twelve Data;
- Os schedulers usam o intervalo configurado pela propriedade
  `market-data.fixed-rate-ms`;
- A Twelve Data consulta os tickers configurados um por vez;
- A Brapi consulta os tickers brasileiros um por vez;
- A CoinGecko consulta a lista de criptomoedas em uma única chamada;
- As respostas das APIs são exibidas no console da aplicação;
- A entidade `Ativo` representa os ativos na tabela `ativos`;
- O `Repository` permite consultar e persistir ativos;
- O service `SalvarDados` centraliza a lógica de salvar ou atualizar ativos;
- Os schedulers salvam ou atualizam os preços retornados pelas APIs;
- Os índices dos schedulers avançam mesmo quando uma consulta apresenta erro;
- O PostgreSQL é utilizado como banco de dados da aplicação;
- Os dados das APIs são atualizados pelo Hibernate no banco configurado;
- O endpoint `GET /cotacao` está disponível para testes e retorna
  `teste`.

## Configuração do agendamento

O intervalo dos schedulers é definido em
[`application.properties`](./src/main/resources/application.properties):

```properties
market-data.fixed-rate-ms=125217
```

Os três schedulers utilizam essa propriedade por meio de `fixedRateString`.
O valor está em milissegundos.

## Tecnologias

- Java 25;
- Spring Boot 4.1.2;
- Spring Web MVC;
- Maven;
- PostgreSQL;
- Spring Data JPA;
- Twelve Data;
- CoinGecko;
- Brapi.

## APIs utilizadas

- Twelve Data;
- CoinGecko;
- Brapi.


## Como executar

Com o PostgreSQL configurado, execute:

```bash
./mvnw spring-boot:run
```


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
    │   │   │   ├── DatabaseFolder/
    │   │   │   │   ├── Ativo.java
    │   │   │   │   └── Repository.java
    │   │   ├── Controllers/
    │   │   │   └── PortController.java
    │   │   ├── Services/
    │   │   │   └── SalvarDados.java
    │   │   ├── Scheduleds/
    │   │   │   ├── ScheduledBrapi.java
    │   │   │   ├── ScheduledGecko.java
    │   │   │   └── ScheduledTwelve.java
    │   │   └── DemoApplication.java
    │   └── resources/
    │       └── application.properties
    └── test/
        └── java/com/example/demo/
            └── DemoApplicationTests.java
```

## Testes

Atualmente, o projeto possui um teste de carregamento do contexto Spring.
Os testes unitários das APIs, dos schedulers e do serviço de persistência ainda
podem ser adicionados em uma próxima etapa.

Para executar os testes:

```bash
./mvnw test
```

## Licença

Este projeto está disponível sob a
[Licença MIT](./LICENSE).
