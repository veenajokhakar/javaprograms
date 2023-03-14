/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

/**
 *
 * @author Dell
 */
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class GetCellValues{
  JTable table;
  public static void main(String[] args) {
  new GetCellValues();
  }

  public GetCellValues(){
  JFrame frame = new JFrame("Getting Cell Values in JTable");
  JPanel panel = new JPanel();
  String data[][] = {{"Vinod","MCA","Computer"},
  {"Deepak","PGDCA","History"},
  {"Ranjan","M.SC.","Biology"},
  {"Radha","BCA","Computer"}};
  String col[] = {"Name","Course","Subject"};  
  DefaultTableModel model = new DefaultTableModel(data, col);
  table = new JTable(model);
  JTableHeader header = table.getTableHeader();
  header.setBackground(Color.yellow);
  JScrollPane pane = new JScrollPane(table);
  Object obj1 = GetData(table, 2, 2);
  System.out.println("Cell value of 3 column and 3 row :" + obj1);
  Object obj2 = GetData(table, 1, 1);
  System.out.println("Cell value of 2 column and 2 row :" + obj2);
  panel.add(pane);
  frame.add(panel);
  frame.setSize(500,150);
  frame.setUndecorated(true);
  frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
  frame.setVisible(true);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public Object GetData(JTable table, int row_index, int col_index){
  return table.getModel().getValueAt(row_index, col_index);
  }  
}
