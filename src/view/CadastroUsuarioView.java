/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.CadastroUsuarioController;
import controller.Helper.UsuarioHelper;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;

import javax.swing.JTextField;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;



/**
 *
 * @author Adriano Pavaneli
 */
public class CadastroUsuarioView extends javax.swing.JFrame {

    private final CadastroUsuarioController controller;
    private final UsuarioHelper helper;

    /**
     * Creates new form FormCadastroView
     */
    public CadastroUsuarioView() throws SQLException, ParseException {
        initComponents();
        controller = new CadastroUsuarioController(this);
        helper = new UsuarioHelper(this);
        TxtCadId.setEnabled(false);
        TxtCadUsuario.setEnabled(false);
        TxtCadSenha.setEnabled(false);        
        BtnInserir.setEnabled(true);
        BtnAlterar.setEnabled(true);
        BtnExcluir.setEnabled(true);
        BtnSalvar.setEnabled(false);
        BtnCancelar.setEnabled(false);
        BtnFechar.setEnabled(true);
        
        iniciar();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LblId = new javax.swing.JLabel();
        LblUsuario = new javax.swing.JLabel();
        LblSenha = new javax.swing.JLabel();
        TxtCadId = new javax.swing.JTextField();
        TxtCadUsuario = new javax.swing.JTextField();
        TxtCadSenha = new javax.swing.JPasswordField();
        BtnSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableUsuario = new javax.swing.JTable();
        BtnInserir = new javax.swing.JButton();
        BtnAlterar = new javax.swing.JButton();
        BtnExcluir = new javax.swing.JButton();
        BtnFechar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuarios");
        setLocation(new java.awt.Point(550, 250));

        LblId.setText("Id");

        LblUsuario.setText("Usuário:");

        LblSenha.setText("Senha:");

        BtnSalvar.setText("Salvar");
        BtnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalvarActionPerformed(evt);
            }
        });

        TableUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Usuário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableUsuarioMouseClicked(evt);
            }
        });
        TableUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TableUsuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TableUsuarioKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TableUsuario);

        BtnInserir.setText("Inserir");
        BtnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInserirActionPerformed(evt);
            }
        });

        BtnAlterar.setText("Alterar");
        BtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAlterarActionPerformed(evt);
            }
        });

        BtnExcluir.setText("Excluir");
        BtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExcluirActionPerformed(evt);
            }
        });

        BtnFechar.setText("Fechar");
        BtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFecharActionPerformed(evt);
            }
        });

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(LblSenha)
                                .addGap(74, 74, 74))
                            .addComponent(TxtCadSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtCadId, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblId))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LblUsuario)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(TxtCadUsuario)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(BtnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnFechar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblId)
                    .addComponent(LblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtCadId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCadUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TxtCadSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSalvar)
                    .addComponent(BtnInserir)
                    .addComponent(BtnAlterar)
                    .addComponent(BtnExcluir)
                    .addComponent(BtnFechar)
                    .addComponent(BtnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void atualizaJTable(){
        int indicelinha = TableUsuario.getSelectedRow();
        TxtCadId.setText(TableUsuario.getValueAt(indicelinha, 0).toString());
        TxtCadUsuario.setText(TableUsuario.getValueAt(indicelinha, 1).toString());
        
        
    }    
    private void BtnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalvarActionPerformed
        if(TxtCadUsuario.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Usuário não pode ficar em branco!");
            TxtCadUsuario.grabFocus();
        }else if (TxtCadSenha.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Senha não pode ficar em branco!");
            TxtCadSenha.grabFocus();
        }else{
            controller.salvaUsuario();
            TxtCadId.setEnabled(false);
            TxtCadUsuario.setEnabled(false);
            TxtCadSenha.setEnabled(false);        
            BtnInserir.setEnabled(true);
            BtnAlterar.setEnabled(true);
            BtnExcluir.setEnabled(true);
            BtnSalvar.setEnabled(false);
            BtnCancelar.setEnabled(false);
            BtnFechar.setEnabled(true);
            TxtCadUsuario.grabFocus();
           
        }
        
          
        
      
      
        
        
        
    }//GEN-LAST:event_BtnSalvarActionPerformed

    private void TableUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableUsuarioMouseClicked
        atualizaJTable();
    }//GEN-LAST:event_TableUsuarioMouseClicked

    private void TableUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableUsuarioKeyPressed
        atualizaJTable();
    }//GEN-LAST:event_TableUsuarioKeyPressed

    private void TableUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableUsuarioKeyReleased
        atualizaJTable();
    }//GEN-LAST:event_TableUsuarioKeyReleased

    private void BtnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInserirActionPerformed
        TxtCadId.setEnabled(false);
        TxtCadUsuario.setEnabled(true);
        TxtCadSenha.setEnabled(true);        
        BtnInserir.setEnabled(false);
        BtnAlterar.setEnabled(false);
        BtnExcluir.setEnabled(false);
        BtnSalvar.setEnabled(true);
        BtnCancelar.setEnabled(true);
        BtnFechar.setEnabled(false);
        TxtCadUsuario.grabFocus();
        helper.limpaTela();
    }//GEN-LAST:event_BtnInserirActionPerformed

    private void BtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAlterarActionPerformed
       TxtCadId.setEnabled(false);
        TxtCadUsuario.setEnabled(true);
        TxtCadSenha.setEnabled(true);        
        BtnInserir.setEnabled(false);
        BtnAlterar.setEnabled(false);
        BtnExcluir.setEnabled(false);
        BtnSalvar.setEnabled(true);
        BtnCancelar.setEnabled(true);
        BtnFechar.setEnabled(false);
        TxtCadUsuario.grabFocus();
        
    }//GEN-LAST:event_BtnAlterarActionPerformed

    private void BtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExcluirActionPerformed
       if(TxtCadId.getText().isEmpty()){
           JOptionPane.showMessageDialog(null,"Você precisar selecionar um usuario para excluir!");
       }else{
        int i = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o Usuario " + TxtCadUsuario.getText() + "?","Exclusão", JOptionPane.YES_NO_OPTION);
           if(i == JOptionPane.YES_OPTION){
            try {
                controller.deletaUsuario();
            } catch (SQLException ex) {
                Logger.getLogger(CadastroUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
            }
               JOptionPane.showMessageDialog(null,"Usuário excluido com sucesso");
           }
               
          
       }
    }//GEN-LAST:event_BtnExcluirActionPerformed

    private void BtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFecharActionPerformed
        
        CadastroUsuarioView.this.dispose();
    }//GEN-LAST:event_BtnFecharActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
       
            TxtCadId.setEnabled(false);
            TxtCadUsuario.setEnabled(false);
            TxtCadSenha.setEnabled(false);        
            BtnInserir.setEnabled(true);
            BtnAlterar.setEnabled(true);
            BtnExcluir.setEnabled(true);
            BtnSalvar.setEnabled(false);
            BtnFechar.setEnabled(true);
            BtnCancelar.setEnabled(false);
            TxtCadUsuario.grabFocus();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    /**
     * 
     * 
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
            java.util.logging.Logger.getLogger(CadastroUsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CadastroUsuarioView().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CadastroUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(CadastroUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public JTextField getTxtCadSenha() {
        return TxtCadSenha;
    }

    public void setTxtCadSenha(JPasswordField TxtCadSenha) {
        this.TxtCadSenha = TxtCadSenha;
    }

    public JTextField getTxtCadUsuario() {
        return TxtCadUsuario;
    }

    public void setTxtCadUsuario(JTextField TxtCadUsuario) {
        this.TxtCadUsuario = TxtCadUsuario;
    }

    public JTextField getTxtCadId() {
        return TxtCadId;
    }

    public void setTxtCadId(JTextField TxtCadId) {
        this.TxtCadId = TxtCadId;
    }

    public JTable getTableUsuario() {
        return TableUsuario;
    }

    public void setTableUsuario(JTable TableUsuario) {
        this.TableUsuario = TableUsuario;
    }
    
    
    private void iniciar() throws SQLException, ParseException {
        this.controller.atualizaTabela();
        
       
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAlterar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnExcluir;
    private javax.swing.JButton BtnFechar;
    private javax.swing.JButton BtnInserir;
    private javax.swing.JButton BtnSalvar;
    private javax.swing.JLabel LblId;
    private javax.swing.JLabel LblSenha;
    private javax.swing.JLabel LblUsuario;
    private javax.swing.JTable TableUsuario;
    private javax.swing.JTextField TxtCadId;
    private javax.swing.JPasswordField TxtCadSenha;
    private javax.swing.JTextField TxtCadUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
