package com.raven.form;

import com.raven.connection.koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FormBiaya extends javax.swing.JPanel {
    
    public Connection connection;
    PreparedStatement pst;
    /**
     * Creates new form FormBiaya
     */
    public FormBiaya() {
        initComponents();
        //getDataBiaya();
        table_update();
    }
    
    private void table_update (){
        connection = null;
        int CC;
        
        try {
            String url = "jdbc:mysql://localhost:3306/infotama_pool_cafe";
            String user = "root";
            String pass = "abduh";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = (Connection) DriverManager.getConnection(url, user, pass);
            pst = connection.prepareStatement("SELECT * FROM biaya");
            ResultSet  Rs = pst.executeQuery();
            
            ResultSetMetaData stData = Rs.getMetaData();
            CC = stData.getColumnCount();
            DefaultTableModel RecordTable = (DefaultTableModel) jTableBiaya.getModel();
            RecordTable.setRowCount(0);
            DecimalFormat f = new DecimalFormat("#,##0.##");
            
            while (Rs.next()) {                
                Vector columnData = new Vector();
                for (int i = 1; i < CC; i++) {
                    columnData.add(Rs.getInt("id_biaya"));
                    columnData.add(Rs.getString("nama_biaya"));
                    columnData.add(f.format(Rs.getDouble("harga")));
                }
                RecordTable.addRow(columnData);
            }
        } catch (Exception e) {
            System.out.println("Gagal get data biaya");
        }
            
    }
    private void getDataBiaya(){
        connection = null;
        Statement st = null;
        ResultSet rs = null;
        DefaultTableModel model = (DefaultTableModel) jTableBiaya.getModel();
        model.setRowCount(0);
        
            try {
                connection = koneksi.getConnection();
                st = connection.createStatement();
                String sql = "SELECT * FROM biaya";
         
                rs = st.executeQuery(sql);
               
                while(rs.next()){
                    Object[] row = new Object[jTableBiaya.getColumnCount()];
                    row[0] = rs.getInt("id_biaya");
                    row[1] = rs.getString("nama_biaya");
                    row[2] = rs.getInt("harga");
                    model.addRow(row);
                }
            } catch (Exception e) {
                System.out.println("Gagal");
            
        }
    } 
    
    public void updateBiaya(){
        String nama = jNamaBiaya.getText();
        String harga = jHarga.getText();
        connection = null;
        Statement st = null;
        
        if (connection == null){
            try {
                String url = "jdbc:mysql://localhost:3306/infotama_pool_cafe";
                String user = "root";
                String pass = "abduh";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connection = (Connection) DriverManager.getConnection(url, user, pass);
                //connection = koneksi.getConnection();
                st = connection.createStatement();
                String sql = "UPDATE biaya SET harga='"+harga+"' WHERE nama_biaya='"+nama+"' ";
                             
                st.execute(sql);
                JOptionPane.showMessageDialog(null, "Data harga berhasil diupdate");

                } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Gagal update data harga");
            }     
        }
    }
    private void tambahBiaya(){
        String nama = jNamaBiaya.getText();
        String harga = jHarga.getText();
        connection = null;
        Statement st = null;
        
        if (connection == null){
            try {
                String url = "jdbc:mysql://localhost:3306/infotama_pool_cafe";
                String user = "root";
                String pass = "abduh";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connection = (Connection) DriverManager.getConnection(url, user, pass);
                //connection = koneksi.getConnection();
                st = connection.createStatement();
                String sql = "INSERT INTO biaya(nama_biaya,harga) " +
                             "VALUES ('"+nama+"','"+harga+"')";

                st.execute(sql);
                JOptionPane.showMessageDialog(null, "Data Harga berhasil ditambahkan");
                //getDataBiaya();

                } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Gagal tambah data Harga");
                 
            }     
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        tampilData = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jHarga = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jNamaBiaya = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBiaya = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 204));
        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        tampilData.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(106, 106, 106));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Daftar Harga");

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

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("Jenis");

        jHarga.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jHarga.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("Harga");

        jNamaBiaya.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jNamaBiaya.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jTableBiaya.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTableBiaya.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Jenis", "Harga"
            }
        ));
        jTableBiaya.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBiayaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableBiaya);

        javax.swing.GroupLayout tampilDataLayout = new javax.swing.GroupLayout(tampilData);
        tampilData.setLayout(tampilDataLayout);
        tampilDataLayout.setHorizontalGroup(
            tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tampilDataLayout.createSequentialGroup()
                .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tampilDataLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tampilDataLayout.createSequentialGroup()
                                .addComponent(btn_tambah)
                                .addGap(47, 47, 47)
                                .addComponent(btn_hapus))
                            .addComponent(jLabel6)
                            .addComponent(jNamaBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jHarga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        tampilDataLayout.setVerticalGroup(
            tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(31, 31, 31)
                .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tampilDataLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNamaBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_tambah)
                            .addComponent(btn_hapus))
                        .addGap(156, 156, 156))
                    .addGroup(tampilDataLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        btn_tambah.setVisible(false);
        btn_hapus.setVisible(false);

        mainPanel.add(tampilData, "card2");

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        tambahBiaya();
        jNamaBiaya.setText("");
        jHarga.setText("");
        jNamaBiaya.requestFocus();
        getDataBiaya();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void jTableBiayaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBiayaMouseClicked
        DefaultTableModel model = (DefaultTableModel) jTableBiaya.getModel();
        Integer selectedIndex = jTableBiaya.getSelectedRow();
        jNamaBiaya.setText(model.getValueAt(selectedIndex, 1).toString());
        jHarga.setText(model.getValueAt(selectedIndex, 2).toString());
    }//GEN-LAST:event_jTableBiayaMouseClicked

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        String nama = jNamaBiaya.getText();
        String harga = jHarga.getText();
        connection = null;
        Statement st = null;
        
//        if (connection == null){
            try {
                String url = "jdbc:mysql://localhost:3306/infotama_pool_cafe";
                String user = "root";
                String pass = "abduh";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connection = (Connection) DriverManager.getConnection(url, user, pass);
                //connection = koneksi.getConnection();
                st = connection.createStatement();
                String sql = "UPDATE biaya SET harga='"+harga+"' WHERE nama_biaya='"+nama+"' ";
                             
                st.execute(sql);
                JOptionPane.showMessageDialog(null, "Data harga berhasil diupdate");
                table_update();
                jNamaBiaya.setText("");
                jHarga.setText("");

                } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Gagal update data harga");
            }     
//        }
        table_update();
    }//GEN-LAST:event_btn_editActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JTextField jHarga;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jNamaBiaya;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBiaya;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel tampilData;
    // End of variables declaration//GEN-END:variables
}
