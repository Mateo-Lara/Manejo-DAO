package DAO;

import Interfaces.DAOFuncionario;
import Modelos.Funcionario;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOFuncionarioImpl extends Conexion implements DAOFuncionario{

    @Override
 public void crear(Funcionario funcionario) throws Exception {
    try {
        this.conectar();
        String sql = "INSERT INTO funcionarios (TipoIdentificacion, NumeroIdentificacion, Nombres, Apellidos, EstadoCivil, Sexo, Direccion, Telefono, FechaNacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st = this.conexion.prepareStatement(sql);
       
        st.setString(1, funcionario.getTipoIdentificacion());
        st.setString(2, funcionario.getNumeroIdentificacion());
        st.setString(3, funcionario.getNombres());
        st.setString(4, funcionario.getApellidos());
        st.setString(5, funcionario.getEstadoCivil());
        st.setString(6, String.valueOf(funcionario.getSexo())); 
        st.setString(7, funcionario.getDireccion());
        st.setString(8, funcionario.getTelefono());
        st.setDate(9, new java.sql.Date(funcionario.getFechaNacimiento().getTime()));

        st.executeUpdate();
    } catch (Exception e) {
        throw e;
    } finally {
        this.cerrar();
    }
}

@Override
public void editar(Funcionario funcionario) throws Exception {
    try {
        this.conectar();
        String sql = "UPDATE Funcionarios SET TipoIdentificacion=?, NumeroIdentificacion=?, Nombres=?, Apellidos=?, EstadoCivil=?, Sexo=?, Direccion=?, Telefono=?, FechaNacimiento=? WHERE ID=?";
        PreparedStatement st = this.conexion.prepareStatement(sql);
        
        st.setString(1, funcionario.getTipoIdentificacion());
        st.setString(2, funcionario.getNumeroIdentificacion());
        st.setString(3, funcionario.getNombres());
        st.setString(4, funcionario.getApellidos());
        st.setString(5, funcionario.getEstadoCivil());
        st.setString(6, String.valueOf(funcionario.getSexo()));
        st.setString(7, funcionario.getDireccion());
        st.setString(8, funcionario.getTelefono());
        st.setDate(9, new java.sql.Date(funcionario.getFechaNacimiento().getTime()));
        st.setInt(10, funcionario.getID());

        st.executeUpdate();
    } catch (SQLException e) {
        throw e;
    } finally {
        this.cerrar();
    }
}


    @Override
public void eliminar(Funcionario funcionario) throws Exception {
    try {
        this.conectar();
        String sql = "DELETE FROM Funcionarios WHERE ID=?";
        PreparedStatement st = this.conexion.prepareStatement(sql);

        st.setInt(1, funcionario.getID());

        st.executeUpdate();
    } catch (SQLException e) {
        throw e;
    } finally {
        this.cerrar();
    }
}


 @Override
public List<Funcionario> listar() throws Exception {
    List<Funcionario> funcionarios = new ArrayList<>();

    try {
        String sql = "SELECT * FROM Funcionarios";
        PreparedStatement st = this.conexion.prepareStatement(sql);

        // Ejecuta la consulta SELECT
        ResultSet rs = st.executeQuery();

        // Recorre el conjunto de resultados y crea objetos Funcionario
        while (rs.next()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setID(rs.getInt("ID"));
            funcionario.setTipoIdentificacion(rs.getString("TipoIdentificacion"));
            funcionario.setNumeroIdentificacion(rs.getString("NumeroIdentificacion"));
            funcionario.setNombres(rs.getString("Nombres"));
            funcionario.setApellidos(rs.getString("Apellidos"));
            funcionario.setEstadoCivil(rs.getString("EstadoCivil"));
            funcionario.setSexo(rs.getString("Sexo").charAt(0));
            funcionario.setDireccion(rs.getString("Direccion"));
            funcionario.setTelefono(rs.getString("Telefono"));
            funcionario.setFechaNacimiento(rs.getDate("FechaNacimiento"));

            funcionarios.add(funcionario);
        }
    } catch (SQLException e) {
        throw e;
    } finally {
        this.cerrar();
    }

    return funcionarios;
}
}

