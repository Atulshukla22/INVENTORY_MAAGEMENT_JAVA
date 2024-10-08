/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventory.management.system;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import commen.OpenPdf;
import dau.ConnectionProvider;
import dau.InventoryUtils;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author dell
 */
public class ManageOrder extends javax.swing.JFrame {
    
    private int CustomerPK = 0;
    private int ProductPk = 0;
    private int finaleTotalPrice = 0;
    private String OrderID = "";

    /**
     * Creates new form ManageOrder
     */
    public ManageOrder() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void clearProductFields() {
        ProductPk = 0;
        txtProductName.setText("");
        txtProductPrice.setText("");
        txtProductDiscription.setText("");
        txtOrderQuantity.setText("");
    }
    
    public String getUniqueID(String prefix) {
        return prefix + System.nanoTime();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCart = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        txtCustomerMobileNumber = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCustomerEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();
        txtProductDiscription = new javax.swing.JTextField();
        txtOrderQuantity = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnAddToCart = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lblTotalAmount = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Impact", 1, 24)); // NOI18N
        jLabel1.setText("Manage Order");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(524, 6, -1, -1));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 188, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Product list");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 69, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Cart");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(994, 69, -1, -1));

        tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Mobile Number", "Email"
            }
        ));
        tableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCustomer);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 97, 390, 272));

        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Discription", "category ID", "category name"
            }
        ));
        tableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableProduct);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 97, 411, 272));

        tableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Name", "Quantity", "Price", "Discription", "Sub Total"
            }
        ));
        tableCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCartMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableCart);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(859, 97, 379, 272));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Customer list");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 69, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Selected Customer");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 406, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Name");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 442, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Mobile Number");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 525, -1, -1));

        txtCustomerName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 484, 390, -1));

        txtCustomerMobileNumber.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCustomerMobileNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerMobileNumberActionPerformed(evt);
            }
        });
        getContentPane().add(txtCustomerMobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 559, 390, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Email");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 614, -1, -1));

        txtCustomerEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtCustomerEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 648, 390, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Selected Product");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 406, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Product Name");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 442, -1, -1));

        txtProductName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 484, 411, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Product Price ");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 525, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Product Discription");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 614, -1, -1));

        txtProductPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtProductPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductPriceActionPerformed(evt);
            }
        });
        getContentPane().add(txtProductPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 559, 411, -1));

        txtProductDiscription.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtProductDiscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductDiscriptionActionPerformed(evt);
            }
        });
        getContentPane().add(txtProductDiscription, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 648, 411, -1));

        txtOrderQuantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtOrderQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderQuantityActionPerformed(evt);
            }
        });
        getContentPane().add(txtOrderQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 723, 411, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Order Quantity");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 689, -1, -1));

        btnAddToCart.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddToCart.setText("Add To Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 720, 390, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Total Amount RS :");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(916, 399, -1, -1));

        lblTotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotalAmount.setText("000000");
        getContentPane().add(lblTotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1077, 399, -1, -1));

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(868, 484, 370, -1));

        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(868, 559, 370, -1));

        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(868, 648, 370, -1));

        jPanel1.setBackground(new java.awt.Color(196, 162, 162));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 760));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(100, 91, 103));
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 420, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCustomerMobileNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerMobileNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerMobileNumberActionPerformed

    private void txtProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductNameActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
        String noOFUnit = txtOrderQuantity.getText();
        if (!noOFUnit.equals("")) {
            String ProductName = txtProductName.getText();
            String Productdescription = txtProductDiscription.getText();
            String ProductPrice = txtProductPrice.getText();
            
            int totalPrice = Integer.parseInt(txtOrderQuantity.getText()) * Integer.parseInt(ProductPrice);
            
            int checkStock = 0;
            int checkProductAlreadyExistInCart = 0;
            
            try {
                
                Connection con = ConnectionProvider.getcon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select* from product where product_Pk =" + ProductPk + "");
                while (rs.next()) {
                    if (rs.getInt("quantity") >= Integer.parseInt(noOFUnit)) {
                        checkStock = 1;
                    } else {
                        JOptionPane.showMessageDialog(null, "Product is out of Stock . Only" + rs.getInt("quantity") + "left");
                    }
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
            if (checkStock == 1) {
                DefaultTableModel model = (DefaultTableModel) tableCart.getModel();
                if (tableCart.getRowCount() != 0) {
                    for (int i = 0; i < tableCart.getRowCount(); i++) {
                        if (Integer.parseInt(model.getValueAt(i, 0).toString()) == ProductPk) {
                            checkProductAlreadyExistInCart = 1;
                            JOptionPane.showMessageDialog(null, "Product already exist in cart");
                        }
                    }
                }
                
                if (checkProductAlreadyExistInCart == 0) {
                    model.addRow(new Object[]{ProductPk, ProductName, noOFUnit, ProductPrice, Productdescription, totalPrice});
                    finaleTotalPrice = finaleTotalPrice + totalPrice;
                    lblTotalAmount.setText(String.valueOf(finaleTotalPrice));
                    JOptionPane.showMessageDialog(null, "ADDED SUCCESFULLY");
                }
            }
            clearProductFields();
            
        } else {
            JOptionPane.showMessageDialog(null, "enter the order quantity");
        }
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        txtCustomerName.setEditable(false);
        txtCustomerMobileNumber.setEditable(false);
        txtCustomerEmail.setEditable(false);
        
        txtProductName.setEditable(false);
        txtProductPrice.setEditable(false);
        txtProductDiscription.setEditable(false);
        
        DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
        DefaultTableModel ProductModel = (DefaultTableModel) tableProduct.getModel();
        
        try {
            Connection con = ConnectionProvider.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select* from customer ");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("customer_Pk"), rs.getString("name"), rs.getString("mobile_Number"), rs.getString("Email")});
            }
            rs = st.executeQuery("select* from product inner join category on product.category_fk = category.category");
            while (rs.next()) {
                ProductModel.addRow(new Object[]{rs.getString("product_Pk"), rs.getString("name"), rs.getString("price"), rs.getString("quantity"), rs.getString("discription"), rs.getString("category_fk"), rs.getString(8)});
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        

    }//GEN-LAST:event_formComponentShown

    private void txtProductDiscriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductDiscriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductDiscriptionActionPerformed

    private void txtOrderQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrderQuantityActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        

    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new ManageOrder().setVisible(true);
    }//GEN-LAST:event_btnResetActionPerformed

    private void tableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerMouseClicked
        // TODO add your handling code here:
        int index = tableCustomer.getSelectedRow();
        TableModel model = tableCustomer.getModel();
        
        String id = model.getValueAt(index, 0).toString();
        CustomerPK = Integer.parseInt(id);
        
        String name = model.getValueAt(index, 1).toString();
        txtCustomerName.setText(name);
        
        String MobileNumber = model.getValueAt(index, 2).toString();
        txtCustomerMobileNumber.setText(MobileNumber);
        String Email = model.getValueAt(index, 3).toString();
        txtCustomerEmail.setText(Email);
        
       

    }//GEN-LAST:event_tableCustomerMouseClicked

    private void tableProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductMouseClicked
        // TODO add your handling code here:
        int index = tableProduct.getSelectedRow();
        TableModel model = tableProduct.getModel();
        
        String id = model.getValueAt(index, 0).toString();
        ProductPk = Integer.parseInt(id);
        
        String name = model.getValueAt(index, 1).toString();
        txtProductName.setText(name);
        
        String price = model.getValueAt(index, 2).toString();
        txtProductPrice.setText(price);
        
        String discription = model.getValueAt(index, 4).toString();
        txtProductDiscription.setText(discription);
        

    }//GEN-LAST:event_tableProductMouseClicked

    private void txtCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerNameActionPerformed

    private void txtProductPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductPriceActionPerformed

    private void tableCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCartMouseClicked
        // TODO add your handling code here:
        int index = tableCart.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to delet the item", "SELECTED", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            TableModel model = tableCart.getModel();
            String subTotal = model.getValueAt(index, 5).toString();
            finaleTotalPrice = finaleTotalPrice - Integer.parseInt(subTotal);
            lblTotalAmount.setText(String.valueOf(finaleTotalPrice));
            ((DefaultTableModel) tableCart.getModel()).removeRow(index);
            
        }

    }//GEN-LAST:event_tableCartMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (finaleTotalPrice != 0 && !txtCustomerName.equals("")) {
            OrderID = getUniqueID("Bill-");
            
            DefaultTableModel dtm = (DefaultTableModel) tableCart.getModel();
            if (tableCart.getRowCount() != 0) {
                for (int i = 0; i < tableCart.getRowCount(); i++) {
                    try {
                        Connection con = ConnectionProvider.getcon();
                        Statement st = con.createStatement();
                        st.executeUpdate("update product set  quantity =quantity-" + Integer.parseInt(dtm.getValueAt(i, 2).toString()) + " Where  product_Pk = "+ Integer.parseInt(dtm.getValueAt(i, 0).toString()));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                        
                    }
                    
                }
            }
            try {
                SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal = Calendar.getInstance();
                Connection con = ConnectionProvider.getcon();
                PreparedStatement ps = con.prepareStatement("insert into  order_details(order_id,customer_fk,orderDate,totalPaid) values(?,?,?,?)");
                ps.setString(1, OrderID);
                ps.setInt(2, CustomerPK);
                ps.setString(3, myFormat.format(cal.getTime()));
                ps.setInt(4, finaleTotalPrice);
                ps.executeUpdate();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                
            }

            //creating Document
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            try {
                SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal = Calendar.getInstance();
                PdfWriter.getInstance(doc, new FileOutputStream(InventoryUtils.BillPath + "" + OrderID + ".pdf"));
                doc.open();
                Paragraph ProjectName = new Paragraph("                                                          Invebtory Management system    \n");
                doc.add(ProjectName);
                Paragraph StarLine = new Paragraph("-----------------------------------------------------------------------------------------------");
                doc.add(StarLine);
                Paragraph details = new Paragraph("\t OrderId " + OrderID + "\nDate" + myFormat.format(cal.getTime()) + "\nTOtal Paid" + finaleTotalPrice);
                doc.add(details);
                doc.add(StarLine);
                
                PdfPTable tb1 = new PdfPTable(5);
                
                PdfPCell namecell = new PdfPCell(new Phrase("Name"));
                PdfPCell descriptioncell = new PdfPCell(new Phrase("Description"));
                PdfPCell pricecell = new PdfPCell(new Phrase("Price Per Unit"));
                PdfPCell quantitycell = new PdfPCell(new Phrase("Quantity"));
                PdfPCell subTotalPricecell = new PdfPCell(new Phrase("Sub Total Price"));
                
                BaseColor Background = new BaseColor(255, 204, 51);
                namecell.setBackgroundColor(Background);
                descriptioncell.setBackgroundColor(Background);
                pricecell.setBackgroundColor(Background);
                quantitycell.setBackgroundColor(Background);
                subTotalPricecell.setBackgroundColor(Background);
                
                tb1.addCell(namecell);
                tb1.addCell(descriptioncell);
                tb1.addCell(pricecell);
                tb1.addCell(quantitycell);
                tb1.addCell(subTotalPricecell);
                
                for (int i = 0; i < tableCart.getRowCount(); i++) {
                    tb1.addCell(tableCart.getValueAt(i, 1).toString());
                    tb1.addCell(tableCart.getValueAt(i, 4).toString());
                    tb1.addCell(tableCart.getValueAt(i, 3).toString());
                    tb1.addCell(tableCart.getValueAt(i, 2).toString());
                    tb1.addCell(tableCart.getValueAt(i, 5).toString());
                }
                
                doc.add(tb1);
                doc.add(StarLine);
                Paragraph thanksMsg = new Paragraph("Thank You , Please Visit Again");
                doc.add(thanksMsg);
                
                OpenPdf.OpenById(OrderID);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                
            }
            doc.close();
            setVisible(false);
            new ManageOrder().setVisible(true);
            

    }//GEN-LAST:event_btnSaveActionPerformed
        else {
            JOptionPane.showMessageDialog(null, "please add some product to cart and select customer");
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
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JTable tableCart;
    private javax.swing.JTable tableCustomer;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTextField txtCustomerEmail;
    private javax.swing.JTextField txtCustomerMobileNumber;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtOrderQuantity;
    private javax.swing.JTextField txtProductDiscription;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    // End of variables declaration//GEN-END:variables

}
