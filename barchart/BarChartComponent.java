/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barchart;

/**
 *
 * @author Kirtan
 */
import IntVisualizer2.IntCentralityPanel;
import pp.Srt;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
 
public class BarChartComponent extends JComponent
{
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      BarChart c = new BarChart(getWidth(), getHeight());
           Srt s = new Srt();
           
           DefaultTableModel dt = new IntCentralityPanel().dtm2;
        DefaultTableModel dt1= new DefaultTableModel(dt.getRowCount(),0);
        
        
        
        dt1.addColumn(dt.getColumnName(0));
       
        dt1.addColumn(dt.getColumnName(1));
        JTable j1,j;
       
      j= new JTable();
        j1 = new JTable();
            j.setModel(dt);
            
            
            int t1=0;
            
             j.setAutoCreateRowSorter(true);
              j.getRowSorter().toggleSortOrder(1);
              
              
               for(int e=0;e<j.getRowCount();e++)
       {
           
            
           if (j.getValueAt(e, 0).toString().endsWith("% Betweenness")==true)
           {
                        
               dt1.setValueAt(j.getValueAt(e, 0), t1, 0);
               dt1.setValueAt(j.getValueAt(e, 1), t1, 1);
      //         jlist11.add(j.getValueAt(e, 0).toString());
        //       jlist1.add(Double.parseDouble(j.getValueAt(e, 1).toString()));
               
               
               
               t1++;
               
           }
       }
                dt1.setRowCount(t1); 
                 j1.setModel(dt1);
                 
                 
                 
            //     JOptionPane.showMessageDialog(null, j1.getRowCount());
           //JTable j1 =s.j1;
         //  JOptionPane.showMessageDialog(null,Double.parseDouble(   j1.getValueAt(1, 2).toString()));
          //JOptionPane.showMessageDialog(null, );
                 for(int r=0;r<j1.getRowCount();r++)
                 {
                     
                     c.add(Double.parseDouble(j1.getValueAt(r, 1).toString()));
                 }
                 
      /*c.add(1.1);
      c.add(3.6);
      c.add(4.0);
      c.add(3.7);
      c.add(2.1);
      c.add(2.7);
      c.add(2.6);
      c.add(1.1);
      c.add(3.6);
      c.add(4.0);
      c.add(3.7);
      c.add(2.1);
      c.add(2.7);
      c.add(2.6);
      
      c.add(1.1);
      c.add(3.6);
      c.add(4.0);
      c.add(3.7);
      c.add(2.1);
      c.add(2.7);
      c.add(2.6);
      
      c.add(1.1);
      c.add(3.6);
      c.add(4.0);
      c.add(3.7);
      c.add(2.1);
      c.add(2.7);
      c.add(2.6);
      */
      c.draw(g2);
   }
}