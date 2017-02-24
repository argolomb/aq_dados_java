
import com.fazecast.jSerialComm.SerialPort;
import java.awt.BasicStroke;
import java.awt.Color;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.json.*;






/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miguel
 */




public class aq_dados_gui extends javax.swing.JFrame{
    
    static SerialPort port;
    
    static XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
    
    static XYSeries series15 = new XYSeries("Sensor 15cm");
    static XYSeries series25 = new XYSeries("Sensor 25cm");
    static XYSeries series35 = new XYSeries("Sensor 35cm");
    static XYSeriesCollection dataset = new XYSeriesCollection();
    
    static int x = 0;
    
    int number=0;

    /**
     * Creates new form aq
     */
    public aq_dados_gui() {
        initComponents();
        dataset.addSeries(series15);
        dataset.addSeries(series25);
        dataset.addSeries(series35);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbbox_ports = new javax.swing.JComboBox();
        btn_conectar = new javax.swing.JButton();
        cmbbox_baudrate = new javax.swing.JComboBox();
        jPanel_chart = new javax.swing.JPanel();
        chkbox_sensor15 = new javax.swing.JCheckBox();
        chkbox_sensor25 = new javax.swing.JCheckBox();
        chkbox_sensor35 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bancada para Controle de Fluxo de Calor");

        cmbbox_ports.setModel(new javax.swing.DefaultComboBoxModel());
        cmbbox_ports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbox_portsActionPerformed(evt);
            }
        });

        btn_conectar.setText("Conectar");
        btn_conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_conectarActionPerformed(evt);
            }
        });

        cmbbox_baudrate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "9600", "14400", "19200", "28800", "38400", "57600", "115200" }));

        jPanel_chart.setBackground(new java.awt.Color(254, 254, 254));
        jPanel_chart.setLayout(new javax.swing.BoxLayout(jPanel_chart, javax.swing.BoxLayout.LINE_AXIS));

        chkbox_sensor15.setSelected(true);
        chkbox_sensor15.setText("Sensor 15cm");
        chkbox_sensor15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbox_sensor15ActionPerformed(evt);
            }
        });

        chkbox_sensor25.setText("Sensor 25cm");

        chkbox_sensor35.setText("Sensor 35cm");

        jLabel1.setText("Selecionar Porta Serial");

        jLabel2.setText("Selecionar Baudrate");

        jLabel3.setText("Exibir no Gráfico:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(1023, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_conectar, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(cmbbox_baudrate, 0, 181, Short.MAX_VALUE)
                            .addComponent(cmbbox_ports, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chkbox_sensor15)
                            .addComponent(chkbox_sensor25)
                            .addComponent(chkbox_sensor35)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel_chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_conectar, cmbbox_baudrate, cmbbox_ports});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_chart, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbbox_ports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbbox_baudrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_conectar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkbox_sensor15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkbox_sensor25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkbox_sensor35)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbbox_portsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbox_portsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbox_portsActionPerformed

    private void btn_conectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_conectarActionPerformed
        // TODO add your handling code here:
        
        if(btn_conectar.getText().equals("Conectar")){
            //DEBUG
            System.out.println("Botão Ok");
            //DEBUG
            port = SerialPort.getCommPort(cmbbox_ports.getSelectedItem().toString());
            port.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
            port.setBaudRate(Integer.parseInt(cmbbox_baudrate.getSelectedItem().toString()));
            
            if(port.openPort()){
                
                btn_conectar.setText("Desconectar");
                cmbbox_ports.setEnabled(false);
                cmbbox_baudrate.setEnabled(false);
                
            
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(aq_dados_gui.class.getName()).log(Level.SEVERE, null, ex);
            }
            Thread thread =new Thread(){
            @Override
            
            public void run(){
                
                Scanner scanner = new Scanner(port.getInputStream());
				while(scanner.hasNext()) {
					try {
						 String line = scanner.nextLine();
                                                //int number = Integer.parseInt(line);
						//series.add(x++,number);
                                                //System.out.println(number);
                                                try{
                                                    JSONArray jsonArray = new JSONArray(line);
                                                    JSONObject jsonSensor15 = jsonArray.getJSONObject(0);
                                                    JSONObject jsonSensor25 = jsonArray.getJSONObject(1);
                                                    JSONObject jsonSensor35 = jsonArray.getJSONObject(2);
                                                    /*
                                                    series15.add(jsonSensor15.getBigInteger("time"), jsonSensor15.getInt("value"));
                                                    series25.add(jsonSensor25.getBigInteger("time"), jsonSensor25.getInt("value"));
                                                    series35.add(jsonSensor35.getBigInteger("time"), jsonSensor35.getInt("value"));
                                                    */
                                                    series15.add(x, jsonSensor15.getInt("value"));
                                                    series25.add(x, jsonSensor25.getInt("value"));
                                                    series35.add(x++, jsonSensor35.getInt("value"));

                                                    renderer.setSeriesVisible(0, chkbox_sensor15.isSelected());
                                                    renderer.setSeriesVisible(1, chkbox_sensor25.isSelected());
                                                    renderer.setSeriesVisible(2, chkbox_sensor35.isSelected());
                                                                                                                                                                
                                                    }catch(JSONException e){
                                                        e.printStackTrace();                                                
                                                     }
                                                
                                             } catch(Exception e) {}
				}
                                scanner.close();
                                
                        }
           
            };
            thread.start();
            }else{
            port.closePort();
            cmbbox_ports.setEnabled(true);
            cmbbox_baudrate.setEnabled(true);
            btn_conectar.setText("Conectar");
            /*APAGA O GRAFICO */
            series15.clear();
            series25.clear();
            series35.clear();
            x=0;
            /*APAGA O GRAFICO */
        }
        
    }//GEN-LAST:event_btn_conectarActionPerformed

    private void chkbox_sensor15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbox_sensor15ActionPerformed
        // TODO add your handling code here:
               
    }//GEN-LAST:event_chkbox_sensor15ActionPerformed
   
    /**
     * @param args the command line arguments
     */
            
    public static void main(String args[]) {
                
                new aq_dados_gui().setVisible(true);
                
                Lista_Serial lista_serial=new Lista_Serial();
                SerialPort[] ports_names=lista_serial.lista_serial();
                int ports_num=lista_serial.lista_serial().length;
                
                for(int i=0; i<ports_num;i++){
                    
                cmbbox_ports.addItem(ports_names[i].getSystemPortName());
                }
                
                JFreeChart chart = ChartFactory.createXYLineChart("Bancada Fluxo de Calor","Nº de Amostras", "Temperatura ºC", dataset, PlotOrientation.VERTICAL,true,true,false);
                
                //Gerar_Grafico grafico = new Gerar_Grafico();
                //grafico.grafico(jPanel_chart);
                
                XYPlot plot = chart.getXYPlot();

                
                renderer.setSeriesPaint( 0 , Color.RED );
                renderer.setSeriesPaint( 1 , Color.BLACK );
                renderer.setSeriesPaint( 2 , Color.blue );
                renderer.setSeriesStroke( 0 , new BasicStroke( 1.5f ) );
                renderer.setSeriesStroke( 1 , new BasicStroke( 1.5f ) );
                renderer.setSeriesStroke( 2 , new BasicStroke( 1.5f ) );
                renderer.setSeriesShapesVisible(0, false);
                renderer.setSeriesShapesVisible(1, false);
                renderer.setSeriesShapesVisible(2, false);
                
                plot.setRenderer(renderer);
                ValueAxis axis = plot.getDomainAxis();
                axis.setAutoRange(true);
                axis.setFixedAutoRange(60);
                
               
                jPanel_chart.add(new ChartPanel(chart));
                jPanel_chart.repaint();
                jPanel_chart.setVisible(true);
                
        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton btn_conectar;
    private static javax.swing.JCheckBox chkbox_sensor15;
    private static javax.swing.JCheckBox chkbox_sensor25;
    private static javax.swing.JCheckBox chkbox_sensor35;
    private javax.swing.JComboBox cmbbox_baudrate;
    private static javax.swing.JComboBox cmbbox_ports;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private static javax.swing.JPanel jPanel_chart;
    // End of variables declaration//GEN-END:variables
}
