/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barchart;

/**
 *
 * @author Kirtan
 */
import javax.swing.JFrame;
 
public class BarChartTester    extends  JFrame    
{
   public    BarChartTester() //s//tatic void main(String[] args)
   {
      JFrame frame = new JFrame();
 
      final int FRAME_WIDTH = 300;
      final int FRAME_HEIGHT = 400;
 
      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("BarChart");
      frame.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
 
      BarChartComponent component = new BarChartComponent();
      frame.add(component);
 
      frame.setVisible(true);
   }
}