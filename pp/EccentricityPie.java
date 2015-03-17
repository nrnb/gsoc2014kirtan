package pp;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kirtan
 */








import cytoscape.CyNode;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JPanel;
import Intutils.IntCentrality;
import Intutils.IntImplCentrality;
import java.util.Vector;
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
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * A simple demonstration application showing how to create a pie chart using 
 * data from a {@link DefaultPieDataset}.
 */

    
public class EccentricityPie 

     extends JFrame  {

    
    
    
    
    
    
public  String nodeName;
    public CyNode node;
    public static DefaultCategoryDataset dds = new DefaultCategoryDataset();
//    public static IntMyBarRenderer mybarrenderer;
    public Vector centralities;
   // public Vector centralities;
    public String removedNodeIdentifier;

    /**
     * Default constructor.
     *
     * @param title  the frame title.
     */
    public EccentricityPie(CyNode node, Vector centr,String title) {
        
        
         super("Plot By Node visualization for " + node.getIdentifier());
        this.centralities = new Vector();
       // JOptionPane.showMessageDialog(null, "i m here");
        //this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        centralities.addAll(centr);
         this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        
         nodeName = node.getIdentifier();
        this.node = node;
         
         //super(title);
         JPanel jpanel = createDemoPanel();
        //jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
        //setContentPane(createDemoPanel());
    }

    /**
     * Creates a sample dataset.
     * 
     * @return A sample dataset.
     */
    private  PieDataset createDataset() {
              DefaultPieDataset dataset = new DefaultPieDataset();
          //    int n=0;
              for (Iterator it = centralities.iterator(); it.hasNext();) {
        IntCentrality cent1 = (IntCentrality) it.next();
        //JOptionPane.showMessageDialog(null, cent1.getName());
      //  JOptionPane.showMessageDialog(null,cent1.getName().toString().endsWith("% Betweenness")==true);
        if(cent1.getName().toString().endsWith("% Eccentricity")==true)
        {
        String v0= cent1.getName();
         double v1 = cent1.getMaxValue();
         double v2 = cent1.getMinValue();
          double v3 = cent1.getDefaultValue();
        // JOptionPane.showConfirmDialog(rootPane, "mazx"+v1+"   min="+v2);
/*String s1 = node.getIdentifier() + " Interference centrality value";
        DefaultPieDataset dataset = new DefaultPieDataset();
         for (Iterator it = centralities1.iterator(); it.hasNext();) {
        IntCentrality cent = (IntCentrality) it.next();
        
        
        
             double v1 = cent.getDefaultValue();
            //double v2 = 0;
            double v2 = cent.getMinValue();
            //double v3 = 100;
            double v3 = cent.getMaxValue();
            // add node value for centrality cent
            CyAttributes cattr = Cytoscape.getNodeAttributes();

            //           System.out.println("il nodo è = " + node.getIdentifier());
            //           System.out.println("la centralità è = " + cent.toString());
            double vtmp = cattr.getDoubleAttribute(node.getIdentifier(), cent.getName());
            //       System.out.println("il name della cent è" + cent.getName());
            //double v4 = Math.abs(vtmp -cent.getMinValue())/ Math.abs(cent.getMaxValue()-cent.getMinValue())*100;
            double v4 = vtmp;
       
            
             if ((!Double.isInfinite(v1))
                    && (!Double.isInfinite(v2))
                    && (!Double.isInfinite(v3))
                    && (!Double.isInfinite(v4))) {
       // dataset.setValue("avg",v1);
         
        //dataset.setValue("min", v2);
        //dataset.setValue("max", v3);
        //dataset.setValue(s1, v4);
*/
         dataset.setValue("Max"+v0, v1);//new Double(11.0
         dataset.setValue("Min"+v0, Math.abs(v2));
          dataset.setValue("Avg"+v0, Math.abs(v3));
        //dataset.setValue("Six", new Double(19.4));
        // n=1;
        }
        
              }
    return dataset;   
         }
    /*
     * Creates a chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return A chart.
     */
    private static JFreeChart createChart(PieDataset dataset) {
        
        JFreeChart chart = ChartFactory.createPieChart(
            "Pie Chart for Eccentricity",  // chart title
   dataset,true,true,true
        );

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        
        return chart;
        
    }
    
    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     * 
     * @return A panel.
     */
    public  JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        //this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        return new ChartPanel(chart);
        
    }
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    //public static void main(String[] args) {

        
        //NewClass demo = new NewClass("Pie Chart Demo 1");
       // demo.pack();
        //RefineryUtilities.centerFrameOnScreen(demo);
        //demo.setVisible(true);

    //}

}


    

