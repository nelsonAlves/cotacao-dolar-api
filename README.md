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
## Cenários: 
 01: Consultar cotações do dolar por data válida.     
 Pré-requesitos: O usuário informar uma data válida.
 Procedimento: Consumir o serviço de consulta com uma data válida.   
 Resultado esperado: Responder a consulta com dados das cotações do dólar na data informada. 
 Dados a serem retornados: Data da requisição, valor de compra, valor da venda, data e hora da cotação do dolar;
 
 02: Consultar cotações do dolar por data inválida.  
 Pré-requesitos: O usuário informar a data inválida.  
 Procedimento: Consumir o serviço de consulta de cotações com uma data inválida.  
 Resultado esperado: Responder com uma mensagem de que a data informada está inválida.

 03: Consultar cotações do dolar por data com formato inválido.   
 Pré-requesitos: O usuário informar a data com formato inválido.   
 Procedimento: Consumir o serviço de consulta de cotações com uma data no formato inválido.   
 Resultado esperado: Responder com uma mensagem de que a data informada está no formato inválido.   

 04: Consultar cotações do dolar quando o serviço externo do Banco Central estiver indisponivel.   
 Pré-requesitos: O usuário informar uma data válida. Serviço do BC está indisponivel.    
 Procedimento: Consumir o serviço de consulta de cotações que tentará consumir um serviço externo fornecido pelo Banco Central.   
 Resultado esperado: Responder com uma mensagem de que o serviço do Banco Central está indisponivel. 

 05: Consultar cotações do dolar que não há registros de cotações na data válida informada.    
 Pré-requesitos: O usuário informar uma data válida. Não ter nenhum registro de cotação para a data válida informada.   
 Procedimento: Consumir o serviço de consulta com uma data válida.   
 Resultado esperado: Responder com uma mensagem de que não há registros de cotação para a data informada.


