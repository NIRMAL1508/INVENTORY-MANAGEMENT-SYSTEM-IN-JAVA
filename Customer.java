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
public class Customer extends javax.swing.JFrame {

    /**
     * Creates new form Customer
     */
    public Customer() {
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
            pst = con.prepareStatement("select * from inventory.customer");

            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();

            q = stData.getColumnCount();

            DefaultTableModel RecordTable = (DefaultTableModel)CusList.getModel();
            RecordTable.setRowCount(0);

            while (rs.next()){
                Vector columnData = new Vector();

                for(i = 1;i <= q; i++){
                    columnData.add(rs.getString("CusId"));
                    columnData.add(rs.getString("CusName"));
                    columnData.add(rs.getString("CusNum"));
                    
                    
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
        CloseCus = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CusId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CusName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CusNum = new javax.swing.JTextField();
        EditCus = new javax.swing.JButton();
        AddBtn = new javax.swing.JButton();
        DeleteCus = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CusList = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Countlbl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        OrderAmt = new javax.swing.JLabel();

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
        jLabel4.setText("CUSTOMER");

        CloseCus.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CloseCus.setForeground(new java.awt.Color(255, 255, 255));
        CloseCus.setText("X");
        CloseCus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseCusMouseClicked(evt);
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
                .addComponent(CloseCus)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(465, 465, 465)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CloseCus)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 0));
        jLabel2.setText("Customer Id");

        CusId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CusId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CusIdActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 204, 0));
        jLabel5.setText("Name");

        CusName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CusName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CusNameActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 204, 0));
        jLabel6.setText("Phone");

        CusNum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CusNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CusNumActionPerformed(evt);
            }
        });

        EditCus.setBackground(new java.awt.Color(51, 255, 0));
        EditCus.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        EditCus.setForeground(new java.awt.Color(255, 255, 255));
        EditCus.setText("Edit");
        EditCus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditCusMouseClicked(evt);
            }
        });
        EditCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditCusActionPerformed(evt);
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

        DeleteCus.setBackground(new java.awt.Color(51, 255, 0));
        DeleteCus.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        DeleteCus.setForeground(new java.awt.Color(255, 255, 255));
        DeleteCus.setText("Delete");
        DeleteCus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteCusMouseClicked(evt);
            }
        });
        DeleteCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteCusActionPerformed(evt);
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

        CusList.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        CusList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Id", "Name", "Phone"
            }
        ));
        CusList.setGridColor(new java.awt.Color(0, 0, 0));
        CusList.setIntercellSpacing(new java.awt.Dimension(0, 0));
        CusList.setRowHeight(25);
        CusList.setSelectionBackground(new java.awt.Color(0, 255, 102));
        CusList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CusListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CusList);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 204, 0));
        jLabel9.setText("CUSTOMER LIST");

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));

        Countlbl.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        Countlbl.setForeground(new java.awt.Color(255, 255, 255));
        Countlbl.setText("x");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ORDER NUMBER");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(Countlbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(Countlbl)
                .addGap(23, 23, 23))
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ORDER AMOUNT");

        OrderAmt.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        OrderAmt.setForeground(new java.awt.Color(255, 255, 255));
        OrderAmt.setText("x");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(OrderAmt)
                        .addGap(95, 95, 95))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OrderAmt)
                .addGap(30, 30, 30))
        );

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
                        .addComponent(CusId, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(EditCus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(DeleteCus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CusNum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CusName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(263, 263, 263))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CusId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CusName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CusNum, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EditCus)
                            .addComponent(DeleteCus)
                            .addComponent(AddBtn))
                        .addGap(82, 82, 82)
                        .addComponent(Home))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
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

    private void CusIdActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void CusNameActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void CusNumActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void EditCusActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void DeleteCusActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void CloseCusMouseClicked(java.awt.event.MouseEvent evt) {                                      
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
            pst = con.prepareStatement("insert into inventory.customer values(?,?,?)");

            //Class.forName("com.mysql.jdbc.Driver");
            //sqlConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ashwin");
            //pst = sqlConn.prepareStatement("insert into 'voterlist'('voterID', 'Name', 'Username', 'Password', 'Email', 'Phone no', 'Gender', 'Address', 'Aadhaar No')value(?,?,?,?,?,?,?,?,?)");

            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ashwin");
            //Statement statement = connection.createStatement();
            //ResultSet resultset = statement.executeQuery("insert into 'voterslist'('voterID', 'Name', 'Username', 'Password', 'Email', 'Phone no', 'Gender', 'Address', 'Aadhaar No')value(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, CusId.getText());
            pst.setString(2, CusName.getText());
            pst.setString(3, CusNum.getText());
            
            

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "New Customer Details Added");
            upDateDB();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }                                   

    private void EditCusMouseClicked(java.awt.event.MouseEvent evt) {                                     
        try{

            // Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
            System.out.println("Connected To MySql Database!");

            //Statement st = con.createStatement();
            //st.executeUpdate("create table Books (  Name varchar(50),Book_Id varchar(50),Book_Title varchar(50), Author varchar(50),Edition varchar(50))");
            // PreparedStatement
            pst = con.prepareStatement("update inventory.customer set CusId = ?, CusName = ?, CusNum = ? where CusId = ?");

            //Class.forName("com.mysql.jdbc.Driver");
            //sqlConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ashwin");
            //pst = sqlConn.prepareStatement("insert into 'voterslist'('voterID', 'Name', 'Username', 'Password', 'Email', 'Phone no', 'Gender', 'Address', 'Aadhaar No')value(?,?,?,?,?,?,?,?,?)");

            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ashwin");
            //Statement statement = connection.createStatement();
            //ResultSet resultset = statement.executeQuery("insert into 'voterslist'('voterID', 'Name', 'Username', 'Password', 'Email', 'Phone no', 'Gender', 'Address', 'Aadhaar No')value(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, CusId.getText());
            pst.setString(2, CusName.getText());
            pst.setString(3, CusNum.getText());
            pst.setString(4, CusId.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Customer Details Updated");
            upDateDB();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }                                    

    private void DeleteCusMouseClicked(java.awt.event.MouseEvent evt) {                                       
        DefaultTableModel RecordTable = (DefaultTableModel)CusList.getModel();
        int SelectedRows = CusList.getSelectedRow();
        
        try {
            id = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());
            
            deleteItem = JOptionPane.showConfirmDialog(null, "Confirm if you want to delete item",
                    "Warning", JOptionPane.YES_NO_OPTION);
            
            if(deleteItem == JOptionPane.YES_NO_OPTION){
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
                pst = con.prepareStatement("delete from inventory.customer where CusId = ?");
                
                pst.setInt(1, id);
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Customer List Updated");
                
                upDateDB();
                
                CusId.setText("");
                CusId.requestFocus();
                CusName.setText("");
                CusNum.setText("");
                
                
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }

    }                                      

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {                                  
        new Home().setVisible(true);
        this.dispose();

    }                                 

    private void CusListMouseClicked(java.awt.event.MouseEvent evt) {                                     
        DefaultTableModel RecordTable = (DefaultTableModel)CusList.getModel();
        int SelectedRows = CusList.getSelectedRow();

        CusId.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
        CusName.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        CusNum.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
            Statement St = con.createStatement();
            Statement St1 = con.createStatement();
            ResultSet Rs = St.executeQuery("select count(*) from inventory.ordertable where CusName='"+RecordTable.getValueAt(SelectedRows, 1).toString()+"'");
            ResultSet Rs1 = St1.executeQuery("select sum(Amount) from inventory.ordertable where CusName='"+RecordTable.getValueAt(SelectedRows, 1).toString()+"'");
            while(Rs.next()){
                Countlbl.setText(""+Rs.getInt(1));
            }
            while(Rs1.next()){
                OrderAmt.setText("Rs:"+Rs1.getInt(1));
            }
        }
        catch(Exception e){

        }
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
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton AddBtn;
    private javax.swing.JLabel CloseCus;
    private javax.swing.JLabel Countlbl;
    private javax.swing.JTextField CusId;
    private javax.swing.JTable CusList;
    private javax.swing.JTextField CusName;
    private javax.swing.JTextField CusNum;
    private javax.swing.JButton DeleteCus;
    private javax.swing.JButton EditCus;
    private javax.swing.JButton Home;
    private javax.swing.JLabel OrderAmt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}
