/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokosepatu.barang;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tokosepatu.pengaturan.Koneksi;
/**
 *
 * @author Smoothies
 */
public class BarangView extends javax.swing.JInternalFrame {

    /**
     * Creates new form BarangView
     */
    public BarangView() {
        initComponents();
        ulang();
    }
    PreparedStatement pst;
    ResultSet rs;
    Connection conn = new Koneksi().getKoneksi();
    String status,sql;
    
    private void tampil_data(){
        try {
            String[]judul = {"Kode Barang","Nama Barang","Kategori","Harga","Stok"};
            DefaultTableModel dtm = new DefaultTableModel(null,judul);
            tabelBarang.setModel(dtm);
            if(textCari.getText().isEmpty()){
                sql = "select * from tb_barang";
            }else{
                sql = "select * from tb_barang where nama_barang like '%"+textCari.getText()+ "%'";
            }
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String[] data = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
                dtm.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
}
    
    private void ulang(){
        textKode.setEnabled(false);
        textNama.setEnabled(false);
        textKategori.setEnabled(false);
        textHarga.setEnabled(false);
        textStok.setEnabled(false);
        buttonSimpan.setEnabled(false);
        buttonUbah.setEnabled(false);
        buttonHapus.setEnabled(false);
        buttonTambah.setEnabled(true);
        
        textKode.setText("");
        textNama.setText("");
        textKategori.setText("");
        textHarga.setText("");
        textStok.setText("");
        tampil_data();
    }
    
    private void kode_otomatis(){
       try{
        sql = "select kode_barang from tb_barang order by kode_barang desc limit 1";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        if(rs.next()){
            int kode = Integer.parseInt(rs.getString(1).substring(4)) + 1;
            textKode.setText("BRG-"+ kode);
        }else{
            textKode.setText("BRG-1000");
        }
       }catch (SQLException e){
           JOptionPane.showMessageDialog(null, e.toString());
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

        panelMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textKode = new javax.swing.JTextField();
        textNama = new javax.swing.JTextField();
        textKategori = new javax.swing.JTextField();
        textStok = new javax.swing.JTextField();
        buttonTambah = new javax.swing.JButton();
        buttonSimpan = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();
        buttonUbah = new javax.swing.JButton();
        buttonUlang = new javax.swing.JButton();
        buttonKeluar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        textHarga = new javax.swing.JTextField();

        setClosable(true);
        setResizable(true);
        setTitle("Form Barang");

        panelMain.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("FORM BARANG");

        jLabel2.setText("KODE BARANG");

        jLabel3.setText("NAMA BARANG");

        jLabel4.setText("KATEGORI");

        jLabel5.setText("STOK");

        buttonTambah.setText("TAMBAH");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });

        buttonSimpan.setText("SIMPAN");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        buttonHapus.setText("HAPUS");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });

        buttonUbah.setText("UBAH");
        buttonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahActionPerformed(evt);
            }
        });

        buttonUlang.setText("ULANG");
        buttonUlang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUlangActionPerformed(evt);
            }
        });

        buttonKeluar.setText("KELUAR");
        buttonKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKeluarActionPerformed(evt);
            }
        });

        jLabel6.setText("Cari Barang");

        textCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textCariKeyReleased(evt);
            }
        });

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBarang);

        jLabel7.setText("HARGA");

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(35, 35, 35)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addComponent(buttonTambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(buttonHapus)
                                .addGap(14, 14, 14)
                                .addComponent(buttonUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonUlang, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textCari)
                            .addComponent(textStok)))
                    .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addGroup(panelMainLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(textKode, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textKategori, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                            .addComponent(textNama)
                            .addComponent(textHarga)))
                    .addComponent(jScrollPane1))
                .addContainerGap(378, Short.MAX_VALUE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonTambah)
                    .addComponent(buttonSimpan)
                    .addComponent(buttonHapus)
                    .addComponent(buttonUbah)
                    .addComponent(buttonUlang)
                    .addComponent(buttonKeluar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        getContentPane().add(panelMain, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
       textKode.setEnabled(false);
        textNama.setEnabled(true);
        textKategori.setEnabled(true);
        textHarga.setEnabled(true);
        textStok.setEnabled(true);
        buttonTambah.setEnabled(false);
        buttonSimpan.setEnabled(true);
        status = "tambah";
        kode_otomatis();
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void buttonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahActionPerformed
        textKode.setEnabled(false);
        textNama.setEnabled(true);
        textKategori.setEnabled(true);
        textHarga.setEnabled(true);
        textStok.setEnabled(true);
        buttonSimpan.setEnabled(true);
        buttonUbah.setEnabled(false);
        status = "ubah";
    }//GEN-LAST:event_buttonUbahActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        if(textNama.getText().isEmpty() || textKategori.getText().isEmpty() || textHarga.getText().isEmpty() || textStok.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Inputan ada yang belum diisi");
    }else{
            try {
                if(status.equals("tambah")){
                sql = "insert into tb_barang values (?,?,?,?,?)";
                pst = conn.prepareStatement(sql);
                pst.setString(1, textKode.getText());
                pst.setString(2, textNama.getText());
                pst.setString(3, textKategori.getText());
                pst.setString(4, textHarga.getText());
                pst.setString(5, textStok.getText());
                    }else if(status.equals("ubah")){
                sql = "update tb_barang set nama_barang=?, kategori=?, harga=?, stok=? where kode_barang =?";
                    pst = conn.prepareStatement(sql);
                pst.setString(1, textNama.getText());
                pst.setString(2, textKategori.getText());
                pst.setString(3, textHarga.getText());
                pst.setString(4, textStok.getText());
                pst.setString(5, textKode.getText());
            }
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Barang berhasil ditambahkan");
            ulang();
            } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
            }
            } 
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        int konf = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data barang ini?","Hapus Data?",JOptionPane.YES_NO_OPTION);
        if(konf==0){
            try {
                pst = conn.prepareStatement("delete from tb_barang where kode_barang = ?");
                pst.setString(1, textKode.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Barang berhasil dihapus");
                ulang();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
        }
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void buttonUlangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUlangActionPerformed
        ulang();
    }//GEN-LAST:event_buttonUlangActionPerformed

    private void buttonKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKeluarActionPerformed
       dispose();
    }//GEN-LAST:event_buttonKeluarActionPerformed

    private void textCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCariKeyReleased
    tampil_data();        // TODO add your handling code here:
    }//GEN-LAST:event_textCariKeyReleased

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
    int baris = tabelBarang.getSelectedRow();
    String id = tabelBarang.getValueAt(baris, 0).toString();
    if(!id.isEmpty()){
        textKode.setText(id);
        textNama.setText(tabelBarang.getValueAt(baris, 1).toString());
        textKategori.setText(tabelBarang.getValueAt(baris, 2).toString());
        textHarga.setText(tabelBarang.getValueAt(baris, 3).toString());
        textStok.setText(tabelBarang.getValueAt(baris, 4).toString());
        buttonTambah.setEnabled(false);
        buttonSimpan.setEnabled(false);
        buttonHapus.setEnabled(true);
        buttonUbah.setEnabled(true); 
        }    // TODO add your handling code here:
    }//GEN-LAST:event_tabelBarangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonKeluar;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JButton buttonUlang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelMain;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JTextField textCari;
    private javax.swing.JTextField textHarga;
    private javax.swing.JTextField textKategori;
    private javax.swing.JTextField textKode;
    private javax.swing.JTextField textNama;
    private javax.swing.JTextField textStok;
    // End of variables declaration//GEN-END:variables
}