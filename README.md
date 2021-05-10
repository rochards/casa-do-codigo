# Desafio Casa do Código

Em construção...

## Configurando o ambiente
### Container PostgreSQL no Docker
- Banco de dados baseado na imagem do Postgres: ``docker run -p 5432:5432 --name casa-do-codigo-db -e 
  POSTGRES_PASSWORD=mysecret -e 
  POSTGRES_DB=casa_do_codigo_db postgres``;
- Caso queira inspecionar o banco: ``winpty docker exec -it casa-do-codigo-db  psql -U postgres -W casa_do_codigo_db``;
    - Mostrar tabelas: ``\dt``
    