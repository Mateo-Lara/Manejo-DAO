package Formulario;
import DAO.Conexion;
import DAO.DAOFuncionarioImpl;
import Interfaces.DAOFuncionario;
import Modelos.Funcionario;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class Funcionarios extends javax.swing.JFrame {
    Conexion con = new Conexion();
    Connection conet;
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    int idc;
    public Funcionarios() {
        initComponents();
        consultarFuncionarios();
    }

 public void consultarFuncionarios() {
    try {
        conet = con.conectar();

        String query = "SELECT * FROM funcionarios";
        st = conet.createStatement();
        rs = st.executeQuery(query);

        DefaultTableModel modelo = (DefaultTableModel) DataBase.getModel();
        modelo.setRowCount(0);  

        while (rs.next()) {
            modelo.addRow(new Object[] {
                rs.getInt("ID"),
                rs.getString("TipoIdentificacion"),
                rs.getString("NumeroIdentificacion"),
                rs.getString("Nombres"),
                rs.getString("Apellidos"),
                rs.getString("EstadoCivil"),
                rs.getString("Sexo"),
                rs.getString("Direccion"),
                rs.getString("Telefono"),
                rs.getDate("FechaNacimiento")
            });
        }
    } catch (SQLException e) {
    } finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
            }
        }
        con.cerrar();
    }
}

 private void cargarTablaFuncionarios() {
    DefaultTableModel modelo = (DefaultTableModel) DataBase.getModel();
    
    // Limpia la tabla antes de cargar los nuevos datos
    modelo.setRowCount(0);

    try {
        conet = con.conectar();

        String query = "SELECT * FROM funcionarios";
        st = conet.createStatement();
        rs = st.executeQuery(query);
 
        while (rs.next()) {
            Object[] fila = {
                rs.getInt("ID"),
                rs.getString("TipoIdentificacion"),
                rs.getString("NumeroIdentificacion"),
                rs.getString("Nombres"),
                rs.getString("Apellidos"),
                rs.getString("EstadoCivil"),
                rs.getString("Sexo"),
                rs.getString("Direccion"),
                rs.getString("Telefono"),
                rs.getString("FechaNacimiento")
            };
            modelo.addRow(fila);
        }

        rs.close();
        st.close();
        conet.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al cargar los funcionarios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void limpiarCampos() {
    TextID.setText("");
    TextIdentificacion.setText("");
    TextNumIden.setText("");
    TextNombre.setText("");
    TextApellidos.setText("");
    TextEstadoCivil.setText("");
    TextSexo.setText("");
    TextDirecion.setText("");
    TextTelefono.setText("");
    TextFechaNaci.setText("");
}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ID = new javax.swing.JLabel();
        Identificacion = new javax.swing.JLabel();
        NumIdentificacion = new javax.swing.JLabel();
        Nombres = new javax.swing.JLabel();
        Apellidos = new javax.swing.JLabel();
        EstadoCivil = new javax.swing.JLabel();
        Sexo = new javax.swing.JLabel();
        Direccion = new javax.swing.JLabel();
        Telefono = new javax.swing.JLabel();
        FechaNaci = new javax.swing.JLabel();
        TextIdentificacion = new javax.swing.JTextField();
        TextNumIden = new javax.swing.JTextField();
        TextNombre = new javax.swing.JTextField();
        TextApellidos = new javax.swing.JTextField();
        TextDirecion = new javax.swing.JTextField();
        TextTelefono = new javax.swing.JTextField();
        TextFechaNaci = new javax.swing.JTextField();
        TextID = new javax.swing.JTextField();
        TextEstadoCivil = new javax.swing.JTextField();
        TextSexo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        AgregarBoton = new javax.swing.JButton();
        ModificarBoton = new javax.swing.JButton();
        EliminarBoton = new javax.swing.JButton();
        VacioBoton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DataBase = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Funcionarios");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        ID.setText("ID");

        Identificacion.setText("Identificación");

        NumIdentificacion.setText("Número de identificación");

        Nombres.setText("Nombres");

        Apellidos.setText("Apellidos");

        EstadoCivil.setText("Estado civil");

        Sexo.setText("Sexo");

        Direccion.setText("Dirección");

        Telefono.setText("Teléfono");

        FechaNaci.setText("Fecha de nacimiento");

        TextFechaNaci.setText("yyyy-MM-dd");

        TextID.setEditable(false);
        TextID.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ID)
                    .addComponent(Identificacion)
                    .addComponent(NumIdentificacion)
                    .addComponent(Nombres)
                    .addComponent(Apellidos)
                    .addComponent(EstadoCivil)
                    .addComponent(Sexo)
                    .addComponent(Direccion)
                    .addComponent(Telefono)
                    .addComponent(FechaNaci))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextNumIden)
                    .addComponent(TextNombre)
                    .addComponent(TextApellidos)
                    .addComponent(TextDirecion)
                    .addComponent(TextFechaNaci)
                    .addComponent(TextTelefono)
                    .addComponent(TextIdentificacion)
                    .addComponent(TextID)
                    .addComponent(TextEstadoCivil)
                    .addComponent(TextSexo))
                .addGap(529, 529, 529))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID)
                    .addComponent(TextID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Identificacion)
                    .addComponent(TextIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumIdentificacion)
                    .addComponent(TextNumIden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombres)
                    .addComponent(TextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Apellidos)
                    .addComponent(TextApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EstadoCivil)
                    .addComponent(TextEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sexo)
                    .addComponent(TextSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Direccion)
                    .addComponent(TextDirecion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Telefono)
                    .addComponent(TextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FechaNaci)
                    .addComponent(TextFechaNaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones"));

        AgregarBoton.setText("Agregar");
        AgregarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarBotonActionPerformed(evt);
            }
        });

        ModificarBoton.setText("Modificar");
        ModificarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarBotonActionPerformed(evt);
            }
        });

        EliminarBoton.setText("Eliminar");
        EliminarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarBotonActionPerformed(evt);
            }
        });

        VacioBoton.setText("Vacio");
        VacioBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VacioBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AgregarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(ModificarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(EliminarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(VacioBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(EliminarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VacioBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ModificarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgregarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Base de datos"));

        DataBase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TipoIdentificacion", "NumeroIdentificacion", "Nombres", "Apellidos", "EstadoCivil", "Sexo", "Direccion", "Telefono", "FechaNacimiento"
            }
        ));
        DataBase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataBaseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DataBase);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(395, 395, 395)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarBotonActionPerformed
    try {
        String tipoIdentificacion = TextIdentificacion.getText();
        String numeroIdentificacion = TextNumIden.getText();
        String nombres = TextNombre.getText();
        String apellidos = TextApellidos.getText();
        String estadoCivil = TextEstadoCivil.getText();
        char sexo = TextSexo.getText().charAt(0); 
        String direccion = TextDirecion.getText();
        String telefono = TextTelefono.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = dateFormat.parse(TextFechaNaci.getText());
        
        Funcionario nuevoFuncionario = new Funcionario();
        nuevoFuncionario.setTipoIdentificacion(tipoIdentificacion);
        nuevoFuncionario.setNumeroIdentificacion(numeroIdentificacion);
        nuevoFuncionario.setNombres(nombres);
        nuevoFuncionario.setApellidos(apellidos);
        nuevoFuncionario.setEstadoCivil(estadoCivil);
        nuevoFuncionario.setSexo(sexo);
        nuevoFuncionario.setDireccion(direccion);
        nuevoFuncionario.setTelefono(telefono);
        nuevoFuncionario.setFechaNacimiento(fechaNacimiento);

        DAOFuncionarioImpl funcionarioDAO = new DAOFuncionarioImpl();
        funcionarioDAO.crear(nuevoFuncionario);
        
        limpiarCampos();
        cargarTablaFuncionarios();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al agregar el funcionario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }    }//GEN-LAST:event_AgregarBotonActionPerformed

    private void ModificarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarBotonActionPerformed
        try {
        int id = Integer.parseInt(TextID.getText());
        String tipoIdentificacion = TextIdentificacion.getText();
        String numeroIdentificacion = TextNumIden.getText();
        String nombres = TextNombre.getText();
        String apellidos = TextApellidos.getText();
        String estadoCivil = TextEstadoCivil.getText();
        char sexo = TextSexo.getText().charAt(0);
        String direccion = TextDirecion.getText();
        String telefono = TextTelefono.getText();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = dateFormat.parse(TextFechaNaci.getText());

        Funcionario funcionario = new Funcionario();
        funcionario.setID(id);
        funcionario.setTipoIdentificacion(tipoIdentificacion);
        funcionario.setNumeroIdentificacion(numeroIdentificacion);
        funcionario.setNombres(nombres);
        funcionario.setApellidos(apellidos);
        funcionario.setEstadoCivil(estadoCivil);
        funcionario.setSexo(sexo);
        funcionario.setDireccion(direccion);
        funcionario.setTelefono(telefono);
        funcionario.setFechaNacimiento(fechaNacimiento);
        
        DAOFuncionario dao = new DAOFuncionarioImpl();
        dao.editar(funcionario);

        limpiarCampos();
        cargarTablaFuncionarios();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al editar el funcionario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }    }//GEN-LAST:event_ModificarBotonActionPerformed

    private void VacioBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VacioBotonActionPerformed
    limpiarCampos();
    }//GEN-LAST:event_VacioBotonActionPerformed

    private void DataBaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataBaseMouseClicked
int fila = DataBase.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(null, "No se seleccionó fila");
    } else {
        idc = Integer.parseInt(DataBase.getValueAt(fila, 0).toString());
        String tipoIdentificacion = DataBase.getValueAt(fila, 1).toString();
        String numeroIdentificacion = DataBase.getValueAt(fila, 2).toString();
        String nombres = DataBase.getValueAt(fila, 3).toString();
        String apellidos = DataBase.getValueAt(fila, 4).toString();
        String estadoCivil = DataBase.getValueAt(fila, 5).toString();
        char sexo = DataBase.getValueAt(fila, 6).toString().charAt(0);
        String direccion = DataBase.getValueAt(fila, 7).toString();
        String telefono = DataBase.getValueAt(fila, 8).toString();
        Date fechaNacimiento = null;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fechaNacimiento = dateFormat.parse(DataBase.getValueAt(fila, 9).toString());
        } catch (Exception e) {
        }
        
        TextID.setText(""+idc);
        TextIdentificacion.setText(""+tipoIdentificacion);
        TextNumIden.setText(""+numeroIdentificacion);
        TextNombre.setText(""+nombres);
        TextApellidos.setText(""+apellidos);
        TextEstadoCivil.setText(""+estadoCivil);
        TextSexo.setText(""+sexo);
        TextDirecion.setText(""+direccion);
        TextTelefono.setText(""+telefono);
        TextFechaNaci.setText(dateFormat.format(fechaNacimiento));
    }
    }//GEN-LAST:event_DataBaseMouseClicked

    private void EliminarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarBotonActionPerformed
    int idFuncionario = Integer.parseInt(TextID.getText());

    Funcionario funcionario = new Funcionario();
    funcionario.setID(idFuncionario);

    try {
        DAOFuncionario dao = new DAOFuncionarioImpl();
        dao.eliminar(funcionario);

        cargarTablaFuncionarios();

        limpiarCampos();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al eliminar el funcionario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
        }//GEN-LAST:event_EliminarBotonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Funcionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarBoton;
    private javax.swing.JLabel Apellidos;
    private javax.swing.JTable DataBase;
    private javax.swing.JLabel Direccion;
    private javax.swing.JButton EliminarBoton;
    private javax.swing.JLabel EstadoCivil;
    private javax.swing.JLabel FechaNaci;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel Identificacion;
    private javax.swing.JButton ModificarBoton;
    private javax.swing.JLabel Nombres;
    private javax.swing.JLabel NumIdentificacion;
    private javax.swing.JLabel Sexo;
    private javax.swing.JLabel Telefono;
    private javax.swing.JTextField TextApellidos;
    private javax.swing.JTextField TextDirecion;
    private javax.swing.JTextField TextEstadoCivil;
    private javax.swing.JTextField TextFechaNaci;
    private javax.swing.JTextField TextID;
    private javax.swing.JTextField TextIdentificacion;
    private javax.swing.JTextField TextNombre;
    private javax.swing.JTextField TextNumIden;
    private javax.swing.JTextField TextSexo;
    private javax.swing.JTextField TextTelefono;
    private javax.swing.JButton VacioBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
