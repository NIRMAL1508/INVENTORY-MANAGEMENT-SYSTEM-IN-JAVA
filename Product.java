package inventory;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


//import net.proteanit.sql.DbUtils.*;
/**
 *
 * @author NIRMAL
 */
public class Product extends javax.swing.JFrame {

    /**
     * Creates new form Product
     */
    public Product() {
        initComponents();
        upDateDB(); 
        GetCat();
    }
    
    Connection con=null;
    Statement st = null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    int i,q,id,deleteItem;
    public void upDateDB(){
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
            pst = con.prepareStatement("select * from inventory.product");

            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();

            q = stData.getColumnCount();

            DefaultTableModel RecordTable = (DefaultTableModel)ProductTable.getModel();
            RecordTable.setRowCount(0);

            while (rs.next()){
                Vector columnData = new Vector();

                for(i = 1;i <= q; i++){
                    columnData.add(rs.getString("prodid"));
                    columnData.add(rs.getString("prodName"));
                    columnData.add(rs.getString("prodQty"));
                    columnData.add(rs.getString("prodDesc"));
                    columnData.add(rs.getString("prodcat"));
                    
                }
                RecordTable.addRow(columnData);
            }

        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ProdId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ProdName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ProdQty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ProdDesc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        CatCb = new javax.swing.JComboBox<>();
        Editprod = new javax.swing.JButton();
        AddBtn = new javax.swing.JButton();
        Deleteprod = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 204, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("I 4 INVENTORY");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PRODUCT");

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
                        .addGap(471, 471, 471))))
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
        jLabel2.setText("Product Id");

        ProdId.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        ProdId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdIdActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 204, 0));
        jLabel5.setText("Name");

        ProdName.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        ProdName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdNameActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 204, 0));
        jLabel6.setText("Quantity");

        ProdQty.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        ProdQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdQtyActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 204, 0));
        jLabel7.setText("Description");

        ProdDesc.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 204, 0));
        jLabel8.setText("Cat");

        CatCb.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        CatCb.setForeground(new java.awt.Color(51, 204, 0));
        CatCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));

        Editprod.setBackground(new java.awt.Color(51, 255, 0));
        Editprod.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Editprod.setForeground(new java.awt.Color(255, 255, 255));
        Editprod.setText("Edit");
        Editprod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditprodMouseClicked(evt);
            }
        });
        Editprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditprodActionPerformed(evt);
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

        Deleteprod.setBackground(new java.awt.Color(51, 255, 0));
        Deleteprod.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Deleteprod.setForeground(new java.awt.Color(255, 255, 255));
        Deleteprod.setText("Delete");
        Deleteprod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteprodMouseClicked(evt);
            }
        });
        Deleteprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteprodActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 255, 0));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Home");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        ProductTable.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prod Id", "Name", "Quantity", "Description", "Category"
            }
        ));
        ProductTable.setGridColor(new java.awt.Color(0, 0, 0));
        ProductTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        ProductTable.setRowHeight(25);
        ProductTable.setSelectionBackground(new java.awt.Color(0, 255, 102));
        ProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProductTable);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 204, 0));
        jLabel9.setText("PRODUCT LIST");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ProdName, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CatCb, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(13, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ProdDesc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ProdQty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ProdId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Editprod, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(Deleteprod, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
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
                            .addComponent(ProdId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProdName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProdQty, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProdDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CatCb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Editprod)
                            .addComponent(Deleteprod)
                            .addComponent(AddBtn))
                        .addGap(36, 36, 36)
                        .addComponent(jButton5)
                        .addGap(58, 58, 58))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
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

    private void ProdIdActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void ProdQtyActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void EditprodActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void DeleteprodActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void ProdNameActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        
    /*public void SelectProd(){
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
            St = Con.createStatement();
            Rs = St.executeQuery("SELECT * FROM product");
            ProductTable.setModel(DbUtils.ResultSetToTableModel(Rs));
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }    */
    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {                                         
        new Home().setVisible(true);
        this.dispose();
    }
    private void GetCat(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
            st = con.createStatement();
            String query="select * from inventory.category";
            rs = st.executeQuery(query);
            while(rs.next()){
                String MyCat=rs.getString("CatName");
                CatCb.addItem(MyCat);
            }
        }catch(Exception e){

        }
    }
    private void AddBtnMouseClicked(java.awt.event.MouseEvent evt) {                                    
        /*try{
            
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
            PreparedStatement add=Con.prepareStatement("INSERT INTO product(prodid,prodName,prodQty,prodDesc,prodcat) VALUES(?,?,?,?,?)");
            add.setInt(1, Integer.valueOf(ProdId.getText()));
            add.setString(2, ProdName.getText());
            add.setInt(3, Integer.valueOf(ProdQty.getText()));
            add.setString(4, ProdDesc.getText());
            add.setString(5, CatCb.getSelectedItem().toString());
            int row = add.executeUpdate();
            JOptionPane.showMessageDialog(this,"Product Successfully Added");
            Con.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }*/
        try{

            // Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
            System.out.println("Connected To MySql Database!");

            //Statement st = con.createStatement();
            //st.executeUpdate("create table Books (  Name varchar(50),Book_Id varchar(50),Book_Title varchar(50), Author varchar(50),Edition varchar(50))");
            // PreparedStatement
            pst = con.prepareStatement("insert into inventory.product values(?,?,?,?,?)");

            //Class.forName("com.mysql.jdbc.Driver");
            //sqlConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ashwin");
            //pst = sqlConn.prepareStatement("insert into 'voterlist'('voterID', 'Name', 'Username', 'Password', 'Email', 'Phone no', 'Gender', 'Address', 'Aadhaar No')value(?,?,?,?,?,?,?,?,?)");

            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ashwin");
            //Statement statement = connection.createStatement();
            //ResultSet resultset = statement.executeQuery("insert into 'voterslist'('voterID', 'Name', 'Username', 'Password', 'Email', 'Phone no', 'Gender', 'Address', 'Aadhaar No')value(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, ProdId.getText());
            pst.setString(2, ProdName.getText());
            pst.setString(3, ProdQty.getText());
            pst.setString(4, ProdDesc.getText());
            pst.setString(5, CatCb.getSelectedItem().toString());
            

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "New Product Added");
            upDateDB();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }                                   

    private void EditprodMouseClicked(java.awt.event.MouseEvent evt) {                                      
        try{

            // Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
            System.out.println("Connected To MySql Database!");

            //Statement st = con.createStatement();
            //st.executeUpdate("create table Books (  Name varchar(50),Book_Id varchar(50),Book_Title varchar(50), Author varchar(50),Edition varchar(50))");
            // PreparedStatement
            pst = con.prepareStatement("update inventory.product set prodid = ?, prodName = ?, prodQty = ?, prodDesc = ?, prodcat = ? where prodid = ?");

            //Class.forName("com.mysql.jdbc.Driver");
            //sqlConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ashwin");
            //pst = sqlConn.prepareStatement("insert into 'voterslist'('voterID', 'Name', 'Username', 'Password', 'Email', 'Phone no', 'Gender', 'Address', 'Aadhaar No')value(?,?,?,?,?,?,?,?,?)");

            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ashwin");
            //Statement statement = connection.createStatement();
            //ResultSet resultset = statement.executeQuery("insert into 'voterslist'('voterID', 'Name', 'Username', 'Password', 'Email', 'Phone no', 'Gender', 'Address', 'Aadhaar No')value(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, ProdId.getText());
            pst.setString(2, ProdName.getText());
            pst.setString(3, ProdQty.getText());
            pst.setString(4, ProdDesc.getText());
            pst.setString(5, CatCb.getSelectedItem().toString());
            pst.setString(6, ProdId.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "New Product is Updated");
            upDateDB();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }                                     

    private void DeleteprodMouseClicked(java.awt.event.MouseEvent evt) {                                        
        DefaultTableModel RecordTable = (DefaultTableModel)ProductTable.getModel();
        int SelectedRows = ProductTable.getSelectedRow();
        
        try {
            id = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());
            
            deleteItem = JOptionPane.showConfirmDialog(null, "Confirm if you want to delete item",
                    "Warning", JOptionPane.YES_NO_OPTION);
            
            if(deleteItem == JOptionPane.YES_NO_OPTION){
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
                pst = con.prepareStatement("delete from inventory.product where prodid = ?");
                
                pst.setInt(1, id);
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Products List Updated");
                
                upDateDB();
                
                ProdId.setText("");
                ProdId.requestFocus();
                ProdName.setText("");
                ProdQty.setText("");
                ProdDesc.setText("");
                
                CatCb.setSelectedItem("");
                
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }                                       

    private void ProductTableMouseClicked(java.awt.event.MouseEvent evt) {                                          
        DefaultTableModel RecordTable = (DefaultTableModel)ProductTable.getModel();
        int SelectedRows = ProductTable.getSelectedRow();

        ProdId.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
        ProdName.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        ProdQty.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        ProdDesc.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
        
        CatCb.setSelectedItem(RecordTable.getValueAt(SelectedRows, 4));
        
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
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton AddBtn;
    private javax.swing.JComboBox<String> CatCb;
    private javax.swing.JButton Deleteprod;
    private javax.swing.JButton Editprod;
    private javax.swing.JTextField ProdDesc;
    private javax.swing.JTextField ProdId;
    private javax.swing.JTextField ProdName;
    private javax.swing.JTextField ProdQty;
    private javax.swing.JTable ProductTable;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}
