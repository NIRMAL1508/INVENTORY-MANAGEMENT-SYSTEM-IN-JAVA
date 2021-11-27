package inventory;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author NIRMAL
 */
public class Order extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Order() {
        initComponents();
        upDateProd();
        upDateCus();
        GetToday();
    }

    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    int i,q,id,deleteItem;
    public void upDateProd(){
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
            pst = con.prepareStatement("select * from inventory.product");

            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();

            q = stData.getColumnCount();

            DefaultTableModel RecordTable = (DefaultTableModel)ProductList.getModel();
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
    public void upDateCus(){
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
    private void GetToday(){
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        Date.setText(dtf.format(now));
    }
    private void update(){
        int newQty = oldQty - Integer.valueOf(QtyOrd.getText());
        try{

            // Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
            System.out.println("Connected To MySql Database!");

            //Statement st = con.createStatement();
            //st.executeUpdate("create table Books (  Name varchar(50),Book_Id varchar(50),Book_Title varchar(50), Author varchar(50),Edition varchar(50))");
            // PreparedStatement
            pst = con.prepareStatement("update inventory.product set prodQty = ? where prodid = ?");

            //Class.forName("com.mysql.jdbc.Driver");
            //sqlConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ashwin");
            //pst = sqlConn.prepareStatement("insert into 'voterslist'('voterID', 'Name', 'Username', 'Password', 'Email', 'Phone no', 'Gender', 'Address', 'Aadhaar No')value(?,?,?,?,?,?,?,?,?)");

            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ashwin");
            //Statement statement = connection.createStatement();
            //ResultSet resultset = statement.executeQuery("insert into 'voterslist'('voterID', 'Name', 'Username', 'Password', 'Email', 'Phone no', 'Gender', 'Address', 'Aadhaar No')value(?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, newQty);
            pst.setInt(2, productid);
            
            

            pst.executeUpdate();
            //JOptionPane.showMessageDialog(this, "New Product is Updated");
            upDateProd();
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
        closeord = new javax.swing.JLabel();
        ViewOrd = new javax.swing.JButton();
        AddOrd = new javax.swing.JButton();
        AddTo = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CusList = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        OrderList = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        QtyOrd = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ProdQty = new javax.swing.JTextField();
        Date = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ProdId = new javax.swing.JTextField();
        CusName = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        ProductList = new javax.swing.JTable();
        TotallAmt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        PrcOrd = new javax.swing.JTextField();
        Print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1237, 705));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 204, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("I 4 INVENTORY");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ORDER");

        closeord.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        closeord.setForeground(new java.awt.Color(255, 255, 255));
        closeord.setText("X");
        closeord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeordMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(520, 520, 520)
                .addComponent(closeord)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(564, 564, 564)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeord)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        ViewOrd.setBackground(new java.awt.Color(51, 255, 0));
        ViewOrd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ViewOrd.setForeground(new java.awt.Color(255, 255, 255));
        ViewOrd.setText("View Orders");
        ViewOrd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewOrdMouseClicked(evt);
            }
        });
        ViewOrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewOrdActionPerformed(evt);
            }
        });

        AddOrd.setBackground(new java.awt.Color(51, 255, 0));
        AddOrd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AddOrd.setForeground(new java.awt.Color(255, 255, 255));
        AddOrd.setText("Add order");
        AddOrd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddOrdMouseClicked(evt);
            }
        });
        AddOrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddOrdActionPerformed(evt);
            }
        });

        AddTo.setBackground(new java.awt.Color(51, 255, 0));
        AddTo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AddTo.setForeground(new java.awt.Color(255, 255, 255));
        AddTo.setText("AddToOrder");
        AddTo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddToMouseClicked(evt);
            }
        });
        AddTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddToActionPerformed(evt);
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
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 204, 0));
        jLabel9.setText("CUSTOMER LIST");

        OrderList.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        OrderList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num", "Product", "Quantity", "UPrice", "Total"
            }
        ));
        OrderList.setGridColor(new java.awt.Color(0, 0, 0));
        OrderList.setIntercellSpacing(new java.awt.Dimension(0, 0));
        OrderList.setRowHeight(25);
        OrderList.setSelectionBackground(new java.awt.Color(0, 255, 102));
        OrderList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(OrderList);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 204, 0));
        jLabel10.setText("PRODUCT LIST");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 204, 0));
        jLabel8.setText("Date");

        QtyOrd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 204, 0));
        jLabel6.setText("Qty");

        ProdQty.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ProdQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdQtyActionPerformed(evt);
            }
        });

        Date.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Date.setForeground(new java.awt.Color(51, 255, 0));
        Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 204, 0));
        jLabel5.setText("Customer Name");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 0));
        jLabel2.setText("Order Id");

        ProdId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ProdId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdIdActionPerformed(evt);
            }
        });

        CusName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CusName.setForeground(new java.awt.Color(51, 255, 0));
        CusName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CusNameActionPerformed(evt);
            }
        });

        ProductList.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ProductList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prod Id", "Name", "Quantity", "Description", "Category"
            }
        ));
        ProductList.setGridColor(new java.awt.Color(0, 0, 0));
        ProductList.setIntercellSpacing(new java.awt.Dimension(0, 0));
        ProductList.setRowHeight(25);
        ProductList.setSelectionBackground(new java.awt.Color(0, 255, 102));
        ProductList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ProductList);

        TotallAmt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TotallAmt.setForeground(new java.awt.Color(51, 255, 0));
        TotallAmt.setText("Amount");
        TotallAmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotallAmtActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 204, 0));
        jLabel7.setText("Prc");

        PrcOrd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Print.setBackground(new java.awt.Color(51, 255, 0));
        Print.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Print.setForeground(new java.awt.Color(255, 255, 255));
        Print.setText("PrintOrder");
        Print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrintMouseClicked(evt);
            }
        });
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(258, 258, 258))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(ProdQty, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(ViewOrd))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ProdId, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(AddOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(CusName, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PrcOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(QtyOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AddTo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                        .addComponent(jScrollPane3)))
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TotallAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(Print)
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(ProdId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(CusName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(201, 201, 201)
                                        .addComponent(ProdQty, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(AddOrd)
                                            .addComponent(ViewOrd))
                                        .addGap(18, 18, 18)
                                        .addComponent(Home))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddTo)
                            .addComponent(QtyOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(PrcOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TotallAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Print))
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void CusListMouseClicked(java.awt.event.MouseEvent evt) {                                     
        DefaultTableModel RecordTable = (DefaultTableModel)CusList.getModel();
        int SelectedRows = CusList.getSelectedRow();

        
        CusName.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        
    }                                    

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {                                  
        new Home().setVisible(true);
        this.dispose();
    }                                 

    private void AddToActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     
    int j=1,UPrice,tot=0,total;
    String Prodname;
    private void AddToMouseClicked(java.awt.event.MouseEvent evt) {    
        if(flag==0||QtyOrd.getText().isEmpty() || PrcOrd.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Select Product , Enter Quantity and Price");
        }
        else{
        UPrice = Integer.valueOf(PrcOrd.getText()); 
        tot = UPrice * Integer.valueOf(QtyOrd.getText());                             
        Vector v = new Vector();
        v.add(j);
        v.add(Prodname);
        v.add(QtyOrd.getText());
        v.add(UPrice);
        v.add(tot);
        DefaultTableModel dt=(DefaultTableModel)OrderList.getModel();
        dt.addRow(v);
        total = total+tot;
        TotallAmt.setText("Rs : "+total);
        update();
        j++;
        
        }
    }                                  

    private void AddOrdActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void AddOrdMouseClicked(java.awt.event.MouseEvent evt) {   
        if(ProdId.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Enter The Order Id");
        }                               
        else{  
        try{

            // Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "1234");
            System.out.println("Connected To MySql Database!");

            //Statement st = con.createStatement();
            //st.executeUpdate("create table Books (  Name varchar(50),Book_Id varchar(50),Book_Title varchar(50), Author varchar(50),Edition varchar(50))");
            // PreparedStatement
            pst = con.prepareStatement("insert into inventory.ordertable values(?,?,?,?)");

            //Class.forName("com.mysql.jdbc.Driver");
            //sqlConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ashwin");
            //pst = sqlConn.prepareStatement("insert into 'voterlist'('voterID', 'Name', 'Username', 'Password', 'Email', 'Phone no', 'Gender', 'Address', 'Aadhaar No')value(?,?,?,?,?,?,?,?,?)");

            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "ashwin");
            //Statement statement = connection.createStatement();
            //ResultSet resultset = statement.executeQuery("insert into 'voterslist'('voterID', 'Name', 'Username', 'Password', 'Email', 'Phone no', 'Gender', 'Address', 'Aadhaar No')value(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, ProdId.getText());
            pst.setString(2, CusName.getText());
            pst.setString(3, Date.getText());
            pst.setInt(4, total);
            
            

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Order Successfully Added");
            //upDateDB();
            con.close();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    }                                   

    private void ViewOrdActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void ViewOrdMouseClicked(java.awt.event.MouseEvent evt) {                                     
        JOptionPane.showMessageDialog(this, "Under Process by I4 .....");
    }                                    

    private void closeordMouseClicked(java.awt.event.MouseEvent evt) {                                      
        System.exit(0);
    }                                     

    private void ProdQtyActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void DateActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void ProdIdActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void CusNameActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void TotallAmtActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         
    int flag=0,productid,oldQty;
    private void ProductListMouseClicked(java.awt.event.MouseEvent evt) {                                         
        DefaultTableModel RecordTable = (DefaultTableModel)ProductList.getModel();
        int SelectedRows = ProductList.getSelectedRow();

        productid=Integer.valueOf(RecordTable.getValueAt(SelectedRows, 0).toString());
        Prodname=RecordTable.getValueAt(SelectedRows, 1).toString();
        oldQty= Integer.valueOf(RecordTable.getValueAt(SelectedRows, 2).toString());
        /*ProdDesc.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
        
        CatCb.setSelectedItem(RecordTable.getValueAt(SelectedRows, 4));*/
        flag =1;
        
    }                                        

    private void OrderListMouseClicked(java.awt.event.MouseEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void PrintMouseClicked(java.awt.event.MouseEvent evt) {      
        try{
            OrderList.print();
        }                             
        catch(Exception e){
            e.printStackTrace();
        }
    }                                  

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton AddOrd;
    private javax.swing.JButton AddTo;
    private javax.swing.JTable CusList;
    private javax.swing.JTextField CusName;
    private javax.swing.JTextField Date;
    private javax.swing.JButton Home;
    private javax.swing.JTable OrderList;
    private javax.swing.JTextField PrcOrd;
    private javax.swing.JButton Print;
    private javax.swing.JTextField ProdId;
    private javax.swing.JTextField ProdQty;
    private javax.swing.JTable ProductList;
    private javax.swing.JTextField QtyOrd;
    private javax.swing.JTextField TotallAmt;
    private javax.swing.JButton ViewOrd;
    private javax.swing.JLabel closeord;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration                   
}
