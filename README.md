# lp1-2023-projeto6
Projeto Sistema de Gestão de Loja

[Link do Projeto](https://docs.google.com/document/d/1Urhv-Eu5dYAaQM0Zrv1x5qulNvwfK7s5U7tJtbRb6ow/edit#heading=h.gjdgxs)
<!-- Acesse o nosso [documento](https://docs.google.com/document/d/1Urhv-Eu5dYAaQM0Zrv1x5qulNvwfK7s5U7tJtbRb6ow/edit?usp=sharing) -->

## Da Generalização

A generalização feita em todas as camadas do sistema apoiam uma melhor integridade conceitual em todo código e proporciona classes que implementam requerimentos recorrentes entre as classes de uma mesma camada. Isso pode ser feito, em especial, por meio da reflexão de classes e aplicação de padrões de projeto como o builder, o template e o adapter, em especial.

### Das limitações

As tabelas não podem formar grafos que possuam um ciclo, no que diz respeito às ligações por chave estrangeira, pois, se isso acontecer o sistema poderá entrar em loop.

Os campos anotados com @Column nas DTOs devem ter um tipo de retorno, se forem getters, ou receberem somente um parâmetro, se forem setters, de um tipo compatível com os métodos `PreparedStatement#setObject` e `ResultSet#getObject`, dentre esses é bom resaltar que para `blob` no banco o tipo deve ser `byte[]`, para `date` `java.sql.Date` e para `datetime` `LocalDateTime`.

## DTOs

Todas as DTOs 

### Criando DTOs

## DAOs

### Criando DAOs

#### JDBCOperation

## Sevices

### Criando services

## Servlets

### Usando uma fachada

### Sessions

### Fazendo um post

### Trabalhando com arquivos

## Views

### JSP Tag

## Senhas

### Cadastrando uma senha

### Validando uma senha

## Serializer

### Serializando

### Deserializando
