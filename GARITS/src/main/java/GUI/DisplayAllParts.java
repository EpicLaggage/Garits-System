/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.PartsTable.PartsTableModel;
import StockControl.Part;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author jorda
 */
public class DisplayAllParts extends JFrame implements ActionListener {
    private PartsTableModel tableModel;
    private JTable table;
    private ArrayList<Part> parts;
    Part part;
    public DisplayAllParts(String title) {
        super(title);
        setBounds(10, 10, 1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tableModel = new PartsTableModel(part);
        table = new JTable(tableModel);
        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1000, 1000));
        JPanel panel = new JPanel();
        panel.add(scrollPane);
        add(panel, BorderLayout.CENTER);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
    }
    
    public static void main(String[] args) {
        DisplayAllParts displayAll = new DisplayAllParts("All Parts");
        displayAll.setVisible(true);
    }
    
}
