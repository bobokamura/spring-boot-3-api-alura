create table usuario_role(

    usuario_id bigint not null,
    role_id bigint not null,

    primary key(usuario_id, role_id)

);