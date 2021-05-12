# Micronaut - Desafio Casa do Código

Em construção...

Este repositório apresenta os resultados de uma breve introdução da utilização do [Micronaut](https://micronaut.io/) com o [Kotlin](https://kotlinlang.org/)

## Configurando o ambiente
### O que foi utilizado para o desenvolvimento
- Docker 20.10.6;
- Intellij IDEA;
- Kotlin 1.5.0;
- JDK 11.
### Container PostgreSQL no Docker
- Banco de dados baseado na imagem do Postgres: ``docker run -p 5432:5432 --name casa-do-codigo-db -e 
  POSTGRES_PASSWORD=mysecret -e 
  POSTGRES_DB=casa_do_codigo_db postgres``;
- Caso queira inspecionar o banco: ``winpty docker exec -it casa-do-codigo-db  psql -U postgres -W casa_do_codigo_db``;
    - Mostrar tabelas: ``\dt``
    
## O que foi apresentado
- Módulo HTTP do Micronaut;
- Criação de testes de integração;
- Validações com anotações da *Bean Validation*;
- Boas práticas de escrita de código.
