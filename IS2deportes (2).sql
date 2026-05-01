
--Si cambias algo, tienes que hacer lo siguiente para actualizar las tablas :
--docker-compose down -v elimina el volumen con los datos viejos
--docker-compose up -d crea el volumen nuevo y ejecuta el SQL


CREATE TABLE Persona (
    id_persona INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    dni VARCHAR(20) UNIQUE NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY (id_persona)
);

CREATE TABLE Empleado (
    id_persona INT NOT NULL,
    salario DECIMAL(10, 2),
    PRIMARY KEY (id_persona),
    FOREIGN KEY (id_persona) REFERENCES Persona(id_persona)
);

CREATE TABLE Jugador (
    id_persona INT NOT NULL,
    pie_dominante VARCHAR(10),
    posicion VARCHAR(50),
    PRIMARY KEY (id_persona),
    FOREIGN KEY (id_persona) REFERENCES Persona(id_persona)
);

CREATE TABLE Entrenador (
    id_persona INT NOT NULL,
    num_temporadas INT,
    PRIMARY KEY (id_persona),
    FOREIGN KEY (id_persona) REFERENCES Empleado(id_persona)
);

CREATE TABLE Mantenimiento (
    id_persona INT NOT NULL,
    tipo_mantenimiento VARCHAR(100),
    PRIMARY KEY (id_persona),
    FOREIGN KEY (id_persona) REFERENCES Empleado(id_persona)
);


CREATE TABLE Equipo (
    id_equipo INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY (id_equipo)
);

CREATE TABLE Campo (
    id_campo INT NOT NULL AUTO_INCREMENT,
    ocupado BOOLEAN,
    tipo_superficie VARCHAR(50),
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY (id_campo)
);

CREATE TABLE Campo_Interno (
    id_campo INT NOT NULL,
    acondicionado  BOOLEAN,
    PRIMARY KEY (id_campo),
    FOREIGN KEY (id_campo) REFERENCES Campo(id_campo)
);

CREATE TABLE Campo_Externo (
    id_campo INT NOT NULL,
    clima VARCHAR(50),
    PRIMARY KEY (id_campo),
    FOREIGN KEY (id_campo) REFERENCES Campo(id_campo)
);

CREATE TABLE Partido (
    id_partido        INT  NOT NULL AUTO_INCREMENT,
    id_equipoLocal INT NOT NULL,
    id_equipoVisitante INT NOT NULL,
    fecha             DATE,
    goles_locales     INT  DEFAULT 0,
    goles_visitantes  INT  DEFAULT 0,
    id_campo          INT,
    activo            BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY (id_partido),
    FOREIGN KEY (id_campo) REFERENCES Campo(id_campo),
    FOREIGN KEY (id_equipoLocal) REFERENCES Equipo(id_equipo),
    FOREIGN KEY (id_equipoVisitante) REFERENCES Equipo(id_equipo)
);

--Relacion entre jugador y equipo (pertenece)
CREATE TABLE Pertenencia_Jugador (
    id_persona   INT  NOT NULL,
    id_equipo    INT  NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin    DATE,
    PRIMARY KEY (id_persona, id_equipo, fecha_inicio),
    FOREIGN KEY (id_persona) REFERENCES Jugador(id_persona),
    FOREIGN KEY (id_equipo)  REFERENCES Equipo(id_equipo)
);

-- Relacion entre Entrenador y Equipo (entrena)
CREATE TABLE Entrena (
    id_persona   INT  NOT NULL,
    id_equipo    INT  NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin    DATE,
    PRIMARY KEY (id_persona, id_equipo, fecha_inicio),
    FOREIGN KEY (id_persona) REFERENCES Entrenador(id_persona),
    FOREIGN KEY (id_equipo)  REFERENCES Equipo(id_equipo)
);

-- relacion entre Mantenimiento y Campo (se encarga)
CREATE TABLE Encargado_Mantenimiento (
    id_persona  INT NOT NULL,
    id_campo    INT NOT NULL,
    PRIMARY KEY (id_persona, id_campo),
    FOREIGN KEY (id_persona) REFERENCES Mantenimiento(id_persona),
    FOREIGN KEY (id_campo)   REFERENCES Campo(id_campo)
);

