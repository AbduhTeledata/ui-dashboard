package com.raven.dao;

import com.raven.connection.DatabaseConnection;
import com.raven.connection.koneksi;
import com.raven.main.Form_Login;

import com.raven.main.Menu_Utama;
import com.raven.model.Model_Login;
import com.raven.service.Service_Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAO_Login implements Service_Login{
    
    private Connection conn;
    
    public DAO_Login() {
        conn = koneksi.getConnection();
    }

    @Override
    public void prosesLogin(Model_Login mod_login) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String Id = null;
        String Nama = null;
        String Level2 = null;
        String sql = "SELECT * FROM pengguna WHERE(id_pengguna='"+mod_login.getId_user()+"' "
                + "OR username='"+mod_login.getUsername()+"') "
                + "AND password='"+Encrypt.getmd5java(mod_login.getPass_user())+"'";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            if (rs.next()) {
                Id = rs.getString("id_pengguna");
                Nama = rs.getString("nama_pengguna");
                Level2 = rs.getString("level");
                
                Menu_Utama menu = new Menu_Utama();
                menu.setVisible(true);
                menu.revalidate();
                
                Form_Login lg = new Form_Login();
                lg.setVisible(false);
            }else {
                //JOptionPane dialog = new JOptionPane();
                //dialog.showMessageDialog(null, "Username tidak boleh kosong");
                Form_Login lg = new Form_Login();
                lg.setVisible(true);
            }
        } catch (Exception e) {
            Logger.getLogger(DAO_Login.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if (st != null) {
                try {
                    st.close();
                } catch (Exception e) {
                    Logger.getLogger(DAO_Login.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
    
}
