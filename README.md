# Investment Tracker

Aplicação de acompanhamento de investimentos desenvolvida com Spring Boot.

Este projeto nasceu de uma dor real de investidores: acompanhar diferentes
ativos e entender, de forma simples, como as variações do mercado podem
impactar uma carteira ao longo do tempo. A proposta é centralizar informações
de investimentos e transformar dados de mercado em uma visão mais clara para
apoiar o acompanhamento e a tomada de decisões.

O projeto consulta cotações por meio de APIs externas e está sendo estruturado
para acompanhar ações brasileiras, ações americanas e criptomoedas.

## Versão 0.6

A versão 0.6 mantém a integração com Twelve Data, Brapi e CoinGecko, a
persistência de cotações no PostgreSQL e o cadastro inicial de usuários.
Também adiciona a estrutura de domínio para carteiras de investimento e suas
posições.

### Funcionalidades e estrutura adicionadas

- A entidade `Wallet` representa uma carteira vinculada a um usuário;
- A entidade `Position` representa um ativo e sua quantidade dentro de uma
  carteira;
- Cada posição é associada a uma carteira, e um ticker pode aparecer no máximo
  uma vez por carteira;
- `WalletRepository` permite buscar carteiras por usuário e validar a
  propriedade de uma carteira;
- `PositionRepository` permite listar posições e buscar uma posição por
  carteira e ticker;
- O cadastro de usuários permanece disponível pelo endpoint `POST /register`,
  com validação dos dados e senha armazenada usando BCrypt;
- As cotações continuam sendo consultadas pelos agendadores e salvas no banco
  por meio do serviço `SalvarDados`.


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

As instruções de execução serão documentadas em uma versão futura.


## Estrutura de arquivos

```text
demo/
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .mvn/
│   └── wrapper/
│       └── maven-wrapper.properties
├── .gitattributes
├── .gitignore
├── .env
├── HELP.md
├── LICENSE
├── README.md
└── src/
    ├── main/
    │   ├── java/com/example/demo/
    │   │   ├── ApiFolder/
    │   │   │   ├── BrapiRequest.java
    │   │   │   ├── CoinGeckoRequest.java
    │   │   │   └── TwelveDataRequest.java
    │   │   ├── Configs/
    │   │   │   └── PasswordConfig.java
    │   │   ├── Controllers/
    │   │   │   └── PortController.java
    │   │   ├── DatabaseFolder/
    │   │   │   ├── Entitys/
    │   │   │   │   ├── Ativo.java
    │   │   │   │   ├── Position.java
    │   │   │   │   ├── UsersTable.java
    │   │   │   │   └── Wallet.java
    │   │   │   └── Repositorys/
    │   │   │       ├── PositionRepository.java
    │   │   │       ├── Repository.java
    │   │   │       ├── UsersRepository.java
    │   │   │       └── WalletRepository.java
    │   │   ├── DTO/
    │   │   │   └── RegisterRequest.java
    │   │   ├── Services/
    │   │   │   └── Auth/
    │   │   │       ├── RegisterAutentication.java
    │   │   │       ├── RegisterService.java
    │   │   │       └── BusinessRules/
    │   │   │           ├── DadosLotes.java
    │   │   │           └── SalvarDados.java
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

## Licença

Este projeto está disponível sob a
[Licença MIT](./LICENSE).
