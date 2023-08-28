package com.mycompany.views;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author labhardware01
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public MainForm() {
        initComponents();
    }
    
    public File file;
    // public Map<String,String> lexToken = new LinkedHashMap<String,String>();
    public ArrayList<ArrayList<String>> lexToken = new ArrayList<>();
    public ArrayList<ArrayList<String>> symbols = new ArrayList<>();
    
    String[] reserved_words = {
        "+",
        "-",
        "*",
        "/",
        "=",
        "namespace",
        ";",
        "import",
        "class",
        "{",
        "}",
        "String",
        "Integer",
        "Float",
        ",",
        "void",
        "method",
        "(",
        ")",
        "return"
    }; 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        inputFilePicker = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tokenTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        symbolsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        codeViewer = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButton1.setText("Selecione");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Compilar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tokenTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tokenTable);

        symbolsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(symbolsTable);

        jLabel1.setText("Tokens:");

        jLabel2.setText("Símbolos:");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel3.setText("Compilador .SLA");

        codeViewer.setColumns(20);
        codeViewer.setRows(5);
        jScrollPane3.setViewportView(codeViewer);

        jLabel4.setText("Resultado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(173, 173, 173)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(inputFilePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(264, 264, 264))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputFilePicker, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Selecione apenas seu arquivo",
            "txt", "jpg", "csv", "png", "jspn"
        );
        fileChooser.setFileFilter(filter);

        int chooserReturn = fileChooser.showOpenDialog(null);

        if(chooserReturn == JFileChooser.APPROVE_OPTION) {
            inputFilePicker.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }

        try {
            this.file = new File(fileChooser.getSelectedFile().getAbsolutePath());            
        } catch (Exception e) {
            System.out.println("Error in create File object at MainForm: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void fillCodeViewer() {
        String content = "";
        
        for (ArrayList<String> i : this.lexToken) {
            content += i.get(1);
        }
        
        codeViewer.setText(content);
    }
    
    public void fillTokenTable() {        
        
        //create table with data
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        String header[] = new String[] { "Lexema", "Token" };
        dtm.setColumnIdentifiers(header);
        tokenTable.setModel(dtm);
        
        
        for (ArrayList<String> i : this.lexToken) {
            Vector<Object> data = new Vector<Object>();
            data.add(i.get(0));
            data.add(i.get(1));
            dtm.addRow(data);
        }
    }
    
        public void fillSymbolTable() {        
        
        //create table with data
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        String header[] = new String[] { "Token", "Nome", "Tipo" };
        dtm.setColumnIdentifiers(header);
        symbolsTable.setModel(dtm);
        
         
        for (ArrayList<String> i : this.symbols) {
            Vector<Object> data = new Vector<Object>();
            data.add(i.get(0));
            data.add(i.get(1));
            data.add(i.get(2));
            dtm.addRow(data);
        }
    }
    
    public void compile(String content) {
        String[] splited = content.split(" |\n|\r|\t");
        
        int i = 0;
        for(String word : splited) {
            java.util.List<String> valid = Arrays.asList(this.reserved_words);
            
            if(word.matches(" |")) {
                continue;
            }
            
            if(valid.contains(word)) {
                    ArrayList<String> e = new ArrayList<>();
                    e.add(word);
                    e.add( "<"+word+">");
                    this.lexToken.add(e);
            } else {
                if(word.startsWith("$")) {
                    String token = "<var,"+i+">";
                    ArrayList<String> e = new ArrayList<>();
                    e.add(word);
                    e.add(token);
                    this.lexToken.add(e);
                    ArrayList<String> el = new ArrayList<>();
                    el.add(token);
                    el.add(word);
                    el.add("var");
                    this.symbols.add(el);
                } else if (word.matches("\\d*[.]+?\\d*")) {
                    String token = "<float,"+word+">";
                    ArrayList<String> e = new ArrayList<>();
                    e.add(word);
                    e.add(token);
                    this.lexToken.add(e);
                    ArrayList<String> el = new ArrayList<>();
                    el.add(token);
                    el.add(word);
                    el.add("float");
                    this.symbols.add(el);
                } else if (word.matches("^\\d*?\\d*$")) {
                    String token = "<integer,"+word+">";
                    ArrayList<String> e = new ArrayList<>();
                    e.add(word);
                    e.add(token);
                    this.lexToken.add(e);
                    ArrayList<String> el = new ArrayList<>();
                    el.add(token);
                    el.add(word);
                    el.add("int");
                    this.symbols.add(el);
                } else {
                    String token = "<ext,"+i+">";
                    ArrayList<String> e = new ArrayList<>();
                    e.add(word);
                    e.add(token);
                    this.lexToken.add(e);
                    ArrayList<String> el = new ArrayList<>();
                    el.add(token);
                    el.add(word);
                    el.add("ext");
                    this.symbols.add(el);
                }
            }
            i++;
        }
        
        this.fillTokenTable();
        this.fillSymbolTable();
        this.fillCodeViewer();
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String content = "";

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(this.file);

            int i=0;    
            while((i=fis.read())!=-1){    
                content += (char)i;    
            }
            
            // System.out.println("content: " + content);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        this.compile(content);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea codeViewer;
    private javax.swing.JTextField inputFilePicker;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable symbolsTable;
    private javax.swing.JTable tokenTable;
    // End of variables declaration//GEN-END:variables
}