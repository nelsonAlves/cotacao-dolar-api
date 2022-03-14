# cotacao-dolar-api
API para buscar a cotação do dólar comercial de uma determinada data a ser informada na requisição.

# Sistema de cotação do dolar

O sistema de cotação do dolar consome uma API externa do Banco Central do Brasil. 

# Tecnologias utilizadas
Foi utilizado o framework Spring Boot para consumo da API do Bacen.
O swagger foi utilizado para teste da API e o docker foi utilizado para criação de containers para cada microserviço.

# Portas
  
Microserviço de consumo da API: 8080

# swagger

O swagger foi utilizado para após o sistema ser executado, ser acessado pela seguinte url: 

http://localhost:8080/q/swagger-ui

# docker

Foi utilizado o docker compose. Para executar a aplicação no docker, basta fazer clone do projeto, navegar até a pasta raiz.

ou rodar os comandos:

./mvnw clean package -Spring.container-image.build=true -DskipTests docker-compose up

swagger: http://localhost:8080/q/swagger-ui
jaeger: http://localhost:16686/search?service=cotacao-dolar-api

# Especificação da API de consulta das cotações do dólar cormecial

## 001 - Historia de Usuário: Consultar cotações do dolar por data:
Como um usuário, quero consultar as cotações do dolar comercial na data informada
para ter conhecimento do valor de compra e de venda do dolar naquela data especifica.

## Criterios de Aceite:
 CA-01. Validar se o usuário informou a data.     
 CA-02. Validar se a data informada é válida.     
 CA-03. Se for uma data valida consultar as cotações do dolar em um serviço externo do Banco Central.

# Teste
## Cenário: 
 Consultar cotações do dolar por data válida.     
 Pré-requesitos: O usuário informar uma data válida.
 Procedimento: Consumir o serviço de consulta com uma data válida.   
 Resultado esperado: Responder a consulta com dados das cotações do dólar na data informada. Dados a serem retornados: Data da requisição, valor de compra, valor da venda, data e hora da cotação do dolar.


