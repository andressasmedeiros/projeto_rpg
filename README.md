# TaskApp RPG

Este aplicativo é um gerenciador de tarefas gamificado no estilo RPG. Este repositório, por enquanto, é apenas do **backend**, que será desenvolvido em **Java**, utilizando as seguintes tecnologias: **Spring Boot** para construção da API RESTful, **JWT** para autenticação e autorização, **PostgreSQL** como banco de dados, **Flyway** para controle de migrações e **Swagger/OpenAPI** para documentação da API. 

## Este respositório usa o respositório base de [Mateus Scheper](https://github.com/mateusscheper/spring-base)

## Configuração Inicial
No arquivo `application.properties`, defina a URL, usuário e senha do banco de dados, além dos caminhos para as chaves JWT (`app.key`, `app.pub`). **Importante:** não versionar os arquivos de chave.  

Gere um par de chaves RSA:  
- `app.key` → chave privada (manter em segredo)  
- `app.pub` → chave pública  

Para rodar a aplicação:  
./mvnw spring-boot:run  

## Banco de Dados
Este projeto utiliza **PostgreSQL** e **Flyway** para gerenciar migrações de schema.  

### Instalação do Flyway
- **Linux/macOS**:  
sudo snap install flyway  

- **Windows**:  
Baixar do site oficial do Flyway.  

### Executar migrações
```java
flyway -url=jdbc:postgresql://localhost:5432/spring_base \
       -user=postgres \
       -password=postgres \
       -schemas=base \
       -locations=filesystem:./flyway/db \
       migrate
```

## Documentação da API
A interface **Swagger UI** está disponível para explorar e testar os endpoints. Ela permite autenticar usando o token JWT e interagir diretamente com endpoints protegidos.  

## Contribuição
Forks são bem-vindos. Pull Requests podem ser enviados para melhorias ou correções.  

## Licença
Este projeto é open-source sob a licença **MIT**.
