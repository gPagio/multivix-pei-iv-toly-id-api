# 📚 Toly ID API
Este é a API do Toly ID, projeto que visa contribuir na preservação da espécie. `Tolypeutes tricinctus`, mais conhecida como `Tatu-bola-do-nordeste`.

A espécie se encontra em extinção, restando cerca de apenas 100 indivíduos na natureza. Dessa forma, tomamos para nós a dor do curso de Medicina Veterinária e iniciamos a construção de uma plataforma para ajudar na pesquisa e preservação dessa espécie.

## 💡Objetivo
O objetivo deste projeto é centralizar todas as informações coletadas pelos pesquisadores de campo, posteriormente permitindo a geração de relatórios.

Os pesquisadores irão utilizar um [`aplicativo`](https://github.com/gushadd/pei-III-toly-id-mobile) para registrar as informações coletadas em campo, onde as mesmas serão enviadas para um servidor central por meio desta API, como mencionado anteriormente.

Vale a pena mencionar que essa API persiste os dados em um banco de dados `PostgreSQL` por meio da API do `Spring Boot` que se chama `Spring Data JPA`.

## 📝 End Points
Os end points dessa API estão mapeados com o Swagger. Para acessar esse mapeamento, rode o projeto e entre em:

```
http://localhost:8080/swagger-ui/index.html#/
```

## 📌 Dependências
Para o correto funcionamento doToly ID API, é necessário realizar a instalação das dependências abaixo. Clique no hyperlink em cada uma delas para ir a respectiva página de downloads.
 - [`PostgreSQL`](https://www.postgresql.org/download/): Banco de dados usado pelo Toly ID API
 - [`Maven`](https://maven.apache.org/install.html): Gerenciador de dependências usado pelo Toly ID API

## ⚙️ Configurações
Antes de executar o projeto devemos configurar algumas variáveis de ambiente em nossa máquina.

Abaixo estão listadas as variáveis de deverão ser criadas e o conteúdo que deve conter em cada uma delas:
|Variável|Conteúdo|Exemplo|
|---|---|---|
|`TOLY_ID_API_DATABASE_HOST`|Host do banco de dados. O endereço para acessar o mesmo juntamente com a porta|127.0.0.1:5432|
|`TOLY_ID_API_DATABASE_NAME`|Informa o nome do banco de dados que o Toly ID API irá persistir|multivix-pei-iv-toly-id-api|
|`TOLY_ID_API_DATABASE_USER`|Informa o nome do usuário para se conectar ao banco de dados|postgres|
|`TOLY_ID_API_DATABASE_PASSWORD`|Informa a senha do usuário definido na variável anterior|10203040|
|`TOLY_ID_API_JWT_SECRET`|Informa a chave secreta utilizada para assinar e verificar a autenticidade dos tokens JWT. Deve ser uma seqência de caracteres aleatória e secreta.|91a23XK7|

## 🚀 Uso
Para executar o projeto temos duas opções:

### 1ª Opção
Abra o mesmo com o `Visual Sudio Code` e execute o método abaixo na classe `TolyIdApplication`:

``` Java
public static void main(String[] args)
```

> [!NOTE]
> Para facilitar a execução e manipulação do projeto, instale a extenção [`Extension Pack for Java`](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack), no Visual Studio Code.

### 2ª Opção
Entre na pasta do projeto pelo terminal e execute o comando abaixo:

```
mvn spring-boot:run
```
> [!NOTE]
> Caso encontre problemas com o Maven na execução do Toly ID API, instale a versão `3.9.9`, que foi usada na construção do projeto.

Após a execução do programa, enviar uma requisição para o end point `/login/token`, informando email e senha em um `JSON` (estes que devem estar previamente cadastrados no banco de dados na tabela `usuarios`, sendo a senha criptografada pelo BCrypt), para pegar o `Token JWT`.

Em seguida, basta usar normalmente os demais end poins para realizar as ações desejadas, informando o Token JWT para realizar sua autenticação. Vale mencionar que o Token JWT possui uma duração máxima de `duas horas`, ou seja, a cada duas horas se faz necessário obter um novo Token JWT.

## ⚠️ Avisos
1. Este projeto foi construído e testado sobre o JDK 21, dessa forma recomendamos o uso do mesmo durante a execução do mesmo.