# Everis Beca: Modularização Android

## Proposta:

Faça a modularização somente da parte de login que se encontra neste projeto, para que a mesma possa ser utilizada em outros projetos.

## API:

https://6068931f0add490017340364.mockapi.io/login

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
[Clique aqui](https://github.com/Niemietz/everis-beca-modularizacao/blob/305964e7959b758842076988937a46cac783093f/everis_beca-modularizacao.postman_collection.json)
