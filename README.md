<p align="center">
 <img src="https://github.com/jsantos-examples/flexpag-desafio-backend/blob/main/contents/flexpag.png" width="600" alt="Banner Flexpag">
</p>

# 🚀 Desafio backend

Bem-vindo(a). Este é o desafio Back end!

O objetivo deste desafio é avaliar suas habilidades em programação.
Quando concluir o desafio, basta responder o e-mail onde recebeu o link do repositório.
Em seguida, enviaremos o feedback e as instruções dos próximos passos!

Caso tenha alguma dúvida, nós estamos disponíveis para tirá-las.
Bom desafio!

> ⚠️ **É importante que o seu repo esteja público, caso contrário não iremos conseguir avaliar sua resposta**

---

- [🧠 Contexto](#-contexto)
  - [🚰 Fluxo esperado](#-fluxo-esperado)
- [✔️ Critérios de Avaliação](#️-critérios-de-avaliação)
- [:rocket: Instruções](#rocket-instruções)
  - [:notebook: To-do list](#notebook-to-do-list)

# 🧠 Contexto

A Flexpag é uma empresa de tecnologia especializada em soluções digitais de pagamento. Sabendo disso, montamos um desafio que consiste em implementar um serviço de pagamento agendando.

### 🚰 Fluxo esperado

- Quando um agendamento é enviado deve ser registrado como `pending` e retornado o id;
- O usuário deve conseguir consultar o status do agendamento `pending`|`paid`;
- :warning: **Se o pagamento ainda não foi realizado o usuário pode**;
  - Excluir o agendamento;
  - Atualizar a data:hora do agendamento;
  
## ✔️ Critérios de Avaliação

Além dos requisitos levantados acima, iremos olhar para os seguintes critérios durante a correção do desafio:

- Eficiência e simplicidade;

## :rocket: Instruções

Chegou a hora de colocar a mão na massa!

### Aplicação

A aplicação já está com o pre setup default. 

**dependências:**
- spring-boot-starter-web
- spring-boot-starter-data-jpa
- spring-boot-devtools
- h2
- lombok

| componente | porta |
| --------- | ----------- |
| Aplicação  | `8080` |

aplication.yaml foi configurado para apontar para o banco local h2
```
spring:
  datasource:
    driverClassName: org.h2.Driver
    url: jdbc:h2:mem:payment-scheduler
    username: admin
    password: admin
  h2:
    console:
      enabled: true
      path: /h2-console
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        format_sql: true
        show_sql: true
```

### :notebook: To-do list
- [ ] Fazer o fork do projeto
- [ ] Implementar solução
- [ ] Enviar link do projeto

:information_source: _Sinta-se livre para incluir quaisquer observações que achar necessário_

---

_O desafio acima foi cuidadosamente construído para propósitos de avaliação apenas._


### Solução
Para agendar o pagamento, basta inserir apenas a data e hora no formato(dd/mm/yyyy HH:mm). É retornado as informações sobre o agendamento como o id, para acompanhamento, a data e hora escolhido e os status 

![post](https://user-images.githubusercontent.com/70807687/223594480-b11846e6-c41d-4c09-ba1b-0e3a6b78fc4c.png)

![post response](https://user-images.githubusercontent.com/70807687/223594605-8ab439a3-d4ad-48c6-b9cc-9a79a3320eec.png)



Para consultar os status do pagamento, basta inserir o id e se a hora do pagamento chegou, recebe os status "paid"

![get response](https://user-images.githubusercontent.com/70807687/223594700-bcbf3586-f512-459a-8854-55e1532477db.png)


