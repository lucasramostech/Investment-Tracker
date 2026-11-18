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
para mais de 300 ativos. Nesta etapa, a configuração contém 319 ativos únicos
entre ações, ETFs, FIIs e criptomoedas.

Nesta versão:

- O projeto acompanha mais de 300 ativos;
- A Twelve Data acompanha 138 ações e ETFs;
- A CoinGecko acompanha 48 criptomoedas;
- A Brapi acompanha 133 ações e FIIs;
- Um ticker da Twelve Data é consultado por vez;
- Um ticker da Brapi é consultado junto com cada ticker da Twelve Data;
- A Twelve Data consulta um ticker a cada 15 segundos;
- A Brapi consulta um ticker a cada 15 segundos;
- A CoinGecko consulta a lista de criptomoedas a cada 1 minuto;
- As respostas das APIs são exibidas no console da aplicação;
- A entidade `Ativo` representa os ativos na tabela `ativos`;
- O `Repository` permite consultar e persistir ativos;
- O service `SalvarDados` centraliza a lógica de salvar ou atualizar ativos;
- Os schedulers salvam ou atualizam os preços retornados pelas APIs;
- Os índices dos schedulers avançam mesmo quando uma consulta apresenta erro;
- O PostgreSQL é utilizado como banco de dados da aplicação;
- O endpoint `GET /cotacao` está disponível para testes e retorna
  `teste`.

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

Para executar os testes:

```bash
./mvnw test
```

## Licença

Este projeto está disponível sob a
[Licença MIT](./LICENSE).
