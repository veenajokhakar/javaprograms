import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class JTableDatabase extends JFrame{
public JTableDatabase() {
Vector columnNames = new Vector();
Vector data = new Vector();

try {
Class.forName("DriverNM");
Connection connect =DriverManager.getConnection("databasenm connection str");

String sql = "Select * from emp";
Statement stmt = connect.createStatement();
ResultSet rs = stmt.executeQuery( sql );
ResultSetMetaData md = rs.getMetaData();
int columns = md.getColumnCount();
for (int i = 1; i <= columns; i++) {
columnNames.addElement( md.getColumnName(i) );
}
while (rs.next()) {
Vector row = new Vector(columns);
for (int i = 1; i <= columns; i++) {
row.addElement( rs.getObject(i) );
}
data.addElement( row );
}
rs.close();
stmt.close();
}
catch(Exception e) {
System.out.println( e );
}
JTable table = new JTable(data, columnNames);

JScrollPane scrollPane = new JScrollPane( table );
getContentPane().add( scrollPane );

JPanel buttonPanel = new JPanel();
getContentPane().add( buttonPanel, BorderLayout.SOUTH );
}
public static void main(String[] args)
{


JTableDatabase frame = new JTableDatabase();
frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
frame.pack();
frame.setTitle("Information Table");
frame.setVisible(true);
}
}