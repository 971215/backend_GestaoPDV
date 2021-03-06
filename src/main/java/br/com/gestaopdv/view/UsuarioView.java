/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gestaopdv.view;

import br.com.gestaopdv.criptografia.Criptografia;
import br.com.gestaopdv.dao.AutenticacaoDAO;
import br.com.gestaopdv.dao.UsuarioDAO;
import br.com.gestaopdv.model.Usuario;
import br.com.gestaopdv.services.UsuarioService;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class UsuarioView extends javax.swing.JFrame {

    /**
     * Creates new form UsuarioVIew
     */
    private UsuarioService service;
    private Usuario usuario;

    public UsuarioView() {
        initComponents();
        service = new UsuarioService(new UsuarioDAO(), new AutenticacaoDAO());
        inicializarBotoes();
        inicializarCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbPerfil = new javax.swing.JComboBox<>();
        jtfNome = new javax.swing.JTextField();
        jtfLogin = new javax.swing.JTextField();
        jtfSenha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jbCosultar = new javax.swing.JButton();
        jbNovo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jbRemover = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NOME:");

        jLabel2.setText("LOGIN:");

        jLabel3.setText("SENHA:");

        jcbPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Operador" }));

        jLabel4.setText("PERFIL:");

        jbCosultar.setText("CONSULTAR");
        jbCosultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCosultarActionPerformed(evt);
            }
        });

        jbNovo.setText("NOVO");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jButton1.setText("ALTERAR");

        jbRemover.setText("REMOVER");

        jbCadastrar.setText("CADASTRAR");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                            .addComponent(jtfNome)
                            .addComponent(jcbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfSenha)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jbCosultar)
                        .addGap(14, 14, 14)
                        .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jbCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(76, 76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCosultar)
                    .addComponent(jbNovo)
                    .addComponent(jButton1)
                    .addComponent(jbRemover)
                    .addComponent(jbCadastrar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCosultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCosultarActionPerformed
        // TODO add your handling code here:
        consultar();
    }//GEN-LAST:event_jbCosultarActionPerformed

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        // TODO add your handling code here:
        cadastrar();
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        // TODO add your handling code here:
        liberarClickNovo();
    }//GEN-LAST:event_jbNovoActionPerformed

    private boolean validar() {
        if (jtfLogin.getText().isEmpty() || jtfNome.getText().isEmpty() || jtfSenha.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    private void cadastrar() {
        if (!validar()) {
            JOptionPane.showMessageDialog(null, "Todos os campos s??o obrigat??rios!");
            return;
        }

        usuario = new Usuario(null, jtfNome.getText(), jcbPerfil.getSelectedIndex(), jtfLogin.getText(), Criptografia.criptografarSenha(jtfSenha.getText()));

        try {
            //usuario = new Usuario(null, "Leidiane Brito", 2, "tesasasatando", "12345");
            service.salvar(usuario);
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");

        } catch (Exception e) {
            System.err.println("exception = " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao salvar o registro!");
        }

    }

    private void consultar() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do Usu??rio"));
        try {
            usuario = service.consultar(id);
            preencherCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado!");
        }

    }

    private void preencherCampos() {
        jtfLogin.setText(usuario.getLogin());
        jtfNome.setText(usuario.getNome());
        jtfSenha.setText(usuario.getSenha());
        jtfNome.setEnabled(true);
        jtfSenha.setEnabled(true);
        jButton1.setEnabled(true);
    }

    private void inicializarBotoes() {
        jbCadastrar.setEnabled(false);
        jbRemover.setEnabled(false);
        jButton1.setEnabled(false);

    }

    private void inicializarCampos() {
        jtfLogin.setEnabled(false);
        jtfNome.setEnabled(false);
        jtfSenha.setEnabled(false);
    }

    private void limparBloquearCampos() {
        jtfLogin.setText(null);
        jtfNome.setText(null);
        jtfSenha.setText(null);
        jcbPerfil.setSelectedIndex(1);
        jtfLogin.setEnabled(false);
        jtfNome.setEnabled(false);
        jtfSenha.setEnabled(false);
        jcbPerfil.setEnabled(false);
    }

    private void limparLiberarCampos() {
        jtfLogin.setText(null);
        jtfNome.setText(null);
        jtfSenha.setText(null);
        jcbPerfil.setSelectedIndex(1);
        jtfLogin.setEnabled(true);
        jtfNome.setEnabled(true);
        jtfSenha.setEnabled(true);
        jcbPerfil.setEnabled(true);
    }

    private void liberarClickNovo() {
        inicializarBotoes();
        inicializarCampos();
        limparLiberarCampos();
        jbCadastrar.setEnabled(true);

    }

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
            java.util.logging.Logger.getLogger(UsuarioView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbCosultar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbRemover;
    private javax.swing.JComboBox<String> jcbPerfil;
    private javax.swing.JTextField jtfLogin;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfSenha;
    // End of variables declaration//GEN-END:variables
}
