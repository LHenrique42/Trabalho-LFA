
package analisadorsintatico;

import analisadorlexico.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AnalisadorInterface extends javax.swing.JFrame {

    /**
     * Creates new form AnalisadorInterface
     */
    public AnalisadorInterface() {
        initComponents();
    }
    
    static public AnalisadorGramatica parser;
    File arquivo;
    FileWriter aux;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileSalva = new javax.swing.JFileChooser();
        jFile = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        AtTexto = new javax.swing.JTextArea();
        BntArquivo = new javax.swing.JButton();
        BntTesta = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        AtSaida = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        BntSalvar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jFileSalva.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        jFileSalva.setApproveButtonText("Salvar");
        jFileSalva.setApproveButtonToolTipText("Salvar");
        jFileSalva.setDialogTitle("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AtTexto.setColumns(20);
        AtTexto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        AtTexto.setRows(5);
        jScrollPane1.setViewportView(AtTexto);

        BntArquivo.setText("escolher arquivo");
        BntArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BntArquivoActionPerformed(evt);
            }
        });

        BntTesta.setText("Testar");
        BntTesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BntTestaActionPerformed(evt);
            }
        });

        AtSaida.setEditable(false);
        AtSaida.setColumns(20);
        AtSaida.setRows(5);
        AtSaida.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                AtSaidaPropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(AtSaida);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel2.setText("Analisador Lexico em C");

        BntSalvar.setText("salvar arquivo");
        BntSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BntSalvarActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);

        jLabel1.setText("Arquivo aberto:");

        jLabel3.setText("          Copyright©2018-2018, Grupo 1. Todos os direitos reservados. ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 1, Short.MAX_VALUE)
                                .addComponent(BntArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BntSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BntTesta, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BntArquivo)
                            .addComponent(BntSalvar)
                            .addComponent(BntTesta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BntArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntArquivoActionPerformed
        // TODO add your handling code here:
        int returnVal = jFile.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = jFile.getSelectedFile();
        jTextField1.setText(file.getAbsolutePath());
        try {
          // What to do with the file, e.g. display it in a TextArea
          AtTexto.read( new FileReader( file.getAbsolutePath() ), null );
        } catch (IOException ex) {
          System.out.println("problem accessing file"+file.getAbsolutePath());
        }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_BntArquivoActionPerformed

    private void AtSaidaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_AtSaidaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_AtSaidaPropertyChange

    private void BntTestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntTestaActionPerformed
        // TODO add your handling code here:
        try {
			aux = new FileWriter(new File("Arquivo.txt"));
			aux.write(AtTexto.getText());
			aux.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    
        try 
        {
            parser = new AnalisadorGramatica( "Arquivo.txt" ); 
            parser.programa();
            AtSaida.setText("Sucesso: Sintaxe aceita ! :D");
            AtSaida.repaint();     
        } catch (ErroLexico e) {
            AtSaida.setText("Erro lexico: " + e.toString());
            AtSaida.repaint();
        } catch (ErroSintatico e) {
            AtSaida.setText("Erro sintatico: " + e.toString());
            AtSaida.repaint();
        } catch (RuntimeException e) {
            AtSaida.setText("Erro lexico2: " + e.getMessage());
            AtSaida.repaint();
        }
        
        try {
            aux.close();
            arquivo = new File("Arquivo.txt");
            arquivo.delete();
        } catch (IOException ex) {
            Logger.getLogger(AnalisadorInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_BntTestaActionPerformed

    private void BntSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntSalvarActionPerformed
        // TODO add your handling code here:
        int returnVal2 = jFileSalva.showOpenDialog(this);
        if (returnVal2 == JFileChooser.APPROVE_OPTION) {
        File file2 = jFileSalva.getSelectedFile();
        // What to do with the file, e.g. display it in a TextArea
        FileWriter aux2;
        try {
            aux2 = new FileWriter(file2.getAbsolutePath());
            aux2.write(AtTexto.getText());
            aux2.close();
        } catch (IOException ex) {
            Logger.getLogger(AnalisadorInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        } else {
            System.out.println("File save cancelled by user.");
        }
    }//GEN-LAST:event_BntSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(AnalisadorInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnalisadorInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnalisadorInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnalisadorInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnalisadorInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AtSaida;
    private javax.swing.JTextArea AtTexto;
    private javax.swing.JButton BntArquivo;
    private javax.swing.JButton BntSalvar;
    private javax.swing.JButton BntTesta;
    private javax.swing.JFileChooser jFile;
    private javax.swing.JFileChooser jFileSalva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
