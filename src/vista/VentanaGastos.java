/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorBalance;
import controlador.ControladorCategoria;
import controlador.ControladorGastos;
import java.math.BigDecimal;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import modelo.EnumTipoGasto;
import modelo.Gasto;

/**
 *
 * @author User
 */
public class VentanaGastos extends javax.swing.JInternalFrame {
    
    private ControladorCategoria controladorCategoria;
    private ControladorGastos controladorGastos;
    private ControladorBalance controladorBalance;
    
    private Gasto gasto;
    
    private BigDecimal actualizacionGasto;

    /**
     * Creates new form VentanaGastos
     */
    public VentanaGastos(ControladorCategoria controladorCategoria, ControladorGastos controladorGastos,
            ControladorBalance controladorBalance) {
        initComponents();
        
        this.controladorCategoria = controladorCategoria;
        this.controladorGastos = controladorGastos;
        this.controladorBalance = controladorBalance;
        
        actualizacionGasto = null;
        
        limpiar();
    }
    
    public void cargarFecha() {
        jDateChooser1.setDate(new Date());
    }
    
    public void cargarCategorias() {
        
        cbxCategoria.removeAllItems();
        cbxCategoria.addItem("--Seleccione--");
        controladorCategoria.findByTipo(EnumTipoGasto.GASTO.toString()).forEach(cat -> {
            cbxCategoria.addItem(cat.getNombre());
        });
    }
    
    public void cargarCodigo() {
        txtCodigo.setText(String.valueOf(controladorGastos.codigo()));
    }
    
    public void llenarTbl() {
        var lista = controladorGastos.findAll();
        
        DefaultTableModel modelo = (DefaultTableModel) tblGastos.getModel();
        modelo.setRowCount(0);
        
        for (var g : lista) {
            Object[] row = {g.getId(), g.getCategoriaFk().getNombre(), g.getDineroGastado().toString(),
                g.getFecha().toString(), g.getDescripcion()};
            modelo.addRow(row);
        }
        
        tblGastos.setModel(modelo);
        
    }
    
    public void limpiar() {
        cargarCategorias();
        cargarCodigo();
        cargarFecha();
        txtDinero.setText("");
        cbxCategoria.setSelectedIndex(0);
        llenarTbl();
        txtAreaDescripcion.setText("");
        
        btnCrear.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        txtCodigo = new javax.swing.JTextField();
        cbxCategoria = new javax.swing.JComboBox<>();
        btnCrear = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtDinero = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaDescripcion = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGastos = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Gastos");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jLabel1.setText("Código:");

        jLabel2.setText("Categoria:");

        jLabel3.setText("Dinero:");

        jLabel4.setText("Fecha:");

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(102, 102, 102));

        btnCrear.setBackground(new java.awt.Color(51, 51, 255));
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(51, 51, 255));
        btnActualizar.setText("Actualizar");
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 102, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Descripción:");

        txtAreaDescripcion.setColumns(20);
        txtAreaDescripcion.setLineWrap(true);
        txtAreaDescripcion.setRows(5);
        txtAreaDescripcion.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtAreaDescripcion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCrear)
                .addGap(46, 46, 46)
                .addComponent(btnActualizar)
                .addGap(57, 57, 57)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(txtDinero, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodigo))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDinero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        tblGastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoria", "Gasto", "Fecha", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGastosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGastos);
        if (tblGastos.getColumnModel().getColumnCount() > 0) {
            tblGastos.getColumnModel().getColumn(0).setResizable(false);
            tblGastos.getColumnModel().getColumn(2).setResizable(false);
            tblGastos.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:

        String categoria = (String) cbxCategoria.getSelectedItem();
        String descripcion = txtAreaDescripcion.getText();
        String dineroGastadoString = ((txtDinero.getText()));
        if (dineroGastadoString.contains(",")) {
            dineroGastadoString = dineroGastadoString.replaceAll(",", ".");
        }
        //dineroGastadoString = String.format(".2f", dineroGastadoString);
        double dineroGastado = Double.valueOf(dineroGastadoString);
        
        if (categoria.equalsIgnoreCase("--Seleccione--") || dineroGastado < 0) {
            JOptionPane.showMessageDialog(this, "Faltan datos", "Aviso", JOptionPane.ERROR_MESSAGE);
        } else {
            
            var cat = controladorCategoria.findByNombre(categoria);
            
            Gasto gas = new Gasto(descripcion, Integer.valueOf(txtCodigo.getText()), jDateChooser1.getDate(),
                    BigDecimal.valueOf(dineroGastado), cat);
            
            if (controladorGastos.create(gas) && controladorBalance.gasto(BigDecimal.valueOf(dineroGastado))) {
                
                JOptionPane.showMessageDialog(this, "Actualizado con exito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "Error", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
        }
        

    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:

        String categoria = (String) cbxCategoria.getSelectedItem();
        String descripcion = txtAreaDescripcion.getText();
        String dineroGastadoString = ((txtDinero.getText()));
        if (dineroGastadoString.contains(",")) {
            dineroGastadoString = dineroGastadoString.replaceAll(",", ".");
        }
        //dineroGastadoString = String.format(".2f", dineroGastadoString);
        double dineroGastado = Double.valueOf(dineroGastadoString);
        
        if (categoria.equalsIgnoreCase("--Seleccione--") || dineroGastado < 0) {
            JOptionPane.showMessageDialog(this, "Faltan datos", "Aviso", JOptionPane.ERROR_MESSAGE);
        } else {
            
            var cat = controladorCategoria.findByNombre(categoria);
            
            gasto.setCategoriaFk(cat);
            gasto.setDineroGastado(BigDecimal.valueOf(dineroGastado));
            gasto.setDescripcion(descripcion);
            
            if (controladorGastos.update(gasto) && controladorBalance.ahorro(actualizacionGasto)
                    && controladorBalance.gasto(BigDecimal.valueOf(dineroGastado))) {
                JOptionPane.showMessageDialog(this, "Actualizado con exito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "Error", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:

        gasto = controladorGastos.read(Integer.valueOf(txtCodigo.getText()));
        
        if (controladorGastos.delete(gasto) && controladorBalance.ahorro(gasto.getDineroGastado())) {
            JOptionPane.showMessageDialog(this, "Eliminado con exito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            limpiar();
        } else {
            JOptionPane.showMessageDialog(this, "Error", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
        

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblGastosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGastosMouseClicked
        // TODO add your handling code here:

        int fila = tblGastos.getSelectedRow();
        int id = (int) tblGastos.getValueAt(fila, 0);
        
        gasto = controladorGastos.read(id);
        
        txtCodigo.setText(String.valueOf(gasto.getId()));
        txtDinero.setText(gasto.getDineroGastado().toString());
        cbxCategoria.setSelectedItem(gasto.getCategoriaFk().getNombre());
        jDateChooser1.setDate(gasto.getFecha());
        txtAreaDescripcion.setText(gasto.getDescripcion());
        
        actualizacionGasto = gasto.getDineroGastado();
        
        btnCrear.setEnabled(false);
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);

    }//GEN-LAST:event_tblGastosMouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cbxCategoria;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblGastos;
    private javax.swing.JTextArea txtAreaDescripcion;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDinero;
    // End of variables declaration//GEN-END:variables
}
