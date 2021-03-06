/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.HLOCADORA.telas;

import javax.swing.table.*;
import java.sql.*;
import java.util.Calendar;
import br.com.HLOCADORA.dal.ModuloConexao;
import javax.swing.JOptionPane;

import java.io.IOException;



public class TelaPrincipal extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void criarCliente() {
         if(txtNome.getText().equals("") ||  txtIdade.getText().equals("") ||  txtEndereco.getText().equals("") ||  txtCPF.getText().equals("")){
              JOptionPane.showMessageDialog(null, "Preencha todos os campos para criar o registro.");
          }
         else{
        // Verificando se ja ha algum dado cadastrado com 
        String sql = "SELECT * FROM clientes WHERE cpf=?";
        
        try {
           
            pst = conexao.prepareStatement(sql);

            
            pst.setString(1, txtCPF.getText());

            rs = pst.executeQuery();
            
           
            if (rs.next()) {
                // Caso ja tenha registro
            JOptionPane.showMessageDialog(null, "Ja existe usuario com este cpf");
            
            } else {
                // Caso nao tenha registro
        String sql2 = "insert into clientes (nome,idade,endereco,cpf) values (?,?,?,?);";
        
        try {
            
         
            
            // Armazenando a resposta dentro da variavel pst    
            pst = conexao.prepareStatement(sql2);

            // Pegando texto de dentro das labels 
            pst.setString(1, txtNome.getText());
            pst.setString(2, txtIdade.getText());
            pst.setString(3, txtEndereco.getText());   
            pst.setString(4, txtCPF.getText());
            pst.executeUpdate();
            listarClientes();
            // Limpando os campos para verificar se o usuario colocou ou nao todos os campos
            txtNome.setText("");
            txtIdade.setText("");
            txtEndereco.setText("");
            txtCPF.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         } 
         }

    public void listarClientes() {
        
        DefaultTableModel hsaktableInicio = (DefaultTableModel) jTInicio.getModel();

        hsaktableInicio.setRowCount(0);

        // Criando SQL para listar todas as aplicacoes WEB
        String sql = "SELECT * FROM clientes;";

        try {
            // Armazenando a resposta dentro da variavel pst    
            pst = conexao.prepareStatement(sql);

            rs = pst.executeQuery();
            while (rs.next()) {
                
                //int hora = data.get(Calendar.HOUR_OF_DAY);
                //int min = data.get(Calendar.MINUTE);
                //int seg = data.get(Calendar.SECOND);

                // Fazendo WebScrapping
            hsaktableInicio.addRow(new Object[]{rs.getString("id_cliente"),rs.getString("nome"), rs.getString("cpf"),rs.getString("idade"),rs.getString("endereco")});
                

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "3");
        }

    }

    /**
     * Creates new form TelaPrincipal
     */
    
    
    public TelaPrincipal() {
        
        // Estabelecendo conexao com o banco de dados
        conexao = ModuloConexao.conector();
        // Iniciando a funcao padrao para criar os componentes na tela
        initComponents();
        // Ocultando botao editar e apagar e deixando somente o criar
        jButton1.setVisible(true);
   jButton2.setVisible(false);
   jButton3.setVisible(false);
   jButton5.setVisible(false);
        // Iniciando funcao para popular tabela inicial.
       listarClientes();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTInicio = new javax.swing.JTable();
        txtcpfSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdade = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("[HLocadora] Gerenciamento de Clientes");

        jTInicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Idade", "Endereco"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTInicioMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTInicio);

        jLabel2.setText("CPF");

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Crie seus clientes aqui");

        jLabel3.setText("Nome");

        jLabel5.setText("Endereco");

        jLabel6.setText("Idade");

        jLabel7.setText("CPF");

        jButton1.setText("Criar Cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Apagar Cliente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Editar Cliente");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(145, 145, 145))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(txtNome)
                            .addComponent(jLabel6)
                            .addComponent(txtIdade)
                            .addComponent(txtEndereco)
                            .addComponent(txtCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(10, 10, 10)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton5)))
        );

        jButton6.setText("Listar tudo");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jMenu4.setText("Titulos");

        jMenuItem1.setText("Genciar Titulos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem2.setText("Gerenciar Alugueis");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Clientes");

        jMenuItem4.setText("Gerenciar Clientes");
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Sobre");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem3.setText("Projeto HLocadora");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtcpfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton4)
                            .addGap(527, 527, 527))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(146, 146, 146))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtcpfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 77, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1293, 561);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        TelaSobre sobre = new TelaSobre();
        sobre.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        criarCliente();       
    }//GEN-LAST:event_jButton1ActionPerformed

    
        
 
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   if(jTInicio.getSelectedRow() != -1){
       
   DefaultTableModel hsaktableInicio = (DefaultTableModel) jTInicio.getModel(); 
   
   String value = hsaktableInicio.getValueAt(jTInicio.getSelectedRow(), 0).toString();
    
         String sql2 = "DELETE FROM clientes WHERE id_cliente=? ;";
        
        try {
            
         
            
            // Armazenando a resposta dentro da variavel pst    
            pst = conexao.prepareStatement(sql2);

            // Pegando texto de dentro das labels 
            pst.setString(1, value);
            pst.executeUpdate();
               txtNome.setText("");
            txtIdade.setText("");
            txtEndereco.setText("");
            txtCPF.setText("");
                        
            listarClientes();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
   
   
   //  
   //hsaktableInicio.removeRow(jTInicio.getSelectedRow());
    
   
   }else{
        JOptionPane.showMessageDialog(null, "Selecione alguma linha.");
   }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTInicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTInicioMousePressed
   jButton1.setVisible(false);
   jButton2.setVisible(true);
   jButton3.setVisible(true);
   jButton5.setVisible(true);
   DefaultTableModel hsaktableInicio = (DefaultTableModel) jTInicio.getModel(); 
   
   String nome = hsaktableInicio.getValueAt(jTInicio.getSelectedRow(), 1).toString();
   String idade = hsaktableInicio.getValueAt(jTInicio.getSelectedRow(), 3).toString();
   String endereco = hsaktableInicio.getValueAt(jTInicio.getSelectedRow(), 4).toString();
   String cpf = hsaktableInicio.getValueAt(jTInicio.getSelectedRow(), 2).toString();
    txtNome.setText(nome);
            txtIdade.setText(idade);
            txtEndereco.setText(endereco);
            txtCPF.setText(cpf);
   
    }//GEN-LAST:event_jTInicioMousePressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
jButton1.setVisible(true);
   jButton2.setVisible(false);
   jButton3.setVisible(false);
   jButton5.setVisible(false);
   txtNome.setText("");
            txtIdade.setText("");
            txtEndereco.setText("");
            txtCPF.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 DefaultTableModel hsaktableInicio = (DefaultTableModel) jTInicio.getModel(); 
   
   String value = hsaktableInicio.getValueAt(jTInicio.getSelectedRow(), 0).toString();
    
         String sql3 = "UPDATE clientes SET nome=?,idade=?,endereco=?,cpf=? WHERE id_cliente=? ;";
        
        try {
            
         
            
            // Armazenando a resposta dentro da variavel pst    
            pst = conexao.prepareStatement(sql3);

            // Pegando texto de dentro das labels \
            pst.setString(1, txtNome.getText());
             pst.setString(2, txtIdade.getText());
            pst.setString(3, txtEndereco.getText());
             pst.setString(4, txtCPF.getText());
            pst.setString(5, value);
            pst.executeUpdate();
            
            // Resetando os labels
            txtNome.setText("");
            txtIdade.setText("");
            txtEndereco.setText("");
            txtCPF.setText("");
            
            
            jButton1.setVisible(true);
               jButton2.setVisible(false);
   jButton3.setVisible(false);
   jButton5.setVisible(false);
   
   
            listarClientes();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }  
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed


if(txtcpfSearch.getText().equals("")){
              JOptionPane.showMessageDialog(null, "Preencha o CPF  a ser pesquisado.");
          }
else{

DefaultTableModel hsaktableInicio = (DefaultTableModel) jTInicio.getModel();

        hsaktableInicio.setRowCount(0);

        // Criando SQL para listar todas as aplicacoes WEB
        String sql = "SELECT * FROM clientes where cpf=?;";

        try {
            
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtcpfSearch.getText());
            rs = pst.executeQuery();
            
            int rowCount = 0;
            while (rs.next()) {
                rowCount = rowCount + 1;
                
            hsaktableInicio.addRow(new Object[]{rs.getString("id_cliente"),rs.getString("nome"), rs.getString("cpf"),rs.getString("idade"),rs.getString("endereco")});
                

            }
            
            if (rowCount <= 0){
                JOptionPane.showMessageDialog(null, "Nada foi encontrado");
                listarClientes();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    TelaFilmes telafilmes = new TelaFilmes();
       telafilmes.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       TelaAluguel telaluguel = new TelaAluguel();
       telaluguel.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      listarClientes();
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTInicio;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtcpfSearch;
    // End of variables declaration//GEN-END:variables
}
