CREATE TABLE Persona (
    id_persona INT PRIMARY KEY,
    nombre     VARCHAR(100) NOT NULL,
    telefono   VARCHAR(20),
    dni        VARCHAR(20) UNIQUE NOT NULL,
    activo     BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE Empleado (
    id_persona INT PRIMARY KEY,
    salario    DECIMAL(10, 2),
    activo     BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (id_persona) REFERENCES Persona(id_persona)
);

CREATE TABLE Jugador (
    id_persona     INT PRIMARY KEY,
    pie_dominante  VARCHAR(10),
    posicion       VARCHAR(50),
    activo         BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (id_persona) REFERENCES Persona(id_persona)
);

CREATE TABLE Entrenador (
    id_persona     INT PRIMARY KEY,
    num_temporadas INT,
    activo         BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (id_persona) REFERENCES Empleado(id_persona)
);

CREATE TABLE Mantenimiento (
    id_persona        INT PRIMARY KEY,
    tipo_mantenimiento VARCHAR(100),
    activo            BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (id_persona) REFERENCES Empleado(id_persona)
);

CREATE TABLE Equipo (
    id_equipo INT PRIMARY KEY AUTO_INCREMENT,
    nombre    VARCHAR(100) NOT NULL,
    activo    BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE Campo (
    id_campo        INT PRIMARY KEY,
    ocupado         BOOLEAN,
    tipo_superficie VARCHAR(50),
    activo          BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE Campo_Interno (
    id_campo      INT PRIMARY KEY,
    acondicionado BOOLEAN,
    activo        BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (id_campo) REFERENCES Campo(id_campo)
);

CREATE TABLE Campo_Externo (
    id_campo INT PRIMARY KEY,
    clima    VARCHAR(50),
    activo   BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (id_campo) REFERENCES Campo(id_campo)
);

CREATE TABLE Partido (
    id_partido       INT PRIMARY KEY,
    fecha            DATE,
    goles_locales    INT DEFAULT 0,
    goles_visitantes INT DEFAULT 0,
    id_campo         INT,
    activo           BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (id_campo) REFERENCES Campo(id_campo)
);

CREATE TABLE Pertenencia_Jugador (
    id_persona   INT,
    id_equipo    INT,
    fecha_inicio DATE,
    fecha_fin    DATE,
    activo       BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY (id_persona, id_equipo, fecha_inicio),
    FOREIGN KEY (id_persona) REFERENCES Jugador(id_persona),
    FOREIGN KEY (id_equipo)  REFERENCES Equipo(id_equipo)
);

CREATE TABLE Entrena (
    id_persona   INT,
    id_equipo    INT,
    id_campo     INT,
    fecha_inicio DATE,
    fecha_fin    DATE,
    activo       BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY (id_persona, id_equipo, id_campo, fecha_inicio),
    FOREIGN KEY (id_persona) REFERENCES Entrenador(id_persona),
    FOREIGN KEY (id_equipo)  REFERENCES Equipo(id_equipo),
    FOREIGN KEY (id_campo)   REFERENCES Campo(id_campo)
);

CREATE TABLE Encargado_Mantenimiento (
    id_persona INT,
    id_campo   INT,
    activo     BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY (id_persona, id_campo),
    FOREIGN KEY (id_persona) REFERENCES Mantenimiento(id_persona),
    FOREIGN KEY (id_campo)   REFERENCES Campo(id_campo)
);

CREATE TABLE Equipo_Participa_Partido (
    id_equipo  INT,
    id_partido INT,
    es_local   BOOLEAN,
    activo     BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY (id_equipo, id_partido),
    FOREIGN KEY (id_equipo)  REFERENCES Equipo(id_equipo),
    FOREIGN KEY (id_partido) REFERENCES Partido(id_partido)
);