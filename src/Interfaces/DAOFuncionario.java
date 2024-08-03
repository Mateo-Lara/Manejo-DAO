package Interfaces;

import Modelos.Funcionario;
import java.util.List;
public interface DAOFuncionario {
    
    public void crear(Funcionario funcionario) throws Exception;
    public void editar(Funcionario funcionario) throws Exception;
    public void eliminar(Funcionario funcionario) throws Exception;
    public List<Funcionario> listar() throws Exception;
}
