create table t_user
(
    id              int(10) not null auto_increment,
    name            varchar(20),
    password        varchar(32),
    password_salt   varchar(10),
    real_name       varchar(20),
    email           varchar(40),
    status          bit(1),
    last_login_time timestamp,
    register_time   timestamp default current_timestamp,
    PRIMARY KEY (id)
) engine = innodb
  default charset = utf8;

create table t_permission
(
    id              int(10) not null auto_increment,
    name            varchar(20),
    url             varchar(50),
    type            int(2),
    order_num       int(3),
    pid             int(10),
    is_show         bit(1),
    permission_code varchar(70),
    pids            varchar(50),
    PRIMARY KEY (id)
) engine = innodb
  default charset = utf8;

create table t_role
(
    id          int(10) not null auto_increment,
    role_name   varchar(20),
    create_time timestamp default current_timestamp,
    primary key (id)
) engine = innodb
  default charset = utf8;

create table t_user_role
(
    id      int(10) not null auto_increment,
    user_id int(10),
    role_id int(10),
    primary key (id),
    index (user_id) using btree
) engine = innodb
  default charset = utf8;

create table t_role_permission
(
    id            int(10) not null auto_increment,
    role_id       int(10),
    permission_id int(10),
    primary key (id),
    index (permission_id) using btree
) engine = innodb
  default charset = utf8;
