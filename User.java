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
public class User extends javax.swing.JFrame {

    /**
     * Creates new form User
     */
    public User() {
        initComponents();
        upDateDB();
    }

    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    int i,q,deleteItem;
    String id;
    public void upDateDB(){
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
            pst = con.prepareStatement("select * from inventory.users");

            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();

            q = stData.getColumnCount();

            DefaultTableModel RecordTable = (DefaultTableModel)UList.getModel();
            RecordTable.setRowCount(0);

            while (rs.next()){
                Vector columnData = new Vector();

                for(i = 1;i <= q; i++){
                    columnData.add(rs.getString("UName"));
                    columnData.add(rs.getString("UPass"));
                    columnData.add(rs.getString("UNum"));
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
        CloseUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        UName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Upass = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        UNum = new javax.swing.JTextField();
        UEdit = new javax.swing.JButton();
        AddBtn = new javax.swing.JButton();
        Udelete = new javax.swing.JButton();
        HomeBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        UList = new javax.swing.JTable();
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
        jLabel4.setText("USER");

        CloseUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CloseUser.setForeground(new java.awt.Color(255, 255, 255));
        CloseUser.setText("X");
        CloseUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseUserMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 443, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(422, 422, 422)
                .addComponent(CloseUser)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(491, 491, 491)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CloseUser)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 0));
        jLabel2.setText("User Name");

        UName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        UName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UNameActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 204, 0));
        jLabel5.setText("Password");

        Upass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Upass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpassActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 204, 0));
        jLabel6.setText("Phone");

        UNum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        UNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UNumActionPerformed(evt);
            }
        });

        UEdit.setBackground(new java.awt.Color(51, 255, 0));
        UEdit.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        UEdit.setForeground(new java.awt.Color(255, 255, 255));
        UEdit.setText("Edit");
        UEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UEditMouseClicked(evt);
            }
        });
        UEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UEditActionPerformed(evt);
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

        Udelete.setBackground(new java.awt.Color(51, 255, 0));
        Udelete.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Udelete.setForeground(new java.awt.Color(255, 255, 255));
        Udelete.setText("Delete");
        Udelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UdeleteMouseClicked(evt);
            }
        });
        Udelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UdeleteActionPerformed(evt);
            }
        });

        HomeBtn.setBackground(new java.awt.Color(51, 255, 0));
        HomeBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        HomeBtn.setForeground(new java.awt.Color(255, 255, 255));
        HomeBtn.setText("Home");
        HomeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeBtnMouseClicked(evt);
            }
        });
        HomeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeBtnActionPerformed(evt);
            }
        });

        UList.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        UList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User", "Password", "Phone"
            }
        ));
        UList.setGridColor(new java.awt.Color(0, 0, 0));
        UList.setIntercellSpacing(new java.awt.Dimension(0, 0));
        UList.setRowHeight(25);
        UList.setSelectionBackground(new java.awt.Color(0, 255, 102));
        UList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(UList);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 204, 0));
        jLabel9.setText("USER LIST");

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
                        .addComponent(UName, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(HomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(UEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(Udelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UNum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Upass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
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
                            .addComponent(UName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Upass, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UNum, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UEdit)
                            .addComponent(Udelete)
                            .addComponent(AddBtn))
                        .addGap(82, 82, 82)
                        .addComponent(HomeBtn))
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

    private void UNameActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void UpassActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void UNumActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void UEditActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void UdeleteActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void HomeBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void CloseUserMouseClicked(java.awt.event.MouseEvent evt) {                                       
        System.exit(0);
    }                                      

    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {                                    
        try{

            // Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
            System.out.println("Connected To MySql Database!");

            //Statement st = con.createStatement();
            //st.executeUpdate("create table Books (  Name varchar(50),Book_Id varchar(50),Book_Title varchar(50), Author varchar(50),Edition varchar(50))");
            // PreparedStatement
            pst = con.prepareStatement("insert into inventory.users values(?,?,?)");

            //Class.forName("com.mysql.jdbc.Driver");
            //sqlConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ashwin");
            //pst = sqlConn.prepareStatement("insert into 'voterlist'('voterID', 'Name', 'Username', 'Password', 'Email', 'Phone no', 'Gender', 'Address', 'Aadhaar No')value(?,?,?,?,?,?,?,?,?)");

            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ashwin");
            //Statement statement = connection.createStatement();
            //ResultSet resultset = statement.executeQuery("insert into 'voterslist'('voterID', 'Name', 'Username', 'Password', 'Email', 'Phone no', 'Gender', 'Address', 'Aadhaar No')value(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, UName.getText());
            pst.setString(2, Upass.getText());
            pst.setString(3, UNum.getText());
            
            

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "New User Added");
            upDateDB();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }                                   

    private void UEditMouseClicked(java.awt.event.MouseEvent evt) {                                   
        try{

            // Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
            System.out.println("Connected To MySql Database!");

            //Statement st = con.createStatement();
            //st.executeUpdate("create table Books (  Name varchar(50),Book_Id varchar(50),Book_Title varchar(50), Author varchar(50),Edition varchar(50))");
            // PreparedStatement
            pst = con.prepareStatement("update inventory.users set UName = ?, UPass = ?, UNum = ? where UNum = ?");

            //Class.forName("com.mysql.jdbc.Driver");
            //sqlConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ashwin");
            //pst = sqlConn.prepareStatement("insert into 'voterslist'('voterID', 'Name', 'Username', 'Password', 'Email', 'Phone no', 'Gender', 'Address', 'Aadhaar No')value(?,?,?,?,?,?,?,?,?)");

            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ashwin");
            //Statement statement = connection.createStatement();
            //ResultSet resultset = statement.executeQuery("insert into 'voterslist'('voterID', 'Name', 'Username', 'Password', 'Email', 'Phone no', 'Gender', 'Address', 'Aadhaar No')value(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, UName.getText());
            pst.setString(2, Upass.getText());
            pst.setString(3, UNum.getText());
            pst.setString(4, UNum.getText());
            

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "New User is Updated");
            upDateDB();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    
    }                                  

    private void UdeleteMouseClicked(java.awt.event.MouseEvent evt) {                                     
        DefaultTableModel RecordTable = (DefaultTableModel)UList.getModel();
        int SelectedRows = UList.getSelectedRow();
        
        try {
            id = RecordTable.getValueAt(SelectedRows, 2).toString();
            
            deleteItem = JOptionPane.showConfirmDialog(null, "Confirm if you want to delete item",
                    "Warning", JOptionPane.YES_NO_OPTION);
            
            if(deleteItem == JOptionPane.YES_NO_OPTION){
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
                pst = con.prepareStatement("delete from inventory.users where UNum = ?");
                
                pst.setString(1, id);
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Users List Updated");
                
                upDateDB();
                
                UName.setText("");
                Upass.setText("");
                UNum.setText("");
                UNum.requestFocus();
                
                
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }                                    

    private void HomeBtnMouseClicked(java.awt.event.MouseEvent evt) {                                     
        new Home().setVisible(true);
        this.dispose();
    }                                    

    private void UListMouseClicked(java.awt.event.MouseEvent evt) {                                   
        DefaultTableModel RecordTable = (DefaultTableModel)UList.getModel();
        int SelectedRows = UList.getSelectedRow();

        UName.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
        Upass.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        UNum.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        
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
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton AddBtn;
    private javax.swing.JLabel CloseUser;
    private javax.swing.JButton HomeBtn;
    private javax.swing.JButton UEdit;
    private javax.swing.JTable UList;
    private javax.swing.JTextField UName;
    private javax.swing.JTextField UNum;
    private javax.swing.JButton Udelete;
    private javax.swing.JTextField Upass;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}
