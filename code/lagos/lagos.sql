create table periodicidade
(
    periodo                     int not null,
    quantidade_dias_por_periodo int not null,
    pk                          bigint auto_increment
        primary key
);

create table pessoa
(
    nome       varchar(128) not null,
    sobrenome  varchar(256) null,
    nascimento date         not null,
    email      varchar(128) not null,
    telefone   bigint       null,
    pk         bigint auto_increment
        primary key
);

create table usuario
(
    tipo     int           not null,
    username varchar(256)  not null,
    senha    varchar(1024) not null,
    pk       bigint        not null
        primary key,

    foreign key (pk) references pessoa (pk)
        on delete cascade
);

create table endereco
(
    cep    int not null,
    numero int null,
    pk     bigint auto_increment
        primary key
);

create table cartao
(
    numero   bigint not null
        primary key,
    bandeira int    not null,

    endereco__fk bigint not null,
    usuario__fk  bigint not null,
    foreign key (endereco__fk) references endereco (pk)
        on delete cascade,
    foreign key (usuario__fk) references usuario (pk)
        on delete cascade
);

create table loja
(
    pk bigint auto_increment
        primary key,

    endereco__fk bigint null,
    usuario__fk  bigint not null,
    foreign key (endereco__fk) references endereco (pk),
    foreign key (usuario__fk) references usuario (pk)
        on delete cascade
);

create table configuracoes_de_interface
(
    nome_da_empresa varchar(256) null,
    logo            blob         null,
    cor_base        varchar(64)  null,
    pk              bigint       not null
        primary key,
    foreign key (pk) references usuario (pk)
        on delete cascade
);

create table contrato
(
    ativo           tinyint(1)    not null,
    descricao       varchar(4096) null,
    preco           double        not null,
    documentos      blob          null,
    taxa_de_multa   float         null,
    numero_de_lojas int           not null,
    data_de_criacao date          not null,
    pk              bigint auto_increment
        primary key,

    periodicidade__fk bigint not null,
    foreign key (periodicidade__fk) references periodicidade (pk)
        on delete cascade
);

create table contrato_assinado
(
    vigente             tinyint(1) not null,
    data_de_contratacao date       not null,
    cancelado           tinyint(1) not null,
    pk                  bigint auto_increment
        primary key,

    usuario__fk  bigint null,
    contrato__fk bigint not null,
    foreign key (usuario__fk) references usuario (pk),
    foreign key (contrato__fk) references contrato (pk)
        on delete cascade
);

create table configuracoes_de_venda
(
    limite_de_desconto    float  null,
    taxa_de_juros_ao_mes  float  null,
    metodos_aceitos       blob   null,
    bandeiras_aceitas     blob   null,
    porcentagem_comissao  float  null,
    loja__fk              bigint not null
        primary key,
    foreign key (loja__fk) references loja (pk)
        on delete cascade
);

create table compra
(
    data_de_chegada date null,
    data_de_compra  date not null,
    pk              bigint auto_increment
        primary key,

    loja__fk bigint not null,
    foreign key (loja__fk) references loja (pk)
        on delete cascade
);

create table historico_vet
(
    tipo int      not null,
    data datetime not null,
    pk   bigint auto_increment
        primary key,

    loja__fk bigint not null,
    foreign key (loja__fk) references loja (pk)
        on delete cascade
);

create table produto
(
    codigo     varchar(128)  not null,
    nome       varchar(1024) not null,
    quantidade int           not null,
    preco      double        not null,
    pk         bigint auto_increment
        primary key,
    unique (codigo),

    loja__fk bigint not null,
    foreign key (loja__fk) references loja (pk)
        on delete cascade
);

create table item
(
    preco      double not null,
    quantidade int    not null,
    pk         bigint auto_increment
        primary key,

    historioco_vet__fk bigint not null,
    produto__fk        bigint null,
    foreign key (historioco_vet__fk) references historico_vet (pk)
        on delete cascade,
    foreign key (produto__fk) references produto (pk)
);

create table produto_compra
(
    quantidade     int not null,
    preco_unitario int not null,
    pk             bigint auto_increment
        primary key,

    compra__fk  bigint not null,
    produto__fk bigint null,
    foreign key (compra__fk) references compra (pk)
        on delete cascade,
    foreign key (produto__fk) references produto (pk)
);

create table promocao
(
    porcentagem float      not null,
    ativa       tinyint(1) not null,
    data_inicio date       not null,
    pk          bigint auto_increment
        primary key,

    periodicidade__fk bigint not null,
    loja__fk          bigint not null,
    foreign key (periodicidade__fk) references periodicidade (pk)
        on delete cascade,
    foreign key (loja__fk) references loja (pk)
        on delete cascade
);

create table promocao_de_fidelidade
(
    min_vendas  int        not null,
    ativa       tinyint(1) not null,
    porcentagem float      not null,
    data_inicio date       not null,
    pk          bigint auto_increment
        primary key,

    periodicidade__fk bigint not null,
    loja__fk          bigint not null,
    foreign key (periodicidade__fk) references periodicidade (pk)
        on delete cascade,
    foreign key (loja__fk) references loja (pk)
        on delete cascade
);

create table promocoes__produtos
(
    pk bigint auto_increment
        primary key,

    produto__fk  bigint not null,
    promocao__fk bigint not null,
    foreign key (produto__fk) references produto (pk)
        on delete cascade,
    foreign key (promocao__fk) references promocao (pk)
        on delete cascade
);

create table promocoes_de_fidelidade__produtos
(
    pk bigint auto_increment
        primary key,

    produto__fk                bigint not null,
    promocao_de_fidelidade__fk bigint not null,
    foreign key (produto__fk) references produto (pk)
        on delete cascade,
    foreign key (promocao_de_fidelidade__fk) references promocao_de_fidelidade (pk)
        on delete cascade
);

create table cliente
(
    instagram varchar(128) null,
    cadastro  date         not null,

    pk       bigint not null
        primary key,
    loja__fk bigint not null,
    foreign key (pk) references pessoa (pk)
        on delete cascade,
    foreign key (loja__fk) references loja (pk)
        on delete cascade
);

create table funcionario
(
    salario             double     not null,
    ativo               tinyint(1) not null,
    tipo_funcionario    int        not null,
    pk                  bigint     not null
        primary key,

    loja__fk            bigint not null,
    foreign key (pk) references pessoa (pk)
        on delete cascade,
    foreign key (loja__fk) references loja (pk)
        on delete cascade
);

create table usuario_loja
(
    username varchar(128)  not null,
    senha    varchar(1024) not null,
    pk       bigint        not null
        primary key,

    foreign key (pk) references funcionario (pk)
        on delete cascade
);

create table caixa
(
    aberto            tinyint(1) not null,
    dinheiro_em_caixa double     not null,
    pk                bigint auto_increment
        primary key,

    usuario_loja__fk bigint not null,
    loja__fk         bigint not null,
    foreign key (usuario_loja__fk) references usuario_loja (pk),
    foreign key (loja__fk) references loja (pk)
        on delete cascade
);

create table fluxo_de_caixa
(
    dinheiro_em_caixa double   not null,
    tipo              int      not null,
    hora              datetime not null,
    pk                bigint auto_increment
        primary key,

    caixa__fk bigint not null,
    foreign key (caixa__fk) references caixa (pk)
        on delete cascade
);

create table venda
(
    desconto           float null,
    numero_de_parcelas int   null,

    pk               bigint not null
        primary key,
    caixa__fk bigint not null,
    funcionario__fk  bigint null,
    cliente__fk      bigint null,
    loja__fk         bigint not null,
    foreign key (pk) references historico_vet (pk),
    foreign key (caixa__fk) references caixa (pk),
    foreign key (funcionario__fk) references funcionario (pk),
    foreign key (cliente__fk) references cliente (pk),
    foreign key (loja__fk) references loja (pk)
        on delete cascade
);

create table promocoes__vendas
(
    pk bigint auto_increment
        primary key,

    promocao__fk bigint not null,
    venda__fk    bigint not null,
    foreign key (promocao__fk) references promocao (pk),
    foreign key (venda__fk) references venda (pk)
        on delete cascade
);

create table promocoes_de_fidelidade__vendas
(
    pk bigint auto_increment
        primary key,

    promocao_de_fidelidade__fk bigint not null,
    venda__fk                  bigint not null,
    foreign key (promocao_de_fidelidade__fk) references promocao_de_fidelidade (pk),
    foreign key (venda__fk) references venda (pk)
        on delete cascade
);
