 CREATE TABLE CLIENTE(
id INT NOT NULL PRIMARY KEY,
nombre VARCHAR(150) NOT NULL,
nit VARCHAR(150) NOT NULL,
email VARCHAR(150) NOT NULL
);

CREATE TABLE VENTA(
id INT NOT NULL PRIMARY KEY,
fecha DATE NOT NULL,
id_cliente int not null,
foreign key(id_cliente) REFERENCES ClIENTE(id) 
);

CREATE TABLE PRODUCTO(
id INT NOT NULL PRIMARY KEY,
nombre VARCHAR(150) NOT NULL,
stock INT NOT NULL,
precio FLOAT NOT NULL,
costo FLOAT NOT NULL
);
CREATE TABLE VENTADETALLE(
id INT NOT NULL PRIMARY KEY,
id_producto INT NOT NULL ,
id_venta INT NOT NULL ,
precio_unit FLOAT NOT NULL,
cantidad INT NOT NULL,
foreign key(id_producto) REFERENCES PRODUCTO(id) ,
foreign key(id_venta) REFERENCES VENTA(id)

);