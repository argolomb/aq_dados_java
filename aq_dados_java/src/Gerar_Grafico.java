import javax.swing.BoxLayout;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


import javax.swing.BoxLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class Gerar_Grafico extends JPanel{
                
    public void grafico(JPanel jPanel_chart){
                
                //XYSeries series = new XYSeries("Sensor 15cm");
                //XYSeriesCollection dataset = new XYSeriesCollection(series);
                
                JFreeChart chart = ChartFactory.createXYLineChart("Bancada Fluxo de Calor","Time (segundos)", "Temperatura", aq_dados_gui.dataset);
                
                jPanel_chart.add(new ChartPanel(chart));
                jPanel_chart.repaint();
                jPanel_chart.setVisible(true);
                

    }


}