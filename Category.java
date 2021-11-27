/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NIRMAL
 */
public class Category extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public Category() {
        initComponents();
        upDateDB();
    }

    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    int i,q,id,deleteItem;
    public void upDateDB(){
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
            pst = con.prepareStatement("select * from inventory.category");

            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();

            q = stData.getColumnCount();

            DefaultTableModel RecordTable = (DefaultTableModel)CatList.getModel();
            RecordTable.setRowCount(0);

            while (rs.next()){
                Vector columnData = new Vector();

                for(i = 1;i <= q; i++){
                    columnData.add(rs.getString("CatId"));
                    columnData.add(rs.getString("CatName"));
                }
                RecordTable.addRow(columnData);
            }

        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CatId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CatName = new javax.swing.JTextField();
        EditCat = new javax.swing.JButton();
        AddBtn = new javax.swing.JButton();
        DeleteCat = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CatList = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1053, 700));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 204, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("I 4 INVENTORY");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CATEGORY");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(422, 422, 422)
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(467, 467, 467))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 0));
        jLabel2.setText("Category Id");

        CatId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CatId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatIdActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 204, 0));
        jLabel5.setText("Category Name");

        CatName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CatName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatNameActionPerformed(evt);
            }
        });

        EditCat.setBackground(new java.awt.Color(51, 255, 0));
        EditCat.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        EditCat.setForeground(new java.awt.Color(255, 255, 255));
        EditCat.setText("Edit");
        EditCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditCatMouseClicked(evt);
            }
        });
        EditCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditCatActionPerformed(evt);
            }
        });

        AddBtn.setBackground(new java.awt.Color(51, 255, 0));
        AddBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddBtn.setText("Add");
        AddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddBtnMouseClicked(evt);
            }
        });
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        DeleteCat.setBackground(new java.awt.Color(51, 255, 0));
        DeleteCat.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        DeleteCat.setForeground(new java.awt.Color(255, 255, 255));
        DeleteCat.setText("Delete");
        DeleteCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteCatMouseClicked(evt);
            }
        });
        DeleteCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteCatActionPerformed(evt);
            }
        });

        Home.setBackground(new java.awt.Color(51, 255, 0));
        Home.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Home.setForeground(new java.awt.Color(255, 255, 255));
        Home.setText("Home");
        Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeMouseClicked(evt);
            }
        });
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        CatList.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        CatList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category Id", "Category Name"
            }
        ));
        CatList.setGridColor(new java.awt.Color(0, 0, 0));
        CatList.setIntercellSpacing(new java.awt.Dimension(0, 0));
        CatList.setRowHeight(25);
        CatList.setSelectionBackground(new java.awt.Color(0, 255, 102));
        CatList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CatListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CatList);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 204, 0));
        jLabel9.setText("CATEGORY LIST");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(CatId, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(EditCat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(DeleteCat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(CatName, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(263, 263, 263))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CatId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CatName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(123, 123, 123)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EditCat)
                            .addComponent(DeleteCat)
                            .addComponent(AddBtn))
                        .addGap(82, 82, 82)
                        .addComponent(Home))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void CatIdActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void CatNameActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void EditCatActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void DeleteCatActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {                                    
        try{

            // Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
            System.out.println("Connected To MySql Database!");

            //Statement st = con.createStatement();
            //st.executeUpdate("create table Books (  Name varchar(50),Book_Id varchar(50),Book_Title varchar(50), Author varchar(50),Edition varchar(50))");
            // PreparedStatement
            pst = con.prepareStatement("insert into inventory.category values(?,?)");

            //Class.forName("com.mysql.jdbc.Driver");
            //sqlConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ashwin");
            //pst = sqlConn.prepareStatement("insert into 'voterlist'('voterID', 'Name', 'Username', 'Password', 'Email', 'Phone no', 'Gender', 'Address', 'Aadhaar No')value(?,?,?,?,?,?,?,?,?)");

            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ashwin");
            //Statement statement = connection.createStatement();
            //ResultSet resultset = statement.executeQuery("insert into 'voterslist'('voterID', 'Name', 'Username', 'Password', 'Email', 'Phone no', 'Gender', 'Address', 'Aadhaar No')value(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, CatId.getText());
            pst.setString(2, CatName.getText());
            
            

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "New Category Added");
            upDateDB();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }                                   

    private void EditCatMouseClicked(java.awt.event.MouseEvent evt) {                                     
        try{

            // Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
            System.out.println("Connected To MySql Database!");

            //Statement st = con.createStatement();
            //st.executeUpdate("create table Books (  Name varchar(50),Book_Id varchar(50),Book_Title varchar(50), Author varchar(50),Edition varchar(50))");
            // PreparedStatement
            pst = con.prepareStatement("update inventory.category set CatId = ?, CatName = ? where CatId = ?");

            //Class.forName("com.mysql.jdbc.Driver");
            //sqlConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ashwin");
            //pst = sqlConn.prepareStatement("insert into 'voterslist'('voterID', 'Name', 'Username', 'Password', 'Email', 'Phone no', 'Gender', 'Address', 'Aadhaar No')value(?,?,?,?,?,?,?,?,?)");

            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ashwin");
            //Statement statement = connection.createStatement();
            //ResultSet resultset = statement.executeQuery("insert into 'voterslist'('voterID', 'Name', 'Username', 'Password', 'Email', 'Phone no', 'Gender', 'Address', 'Aadhaar No')value(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, CatId.getText());
            pst.setString(2, CatName.getText());
            pst.setString(3, CatId.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "New Category is Updated");
            upDateDB();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }                                    

    private void DeleteCatMouseClicked(java.awt.event.MouseEvent evt) {                                       
        DefaultTableModel RecordTable = (DefaultTableModel)CatList.getModel();
        int SelectedRows = CatList.getSelectedRow();
        
        try {
            id = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());
            
            deleteItem = JOptionPane.showConfirmDialog(null, "Confirm if you want to delete item",
                    "Warning", JOptionPane.YES_NO_OPTION);
            
            if(deleteItem == JOptionPane.YES_NO_OPTION){
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
                pst = con.prepareStatement("delete from inventory.category where CatId = ?");
                
                pst.setInt(1, id);
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Categories List Updated");
                
                upDateDB();
                
                CatId.setText("");
                CatId.requestFocus();
                CatName.setText("");
                
                
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }                                      

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {                                  
        new Home().setVisible(true);
        this.dispose();
    }                                 

    private void CatListMouseClicked(java.awt.event.MouseEvent evt) {                                     
        DefaultTableModel RecordTable = (DefaultTableModel)CatList.getModel();
        int SelectedRows = CatList.getSelectedRow();

        CatId.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
        CatName.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        
    }                                    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        System.exit(0);
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
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Category().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton AddBtn;
    private javax.swing.JTextField CatId;
    private javax.swing.JTable CatList;
    private javax.swing.JTextField CatName;
    private javax.swing.JButton DeleteCat;
    private javax.swing.JButton EditCat;
    private javax.swing.JButton Home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}
