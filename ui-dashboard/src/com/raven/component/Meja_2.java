package com.raven.component;

import com.raven.connection.koneksi;
import com.raven.model.Model_Card;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Meja_2 extends javax.swing.JPanel implements ActionListener{
    
    static int milliseconds = 0;
    static int seconds = 0;
    static int minutes = 0;
    static int hours = 0;
    
    static int jam = 0;
    static int menit = 0;
    static int detik = 0;
    static int totalMenit = 0;
    static LocalDateTime totalJam;
    
    static int jamBiaya = 0;
    static int menitBiaya = 0;
    static int biayaTotal = 0;
    
    int counter1 = 1, counter2 = 1, counter3 = 3;
    
    static boolean state = true;
    
    public Connection connection;
    public Statement statement;
   
    String ddSecond, ddMinute, ddHour, ddJam, ddMenit, ddDetik;
    DecimalFormat ddFormat = new DecimalFormat("00");
    
    Timer timer;
    private Connection conn;
    
    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2){
        this.color2 = color2;
    }

    private Color color1;
    private Color color2;

    public Meja_2() {
        initComponents();
        curDate();
        setOpaque(false);
        color1 = Color.BLACK;
        color2 = Color.WHITE;
        jButtonRefresh.addActionListener(this);
        jButtonStart.addActionListener(this);
        jButtonLanjutkan.addActionListener(this);
        //getDataBiaya();
    }

    public void setData(Model_Card data) {
        lbIcon.setIcon(data.getIcon());
        //lbValues.setText(data.getValues());
        //lbDescription.setText(data.getDescription());
    }
    
    public void curDateTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        dateTime.setText(dtf.format(now));        
    }
    
    public void curDate(){
        DateTimeFormatter dtt = DateTimeFormatter.ofPattern("dd-MM-YYY");
        LocalDateTime now = LocalDateTime.now(); 
        jLabelTanggal.setText(dtt.format(now));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        lbValues4 = new javax.swing.JLabel();
        jButtonStart = new javax.swing.JButton();
        jButtonPause = new javax.swing.JButton();
        jSpinnerHour = new javax.swing.JSpinner();
        jSpinnerMinute = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonLanjutkan = new javax.swing.JButton();
        jComboBoxCust = new javax.swing.JComboBox<>();
        jButtonRefresh = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSpinnerSecond = new javax.swing.JSpinner();
        jNomorMeja = new javax.swing.JLabel();
        jTextFieldDiskon = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanelDurasi = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        dateTime = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelBiaya = new javax.swing.JLabel();
        sisaHour = new javax.swing.JLabel();
        durasiHour = new javax.swing.JLabel();
        durasiMinute = new javax.swing.JLabel();
        sisaMinute = new javax.swing.JLabel();
        sisaSecond = new javax.swing.JLabel();
        durasiSecond = new javax.swing.JLabel();
        durasiMillisecond = new javax.swing.JLabel();
        sisaMillisecond = new javax.swing.JLabel();
        jLabelSelesai = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelTanggal = new javax.swing.JLabel();
        jLabel_idorder = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/stock.png"))); // NOI18N

        lbTitle.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbTitle.setText("MEJA-");

        lbValues4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbValues4.setForeground(new java.awt.Color(255, 255, 255));
        lbValues4.setText("Lama Main :");

        jButtonStart.setText("Start");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jButtonPause.setText("Pause");
        jButtonPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPauseActionPerformed(evt);
            }
        });

        jSpinnerHour.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerHourStateChanged(evt);
            }
        });

        jSpinnerMinute.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerMinuteStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Jam");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Menit");

        jButtonLanjutkan.setText("Lanjutkan");
        jButtonLanjutkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLanjutkanActionPerformed(evt);
            }
        });

        jComboBoxCust.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reguler", "Paket", "Free", "Loss", "Member" }));
        jComboBoxCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCustActionPerformed(evt);
            }
        });

        jButtonRefresh.setText("Reset");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });
        jButtonRefresh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonRefreshKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Detik");

        jSpinnerSecond.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerSecondStateChanged(evt);
            }
        });

        jNomorMeja.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jNomorMeja.setForeground(new java.awt.Color(255, 255, 255));
        jNomorMeja.setText("2");

        jTextFieldDiskon.setText("0");
        jTextFieldDiskon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDiskonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Diskon");

        jPanelDurasi.setBackground(new java.awt.Color(204, 204, 204));
        jPanelDurasi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mulai   :");
        jLabel5.setToolTipText("");

        dateTime.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        dateTime.setForeground(new java.awt.Color(255, 255, 255));
        dateTime.setText("00 : 00 : 00");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Durasi :");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Sisa     :");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Biaya:");

        jLabelBiaya.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabelBiaya.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBiaya.setText("0");

        sisaHour.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        sisaHour.setForeground(new java.awt.Color(255, 255, 255));
        sisaHour.setText("00 :");

        durasiHour.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        durasiHour.setForeground(new java.awt.Color(255, 255, 255));
        durasiHour.setText("00 :");

        durasiMinute.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        durasiMinute.setForeground(new java.awt.Color(255, 255, 255));
        durasiMinute.setText("00 :");

        sisaMinute.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        sisaMinute.setForeground(new java.awt.Color(255, 255, 255));
        sisaMinute.setText("00 :");

        sisaSecond.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        sisaSecond.setForeground(new java.awt.Color(255, 255, 255));
        sisaSecond.setText("00");

        durasiSecond.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        durasiSecond.setForeground(new java.awt.Color(255, 255, 255));
        durasiSecond.setText("00");

        durasiMillisecond.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        durasiMillisecond.setForeground(new java.awt.Color(255, 255, 255));
        durasiMillisecond.setText("00");

        sisaMillisecond.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        sisaMillisecond.setForeground(new java.awt.Color(255, 255, 255));
        sisaMillisecond.setText("00");

        jLabelSelesai.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabelSelesai.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSelesai.setText("00 : 00 : 00");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selesai:");

        javax.swing.GroupLayout jPanelDurasiLayout = new javax.swing.GroupLayout(jPanelDurasi);
        jPanelDurasi.setLayout(jPanelDurasiLayout);
        jPanelDurasiLayout.setHorizontalGroup(
            jPanelDurasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDurasiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDurasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDurasiLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelBiaya))
                    .addGroup(jPanelDurasiLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateTime))
                    .addGroup(jPanelDurasiLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sisaHour)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sisaMinute)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sisaSecond)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sisaMillisecond))
                    .addGroup(jPanelDurasiLayout.createSequentialGroup()
                        .addGroup(jPanelDurasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDurasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSelesai)
                            .addGroup(jPanelDurasiLayout.createSequentialGroup()
                                .addComponent(durasiHour)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(durasiMinute)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(durasiSecond)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(durasiMillisecond)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDurasiLayout.setVerticalGroup(
            jPanelDurasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDurasiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelDurasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dateTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDurasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSelesai)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDurasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(durasiHour)
                    .addComponent(durasiMinute)
                    .addComponent(durasiSecond)
                    .addComponent(durasiMillisecond))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDurasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(sisaHour)
                    .addComponent(sisaMinute)
                    .addComponent(sisaSecond)
                    .addComponent(sisaMillisecond))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDurasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabelBiaya)))
        );

        durasiMillisecond.setVisible(false);
        sisaMillisecond.setVisible(false);

        jLabelTanggal.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabelTanggal.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_idorder.setText("id order");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButtonStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPause)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLanjutkan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRefresh))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jSpinnerHour, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinnerSecond, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_idorder)
                                .addGap(13, 13, 13)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbIcon)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabelTanggal))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jNomorMeja))))
                    .addComponent(lbValues4)
                    .addComponent(jTextFieldDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCust, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDurasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbTitle)
                                .addComponent(jNomorMeja))
                            .addComponent(lbIcon))
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbValues4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTanggal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelDurasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_idorder)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerSecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonStart)
                    .addComponent(jButtonPause)
                    .addComponent(jButtonLanjutkan)
                    .addComponent(jButtonRefresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelDurasi.setBackground(Color.GRAY);
        jLabelTanggal.setVisible(false);
        jLabel_idorder.setVisible(false);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        
        state = true;
        detik = (int) jSpinnerSecond.getValue();
        menit = (int) jSpinnerMinute.getValue();
        jam = (int) jSpinnerHour.getValue();
        String lossReguler = jComboBoxCust.getSelectedItem().toString();
        
        
        //Integer biayapermenit = (int) biayamenit;
        Thread t = new Thread(){ 
            public void run(){
                if ("Reguler".equals(lossReguler)) {
                    for(;;){
                        if(state==true){
                        try{
                            sleep(1);
                            milliseconds++;
                            durasiMillisecond.setText(" : "+milliseconds);
                            if(milliseconds > 1000){
                                milliseconds = 0;
                                seconds++;
                                ddSecond = ddFormat.format(seconds);
                                durasiSecond.setText(ddSecond);
                                detik--;
                                ddDetik = ddFormat.format(detik);
                            }
                            if(seconds > 60){
                                milliseconds = 0;
                                seconds = 0;
                                minutes++;
                                ddMinute = ddFormat.format(minutes);
                                durasiMinute.setText(ddMinute + " : ");
                                menit--;
                                ddMenit = ddFormat.format(menit);
                                sisaMinute.setText(ddMenit + " : ");
                            }
                            if(minutes > 60){
                                milliseconds = 0;
                                seconds = 0;
                                minutes = 0;
                                hours++;
                                ddHour = ddFormat.format(hours);
                                durasiHour.setText(""+ ddHour);
                                jam--;
                                ddJam = ddFormat.format(jam);
                                sisaHour.setText(ddJam);
                                //menit = 60;
                            }
                            if(menit == -1){
                                menit = 59;
                                menit--;
                                ddMenit = ddFormat.format(menit);
                                sisaMinute.setText(" : " + ddMenit);
                                jam--;
                                ddJam = ddFormat.format(jam);
                                sisaHour.setText(ddJam + " : ");
                            }
                            if( jam == 0 && menit <= 5){
                               jPanelDurasi.setBackground(Color.RED); 
                               updateTransaksi5m();
                               onOffLampu5m();

                             }
                            if(seconds == (int) jSpinnerSecond.getValue()  && minutes == (int) jSpinnerMinute.getValue() && hours == (int) jSpinnerHour.getValue()){
                                state = false;
                                jPanelDurasi.setBackground(Color.GRAY);
                                jButtonStart.setEnabled(true);
                                jSpinnerHour.setEnabled(true);
                                jSpinnerMinute.setEnabled(true);
                                jSpinnerSecond.setEnabled(true);
                                jComboBoxCust.setEnabled(true);
                                jTextFieldDiskon.setEditable(true);
                                jSpinnerHour.setValue(0);
                                jSpinnerMinute.setValue(0);
                                jSpinnerMinute.setValue(0);
                                updateTransaksi();
                                offLampu();

                            }
                            if(jam == 0 && menit == 00){
                                state = false;
                                jPanelDurasi.setBackground(Color.GRAY);
                                jButtonStart.setEnabled(true);
                                jSpinnerHour.setEnabled(true);
                                jSpinnerMinute.setEnabled(true);
                                jSpinnerSecond.setEnabled(true);
                                jComboBoxCust.setEnabled(true);
                                jTextFieldDiskon.setEditable(true);
                                jSpinnerHour.setValue(0);
                                jSpinnerMinute.setValue(0);
                                jSpinnerMinute.setValue(0);
                            }
                            
                        }
                        catch(Exception e){  
                        }
                    }
                    }
                }
                if ("Paket".equals(lossReguler)) {
                    for(;;){
                        if(state==true){
                        try{
                            sleep(1);
                            milliseconds++;
                            durasiMillisecond.setText(" : "+milliseconds);
                            if(milliseconds > 1000){
                                milliseconds = 0;
                                seconds++;
                                ddSecond = ddFormat.format(seconds);
                                durasiSecond.setText(ddSecond);
                                detik--;
                                ddDetik = ddFormat.format(detik);
                            }
                            if(seconds > 60){
                                milliseconds = 0;
                                seconds = 0;
                                minutes++;
                                ddMinute = ddFormat.format(minutes);
                                durasiMinute.setText(ddMinute + " : ");
                                menit--;
                                ddMenit = ddFormat.format(menit);
                                sisaMinute.setText(ddMenit + " : ");
                            }
                            if(minutes > 60){
                                milliseconds = 0;
                                seconds = 0;
                                minutes = 0;
                                hours++;
                                ddHour = ddFormat.format(hours);
                                durasiHour.setText(""+ ddHour);
                                jam--;
                                ddJam = ddFormat.format(jam);
                                sisaHour.setText(ddJam);
                                //menit = 60;
                            }
                            if(menit == -1){
                                menit = 59;
                                menit--;
                                ddMenit = ddFormat.format(menit);
                                sisaMinute.setText(" : " + ddMenit);
                                jam--;
                                ddJam = ddFormat.format(jam);
                                sisaHour.setText(ddJam + " : ");
                            }
                            if( jam == 0 && menit <= 5){
                               jPanelDurasi.setBackground(Color.RED); 
                               updateTransaksi5m();
                               onOffLampu5m();
                             }
                            if(seconds == (int) jSpinnerSecond.getValue()  && minutes == (int) jSpinnerMinute.getValue() && hours == (int) jSpinnerHour.getValue()){
                                state = false;
                                jPanelDurasi.setBackground(Color.GRAY);
                                jButtonStart.setEnabled(true);
                                jSpinnerHour.setEnabled(true);
                                jSpinnerMinute.setEnabled(true);
                                jSpinnerSecond.setEnabled(true);
                                jComboBoxCust.setEnabled(true);
                                jTextFieldDiskon.setEditable(true);
                                jSpinnerHour.setValue(0);
                                jSpinnerMinute.setValue(0);
                                jSpinnerMinute.setValue(0);
                                updateTransaksi();
                                offLampu();
                            }
                            if(jam == 0 && menit == 00){
                                state = false;
                                jPanelDurasi.setBackground(Color.GRAY);
                                jButtonStart.setEnabled(true);
                                jSpinnerHour.setEnabled(true);
                                jSpinnerMinute.setEnabled(true);
                                jSpinnerSecond.setEnabled(true);
                                jComboBoxCust.setEnabled(true);
                                jTextFieldDiskon.setEditable(true);
                                jSpinnerHour.setValue(0);
                                jSpinnerMinute.setValue(0);
                                jSpinnerMinute.setValue(0);
                                updateTransaksi();
                            }
                            
                        }
                        catch(Exception e){  
                        }
                    }
                    }
                }
                if ("Free".equals(lossReguler)) {
                    for(;;){
                        if(state==true){
                        try{
                            sleep(1);
                            milliseconds++;
                            durasiMillisecond.setText(" : "+milliseconds);
                            if(milliseconds > 1000){
                                milliseconds = 0;
                                seconds++;
                                ddSecond = ddFormat.format(seconds);
                                durasiSecond.setText(ddSecond);
                                detik--;
                                ddDetik = ddFormat.format(detik);
                            }
                            if(seconds > 60){
                                milliseconds = 0;
                                seconds = 0;
                                minutes++;
                                ddMinute = ddFormat.format(minutes);
                                durasiMinute.setText(ddMinute + " : ");
                                menit--;
                                ddMenit = ddFormat.format(menit);
                                sisaMinute.setText(ddMenit + " : ");
                            }
                            if(minutes > 60){
                                milliseconds = 0;
                                seconds = 0;
                                minutes = 0;
                                hours++;
                                ddHour = ddFormat.format(hours);
                                durasiHour.setText(""+ ddHour);
                                jam--;
                                ddJam = ddFormat.format(jam);
                                sisaHour.setText(ddJam);
                                //menit = 60;
                            }
                            if(menit == -1){
                                menit = 59;
                                menit--;
                                ddMenit = ddFormat.format(menit);
                                sisaMinute.setText(" : " + ddMenit);
                                jam--;
                                ddJam = ddFormat.format(jam);
                                sisaHour.setText(ddJam + " : ");
                            }
                            if( jam == 0 && menit <= 5){
                               jPanelDurasi.setBackground(Color.RED); 
                               updateTransaksi5m();
                               onOffLampu5m();
                             }
                            if(seconds == (int) jSpinnerSecond.getValue()  && minutes == (int) jSpinnerMinute.getValue() && hours == (int) jSpinnerHour.getValue()){
                                state = false;
                                jPanelDurasi.setBackground(Color.GRAY);
                                jButtonStart.setEnabled(true);
                                jSpinnerHour.setEnabled(true);
                                jSpinnerMinute.setEnabled(true);
                                jSpinnerSecond.setEnabled(true);
                                jComboBoxCust.setEnabled(true);
                                jTextFieldDiskon.setEditable(true);
                                jSpinnerHour.setValue(0);
                                jSpinnerMinute.setValue(0);
                                jSpinnerMinute.setValue(0);
                                updateTransaksi();
                                offLampu();
                            }
                            if(jam == 0 && menit == 00){
                                state = false;
                                jPanelDurasi.setBackground(Color.GRAY);
                                jButtonStart.setEnabled(true);
                                jSpinnerHour.setEnabled(true);
                                jSpinnerMinute.setEnabled(true);
                                jSpinnerSecond.setEnabled(true);
                                jComboBoxCust.setEnabled(true);
                                jTextFieldDiskon.setEditable(true);
                                jSpinnerHour.setValue(0);
                                jSpinnerMinute.setValue(0);
                                jSpinnerMinute.setValue(0);
                            }
                            
                        }
                        catch(Exception e){  
                        }
                        }
                    }
                }
                if ("Loss".equals(lossReguler)) {
                    jSpinnerHour.setEnabled(false);
                    jSpinnerMinute.setEnabled(false);
                    jSpinnerSecond.setEnabled(false);
                    Double biayapermenit = Double.parseDouble(jLabelBiaya.getText());
                    DecimalFormat f = new DecimalFormat("#,##0.##");
                    for (;;) {
                        if (state == true) {
                            try {
                                sleep(1);
                                milliseconds++;
                                durasiMillisecond.setText(" : "+milliseconds);
                                if(milliseconds > 1000){
                                        milliseconds = 0;
                                        seconds++;
                                        ddSecond = ddFormat.format(seconds);
                                        durasiSecond.setText(ddSecond);    
                                    }
                                if(seconds > 60){
                                        milliseconds = 0;
                                        seconds = 0;
                                        minutes++;
                                        ddMinute = ddFormat.format(minutes);
                                        durasiMinute.setText(ddMinute + " : ");
                                        biayaTotal = (int) (minutes * biayapermenit);
                                        jLabelBiaya.setText(f.format(biayaTotal));
                                    }
                                if(minutes > 60){
                                        milliseconds = 0;
                                        seconds = 0;
                                        minutes = 0;
                                        hours++;
                                        ddHour = ddFormat.format(hours);
                                        durasiHour.setText(""+ ddHour); 
                                    }
                                   
                                } 
                            catch (Exception e) {
                             }
                            }
                            
                        }
                                
                }
                if ("Member".equals(lossReguler)) {
                    for(;;){
                        if(state==true){
                        try{
                            sleep(1);
                            milliseconds++;
                            durasiMillisecond.setText(" : "+milliseconds);
                            if(milliseconds > 1000){
                                milliseconds = 0;
                                seconds++;
                                ddSecond = ddFormat.format(seconds);
                                durasiSecond.setText(ddSecond);
                                detik--;
                                ddDetik = ddFormat.format(detik);
                            }
                            if(seconds > 60){
                                milliseconds = 0;
                                seconds = 0;
                                minutes++;
                                ddMinute = ddFormat.format(minutes);
                                durasiMinute.setText(ddMinute + " : ");
                                menit--;
                                ddMenit = ddFormat.format(menit);
                                sisaMinute.setText(ddMenit + " : ");
                            }
                            if(minutes > 60){
                                milliseconds = 0;
                                seconds = 0;
                                minutes = 0;
                                hours++;
                                ddHour = ddFormat.format(hours);
                                durasiHour.setText(""+ ddHour);
                                jam--;
                                ddJam = ddFormat.format(jam);
                                sisaHour.setText(ddJam);
                                //menit = 60;
                            }
                            if(menit == -1){
                                menit = 59;
                                menit--;
                                ddMenit = ddFormat.format(menit);
                                sisaMinute.setText(" : " + ddMenit);
                                jam--;
                                ddJam = ddFormat.format(jam);
                                sisaHour.setText(ddJam + " : ");
                            }
                            if( jam == 0 && menit <= 5){
                               jPanelDurasi.setBackground(Color.RED); 
                               updateTransaksi5m();
                               onOffLampu5m();
                             }
                            if(seconds == (int) jSpinnerSecond.getValue()  && minutes == (int) jSpinnerMinute.getValue() && hours == (int) jSpinnerHour.getValue()){
                                state = false;
                                jPanelDurasi.setBackground(Color.GRAY);
                                jButtonStart.setEnabled(true);
                                jSpinnerHour.setEnabled(true);
                                jSpinnerMinute.setEnabled(true);
                                jSpinnerSecond.setEnabled(true);
                                jComboBoxCust.setEnabled(true);
                                jTextFieldDiskon.setEditable(true);
                                jSpinnerHour.setValue(0);
                                jSpinnerMinute.setValue(0);
                                jSpinnerMinute.setValue(0);
                                updateTransaksi();
                                offLampu();
                            }
                            if(jam == 0 && menit == 00){
                                state = false;
                                jPanelDurasi.setBackground(Color.GRAY);
                                jButtonStart.setEnabled(true);
                                jSpinnerHour.setEnabled(true);
                                jSpinnerMinute.setEnabled(true);
                                jSpinnerSecond.setEnabled(true);
                                jComboBoxCust.setEnabled(true);
                                jTextFieldDiskon.setEditable(true);
                                jSpinnerHour.setValue(0);
                                jSpinnerMinute.setValue(0);
                                jSpinnerMinute.setValue(0);
                                updateTransaksi();
                            }
                            
                        }
                        catch(Exception e){  
                        }
                    }
                    }
                }
            }
        };
        t.start();
        curDateTime();
        convertTominutes();
        jSpinnerHour.setEnabled(false);
        jSpinnerMinute.setEnabled(false);
        jSpinnerSecond.setEnabled(false);
        jPanelDurasi.setBackground(Color.BLUE);
        jComboBoxCust.setEnabled(false);
        jTextFieldDiskon.setEditable(false);
        jButtonStart.setEnabled(false);
        tambahTransaksi();
        getDataTransaksi();
        onLampu();

        
    }//GEN-LAST:event_jButtonStartActionPerformed
    public void onLampu(){
        byte[] ipServer={ (byte)192 , (byte)168 , (byte)1, (byte)111 };
        Thread threadon = new Thread(){
            public void run (){
                try {
                Socket s=new Socket(InetAddress.getByAddress(ipServer),5000);
                OutputStream sout = s.getOutputStream();
                DataInputStream sin = new DataInputStream(s.getInputStream());
                DataInputStream keyboard = new DataInputStream(System.in);
                String command = "lampu meja 4 ON";
                String response ;
                
                if (command.equals("lampu meja 4 ON")){
                    sout.write("g".getBytes());
                    response=sin.readLine();
                    System.out.println(response);
                } 
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Tidak dapat mengirimkan data ke arduino");
                }
            }
        };
        threadon.start();
    }
    
    public void offLampu(){
        byte[] ipServer={ (byte)192 , (byte)168 , (byte)1, (byte)111 };
                                Thread threadoff = new Thread(){
                                    public void run (){
                                        try {
                                            Socket s=new Socket(InetAddress.getByAddress(ipServer),5000);
                                            OutputStream sout = s.getOutputStream();
                                            DataInputStream sin = new DataInputStream(s.getInputStream());
                                            DataInputStream keyboard = new DataInputStream(System.in);
                                            String command = "lampu meja 4 OFF";
                                            String response ;
                
                                            if (command.equals("lampu meja 4 OFF")){
                                                sout.write("h".getBytes());
                                                response=sin.readLine();
                                                System.out.println(response);
                                            } 
                                        } catch (Exception e) {
                                            JOptionPane.showMessageDialog(null, "Tidak dapat mengirimkan data ke arduino");
                                        }
                                    }
                                };
                                threadoff.start();
    }
    
    public void onOffLampu5m(){
        byte[] ipServer={ (byte)192 , (byte)168 , (byte)1, (byte)111 };
            Thread threadonoff = new Thread(){
                public void run (){
                    try {
                        Socket s=new Socket(InetAddress.getByAddress(ipServer),5000);
                        OutputStream sout = s.getOutputStream();
                        DataInputStream sin = new DataInputStream(s.getInputStream());
                        DataInputStream keyboard = new DataInputStream(System.in);
                        String command = "lampu meja 4 ONOFF";
                        String response ;
                
                        if (command.equals("lampu meja 4 ONOFF")){
                            sout.write("1".getBytes());
                            response=sin.readLine();
                            System.out.println(response);
                        } 
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Tidak dapat mengirimkan data ke arduino");
                    }
                }
            };
            threadonoff.start();
    }
    private void jButtonPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPauseActionPerformed
        state = false;      
    }//GEN-LAST:event_jButtonPauseActionPerformed

    private void jSpinnerHourStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerHourStateChanged
        jam = (int) jSpinnerHour.getValue();
        ddJam = ddFormat.format(jam);
        sisaHour.setText(ddJam + " : ");
        //jamBiayaTotal();
        getDataBiaya();
        convertTominutes();
    }//GEN-LAST:event_jSpinnerHourStateChanged

    private void jSpinnerMinuteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerMinuteStateChanged
        menit = (int) jSpinnerMinute.getValue();
        ddMenit = ddFormat.format(menit);
        sisaMinute.setText(ddMenit + " : ");
        jamBiayaTotal();
        convertTominutes();
    }//GEN-LAST:event_jSpinnerMinuteStateChanged

    private void jSpinnerSecondStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerSecondStateChanged
        // TODO add your handling code here:
        detik = (int) jSpinnerSecond.getValue();
        ddDetik = ddFormat.format(detik);
        sisaSecond.setText(ddDetik);
    }//GEN-LAST:event_jSpinnerSecondStateChanged

    private void jTextFieldDiskonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDiskonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDiskonActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        
        state = false;
        jPanelDurasi.setBackground(Color.GRAY);
        jButtonStart.setEnabled(true);
        jSpinnerHour.setEnabled(true);
        jSpinnerMinute.setEnabled(true);
        jSpinnerSecond.setEnabled(true);
        jComboBoxCust.setEnabled(true);
        jTextFieldDiskon.setEditable(true);
        jSpinnerHour.setValue(0);
        jSpinnerMinute.setValue(0);
        jSpinnerMinute.setValue(0);
        dateTime.setText("00 : 00 : 00");
        jLabelSelesai.setText("00 : 00 : 00");
        durasiSecond.setText("00");
        durasiMinute.setText("00 :" );
        durasiHour.setText("00 :");
        sisaHour.setText("00 :");
        sisaMinute.setText("00 :");
        sisaSecond.setText("00");
        durasiMillisecond.setText("00");
        sisaMillisecond.setText("00");
        jButtonStart.setEnabled(true);
        //jButtonRefresh.addActionListener(this);
        updateTransaksi();
       offLampu();
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void jComboBoxCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCustActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCustActionPerformed

    private void jButtonLanjutkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLanjutkanActionPerformed
        // TODO add your handling code here:
        state = true;
        jButtonStart.setEnabled(false);
        //jButtonLanjutkan.addActionListener(this);
        //getDataTransaksi();
        getDataBiaya();
    }//GEN-LAST:event_jButtonLanjutkanActionPerformed

    private void jButtonRefreshKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonRefreshKeyPressed
        // TODO add your handling code here:
        //jButtonRefresh.addActionListener(this);
        state = false;
        
    }//GEN-LAST:event_jButtonRefreshKeyPressed
    
    public void convertTominutes(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        menit = (int) jSpinnerMinute.getValue();
        jam = (int) jSpinnerHour.getValue();
        totalMenit = (jam * 60) + menit;
        //now.plusMinutes(totalMenit);
        jLabelSelesai.setText(dtf.format(now.plusMinutes(totalMenit)));
        
    }
    public void jamBiayaTotal(){
        
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        
        
        Integer biayaperjam = 30000;
        Integer biayapermenit = 15000;
        jamBiaya = (int) jSpinnerHour.getValue();
        menitBiaya = (int) jSpinnerMinute.getValue();
        
        if (jamBiaya >= 1) {
            biayaTotal = (jamBiaya * biayaperjam);
            jLabelBiaya.setText(Integer.toString(biayaTotal));
            //kursIndonesia.format(jLabelBiaya.setText(Integer.toString(biayaTotal)));
            System.out.printf("Harga Rupiah: %s %n", kursIndonesia.format(biayaTotal));
        }
        if (jamBiaya  >=1 && menitBiaya >= 30) {
            biayaTotal = (jamBiaya * biayaperjam) + biayapermenit;
            jLabelBiaya.setText(Integer.toString(biayaTotal));
            System.out.printf("Harga Rupiah: %s %n", kursIndonesia.format(biayaTotal));
        }
        
    }
    
    public void itemStateChange(ItemEvent e){
        System.out.println(jComboBoxCust.getSelectedItem());
    }
    
    public void biayaLossReguler(){
        connection = null;
        Statement st = null;
        ResultSet rs = null;
        String namapaket = jComboBoxCust.getSelectedItem().toString();
        jamBiaya = (int) jSpinnerHour.getValue();
        DecimalFormat f = new DecimalFormat("#,##0.##");
        if (connection == null){
            try {
                String url = "jdbc:mysql://localhost:3306/infotama_pool_cafe";
                String user = "root";
                String pass = "@Hazlam2024";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connection = (Connection) DriverManager.getConnection(url, user, pass);
                //connection = koneksi.getConnection();
                st = connection.createStatement();
                
                String sql = "SELECT * FROM biaya WHERE nama_biaya LIKE '%"+namapaket+"%' ORDER BY id_biaya DESC LIMIT 1";
                rs = st.executeQuery(sql);         

                if (rs.next()) {
                    //JOptionPane.showMessageDialog(null, "Data transaksi berhasil diupdate");
                    Integer idbiaya = rs.getInt("id_biaya");
                    String namabiaya = rs.getString("nama_biaya");
                    Integer harga = rs.getInt("harga");
                    
                    //jLabel_idorder.setText(Integer.toString(idorder));
                    if ("Loss".equals(namapaket)) {
                        biayaTotal = (jamBiaya * harga);
                        jLabelBiaya.setText(Integer.toString(biayaTotal));
                        //kursIndonesia.format(jLabelBiaya.setText(Integer.toString(biayaTotal)));
                        
        }
                    System.out.println(idbiaya);
                    System.out.println(namabiaya);
                    System.out.println(harga);
                    connection.close();
                }
            } 
            catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Gagal get data");
                 System.out.println("Gagal get data biaya");
            }     
        }
    }
    
    public void jamSelesai(){
        String mulai = dateTime.getText().toString();
        Integer selesaiJam = (int) jSpinnerHour.getValue();
        Integer selesaiMenit = (int) jSpinnerMinute.getValue();
    }
    public void tambahTransaksi(){
        String no_meja = jNomorMeja.getText();
        String jamMulai = dateTime.getText();
        String jamSelesai = jLabelSelesai.getText();
        String totalBiaya = jLabelBiaya.getText();
        String durasi = jSpinnerHour.getValue().toString() + ":" + jSpinnerMinute.getValue().toString();
        //durasi = (int) jSpinnerHour.getValue();
        String member = jComboBoxCust.getSelectedItem().toString();
        String diskon = jTextFieldDiskon.getText();
        String statusOrder = "0";
        String statusBayar = "Lunas";
        String tanggalOrder = jLabelTanggal.getText();
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
                String sql = "INSERT INTO transaksi(no_meja,jam_mulai,jam_selesai,total_biaya,durasi,member,diskon,status_order,status_bayar,tanggal_order) " +
                             "VALUES ('"+no_meja+"','"+jamMulai+"','"+jamSelesai+"','"+totalBiaya+"','"+durasi+"','"+member+"','"+diskon+"','"+statusOrder+"','"+statusBayar+"','"+tanggalOrder+"')";

                st.execute(sql);
                JOptionPane.showMessageDialog(null, "Data transaksi berhasil ditambahkan");
                connection.close();

                } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Gagal tambah data transaksi");
                 
            }     
        }
    }
    public void updateTransaksi(){
        String no_meja = jNomorMeja.getText();
        String id_order = jLabel_idorder.getText();
        String statusOrder = "1";
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
                String sql = "UPDATE transaksi SET status_order='"+statusOrder+"' WHERE id_order='"+id_order+"' ";
                             
                st.execute(sql);
                JOptionPane.showMessageDialog(null, "Data transaksi berhasil diupdate");

                } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Gagal tambah data transaksi");
            }     
        }
    }
    
    public void updateTransaksi5m(){
        String no_meja = jNomorMeja.getText();
        String id_order = jLabel_idorder.getText();
        String statusOrder = "01";
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
                String sql = "UPDATE transaksi SET status_order='"+statusOrder+"' WHERE id_order='"+id_order+"'";
                             

                st.execute(sql);
                JOptionPane.showMessageDialog(null, "Data transaksi berhasil diupdate");
                connection.close();

                } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Gagal tambah data transaksi");
            }     
        }
    }
    public void getDataTransaksi(){
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
                
                String sql = "SELECT * FROM transaksi ORDER BY id_order DESC LIMIT 1";
                rs = st.executeQuery(sql);         

                if (rs.next()) {
                    //JOptionPane.showMessageDialog(null, "Data transaksi berhasil diupdate");
                    Integer idorder = rs.getInt("id_order");
                    String nomeja = rs.getString("no_meja");
                    
                    jLabel_idorder.setText(Integer.toString(idorder));
                    
//                    System.out.println(idorder);
//                    System.out.println(nomeja);
                    connection.close();
                }
            } 
            catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Gagal get data");
                 System.out.println("Gagal get data");
            }     
        }
    }
    
    public void getDataBiaya(){
        connection = null;
        Statement st = null;
        ResultSet rs = null;
        String namapaket = jComboBoxCust.getSelectedItem().toString();
        jamBiaya = (int) jSpinnerHour.getValue();
        DecimalFormat f = new DecimalFormat("#,##0.##");
        if (connection == null){
            try {
                String url = "jdbc:mysql://localhost:3306/infotama_pool_cafe";
                String user = "root";
                String pass = "@Hazlam2024";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connection = (Connection) DriverManager.getConnection(url, user, pass);
                //connection = koneksi.getConnection();
                st = connection.createStatement();
                
                String sql = "SELECT * FROM biaya WHERE nama_biaya LIKE '%"+namapaket+"%' ORDER BY id_biaya DESC LIMIT 1";
                rs = st.executeQuery(sql);         

                if (rs.next()) {
                    //JOptionPane.showMessageDialog(null, "Data transaksi berhasil diupdate");
                    Integer idbiaya = rs.getInt("id_biaya");
                    String namabiaya = rs.getString("nama_biaya");
                    Integer harga = rs.getInt("harga");
                    
                    //jLabel_idorder.setText(Integer.toString(idorder));
                    if (jamBiaya >= 1) {
                        biayaTotal = (jamBiaya * harga);
                        jLabelBiaya.setText(f.format(biayaTotal));
                        //kursIndonesia.format(jLabelBiaya.setText(Integer.toString(biayaTotal)));
                        
        }
                    System.out.println(idbiaya);
                    System.out.println(namabiaya);
                    System.out.println(harga);
                    connection.close();
                }
            } 
            catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Gagal get data");
                 System.out.println("Gagal get data biaya");
            }     
        }
    }
    public void onOffLampu(){
        byte[] ipServer={ (byte)192 , (byte)168 , (byte)1, (byte)111 }; //that is your router's public ip
	try{	
		Socket s=new Socket(InetAddress.getByAddress(ipServer),5000);
		OutputStream sout=s.getOutputStream();
		DataInputStream sin=new DataInputStream(s.getInputStream());
		DataInputStream keyboard=new DataInputStream(System.in);
		String command,response ;
		
            OUTER:
            while (true) {
                command=keyboard.readLine();
//                if (command.equals("TURN ON lampu meja 1")){
//                    sout.write("a".getBytes());
//                    response=sin.readLine();
//                    System.out.println(response);
//                }
//                else if (command.equals("TURN OFF lampu meja 1")){
//                    sout.write("b".getBytes());
//                    response=sin.readLine();
//                    System.out.println(response);
//                }
                switch (command) {
                    case "lampu meja 1 ON": 
                        sout.write("a".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 1 OFF":
                        sout.write("b".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 2 ON": 
                        sout.write("c".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 2 OFF":
                        sout.write("d".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 3 ON": 
                        sout.write("e".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 3 OFF":
                        sout.write("f".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 4 ON": 
                        sout.write("g".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 4 OFF": 
                        sout.write("h".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 5 ON":
                        sout.write("i".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 5 OFF": 
                        sout.write("j".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 6 ON": 
                        sout.write("k".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 6 OFF": 
                        sout.write("l".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 7 ON":
                        sout.write("m".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 7 OFF":
                        sout.write("n".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 8 ON":
                        sout.write("o".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 8 OFF":
                        sout.write("p".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 9 ON":
                        sout.write("q".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 9 OFF":
                        sout.write("r".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 10 ON":
                        sout.write("s".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 10 OFF":
                        sout.write("t".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 11 ON":
                        sout.write("u".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 11 OFF":
                        sout.write("v".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 12 ON":
                        sout.write("w".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 12 OFF":
                        sout.write("x".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 13 ON":
                        sout.write("y".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "lampu meja 13 OFF":
                        sout.write("z".getBytes());
                        response=sin.readLine();
                        System.out.println(response);
                        break;
                    case "EXIT":
                        s.close();
                        break OUTER;
                        
                    default:
                        //the user didn't enter one of the known commands
                        System.out.println("THE KNOWN COMMANDS ARE THE FOLLOWING:");
                        System.out.println("TURN ON");
                        System.out.println("TURN OFF");
                        System.out.println("EXIT");
                        
                }
            }	
	 }catch(IOException e){
		 System.out.println(e.getMessage());
	         System.exit(0);
	 }
    }
    
    @Override
    public void actionPerformed(ActionEvent evt){
        
        if (evt.getSource() == jButtonStart) {
            System.out.println("click button start");
        }
        if (evt.getSource() == jButtonRefresh) {
            System.out.println("clik button reset");
        }
        if (evt.getSource() == jButtonLanjutkan) {
            System.out.println("Clik button lanjutkan");
            state = true;
        }

    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(new Color(255, 255, 255, 50));
        g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
        g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
        super.paintComponent(grphcs);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateTime;
    private javax.swing.JLabel durasiHour;
    private javax.swing.JLabel durasiMillisecond;
    private javax.swing.JLabel durasiMinute;
    private javax.swing.JLabel durasiSecond;
    private javax.swing.JButton jButtonLanjutkan;
    private javax.swing.JButton jButtonPause;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JComboBox<String> jComboBoxCust;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBiaya;
    private javax.swing.JLabel jLabelSelesai;
    private javax.swing.JLabel jLabelTanggal;
    private javax.swing.JLabel jLabel_idorder;
    private javax.swing.JLabel jNomorMeja;
    private javax.swing.JPanel jPanelDurasi;
    private javax.swing.JSpinner jSpinnerHour;
    private javax.swing.JSpinner jSpinnerMinute;
    private javax.swing.JSpinner jSpinnerSecond;
    private javax.swing.JTextField jTextFieldDiskon;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbValues4;
    private javax.swing.JLabel sisaHour;
    private javax.swing.JLabel sisaMillisecond;
    private javax.swing.JLabel sisaMinute;
    private javax.swing.JLabel sisaSecond;
    // End of variables declaration//GEN-END:variables
}
