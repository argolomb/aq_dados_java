import com.fazecast.jSerialComm.SerialPort;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.annotation.Generated;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class aq_dados_gui extends javax.swing.JFrame{
    
    static SerialPort port;
    
    static XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
    
    static XYSeries series15 = new XYSeries("Sensor 15cm");
    static XYSeries series25 = new XYSeries("Sensor 25cm");
    static XYSeries series35 = new XYSeries("Sensor 35cm");
    static XYSeriesCollection dataset = new XYSeriesCollection();
    
    static int x = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton btn_conectar;
    private static javax.swing.JCheckBox chkbox_sensor15;
    private static JTextField txtField_beta_sensor15;
    private static JTextField txtField_initialResistence_sensor15;
    private static JTextField txtField_initialTemperature_sensor;
    private static javax.swing.JCheckBox chkbox_sensor25;
    private static JTextField txtField_beta_sensor25;
    private static JTextField txtField_initialResistence_sensor25;
    private static javax.swing.JCheckBox chkbox_sensor35;
    private static JTextField txtField_beta_sensor35;
    private static JTextField txtField_initialResistence_sensor35;
    private static JTextField txtField_initial_voltage;
    private static javax.swing.JComboBox cmbbox_ports;
    private static javax.swing.JComboBox frequency_text;
    private static javax.swing.JPanel jPanel_chart;
    int number=0;
    private javax.swing.JLabel jLabel_beta_sensor15;
    private javax.swing.JLabel jLabel_beta_sensor25;
    private javax.swing.JLabel jLabel_beta_sensor35;
    private javax.swing.JLabel jLabel_initialResistence_sensor15;
    private javax.swing.JLabel jLabel_initialResistence_sensor25;
    private javax.swing.JLabel jLabel_initialResistence_sensor35;
    private javax.swing.JLabel jLabel_initialTemperature_sensor;
    private javax.swing.JLabel jLabel_initial_voltage;
    private javax.swing.JComboBox cmbbox_baudrate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private Double beta15;
    private Double beta25;
    private Double beta35;
    private Double initialTemp;
    private Double initialRes15;
    private Double initialRes25;
    private Double initialRes35;
    private Double inputVoltage;
    private int sensorCount;

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
     * @param args the command line arguments
     */

    public static void main(String args[]) {
               /* System.out.println(eval("((4 - 2^3 + 1) * -sqrt(3*3+4*4)) / 2"));
                    ScriptEngineManager mgr = new ScriptEngineManager();
                    ScriptEngine engine = mgr.getEngineByName("JavaScript");
                    String foo = "((4 - Math.pow(2, 3) + 1) * -Math.sqrt(3*3+4*4)) / 2";
//                    String foo = "((4 - 2^3))";
//        System.out.println(2^3);
        try {
            System.out.println(engine.eval(foo));
        } catch (ScriptException e) {
            e.printStackTrace();
        }*/
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
                plot.setDomainPannable(true);
                plot.setRangePannable(true);
                plot.setDomainCrosshairVisible(true);
                plot.setRangeCrosshairVisible(true);
                plot.setRenderer(renderer);
                ValueAxis axis = plot.getDomainAxis();
                axis.setFixedAutoRange(60);

                jPanel_chart.add(new ChartPanel(chart));
                jPanel_chart.repaint();
                jPanel_chart.setVisible(true);

        /* Create and display the form */

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
        frequency_text = new javax.swing.JComboBox();
        btn_conectar = new javax.swing.JButton();
        cmbbox_baudrate = new javax.swing.JComboBox();
        jPanel_chart = new javax.swing.JPanel();
        chkbox_sensor15 = new javax.swing.JCheckBox();
        chkbox_sensor25 = new javax.swing.JCheckBox();
        chkbox_sensor35 = new javax.swing.JCheckBox();
        txtField_beta_sensor15 = new JTextField();
        jLabel_beta_sensor15 = new javax.swing.JLabel();
        txtField_beta_sensor25 = new JTextField();
        jLabel_beta_sensor25 = new javax.swing.JLabel();
        txtField_beta_sensor35 = new JTextField();
        jLabel_beta_sensor35 = new javax.swing.JLabel();
        jLabel_initial_voltage = new javax.swing.JLabel();
        txtField_initial_voltage = new JTextField();
        txtField_initialResistence_sensor15 = new JTextField();
        jLabel_initialResistence_sensor15 = new javax.swing.JLabel();
        txtField_initialResistence_sensor25 = new JTextField();
        jLabel_initialResistence_sensor25 = new javax.swing.JLabel();
        txtField_initialResistence_sensor35 = new JTextField();
        jLabel_initialResistence_sensor35 = new javax.swing.JLabel();
        txtField_initialTemperature_sensor = new JTextField();
        jLabel_initialTemperature_sensor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bancada para Controle de Fluxo de Calor");

        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;
        menuBar = new JMenuBar();
        menu = new JMenu("Settings");
        menuBar.add(menu);
        menuItem = new JMenuItem("Preferences");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preferencesFrame();
            }
        });
        menu.add(menuItem);
        setJMenuBar(menuBar);

        cmbbox_ports.setModel(new javax.swing.DefaultComboBoxModel());
        cmbbox_ports.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cmbbox_portsActionPerformed(evt);
            }
        });

        frequency_text.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"0.5", "1", "2", "5", "10"}));
        frequency_text.setSelectedItem("10");
        frequency_text.setEnabled(false);
        frequency_text.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                frequencyActionPerformed(evt);
            }
        });

        btn_conectar.setText("Conectar");
        btn_conectar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn_conectarActionPerformed(evt);
            }
        });

        txtField_initialTemperature_sensor.setText("29");
        txtField_beta_sensor15.setText("4607.3");
        txtField_beta_sensor25.setText("5181.4");
        txtField_beta_sensor35.setText("4976.9");
        txtField_initialResistence_sensor15.setText("6440");
        txtField_initialResistence_sensor25.setText("5920");
        txtField_initialResistence_sensor35.setText("6990");
        txtField_initial_voltage.setText("5.11");

        cmbbox_baudrate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "9600", "14400", "19200", "28800", "38400", "57600", "115200" }));

        jPanel_chart.setBackground(new java.awt.Color(254, 254, 254));
        jPanel_chart.setLayout(new javax.swing.BoxLayout(jPanel_chart, javax.swing.BoxLayout.LINE_AXIS));

        chkbox_sensor15.setSelected(true);
        chkbox_sensor15.setText("Sensor 15cm");
        chkbox_sensor15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                chkbox_sensor15ActionPerformed(evt);
            }
        });

        chkbox_sensor25.setText("Sensor 25cm");

        chkbox_sensor35.setText("Sensor 35cm");

        jLabel1.setText("Selecionar Porta Serial");

        jLabel2.setText("Selecionar Baudrate");

        jLabel3.setText("Exibir no Gráfico:");

        jLabel4.setText("Frequência (Hz):");
        jLabel_beta_sensor15.setText("Beta");
        jLabel_beta_sensor25.setText("Beta");
        jLabel_beta_sensor35.setText("Beta");
        jLabel_initialResistence_sensor15.setText("Resistência inicial");
        jLabel_initialResistence_sensor25.setText("Resistência inicial");
        jLabel_initialResistence_sensor35.setText("Resistência inicial");
        jLabel_initialTemperature_sensor.setText("Temperatura inicial");
        jLabel_initial_voltage.setText("Tensão de entrada");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(1023, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(btn_conectar, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(cmbbox_baudrate, 0, 181, Short.MAX_VALUE)
                            .addComponent(cmbbox_ports, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(frequency_text, 181, 181, 181)
                            .addComponent(chkbox_sensor15)
                            .addComponent(chkbox_sensor25)
                            .addComponent(chkbox_sensor35)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(txtField_initialTemperature_sensor, 181, 181, 181)
                            .addComponent(jLabel_initialTemperature_sensor)
                            .addComponent(txtField_initial_voltage, 181, 181, 181)
                            .addComponent(jLabel_initial_voltage)
                            .addComponent(txtField_beta_sensor15, 181, 181, 181)
                            .addComponent(jLabel_beta_sensor15)
                            .addComponent(txtField_beta_sensor25, 181, 181, 181)
                            .addComponent(jLabel_beta_sensor25)
                            .addComponent(txtField_beta_sensor35, 181, 181, 181)
                            .addComponent(jLabel_beta_sensor35)
                            .addComponent(txtField_initialResistence_sensor15, 181, 181, 181)
                            .addComponent(jLabel_initialResistence_sensor15)
                            .addComponent(txtField_initialResistence_sensor25, 181, 181, 181)
                            .addComponent(jLabel_initialResistence_sensor25)
                            .addComponent(txtField_initialResistence_sensor35, 181, 181, 181)
                            .addComponent(jLabel_initialResistence_sensor35)
                        )
                        .addGap(18, 18, 18)
                        .addComponent(jPanel_chart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, btn_conectar, cmbbox_baudrate, cmbbox_ports);

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_chart, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbbox_ports, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(cmbbox_baudrate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(btn_conectar)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_initialTemperature_sensor)
                        .addComponent(txtField_initialTemperature_sensor)
                        .addComponent(jLabel_initial_voltage)
                        .addComponent(txtField_initial_voltage)
                        .addComponent(jLabel3)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(chkbox_sensor15)
                        .addComponent(jLabel_beta_sensor15)
                        .addComponent(txtField_beta_sensor15)
                        .addComponent(jLabel_initialResistence_sensor15)
                        .addComponent(txtField_initialResistence_sensor15)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(chkbox_sensor25)
                        .addComponent(jLabel_beta_sensor25)
                        .addComponent(txtField_beta_sensor25)
                        .addComponent(jLabel_initialResistence_sensor25)
                        .addComponent(txtField_initialResistence_sensor25)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(chkbox_sensor35)
                        .addComponent(jLabel_beta_sensor35)
                        .addComponent(txtField_beta_sensor35)
                        .addComponent(jLabel_initialResistence_sensor35)
                        .addComponent(txtField_initialResistence_sensor35)
                        .addComponent(jLabel4)
                        .addComponent(frequency_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openSensorFrame(String name, String value, DefaultTableModel model)
    {
        JFrame frame = new JFrame("Adicionar sensor");
        frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        JTextField txt_field_sensor_name = new JTextField();
        JTextField txt_field_sensor_id = new JTextField();
        JTextField txt_field_sensor_value = new JTextField();
        JButton button = new JButton();
        JLabel label_sensor_name = new JLabel();
        JLabel label_sensor_id = new JLabel();
        JLabel label_sensor_value = new JLabel();
        label_sensor_name.setText("Nome do sensor");
        label_sensor_id.setText("Id do sensor");
        label_sensor_value.setText("Valor do sensor");
        txt_field_sensor_name.setText(name);
        txt_field_sensor_id.setText("s"+String.valueOf(sensorCount));
        txt_field_sensor_id.setEnabled(false);
        txt_field_sensor_value.setText(value);
        button.setText("Adicionar");
        button.putClientProperty("name", txt_field_sensor_name.getText());
        button.putClientProperty("value", txt_field_sensor_value.getText());
        button.putClientProperty("table", txt_field_sensor_value.getText());
        button.putClientProperty("model", model);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((DefaultTableModel)((JButton)e.getSource()).getClientProperty("model")).addRow(new Object[]{1, 2, 3});
            }
        });
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(
                    layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(
                            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(
                                    layout.createSequentialGroup()
                                        .addGroup(
                                            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(label_sensor_name, 181, 181, 181)
                                                .addComponent(txt_field_sensor_name, 181, 181, 181)
                                                .addComponent(label_sensor_id, 181, 181, 181)
                                                .addComponent(txt_field_sensor_id, 181, 181, 181)
                                                .addComponent(label_sensor_value, 181, 181, 181)
                                                .addComponent(txt_field_sensor_value)
                                                .addComponent(button)
                                        )
                                        .addGap(40, 40, 40)
                                )
                        )
                )
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createBaselineGroup(true, true)
                                .addGap(70, 70, 70)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(10)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(label_sensor_name, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_field_sensor_name, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(label_sensor_id, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_field_sensor_id, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(label_sensor_value, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_field_sensor_value, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(10)
                                        .addComponent(button, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(10)
                                )
                        )
        );
        frame.pack();
        frame.setVisible(true);
    }

    private void preferencesFrame() {
        JFrame frame = new JFrame("Adicionar sensor");
        frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("Sensor name");
        model.addColumn("Sensor id");
        model.addColumn("Value");
        JButton button = new JButton("Adicionar sensor");
        button.putClientProperty("model", model);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSensorFrame("", "", (DefaultTableModel)((JButton)e.getSource()).getClientProperty("model"));
            }
        });
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(
                                                                layout.createParallelGroup()
                                                                        .addComponent(table.getTableHeader())
                                                                        .addComponent(table, 300, 300, 300)
                                                                        .addGap(10, 10, 10)
                                                        )
                                                        .addGroup(
                                                                layout.createSequentialGroup()
                                                                        .addGroup(
                                                                                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                                                                        .addComponent(button, 250, 250, 250)
                                                                        )
                                                        )
                                        )
                        )
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(button, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50 ,50)
                                            .addComponent(table.getTableHeader())
                                            .addComponent(table, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                                )
                                .addContainerGap(84, Short.MAX_VALUE))
        );
        frame.pack();
        frame.setVisible(true);
    }

    private void cmbbox_portsActionPerformed(ActionEvent evt) {//GEN-FIRST:event_cmbbox_portsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbbox_portsActionPerformed

    private void frequencyActionPerformed(ActionEvent evt)
    {
        Float frequency = Float.parseFloat(frequency_text.getSelectedItem().toString());
        Float millisecond = 1000 / frequency;
        String buffer = "@" + millisecond.intValue() + ";OK";
        if (port != null && port.isOpen()) {
            port.writeBytes(buffer.getBytes(), buffer.getBytes().length);
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    clearChart();
                }
                catch (Exception e){
                    clearChart();
                    System.err.println(e);
                }
            }).start();
        }
    }

    private void btn_conectarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btn_conectarActionPerformed
        // TODO add your handling code here:

        if(btn_conectar.getText().equals("Conectar")){
            //DEBUG
            System.out.println("Botão Ok");
            //DEBUG
            port = SerialPort.getCommPort(cmbbox_ports.getSelectedItem().toString());
            port.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
            port.setBaudRate(Integer.parseInt(cmbbox_baudrate.getSelectedItem().toString()));

            try {
                beta15 = getFieldValue(txtField_beta_sensor15, "Beta do sensor 15", Double.MIN_VALUE, Double.MAX_VALUE);
                initialRes15 = getFieldValue(txtField_initialResistence_sensor15, "Resistência inicial do sensor 15", Double.MIN_VALUE, Double.MAX_VALUE);
                initialTemp = getFieldValue(txtField_initialTemperature_sensor, "Temperatura inicial", Double.MIN_VALUE, Double.MAX_VALUE);
                beta25 = getFieldValue(txtField_beta_sensor25, "Beta do sensor 25", Double.MIN_VALUE, Double.MAX_VALUE);
                initialRes25 = getFieldValue(txtField_initialResistence_sensor25, "Resistência inicial do sensor 25", Double.MIN_VALUE, Double.MAX_VALUE);
                beta35 = getFieldValue(txtField_beta_sensor35, "Beta do sensor 35", Double.MIN_VALUE, Double.MAX_VALUE);
                initialRes35 = getFieldValue(txtField_initialResistence_sensor35, "Resistência inicial do sensor 35", Double.MIN_VALUE, Double.MAX_VALUE);
                inputVoltage = getFieldValue(txtField_initial_voltage, "Tensão de entrada", Double.MIN_VALUE, Double.MAX_VALUE);
            } catch (Exception e) {
                return;
            }

            if(port.openPort()){
                btn_conectar.setText("Desconectar");
                cmbbox_ports.setEnabled(false);
                cmbbox_baudrate.setEnabled(false);
                txtField_initialTemperature_sensor.setEnabled(false);
                txtField_initial_voltage.setEnabled(false);
                txtField_initialResistence_sensor15.setEnabled(false);
                txtField_initialResistence_sensor25.setEnabled(false);
                txtField_initialResistence_sensor35.setEnabled(false);
                txtField_beta_sensor15.setEnabled(false);
                txtField_beta_sensor25.setEnabled(false);
                txtField_beta_sensor35.setEnabled(false);
                frequency_text.setEnabled(true);
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
                        try{
                            String[] reads = line.split(";");
                            Double sensor15Read = getDoubleValueFromString(reads[0]);
                            Double sensor25Read = getDoubleValueFromString(reads[1]);
                            Double sensor35Read = getDoubleValueFromString(reads[2]);
                            Double value15 = convertKelvinToCelsius(getTemperature(getResistance(inputVoltage*1000.0, sensor15Read, 20000.0), beta15, initialRes15, convertCelsiusToKelvin(initialTemp)));
                            Double value25 = convertKelvinToCelsius(getTemperature(getResistance(inputVoltage*1000.0, sensor25Read, 20000.0), beta25, initialRes25, convertCelsiusToKelvin(initialTemp)));
                            Double value35 = convertKelvinToCelsius(getTemperature(getResistance(inputVoltage*1000.0, sensor35Read, 20000.0), beta35, initialRes35, convertCelsiusToKelvin(initialTemp)));
                            series15.add(x, value15);
                            series25.add(x, value25);
                            series35.add(x++, value35);
                            renderer.setSeriesVisible(0, chkbox_sensor15.isSelected());
                            renderer.setSeriesVisible(1, chkbox_sensor25.isSelected());
                            renderer.setSeriesVisible(2, chkbox_sensor35.isSelected());
                            } catch(Exception e){
                                System.out.println("Read from serial: " + line);
                                e.printStackTrace();
                            }
                     } catch(Exception ignored) {}
				}
                scanner.close();
                        }

            };
            thread.start();
            } else{
                port.closePort();
                cmbbox_ports.setEnabled(true);
                cmbbox_baudrate.setEnabled(true);
                frequency_text.setEnabled(false);
                txtField_initialTemperature_sensor.setEnabled(true);
                txtField_initial_voltage.setEnabled(true);
                txtField_initialResistence_sensor15.setEnabled(true);
                txtField_initialResistence_sensor25.setEnabled(true);
                txtField_initialResistence_sensor35.setEnabled(true);
                txtField_beta_sensor15.setEnabled(true);
                txtField_beta_sensor25.setEnabled(true);
                txtField_beta_sensor35.setEnabled(true);
                btn_conectar.setText("Conectar");
                clearChart();
            }

    }//GEN-LAST:event_btn_conectarActionPerformed

    private Double getResistance(Double inputVoltage, Double outputVoltage, Double initialResistance)
    {
        return (initialResistance * (outputVoltage/inputVoltage)) / ((-outputVoltage/inputVoltage) + 1);
    }

    private double getFieldValue(JTextField field, String description, Double minValue, Double maxValue) throws Exception {
        try {
            Double value = getDoubleValueFromString(field.getText());
            if (value < minValue) {
                JOptionPane.showMessageDialog(field, description + " deve ser menor que " + minValue.toString(), "Erro!", JOptionPane.WARNING_MESSAGE);
                throw new Exception();
            }
            if (value > maxValue) {
                JOptionPane.showMessageDialog(field, description + " deve ser maior que " + maxValue.toString(), "Erro!", JOptionPane.WARNING_MESSAGE);
                throw new Exception();
            }
            return value;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(field, description + " deve ser um número.", "Erro!", JOptionPane.WARNING_MESSAGE);
        }
        throw new Exception();
    }

    private double getDoubleValueFromString(String stringValue) throws Exception {
        return Double.parseDouble(stringValue);
    }

    private double getTemperature(double resistance, double beta, double initialResistance, double initialTemperature)
    {
        return Math.pow((1/initialTemperature) + (1/beta)*(Math.log(resistance/initialResistance)), -1);
    }

    private double convertKelvinToCelsius(double kelvin)
    {
        return kelvin - 273.15F;
    }

    private double convertCelsiusToKelvin(double celsius)
    {
        return celsius + 273.15F;
    }

    private void clearChart()
    {
        series15.clear();
        series25.clear();
        series35.clear();
        x=0;
    }

    private void chkbox_sensor15ActionPerformed(ActionEvent evt) {
    }
}
