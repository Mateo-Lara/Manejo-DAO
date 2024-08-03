CREATE DATABASE Personal_IUD;

USE Personal_IUD;

CREATE TABLE Funcionarios (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    TipoIdentificacion VARCHAR(10),
    NumeroIdentificacion VARCHAR(20),
    Nombres VARCHAR(100),
    Apellidos VARCHAR(100),
    EstadoCivil VARCHAR(20),
    Sexo CHAR(1),
    Direccion VARCHAR(200),
    Telefono VARCHAR(15),
    FechaNacimiento DATE
);

CREATE TABLE GrupoFamiliar (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    IDFuncionario INT,
    NombreMiembro VARCHAR(100),
    Rol VARCHAR(50),
    FOREIGN KEY (IDFuncionario) REFERENCES Funcionarios(ID)
);

CREATE TABLE Educacion (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    IDFuncionario INT,
    Universidad VARCHAR(100),
    NivelEstudio VARCHAR(50),
    TituloEstudio VARCHAR(100),
    FOREIGN KEY (IDFuncionario) REFERENCES Funcionarios(ID)
);
