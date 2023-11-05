CREATE DATABASE CL2;

CREATE TABLE tbl_Cliente(
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    apellidoMaterno VARCHAR(255) NOT NULL,
    apellidoPaterno VARCHAR(255) NOT NULL,
    nombres VARCHAR(255) NOT NULL
);

CREATE TABLE tbl_TipoCuenta(
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    moneda VARCHAR(255) NOT NULL
);

CREATE TABLE tbl_Cuenta (
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    activa BIT(1) NOT NULL,
    numeroCuenta VARCHAR(255) NOT NULL,
    saldo DOUBLE NOT NULL,
    cliente_id BIGINT,
    tipoCuenta BIGINT,
    FOREIGN KEY (cliente_id) REFERENCES tbl_Cliente(id),
    FOREIGN KEY (tipoCuenta) REFERENCES tbl_TipoCuenta(id)
);


CREATE TABLE tbl_Movimiento (
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    fecha DATE NOT NULL,
    monto DOUBLE NOT NULL,
    cuenta_id BIGINT NOT NULL,
    FOREIGN KEY (cuenta_id) REFERENCES tbl_Cuenta(id)
);

CREATE TABLE tbl_Roles (
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    activo BIT(1) NOT NULL,
    descripcion VARCHAR(255) NOT NULL
);

CREATE TABLE tbl_ClienteRol (
    Cliente_id BIGINT NOT NULL,
    roles_id BIGINT NOT NULL,
    FOREIGN KEY (Cliente_id) REFERENCES tbl_Cliente(id),
    FOREIGN KEY (roles_id) REFERENCES tbl_Roles(id)
);



SELECT * FROM tbl_Cliente;
