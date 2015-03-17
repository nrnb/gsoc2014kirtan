
package IntVisualizer2;

import java.util.*;
import Intutils.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author  Kirtan
 */
public class IntCentralityPanel extends javax.swing.JPanel implements Cloneable {
   public  static  DefaultTableModel dtm;
     public static ArrayList<String[]> resultData = new ArrayList<String[]>();
    public class MyObservable extends Observable {

        public void doIt(IntCentralityPanel cp) {
            this.setChanged();
            notifyObservers(cp);
        }
    }
   
    static int s=0;
    public static DefaultTableModel dtm2;
      
        
       
        String[] colnames={"Node Name","Value"};
     Vector<String> colNames = new Vector<String>();
     colNames.add("Node Name");
     colNames.add("Value");
     //Object[][] data = {{cent.getName().toString(),cent.getDefaultValue()}};
     Object[][] data = {{cent.getName().toString(),Math.abs(cent.getMaxValue())}};//.getDefaultValue()
     String[] thisTabData = {cent.getName().toString(),String.valueOf(Math.abs(cent.getMaxValue()))};
   
data2.add(Math.abs(cent.getMaxValue()));
     resultData.add(thisTabData);
        //DefaultTableModel dtm;
         if (s==0)
         {dtm = new DefaultTableModel(resultData.toArray(data), colnames);
             s=1;
         
         }
         else{
         dtm.setRowCount(0);
         dtm.setDataVector(data, colnames);
       //dtm2.setRowCount(0); 
         dtm2 =new DefaultTableModel(resultData.toArray(data), colnames);
         jTable1.setModel(dtm2);
         
         
         }
   // DefaultTableModel dtm = new DefaultTableModel(resultData.toArray(data), colnames);
     
     //tblTemp.setModel(dtm);
     TableRowSorter mysorter = new TableRowSorter(dtm);
     tblTemp.setRowSorter(mysorter);
         tblTemp.getRowSorter().toggleSortOrder(1);
        
         tblTemp.setModel(dtm);
        //JTable table = new JTable (dtm);
        //table.setAutoCreateRowSorter (true);
        //TableRowSorter<TableModel> sorter;
        //sorter = new TableRowSorter<TableModel> (dtm);
        //tblTemp.setAutoCreateColumnsFromModel(true);
        
        //tblTemp.setRowSorter(mysorter);
        //.setVisible(true);
    }

   