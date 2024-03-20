package com.raven.form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FormMember extends javax.swing.JPanel {

    private Connection connection;
    PreparedStatement pst;
    
    public FormMember() {
        initComponents();
        table_update();
        getDataMember();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxtNama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMember = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTxtAlamat = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTxtTelepon = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTxtEmail = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jLabelId = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(106, 106, 106));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Member");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("Nama");

        jTxtNama.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jTxtNama.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jTableMember.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Nama", "Alamat", "Telepon", "Email"
            }
        ));
        jTableMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMemberMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMember);

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("Alamat");

        jTxtAlamat.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jTxtAlamat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("Telepon");

        jTxtTelepon.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jTxtTelepon.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setText("Email");

        jTxtEmail.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jTxtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        btn_tambah.setBackground(new java.awt.Color(51, 204, 0));
        btn_tambah.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_edit.setBackground(new java.awt.Color(255, 255, 0));
        btn_edit.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_edit.setText("Edit");
        btn_edit.setMaximumSize(new java.awt.Dimension(86, 26));
        btn_edit.setMinimumSize(new java.awt.Dimension(86, 26));
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_hapus.setBackground(new java.awt.Color(204, 0, 51));
        btn_hapus.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        jLabelId.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTxtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTxtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_tambah)
                        .addGap(18, 18, 18)
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btn_hapus))
                    .addComponent(jLabelId))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addComponent(jTxtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addComponent(jTxtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7)
                        .addGap(6, 6, 6)
                        .addComponent(jTxtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8)
                        .addGap(6, 6, 6)
                        .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_tambah)
                            .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_hapus))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelId)
                        .addContainerGap(191, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(4, 4, 4))))
        );

        jLabelId.setVisible(false);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
//        jTxtNama.setText("");
//        jTxtNama.requestFocus();
        String nama = jTxtNama.getText();
        String alamat = jTxtAlamat.getText();
        String telp = jTxtTelepon.getText();
        String email = jTxtEmail.getText();
        
        connection = null;
        Statement st = null;
        
        if (connection == null){
            try {
                String url = "jdbc:mysql://localhost:3306/infotama_pool_cafe";
                String user = "root";
                String pass = "@Hazlam2024";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connection = (Connection) DriverManager.getConnection(url, user, pass);
                //connection = koneksi.getConnection();
                st = connection.createStatement();
                String sql = "INSERT INTO member(nama,alamat,telp,email) " +
                             "VALUES ('"+nama+"','"+alamat+"','"+telp+"','"+email+"')";

                st.execute(sql);
                //JOptionPane.showMessageDialog(null, "Data Member berhasil ditambahkan");
                //getDataBiaya();
                table_update();

                } catch (Exception e) {
                 //JOptionPane.showMessageDialog(null, "Gagal tambah data member");
                 
            }     
        }
      
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void table_update (){
        connection = null;
        int CC;
        try {
            String url = "jdbc:mysql://localhost:3306/infotama_pool_cafe";
            String user = "root";
            String pass = "@Hazlam2024";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = (Connection) DriverManager.getConnection(url, user, pass);
            pst = connection.prepareStatement("SELECT * FROM member");
            ResultSet  Rs = pst.executeQuery();
            
            ResultSetMetaData stData = Rs.getMetaData();
            CC = stData.getColumnCount();
            DefaultTableModel RecordTable = (DefaultTableModel) jTableMember.getModel();
            RecordTable.setRowCount(0);
            
            while (Rs.next()) {                
                Vector columnData = new Vector();
                for (int i = 1; i < CC; i++) {
                    columnData.add(Rs.getInt("id_member"));
                    columnData.add(Rs.getString("nama"));
                    columnData.add(Rs.getString("alamat"));
                    columnData.add(Rs.getString("telp"));
                    columnData.add(Rs.getString("email"));
                }
                RecordTable.addRow(columnData);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("Gagal get data member");
        }
            
    }
    
    public void getDataMember(){
        connection = null;
        Statement st = null;
        ResultSet rs = null;
        if (connection == null){
            try {
                String url = "jdbc:mysql://localhost:3306/infotama_pool_cafe";
                String user = "root";
                String pass = "@Hazlam2024";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connection = (Connection) DriverManager.getConnection(url, user, pass);
                //connection = koneksi.getConnection();
                st = connection.createStatement();
                
                String sql = "SELECT * FROM member ORDER BY id_member DESC LIMIT 1";
                rs = st.executeQuery(sql);         

                if (rs.next()) {
                    //JOptionPane.showMessageDialog(null, "Data transaksi berhasil diupdate");
                    Integer idorder = rs.getInt("id_member");
                    //jLabelId.setText(Integer.toString(idorder));
                    
//                    System.out.println(idorder);
//                    System.out.println(nomeja);
                    connection.close();
                }
            } 
            catch (Exception e) {
                 //JOptionPane.showMessageDialog(null, "Gagal get data Member");
                 System.out.println("Gagal get data member");
            }     
        }
    }
    
    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        String nama = jTxtNama.getText();
        String id = jLabelId.getText();
        String alamat = jTxtAlamat.getText();
        String telp = jTxtTelepon.getText();
        String email = jTxtEmail.getText();
        //String harga = jHarga.getText();
        connection = null;
        Statement st = null;

        //        if (connection == null){
            try {
                String url = "jdbc:mysql://localhost:3306/infotama_pool_cafe";
                String user = "root";
                String pass = "@Hazlam2024";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connection = (Connection) DriverManager.getConnection(url, user, pass);
                //connection = koneksi.getConnection();
                st = connection.createStatement();
                String sql = "UPDATE member SET nama='"+nama+"', alamat='"+alamat+"', telp='"+telp+"', email='"+email+"' " + 
                        "WHERE id_member='"+id+"' ";

                st.execute(sql);
                //JOptionPane.showMessageDialog(null, "Data member berhasil diupdate");
                table_update();
                jTxtNama.setText("");
                jTxtAlamat.setText("");
                jTxtTelepon.setText("");
                jTxtEmail.setText("");

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, "Gagal update data member");
            }
            //        }
        //table_update();
    }//GEN-LAST:event_btn_editActionPerformed

    private void jTableMemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMemberMouseClicked
        DefaultTableModel model = (DefaultTableModel) jTableMember.getModel();
        Integer selectedIndex = jTableMember.getSelectedRow();
        jLabelId.setText(model.getValueAt(selectedIndex, 0).toString());
        jTxtNama.setText(model.getValueAt(selectedIndex, 1).toString());
        jTxtAlamat.setText(model.getValueAt(selectedIndex, 2).toString());
        jTxtTelepon.setText(model.getValueAt(selectedIndex, 3).toString());
        jTxtEmail.setText(model.getValueAt(selectedIndex, 4).toString());
    }//GEN-LAST:event_jTableMemberMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        String nama = jTxtNama.getText();
        String id = jLabelId.getText();
        String alamat = jTxtAlamat.getText();
        String telp = jTxtTelepon.getText();
        String email = jTxtEmail.getText();
        //String harga = jHarga.getText();
        connection = null;
        Statement st = null;

        //        if (connection == null){
            try {
                String url = "jdbc:mysql://localhost:3306/infotama_pool_cafe";
                String user = "root";
                String pass = "@Hazlam2024";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connection = (Connection) DriverManager.getConnection(url, user, pass);
                //connection = koneksi.getConnection();
                st = connection.createStatement();
                String sql = "DELETE  FROM member WHERE id_member='"+id+"' ";

                st.execute(sql);
                //JOptionPane.showMessageDialog(null, "Data member berhasil dihapus");
                table_update();
                jTxtNama.setText("");
                jTxtAlamat.setText("");
                jTxtTelepon.setText("");
                jTxtEmail.setText("");

            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, "Gagal hapus data member");
            }
    }//GEN-LAST:event_btn_hapusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMember;
    private javax.swing.JTextField jTxtAlamat;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtNama;
    private javax.swing.JTextField jTxtTelepon;
    // End of variables declaration//GEN-END:variables
}
