package com.raven.main;

import com.formdev.flatlaf.FlatLaf;
import com.raven.connection.DatabaseConnection;
import com.raven.connection.koneksi;
import com.raven.event.EventMenuSelected;
import com.raven.form.FormAdmin;
import com.raven.form.FormMember;
import com.raven.form.FormMakanan;
import com.raven.form.FormLaporan;
import com.raven.form.FormHome;
import com.raven.form.FormBiaya;
import com.raven.form.FormUser;
import com.raven.form.JDialogMember;
import static com.raven.main.Menu_Utama.showOnScreen;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Menu_Utama1 extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    //private FormHome formHome;
    private FormMember formMember;
    private FormMakanan formMakanan;
    private FormLaporan formLaporan;
    private FormBiaya formBiaya;
    private FormUser formUser;
    //private JDialogMember formMember;
    
    private Color color1;
    private Color color2;
    private Connection connection;

    public Menu_Utama1() {
        initComponents();
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setBackground(new Color(0, 0, 0, 0));
        //setUndecorated(false);
//        Dimension dim= Toolkit.getDefaultToolkit().getScreenSize();
//        showOnScreen(1, this);
        //formHome = new FormHome();
        formMember = new FormMember();
        formMakanan = new FormMakanan();
        formLaporan = new FormLaporan();
        formBiaya = new FormBiaya();
        formUser = new FormUser();
        
        menu1.initMoving(Menu_Utama1.this);
        
        menu1.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
//                if (index == 0) {
//                    setForm(formHome);
//                }  
                if (index == 0) {
                    setForm(formMember);
                } else if (index == 1) {
                    setForm(formBiaya);
                } else if (index == 2) {
                    setForm(formLaporan);
                } else if (index == 3) {
                    setForm(formUser);
                }
//                } else if (index == 5) {
//                    setForm(formUser);
//                }
            }
        });
        //  set when system open start with home form
        setForm(new FormAdmin());
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //System.out.println(this.getSize().height + "" + this.getSize().width);
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    public static void showOnScreen( int screen, JFrame frame ){
        GraphicsEnvironment ge = GraphicsEnvironment
        .getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        if( screen > -1 && screen < gs.length ){
        gs[screen].setFullScreenWindow( frame );
        }
        else if( gs.length > 0 ){
        gs[0].setFullScreenWindow( frame );
        }
        else{
        throw new RuntimeException( "No Screens Found" );
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.raven.swing.PanelBorder();
        mainPanel = new javax.swing.JPanel();
        menu1 = new com.raven.component.Menu1();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pool & Cafe Apps V1 Standard");
        setExtendedState(MAXIMIZED_BOTH);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout(10, 10));

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(922, 505));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args) {
        FlatLaf.registerCustomDefaultsSource("style");
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Utama1().setVisible(true);
                
            }
        }); 
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private com.raven.component.Menu1 menu1;
    private com.raven.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
