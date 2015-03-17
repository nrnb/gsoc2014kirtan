/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pp;
import Interference.InterferenceStartMenu;
import cytoscape.CyNode;
import java.awt.Font;
import java.util.Vector;
import IntVisualizer2.IntCentralityPanel;
import Interference.InterferenceStartMenu;
import javax.swing.JPanel;
import Intutils.IntCentrality;
import Intutils.IntImplCentrality;
import java.util.Vector;
import cytoscape.CyNode;
import cytoscape.Cytoscape;
import cytoscape.data.CyAttributes;
import java.awt.*;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import Intutils.IntCentrality;
import Intutils.IntImplCentrality;
import java.util.Vector;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import Intutils.IntCentrality;
import cytoscape.Cytoscape;
import cytoscape.data.CyAttributes;
import java.awt.Component;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author gdcst
 */

public class Srt1   extends JFrame  { 
        
public  String nodeName;
    public CyNode node;
    public static DefaultCategoryDataset dds = new DefaultCategoryDataset();
//    public static IntMyBarRenderer mybarrenderer;
    public Vector centralities;
   // public Vector centralities;
    public String removedNodeIdentifier;
    static int t1=0,t2=0,t3=0;
    public ArrayList<Double> jlist1;
    public ArrayList jlist2;
    public ArrayList jlist3;
    public ArrayList jlist11;
    
public Srt1()
{}

 public Srt1(String title) 
 {        
        
     super("Sorting data of Closeness" );
        this.centralities = new Vector();
        //this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        //centralities.addAll(centr);
         this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        
         //nodeName = node.getIdentifier();
       /// this.node = node;
         
         //super(title);
         JPanel jpanel = createDemoPanel();
        //jpanel.setPreferredSize(new Dimension(500, 270));
       //JScrollPane s = new JScrollPane(jpanel); 
      /// this.add(s);
         //panel.add(new JScrollPane(table));
        setContentPane(jpanel);
        //setContentPane(createDemoPanel());
    }
public  JTable j,j1,j2,j3;
    /**
     * Creates a sample dataset.
     * 
     * @return A sample dataset.
     */
    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     * 
     * @return A panel.
     */
    public  JPanel createDemoPanel() {
     //   JFreeChart chart = createChart(createDataset());
        //this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
       // return new ChartPanel(chart);
        
       JPanel p = new JPanel();
         JPanel l1 = new JPanel((new FlowLayout(FlowLayout.LEFT)));
         
       
     //int n=Integer.parseInt(new InterferenceStartMenu().txtdel.getText());  
       DefaultTableModel dt = new IntCentralityPanel().dtm2;
        DefaultTableModel dt1= new DefaultTableModel(dt.getRowCount(),0);
        DefaultTableModel dt2= new DefaultTableModel(dt.getRowCount(),0);
        DefaultTableModel dt3= new DefaultTableModel(dt.getRowCount(),0);
        
         // dt.setRowCount(dt.getRowCount()-1);
       
        JTableHeader hello = new JTableHeader();
    p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
p.setAlignmentX(Component.LEFT_ALIGNMENT);   
//p.add(j1.getTableHeader());

 //JTableHeader header = j1.getTableHeader();
          //p.add(j1, BorderLayout.CENTER);

        dt1.addColumn(dt.getColumnName(0));
        dt2.addColumn(dt.getColumnName(0));
        dt3.addColumn(dt.getColumnName(0));
        dt1.addColumn(dt.getColumnName(1));
        dt2.addColumn(dt.getColumnName(1));
        dt3.addColumn(dt.getColumnName(1));
       
      j= new JTable();
        j1 = new JTable();
          j2 = new JTable();
           j3 = new JTable();
          
        
           
        
                j.setModel(dt);
                
       /* dt1.setRowCount(dt1.getRowCount()-1);
       j1.setModel(dt1);
       dt2.setRowCount(dt2.getRowCount()-1);
       j2.setModel(dt3);
        dt3.setRowCount(dt3.getRowCount()-1);
       j3.setModel(dt3);
       * *
       */
                
     
 
        j.setAutoCreateRowSorter(true);
              j.getRowSorter().toggleSortOrder(1);
    
   
             
       int n1=t1,n2=t2,n3=t3;
       int ans=n1+n2+n3;
       TreeSet set = new TreeSet();
     //  JOptionPane.showMessageDialog(null, ans);
       
       for(int e=0;e<j.getRowCount();e++)
       {
          if((j.getValueAt(e, 0).toString().equals(""))==true)
          {
          continue;
          
          }
           
           if (j.getValueAt(e, 0).toString().endsWith("% Eccentricity")==true)
           {
                        
               dt1.setValueAt(j.getValueAt(e, 0), t1, 0);
               dt1.setValueAt(j.getValueAt(e, 1), t1, 1);
      //         jlist11.add(j.getValueAt(e, 0).toString());
        //       jlist1.add(Double.parseDouble(j.getValueAt(e, 1).toString()));
               
               
               
               t1++;
               
           }
           else if(j.getValueAt(e, 0).toString().endsWith("% Closeness")==true)
           {
               
               dt2.setValueAt(j.getValueAt(e, 0), t2, 0);
               dt2.setValueAt(j.getValueAt(e, 1), t2, 1);
               t2++;
               
           }
             else if(dt.getValueAt(e, 0).toString().endsWith("Stress")==true)
           {
               dt3.setValueAt(j.getValueAt(e, 0), t3, 0);
               dt3.setValueAt(j.getValueAt(e, 1), t3, 1);
               t3++;
               
           }
           
       
       
       }
      // j1.setAutoResizeMode(t1);
    
   dt1.setRowCount(t1); 
   dt2.setRowCount(t2);
   dt3.setRowCount(t3);
      j1.setModel(dt1);
    //JOptionPane.showMessageDialog(null, t1+"    "+t2+"     "+t3);
    
    
    
   // DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    //for(int i = 0; i < jlist1.size(); i++){
//dataset.setValue(dub[i], "Marks", student[i]); //Setting the values

   // dataset.addValue(jlist1.get(i), "first", jlist11.get(i).toString());
    //dataset.setValue();
    //}
    //JFreeChart chart = createChart(dataset);
    
  //ChartPanel ct = new  ChartPanel(chart);
  //ct.setPreferredSize(new Dimension(500, 270));
       // setContentPane(ct);

  
   
   
      
      j2.setModel(dt2);
    
//l1.add(ct);    
    
    
    
    
    j3.setModel(dt3);
      
           //  j1.setAutoCreateRowSorter(true);
             // j1.getRowSorter().toggleSortOrder(1);
              
              //j2.setAutoCreateRowSorter(true);
              //j2.getRowSorter().toggleSortOrder(1);
              
              //j3.setAutoCreateRowSorter(true);
              //j3.getRowSorter().toggleSortOrder(1);
 
    
    
    
       
      // j.setAutoscrolls(true);
      // j.setAutoResizeMode();
            
       //TableRowSorter mysorter = new TableRowSorter(dtm);
     //j.setRowSorter(mysorter);
        // j.getRowSorter().toggleSortOrder(1);
            
             //JScrollPane scrollPane = new JScrollPane(p);
            // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            // p.add(scrollPane);
        // List<RowSorter.SortKey> NO_SORT = Collections.emptyList();
       //  j.getRowSorter().setSortKeys(NO_SORT);
    
           
       //j.setModel(new IntCentralityPanel().dtm);
       //JLabel l1= new JLabel("hi");
       //p.add(j);
    //p.add(j1.getTableHeader(),"Betweenness");
    // p.add(j2.getTableHeader(),"Closeness");
    //  p.add(j3.getTableHeader(),"Stres");
    //JOptionPane.showMessageDialog(null, j1.getModel().getValueAt(4,4 ));
    
  //  for(int i=0;i<j1.getRowCount();i++)
                      //
                      
                     //JOptionPane.showMessageDialog(null,Double.parseDouble(   j1.getValueAt(i, 2).toString()));
                      
                      
                      //
    JLabel l2 = new JLabel("                                    1)Fisrt Box Data contain Betweenness*");
    
    p.add((l2));
       p.add(j1);
       JLabel l3 = new JLabel("            2) Second Box Data contain Closeness*");
        //p.add((l3));
         //p.add(j2);
         //JLabel l4 = new JLabel("            3) Thired Box Data contain Stress*");
         //p.add((l4));
   
        // p.add(j3);
         
         p.add(hello, BoxLayout.PAGE_AXIS);
     //p.add(l1);
         //JLabel l1 = new JLabel("Betweenness");
      //p.add(new JScrollPane(j));
        p.add(new JScrollPane(j1));
       //  p.add(new JScrollPane(j2));
        //  p.add(new JScrollPane(j3));
          //p.add(j1.getTableHeader(), BorderLayout.NORTH);
          //p.add(j1, BorderLayout.CENTER);
           JLabel l2cls = new JLabel("            2) Second Box Data contain Closeness*");
      //  l1.add((l2cls));
       l1.add(j1); 
        //l1.add(new JScrollPane(j2));
       
       l1.add(new JScrollPane(j1));
       l1.add((l2));
       //l1.add(j); 
       //l1.add(new JScrollPane(j1));
       
       //return p;
       return l1;
        
    }
   /* private JFreeChart createChart(final CategoryDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
            "Bar Chart Demo",         // chart title
            "Category",               // domain axis label
            "Value",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );
        return chart;
    }
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    //
    //public static void main(String[] args) {

        
        //NewClass demo = new NewClass("Pie Chart Demo 1");
       // demo.pack();
        //RefineryUtilities.centerFrameOnScreen(demo);
        //demo.setVisible(true);

    

}


    

