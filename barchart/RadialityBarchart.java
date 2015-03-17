/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barchart;

/**
 *
 * @author gdcst
 */
import IntVisualizer2.IntCentralityPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import pp.Srt;

public class RadialityBarchart extends JFrame {

    private static final long serialVersionUID = 1L;

  /*  public NewClass(final String title) {
        super(title);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);

    }*/

    public RadialityBarchart() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Returns a sample dataset.
     * @return The dataset.
     */
    private CategoryDataset createDataset() {
        
        
        
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
           
            
           if (j.getValueAt(e, 0).toString().endsWith("% Radiality")==true)
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
                final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                 for(int r=0;r<j1.getRowCount();r++)
                 {
                      
       final String rowName = "Radiality";
       //final String[] columnName = { "Column1","Column2","Column3","Column4","Column5"};
        

        dataset.addValue(Double.parseDouble(j1.getValueAt(r, 1).toString()), rowName, j1.getValueAt(r, 0).toString());
        /*dataset.addValue(9.3, rowName, columnName[1]);
        dataset.addValue(9.4, rowName, columnName[2]);
        dataset.addValue(9.5, rowName, columnName[3]);
        dataset.addValue(10.0, rowName, columnName[4]);*/
}
        return dataset;
    }

    /**
     * Creates a sample chart.
     * @param dataset  the dataset.
     * @return The chart.
     */
    private JFreeChart createChart(final CategoryDataset dataset) {
        double d =0.0;
        final JFreeChart chart =
            ChartFactory.createBarChart(
                    "Radiality Chart",
                    "Radiality Nodes",
                    "% Radiality",
                    dataset,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false);
        chart.setBackgroundPaint(Color.white);  
        // Set the background color of the chart
        chart.getTitle().setPaint(Color.DARK_GRAY);
        chart.setBorderVisible(true);
        // Adjust the color of the title
        CategoryPlot plot = chart.getCategoryPlot();
        plot.getRangeAxis().setLowerBound(d);
        // Get the Plot object for a bar graph
        plot.setBackgroundPaint(Color.white);     
        plot.setRangeGridlinePaint(Color.CYAN);
        CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, Color.decode("#00FFFF"));
        return chart;
    }

    public RadialityBarchart(final String args) {
       // super(title);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
setVisible(true);
setSize(500, 500);
        //final NewClass test = new NewClass("Test");
        //test.pack();
        //test.setVisible(true);
    }
}
 
    

