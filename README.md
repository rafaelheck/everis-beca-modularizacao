# Everis Beca: Modularização Android

## Proposta:

Faça a modularização somente da parte de login que se encontra neste projeto, para que a mesma possa ser utilizada em outros projetos.

## API:

https://6068931f0add490017340364.mockapi.io/login

A API está mockada, ou seja, o resultado sempre será o mesmo, independente de quem faz o request, porém o verbo deve estar de acordo com cada endpoint, conforme descritos a seguir.

## Endpoints:

### /session

Retorna o ID da sessão aberta e a configuração do teclado que será utilizado para a realização do login.

**Obs.:** O request deste endpoint deve ser feito com o verbo **POST**

### /authenticate

Retorna um booleano como resultado da autenticação e além disso um determinado conteúdo, neste caso, os dados do usuário, que seriam, o **ID** e o **nome**

**Obs.:** O request deste endpoint deve ser feito com o verbo **POST**

## Collection do Postman:

Faça download do collection desta API, para ser utilizado no *software* [Postman](https://www.postman.com/):
<br>
[Clique aqui](https://github.com/Niemietz/everis-beca-modularizacao/blob/21774a1784409bae766ffd9cae9fc57e59f0521c/everis_beca-modularizacao.postman_collection.json)
