# lp1-2023-projeto6
Projeto Sistema de Gestão de Loja

[Link do Projeto](https://docs.google.com/document/d/1Urhv-Eu5dYAaQM0Zrv1x5qulNvwfK7s5U7tJtbRb6ow/edit#heading=h.gjdgxs)
<!-- Acesse o nosso [documento](https://docs.google.com/document/d/1Urhv-Eu5dYAaQM0Zrv1x5qulNvwfK7s5U7tJtbRb6ow/edit?usp=sharing) -->

## Da Generalização

A generalização feita em todas as camadas do sistema apoiam uma melhor integridade conceitual em todo código e proporciona classes que implementam requerimentos recorrentes entre as classes de uma mesma camada. Isso pode ser feito, em especial, por meio da reflexão de classes e aplicação de padrões de projeto como o builder, o template e o adapter, principalmente.

### Das limitações

As tabelas não podem formar grafos que possuam um ciclo, no que diz respeito às ligações por chave estrangeira, pois, se isso acontecer o sistema poderá entrar em loop.

Os campos anotados com @Column nas DTOs devem ter um tipo de retorno, se forem getters, ou receberem somente um parâmetro, se forem setters, de um tipo compatível com os métodos `PreparedStatement#setObject` e `ResultSet#getObject`, dentre esses é bom resaltar que para `blob` no banco o tipo deve ser `byte[]`, para `date` `java.sql.Date` e para `datetime` `LocalDateTime`.

Toda DTO deve ter uma chave primária, ou id e esse deve ser do tipo `Long`.

A nomenclatura é limitada por enquanto, uma chave estrangeira deve ou ser a própria chave primária, no caso que convenciono herança, caso não seja uma chave estrangeira para estabelecer herança ela deve ser nomeada como `<nome_da_tabela>__fk`, onde `<nome_da_tabela>` é o nome da tabela que quer se estabelecer a ligação.

A generalização não joga erros específicos para colunas únicas, pois não tem conhecimento delas.

Não é possível usar a generalização como substituto para qualquer sql que possa querer usar para extrair dados do banco, portanto, por vezes, é necessário implementar alguns métodos mais específicos de uma DAO, veja [JDBCOperation](#JDBCOperation) para ver um modo facilitado de criar métodos usando JDBC em suas DAOs.

## DTOs

Todas as DTOs implementam a interface `DTO` que recebe como parâmetro de tipo a DTO que está sendo criada. A interface `DTO` garante que toda DTO tenha métodos get e set para o id, métodos `toString` e `toMap`, métodos instanciadores e um método `getManager` que retorna o `Manager` daquela DTO. O `Manager` de uma DTO é a classe que proporciona a reflexão da DTO, possibilitando extrair de uma DTO a tabela a qual ela se refere, no banco, o nome de sua chave primária, as colunas que a DTO possuí, as colunas não nulas daquela DTO, se as colunas não nulas estão todas preenchidas e os métodos get e set daquela DTO.

A classe abstrata `AbstractDTO` tem como parâmetro de tipo a própria classe que a extende e implementa vários dos métodos da interface `DTO`, deixando somente os métodos `getId` e `setId` a serem implementados. Desse modo a grande maioria das DTOs herda de `AbstractDTO`.

Para cada coluna de uma DTO devem ser criados métodos get e set anotados, respectivamente, por `@Getter` e `@Setter`, além de ambos terem que ser anotados com `@Column(nome = "<nome_da_coluna_no_banco_de_dados>", tipo = <TipoCompativelComODoBancoDeDados>)`, se a coluna for não nula devem ser anotados com `@NotNull`. Toda DTO também deve ser anotada com `@Table(nome = "<nome_da_tabela_no_banco_de_dados>")` e com `@PrimaryKey(nome = <nome_da_chave_primaria_desta_tabela_no_banco_de_dados>)`.

### Criando DTOs

Suponha uma tabela `x` no banco de dados, com as colunas `c1`, `c2`, ..., `cn`, que não são chaves primárias ou estrangeiras, assuma ainda que esta tabela tenha uma coluna de nome `pk` que é chave primária dessa tabela, por fim, tome cada coluna par como não nula e impar como nula e assuma um `n` par. A implementação dessa DTO seria como segue:

```java
@Table(nome = "x")
@PrimaryKey(nome = "pk")
public class X extends AbstractDTO<X> implements DTO<X> {
    // variáveis e construtor

    @Column(nome = "c1", tipo = TipoDaColunaC1EmJava)
    @Getter
    public TipoDaColunaC1EmJava getC1() {
        // lógica para retornar c1
    }

    @Column(nome = "c1", tipo = TipoDaColunaC1EmJava)
    @Setter
    public void getC1(TipoDaColunaC1EmJava c1) {
        // lógica para setar c1 nessa dto
    }

    // ...

    @Column(nome = "cn", tipo = TipoDaColunaCnEmJava)
    @Getter
    public TipoDaColunaCnEmJava getCn() {
        // lógica para retornar cn
    }

    @Column(nome = "cn", tipo = TipoDaColunaCnEmJava)
    @Setter
    public void getCn(TipoDaColunaCnEmJava cn) {
        // lógica para setar cn nessa dto
    }

    @Column(nome = "pk", tipo = Long.class)
    @Getter
    public Long getId() {
        // lógica para pegar o id
    }

    @Column(nome = "pk", tipo = Long.class)
    @Setter
    public void setId(Long id) {
        // lógica para setar o id
    }
}

```

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
