package com.raven.form;

import com.raven.connection.SingletonConnection;
import com.raven.connection.koneksi;
import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserAdapter;
//import com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class FormLaporan extends javax.swing.JPanel {
    private Connection connection;
    private DateChooser chDate = new DateChooser();
    private DefaultTableModel model;
    
    public FormLaporan() {
        initComponents();
        //getDataTransaksi();
//        dateChooser1.toDay();
//        dateChooser2.toDay();
        chDate.setTextField(txtDate);
        chDate.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        chDate.setDateFormat(new SimpleDateFormat("YYYY-MM-dd"));
        model = (DefaultTableModel) jTableLaporan.getModel();
        chDate.addActionDateChooserListener(new DateChooserAdapter(){
            @Override
            public void dateBetweenChanged(DateBetween date, DateChooserAction action ){
                SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd");
                String dateFrom = df.format(date.getFromDate());
                String toDate = df.format(date.getToDate());
                loadData("SELECT * FROM transaksi WHERE tanggal_order BETWEEN '"+dateFrom+"' AND '"+toDate+"'");
                loadBiaya("SELECT SUM(total_biaya) AS \"Total Harga\" FROM transaksi WHERE tanggal_order BETWEEN '"+dateFrom+"' AND '"+toDate+"';");
            }
        });
        try {
            SingletonConnection.getInstance().connectDatabase();
        } catch (Exception e) {
            System.err.print(e);
        }
    }
    
    private void loadBiaya(String sql){
        try {
            SimpleDateFormat df = new SimpleDateFormat("YYY-MM-dd");
            DecimalFormat f = new DecimalFormat("#,##0.##");
            
            PreparedStatement p = SingletonConnection.getInstance().openConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();
            
            while (r.next()) {                
                txt_Total.setText(f.format(r.getDouble("Total Harga")));
            }
            r.close();
            p.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    private void loadData(String sql){
        try {
            model.setRowCount(0);
            SimpleDateFormat df = new SimpleDateFormat("YYY-MM-dd");
            DecimalFormat f = new DecimalFormat("#,##0.##");
            
            PreparedStatement p = SingletonConnection.getInstance().openConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();
            
            while (r.next()) {                
                Object[] row = new Object[jTableLaporan.getColumnCount()];
                    row[0] = r.getInt("id_order");
                    row[1] = df.format(r.getDate("tanggal_order"));
                    row[2] = r.getString("no_meja");
                    row[3] = r.getString("jam_mulai");
                    row[4] = r.getString("jam_selesai");
                    row[5] = r.getString("durasi");
                    row[6] = r.getString("member");
                    row[7] = r.getString("status_bayar");
                    row[8] = f.format(r.getDouble("total_biaya"));
                    model.addRow(row);
            }
            r.close();
            p.close();
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    private void getDataTransaksi(){
        connection = null;
        Statement st = null;
        ResultSet rs = null;
        DefaultTableModel model = (DefaultTableModel) jTableLaporan.getModel();
        model.setRowCount(0);
        
            try {
                connection = koneksi.getConnection();
                st = connection.createStatement();
                String sql = "SELECT * FROM transaksi";
         
                rs = st.executeQuery(sql);
               
                while(rs.next()){
                    Object[] row = new Object[jTableLaporan.getColumnCount()];
                    row[0] = rs.getInt("id_order");
                    row[1] = rs.getString("tanggal_order");
                    row[2] = rs.getString("no_meja");
                    row[3] = rs.getString("jam_mulai");
                    row[4] = rs.getString("jam_selesai");
                    row[5] = rs.getString("durasi");
                    row[6] = rs.getString("member");
                    row[7] = rs.getString("status_bayar");
                    row[8] = rs.getString("total_biaya");
                    model.addRow(row);
                }
            } catch (Exception e) {
                System.out.println("Gagal");
            
        }
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_Total = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLaporan = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(106, 106, 106));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Laporan Penyewaan Meja Billiard");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Tgl s/d Tgl :");

        txtDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Total :");

        txt_Total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jTableLaporan.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTableLaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Tanggal", "Meja", "Mulai", "Selesai", "Durasi", "Jenis", "Status", "Biaya"
            }
        ));
        jScrollPane1.setViewportView(jTableLaporan);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(txt_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLaporan;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txt_Total;
    // End of variables declaration//GEN-END:variables
}
