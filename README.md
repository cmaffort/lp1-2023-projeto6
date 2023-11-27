# lp1-2023-projeto6
Projeto Sistema de Gestão de Loja

[Link do Projeto](https://docs.google.com/document/d/1Urhv-Eu5dYAaQM0Zrv1x5qulNvwfK7s5U7tJtbRb6ow/edit#heading=h.gjdgxs)
<!-- Acesse o nosso [documento](https://docs.google.com/document/d/1Urhv-Eu5dYAaQM0Zrv1x5qulNvwfK7s5U7tJtbRb6ow/edit?usp=sharing) -->

## Da Generalização

A generalização feita em todas as camadas do sistema apoiam uma melhor integridade conceitual em todo código e
proporciona classes que implementam requerimentos recorrentes entre as classes de uma mesma camada. Isso pode ser feito,
em especial, por meio da reflexão de classes e aplicação de padrões de projeto como o builder, o template e o adapter,
principalmente.

### Das limitações

As tabelas não podem formar grafos que possuam um ciclo, no que diz respeito às ligações por chave estrangeira, pois, se
isso acontecer o sistema poderá entrar em loop.

Os campos anotados com @Column nas DTOs devem ter um tipo de retorno, se forem getters, ou receberem somente um
parâmetro, se forem setters, de um tipo compatível com os métodos `PreparedStatement#setObject` e `ResultSet#getObject`,
dentre esses é bom resaltar que para `blob` no banco o tipo deve ser `byte[]`, para `date` `java.sql.Date` e para
`datetime` `LocalDateTime`.

Toda DTO deve ter uma chave primária, ou id e esse deve ser do tipo `Long`.

A nomenclatura é limitada por enquanto, uma chave estrangeira deve ou ser a própria chave primária, no caso que
convenciono herança, caso não seja uma chave estrangeira para estabelecer herança ela deve ser nomeada como
`<nome_da_tabela>__fk`, onde `<nome_da_tabela>` é o nome da tabela que quer se estabelecer a ligação.

A generalização não joga erros específicos para colunas únicas, pois não tem conhecimento delas.

Não é possível usar a generalização como substituto para qualquer sql que possa querer usar para extrair dados do banco,
portanto, por vezes, é necessário implementar alguns métodos mais específicos de uma DAO, veja
[JDBCOperation](#JDBCOperation) para ver um modo facilitado de criar métodos usando JDBC em suas DAOs.

Só é possível usar essa generalização com o `MYSql` até o momento presente.

Uma tabela não pode ter mais de uma chave estrangeira para outra tabela.

A herança deve ter on delete cascade.

## DTOs

Todas as DTOs implementam a interface `DTO` que recebe como parâmetro de tipo a DTO que está sendo criada. A interface
`DTO` garante que toda DTO tenha métodos get e set para o id, métodos `toString` e `toMap`, métodos instanciadores e
um método `getManager` que retorna o `Manager` daquela DTO. O `Manager` de uma DTO é a classe que proporciona a reflexão
da DTO, possibilitando extrair de uma DTO a tabela a qual ela se refere, no banco, o nome de sua chave primária, as
colunas que a DTO possuí, as colunas não nulas daquela DTO, se as colunas não nulas estão todas preenchidas e os métodos
get e set daquela DTO.

A classe abstrata `AbstractDTO` tem como parâmetro de tipo a própria classe que a extende e implementa vários dos
métodos da interface `DTO`, deixando somente os métodos `getId` e `setId` a serem implementados. Desse modo a grande
maioria das DTOs herda de `AbstractDTO`.

Para cada coluna de uma DTO devem ser criados métodos get e set anotados, respectivamente, por `@Getter` e `@Setter`,
além de ambos terem que ser anotados com `@Column(nome = "<nome_da_coluna_no_banco_de_dados>", tipo =
<TipoCompativelComODoBancoDeDados>.class)`, se a coluna for não nula devem ser anotados com `@NotNull`. Toda DTO também
deve ser anotada com `@Table(nome = "<nome_da_tabela_no_banco_de_dados>")` e com `@PrimaryKey(nome =
<nome_da_chave_primaria_desta_tabela_no_banco_de_dados>)`.

### Criando DTOs

Suponha uma tabela `x` no banco de dados, com as colunas `c1`, `c2`, ..., `cn`, que não são chaves primárias ou
estrangeiras, assuma ainda que esta tabela tenha uma coluna de nome `pk` que é chave primária dessa tabela, por fim,
tome cada coluna par como não nula e impar como nula e assuma um `n` par. A implementação dessa DTO seria como segue:

```java
@Table(nome = "x")
@PrimaryKey(nome = "pk")
public class X extends AbstractDTO<X> implements DTO<X> {
    // variáveis e construtor

    @Column(nome = "c1", tipo = TipoDaColunaC1EmJava.class)
    @Getter
    public TipoDaColunaC1EmJava getC1() {
        // lógica para retornar c1
    }

    @Column(nome = "c1", tipo = TipoDaColunaC1EmJava.class)
    @Setter
    public void setC1(TipoDaColunaC1EmJava c1) {
        // lógica para setar c1
    }

    @Column(nome = "c2", tipo = TipoDaColunaC2EmJava.class)
    @NotNull
    @Getter
    public TipoDaColunaC2EmJava getC2() {
        // lógica para retornar c2
    }

    @Column(nome = "c2", tipo = TipoDaColunaC2EmJava.class)
    @NotNull
    @Setter
    public void setC1(TipoDaColunaC2EmJava c2) {
        // lógica para setar c2
    }

    // ...

    @Column(nome = "cn", tipo = TipoDaColunaCnEmJava.class)
    @NotNull
    @Getter
    public TipoDaColunaCnEmJava getCn() {
        // lógica para retornar cn
    }

    @Column(nome = "cn", tipo = TipoDaColunaCnEmJava.class)
    @NotNull
    @Setter
    public void setCn(TipoDaColunaCnEmJava cn) {
        // lógica para setar cn
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

Não se deve marcar o `id` com `@NotNull` uma vez que os services podem verificar por colunas não nulas no momento da
inserção e o `id`, nesse momento, seria nulo.

Podemos ter, em nossas tabelas, chaves estrangeiras para outras e por várias vezes queremos, ao invés de salvar somente
a chave, salvar a DTO da tabela relacionada, para que isso seja possível a DTO de uma tabela que armazena uma chave
estrangeira deve implementar quatro métodos, os relativos à coluna que são o get e set para o `Long` da chave e outros
dois que são os getters e setters da própria DTO, esses últimos devem ser anotados com `@Related(nome =
"<nome_da_tabela_relacionada>")`. Assuma agora que adicionamos à DTO `X` uma chave estrangeira para a tabela `y`, tal
que essa chave leva o nome de `y__fk` e é do tipo `bigint` no banco de dados. A implementação dos novos métodos na DTO
`X` se daria como segue:

```java
@Table(nome = "x")
@PrimaryKey(nome = "pk")
public class X extends AbstractDTO<X> implements DTO<X> {
    // variáveis e construtor

    // getters e setters das outras colunas
    
    @Related(nome = "y")
    @Getter
    public Y getY() {
        // lógica para retornar a DTO de Y
    }
    
    @Related(nome = "y")
    @Setter
    public void setY(Y y) {
        // lógica para setar o y
    }
    
    @Column(nome = "y__fk", tipo = Long.class)
    @Getter
    public Long getYAsLong() {
        // lógica para retornar y como Long
    }

    @Column(nome = "y__fk", tipo = Long.class)
    @Setter
    public void setYWithLong(Long y) {
        // lógica para setar y como Long
    }
}
```

Caso queira implementar uma herança entre duas tabelas a coluna que representa a chave estrangeira também é a chave
primária, ou seja, se uma tabela `a` herda de uma tabela `b` a tabela `a` tem uma coluna `pk` tal que essa coluna é a
chave primária de `a` e também é a chave estrangeira de `b`. Essa lógica é análoga nas DTOs, no lugar de uma coluna com
o sufixo `__fk` teremos somente uma coluna `pk` que é chave estrangeira para a tabela `b`. O acesso para os membros da
DTO `B`, referente à tabela `b`, no entanto, não se dá por herança, mas por composição, e o que foi feito para contornar
isso nesse projeto foi implementar uma interface adapter com os métodos `default` da DTO herdada. 

## DAOs

Todas as DAOs implementam uma interface correspondente àquela DAO e todas as IDAOs herdam uma interface `IDAO` que
recebe como parâmetro de tipo uma `DTO` que é referente à aquela DAO, esse parâmetro recebe o nome de
`DataTransferObject`. Para saber qual tabela deve ser modificada é olhado a anotação `@Table` da `DTO` correspondente e
para saber quais colunas que devem ser modificadas são usadas as anotações `@Column` e, a não ser que sejam
especificadas quais colunas devem ser alteradas, todas são, por exceção do id na maioria dos casos.
`PersistenceException` é lançada sempre que ocorre um erro no sql, por exemplo, se ao consultar por id for passado um id
que não existe. Deve ser garantido em todos os métodos que as DTOs de retorno sempre terão seus campos relacionados
preenchidos. A `IDAO` genérica define alguns métodos que toda DAO deve ter, esses são:

- `Long inserir(DataTransferObject dto) throws PersistenceException` que insere a `dto` passada no banco e retorna o seu
id, além de atribuí-lo na própria `dto` passada.

- `boolean alterar(DataTransferObject dto) throws PersistenceException` que altera a `dto` passada, o critério para
selecionar qual linha deve ser alterada é o `id` da `dto`, portanto esse não pode ser nulo. Retorna `true` se a `dto`
foi alterada.

- `boolean remover(DataTransferObject dto) throws PersistenceException` que remove do banco a `dto` com o `id` que
corresponder ao da `dto` passada, portanto o `id` da `dto` não deve ser nulo.

- `List<DataTransferObject> listar() throws PersistenceException` que retorna uma lista de todas as DTOs referentes
àquela DAO. A ordem de retorno, por padrão, pelos ids.

- `DataTransferObject consultarPorId(Long id) throws PersistenceException` que retorna a `dto` que possuir o id
correspondente ao passado.

- `List<DataTransferObject> consultarPorIdIn(Long... ids) throws PersistenceException` que retorna a lista das DTOs com
o id correspondente. A ordem de retorno, por padrão, corresponderá à ordem dos ids passados, exceto existam duplicatas.

- `List<DataTransferObject> filtrar(DataTransferObject dto, String... columnsFilter) throws PersistenceException` que 
filtra todas as DTOs com as colunas congruentes com as colunas especificadas em `columnsFilter` da `dto` passada, a
ordem não é garantida.

- `List<DataTransferObject> filtrarRelated(DTO... related) throws PersistenceException` que filtra as DTOs que tenham
relação com todas as outras DTOs passadas em `related` simultaneamente, a relação pode ser de herança ou não e pode
estar em qualquer das tabelas que tenham que se relacionar, a relativa a essa DAO e todas as outras passadas. A ordem
padrão é por id. Observe que se dois relacionados forem do mesmo tipo não haverá nenhum resultado, pois não há como uma
DTO ter ambas relações simultaneamente.

- `List<DataTransferObject> filtrarRelatedIn(DTO<?>... related) throws PersistenceException` que filtra todas as DTOs
que tenham qualquer um dos relacionados. A ordem padrão corresponde ao relacionado para a DTO.


### Criando DAOs

O primeiro passo para criar uma DAO é criar sua interface, resgatemos a DTO `X` especificada anteriormente e mostremos
como ficaria a interface de sua DAO, assumindo que, até então, ela não precise de nenhum método além dos especificados
na `IDAO`, como segue:

```java
public interface IXDAO extends IDAO<X> {
}
```

Para implementarmos `IXDAO` podemos usar como auxiliar a classe abstrata `AbstractDAO` que implementa todos os métodos
da interface `IDAO`, para que `AbstractDAO` seja útil basta implementar os métodos `AbstractDAO#getDTO` que deve
retornar uma instância da DTO referente a essa DAO e `AbstractDAO#getDAOs` que deve retornar um mapa do nome da tabela
para a DAO correspondente, isso para cada uma das tabelas relacionadas. A implementação seria como segue:

```java
public class XDAO extends AbstractDAO<X> implements IXDAO {
    @Override
    protected X getDTO() {
        return new X();
    }

    @Override
    protected Map<String, IDAO> getDAOs() {
        return Map.ofEntries(
                Map.entry("y", new YDAO())
        );
    }
}
```

No caso de termos uma DAO referente a uma DTO que herda de outra DTO podemos usar a classe abstrata `InheritDAO`, que
herda de `AbstractDAO`, para nos auxiliar com detalhes da herança, esses detalhes se apresentam nos métodos `inserir`,
`alterar` e `remover`. O método `inserir` se diferencia por, ao inserir a DTO filha, também insere a pai. O método
`alterar` altera ambas as DTOs, pai e filha. Por fim, o método `remover` remove a DTO pai e, por on delete cascade,
deleta a filha. Para exemplificarmos como se implementaria uma DAO que usa `InheritDAO` assuma que a DTO `X` herde de
`Y`, de forma que `XDAO` ficaria:

```java
public class XDAO extends InheritDAO<X, Y> implements IXDAO {
    @Override
    protected X getDTO() {
        return new X();
    }

    @Override
    protected Map<String, IDAO> getDAOs() {
        return Map.ofEntries(
                Map.entry("y", new YDAO())
        );
    }

    @Override
    protected IYDAO getSuperDAO() {
        return new YDAO();
    }

    @Override
    protected Y getInheritDTOInstance() {
        return new Y();
    }

    @Override
    protected Y callGetSuper(X dto) {
        return dto.getY();
    }
}
```

Da personalização dos métodos da classe `AbstractDAO`, podemos para cada método mudar o sql usado e o parâmetro para a
ordem das colunas retornadas. De mudar a ordem, em especial, podemos sobreescrever o método
`AbstractDAO#getOrderByPriority`, que deve retornar uma lista das colunas especificando a ordem da mais importante para
a menos.

#### JDBCOperation

A classe `JDBCOperation` facilita o uso do JDBC por meio de uma classe buider `JDBCOperation.Builder` que recebe como
parâmetro de tipo uma DTO. E atribui os parâmetros necessários para gerar um `PreparedStatement` e, se quiser, um
`ResultSet`, por fim pode-se terminar retornando os dados em uma dto, em um mapa, não retornando, retornando o id,
retornando uma lista de ids, entre outros. Suponha que a DTO `X` precise de outro método para consultar por onde a
coluna `c1 == cn`, a implementação seria como segue:

```java
public class XDAO extends InheritDAO<X, Y> implements IXDAO {
    // Outros métodos
    
    protected List<List<String>> getColumnsResultSetC1Cn() {
        return Arrays.asList("c1", "c2", /*...,*/ "cn");
    }

    protected String getSqlC1Cn() {
        return """
                SELECT c1, c2, ..., cn FROM x
                WHERE c1 = cn""";
    }

    public ContratoAssinado filterContratoAssinadoAtivo(Usuario usuario) throws PersistenceException {
        List<List<String>> columnsResultSet = getColumnsResultSetAssinadoAtivo();
        String sql = getSqlC1Cn();

        return fillFKedDTOs(
                new JDBCOperation.Builder<>(getDTO())
                        .setSql(sql)
                        .setColumnsResultSet(columnsResultSet)
                        .getInstances()
        );
    }
}
```

O método `fillFKedDTOs` completa todas as colunas relacionas consultando os seus dados.

## Sevices

O objetivo de um service é verificar se os campos de uma DTO estão corretos antes de usar a DAO para las modificar no
banco de dados. A interface `IManter` define alguns métodos padrões, congruentes aos da interface `IDAO`, que todo 
service deve implementar. Para facilitar essa implementação temos a classe `AbstractManter` que implementa esses métodos
verificando se os campos anotados com `@NotNull` estão preenchidos e se os campos passados como relacionados, realmente,
são relacionados.

### Criando services

Para criar um service basta implementar `IManter`, podendo usar o auxílio de `AbstractManter`, definindo na interface
outros métodos que podem ser necessários e implementando-os na classe concreta.

Em caso de dúvidas olhe as implementações do sistema.

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
