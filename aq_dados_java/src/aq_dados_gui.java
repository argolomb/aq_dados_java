import com.fazecast.jSerialComm.SerialPort;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.NumberTickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class aq_dados_gui extends javax.swing.JFrame
{
    private static SerialPort port;
    private static XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
    private static XYSeries series0 = new XYSeries(0);
    private static XYSeries series1 = new XYSeries(1);
    private static XYSeries series2 = new XYSeries(2);
    private static XYSeries series3 = new XYSeries(3);
    private static XYSeries series4 = new XYSeries(4);
    private static XYSeries series5 = new XYSeries(5);
    private static XYSeries series6 = new XYSeries(6);
    private static XYSeries series7 = new XYSeries(7);
    private static XYSeries series8 = new XYSeries(8);
    private static XYSeries series9 = new XYSeries(9);
    private static XYSeriesCollection dataset = new XYSeriesCollection();
    private static int x = 0;
    private static javax.swing.JButton btn_conectar;
    private static JCheckBox chkbox_sensor0 = new JCheckBox();
    private static JCheckBox chkbox_sensor1 = new JCheckBox();
    private static JCheckBox chkbox_sensor2 = new JCheckBox();
    private static JCheckBox chkbox_sensor3 = new JCheckBox();
    private static JCheckBox chkbox_sensor4 = new JCheckBox();
    private static JCheckBox chkbox_sensor5 = new JCheckBox();
    private static JCheckBox chkbox_sensor6 = new JCheckBox();
    private static JCheckBox chkbox_sensor7 = new JCheckBox();
    private static JCheckBox chkbox_sensor8 = new JCheckBox();
    private static JCheckBox chkbox_sensor9 = new JCheckBox();
    private List<JCheckBox> checkBoxList = new ArrayList<JCheckBox>();
    private static javax.swing.JComboBox cmbbox_ports;
    private static javax.swing.JComboBox frequency_text;
    private static javax.swing.JPanel jPanel_chart;
    private javax.swing.JComboBox cmbbox_baudrate;
    private int sensorCount = 0;
    private Map<String, List> sensorsConfiguration = new HashMap<String, List>();

    /**
     * Creates new form aq
     */
    public aq_dados_gui() {
        initComponents();
        dataset.addSeries(series0);
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        dataset.addSeries(series4);
        dataset.addSeries(series5);
        dataset.addSeries(series6);
        dataset.addSeries(series7);
        dataset.addSeries(series8);
        dataset.addSeries(series9);
    }

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
        XYPlot plot = chart.getXYPlot();
        renderer.setSeriesPaint( 0 , Color.RED );
        renderer.setSeriesPaint( 1 , Color.BLACK );
        renderer.setSeriesPaint( 2 , Color.BLUE );
        renderer.setSeriesPaint( 3 , Color.CYAN );
        renderer.setSeriesPaint( 4 , Color.GREEN );
        renderer.setSeriesPaint( 5 , Color.MAGENTA );
        renderer.setSeriesPaint( 6 , Color.GRAY );
        renderer.setSeriesPaint( 7 , Color.YELLOW );
        renderer.setSeriesPaint( 8 , Color.PINK );
        renderer.setSeriesPaint( 9 , Color.ORANGE );
        for (int i = 0; i < 10; i++) {
            renderer.setSeriesStroke( i , new BasicStroke( 1.5f ) );
            renderer.setSeriesShapesVisible(i, false);
        }
        plot.setDomainPannable(true);
        plot.setRangePannable(true);
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);
        plot.setRenderer(renderer);
        NumberAxis axis = (NumberAxis) plot.getDomainAxis();
        axis.setFixedAutoRange(60);
        axis.setTickUnit(new NumberTickUnit(20));
        jPanel_chart.add(new ChartPanel(chart));
        jPanel_chart.repaint();
        jPanel_chart.setVisible(true);
    }

    private void initComponents()
    {
        cmbbox_ports = new javax.swing.JComboBox();
        frequency_text = new javax.swing.JComboBox();
        btn_conectar = new javax.swing.JButton();
        cmbbox_baudrate = new javax.swing.JComboBox();
        jPanel_chart = new javax.swing.JPanel();
        checkBoxList.add(chkbox_sensor0);
        checkBoxList.add(chkbox_sensor1);
        checkBoxList.add(chkbox_sensor2);
        checkBoxList.add(chkbox_sensor3);
        checkBoxList.add(chkbox_sensor4);
        checkBoxList.add(chkbox_sensor5);
        checkBoxList.add(chkbox_sensor6);
        checkBoxList.add(chkbox_sensor7);
        checkBoxList.add(chkbox_sensor8);
        checkBoxList.add(chkbox_sensor9);
        for (JCheckBox chbox : checkBoxList) {
            chbox.setEnabled(false);
            chbox.setVisible(false);
        }
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JMenuBar menuBar = new JMenuBar();
        JMenu menuSettings = new JMenu("Iniciar");
        JMenu initializeMenu = new JMenu("Configurações");
        JMenuItem serialMenuItem = new JMenuItem("Serial");
        JMenuItem sensorsMenuItem = new JMenuItem("Sensores");
        JMenuItem connectMenuItem = new JMenuItem("Conectar");
        JMenuItem disconnectMenuItem = new JMenuItem("Desconectar");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bancada para Controle de Fluxo de Calor");

        setJMenuBar(menuBar);
        menuBar.add(menuSettings);
        menuSettings.add(connectMenuItem);
        menuSettings.add(disconnectMenuItem);
        menuSettings.add(initializeMenu);
        initializeMenu.add(serialMenuItem);
        initializeMenu.add(sensorsMenuItem);

        sensorsMenuItem.putClientProperty("frame", createSensorsFrame());
        sensorsMenuItem.addActionListener(e -> {
            JFrame frame = (JFrame)((JMenuItem)e.getSource()).getClientProperty("frame");
            frame.setVisible(true);
        });

        serialMenuItem.putClientProperty("frame", createSerialFrame());
        serialMenuItem.addActionListener(e -> {
            JFrame frame = (JFrame)((JMenuItem)e.getSource()).getClientProperty("frame");
            frame.setVisible(true);
        });

        connectMenuItem.putClientProperty("disconnect", disconnectMenuItem);
        connectMenuItem.addActionListener(this::btn_conectarActionPerformed);
        disconnectMenuItem.putClientProperty("connect", connectMenuItem);
        disconnectMenuItem.addActionListener(this::btn_desconectarActionPerformed);
        disconnectMenuItem.setEnabled(false);

        cmbbox_ports.setModel(new DefaultComboBoxModel());
        cmbbox_ports.addActionListener(this::cmbbox_portsActionPerformed);
        frequency_text.setModel(new DefaultComboBoxModel(new String[] {"0.5", "1", "2", "5", "10"}));
        frequency_text.setSelectedItem("10");
        frequency_text.setEnabled(false);
        frequency_text.addActionListener(this::frequencyActionPerformed);
        btn_conectar.setText("Conectar");
        btn_conectar.addActionListener(this::btn_conectarActionPerformed);
        cmbbox_baudrate.setModel(new DefaultComboBoxModel(new String[] { "9600", "14400", "19200", "28800", "38400", "57600", "115200" }));
        cmbbox_baudrate.setSelectedItem("115200");
        jPanel_chart.setBackground(new java.awt.Color(254, 254, 254));
        jPanel_chart.setLayout(new javax.swing.BoxLayout(jPanel_chart, javax.swing.BoxLayout.LINE_AXIS));
        jLabel1.setText("Selecionar Porta Serial");
        jLabel2.setText("Selecionar Baudrate");
        jLabel3.setText("Exibir no Gráfico:");
        jLabel4.setText("Frequência (Hz):");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(1023, Short.MAX_VALUE)
                    )
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(frequency_text, 181, 181, 181)
                            .addComponent(chkbox_sensor0)
                            .addComponent(chkbox_sensor1)
                            .addComponent(chkbox_sensor2)
                            .addComponent(chkbox_sensor3)
                            .addComponent(chkbox_sensor4)
                            .addComponent(chkbox_sensor5)
                            .addComponent(chkbox_sensor6)
                            .addComponent(chkbox_sensor7)
                            .addComponent(chkbox_sensor8)
                            .addComponent(chkbox_sensor9)
                            .addComponent(jLabel4)
                        )
                        .addGap(18, 18, 18)
                        .addComponent(jPanel_chart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28))))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel_chart, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addComponent(frequency_text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(chkbox_sensor0)
                        .addComponent(chkbox_sensor1)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(chkbox_sensor2)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(chkbox_sensor3)
                        .addComponent(chkbox_sensor4)
                        .addComponent(chkbox_sensor5)
                        .addComponent(chkbox_sensor6)
                        .addComponent(chkbox_sensor7)
                        .addComponent(chkbox_sensor8)
                        .addComponent(chkbox_sensor9)

                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openSensorFrame(String name, String id, String value, DefaultTableModel model, JTable table)
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
        txt_field_sensor_id.setText(id);
        txt_field_sensor_id.setEnabled(false);
        txt_field_sensor_value.setText(value);
        button.setText("Adicionar");
        button.putClientProperty("name", txt_field_sensor_name);
        button.putClientProperty("id", txt_field_sensor_id);
        button.putClientProperty("value", txt_field_sensor_value);
        button.putClientProperty("table", table);
        button.putClientProperty("model", model);
        button.putClientProperty("frame", frame);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                String name = ((JTextField)(button).getClientProperty("name")).getText();
                String id = ((JTextField)(button).getClientProperty("id")).getText();
                String value = ((JTextField)(button).getClientProperty("value")).getText();
                DefaultTableModel model = ((DefaultTableModel)(button).getClientProperty("model"));
                JTable table = ((JTable)(button).getClientProperty("table"));
                JFrame frame = ((JFrame)(button).getClientProperty("frame"));
                if (button.getText().equals("Adicionar")) {
                    model.addRow(new Object[]{name, id, value, "Editar "+id});
                    ArrayList<String> list = new ArrayList<String>();
                    list.add(name);
                    list.add(value);
                    sensorsConfiguration.put(id, list);
                    String[] getRow = id.split("s");
                    table.putClientProperty("frame-"+getRow[1], frame);
                    Action edit = new AbstractAction()
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            JTable table = (JTable)e.getSource();
                            String row = e.getActionCommand();
                            table.putClientProperty("activeIndex", row);
                            ((JFrame)(table).getClientProperty("frame-"+row)).setVisible(true);
                        }
                    };
                    ButtonColumn button_edit = new ButtonColumn(table, edit, 3);
                    button.setText("Editar");
                    sensorCount++;
                } else {
                    String stringRow = (String)table.getClientProperty("activeIndex");
                    ArrayList<String> list = new ArrayList<String>();
                    list.add(name);
                    list.add(value);
                    sensorsConfiguration.replace("s"+stringRow, list);
                    int row = Integer.valueOf(stringRow);
                    model.setValueAt(name, row,0);
                    model.setValueAt(value, row,2);
                }
                frame.setVisible(false);
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

    private JFrame createSerialFrame()
    {
        JFrame frame = new JFrame("Configurar serial");
        frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        jLabel1.setText("Selecionar Porta Serial");
        jLabel2.setText("Selecionar Baudrate");
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                        )
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(cmbbox_baudrate, 0, 181, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(cmbbox_ports, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            )
                            .addGap(28, 28, 28)
                        )
                    )
                )
        );
        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, cmbbox_baudrate, cmbbox_ports);
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(cmbbox_ports, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(cmbbox_baudrate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)
                                        )
                                )
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        frame.pack();
        return frame;
    }

    private JFrame createSensorsFrame() {
        JFrame frame = new JFrame("Tabela de sensores");
        frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3;
            }
        };
        JTable table = new JTable(model);
        model.addColumn("Sensor name");
        model.addColumn("Sensor id");
        model.addColumn("Value");
        model.addColumn("Ações");
        JButton button = new JButton("Adicionar sensor");
        button.putClientProperty("model", model);
        button.putClientProperty("table", table);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSensorFrame(
                        "",
                        "s" + String.valueOf(sensorCount),
                        "",
                        (DefaultTableModel)((JButton)e.getSource()).getClientProperty("model"),
                        (JTable)((JButton)e.getSource()).getClientProperty("table")
                );
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
                                                                        .addComponent(table)
                                                                        .addGap(1000, 1000, 1000)
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
                    .addContainerGap(10, Short.MAX_VALUE)
                )
        );
        frame.pack();
        return frame;
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

    private void btn_desconectarActionPerformed(ActionEvent evt)
    {
        port.closePort();
        cmbbox_ports.setEnabled(true);
        cmbbox_baudrate.setEnabled(true);
        frequency_text.setEnabled(false);
        ((JMenuItem)(evt.getSource())).setEnabled(false);
        ((JMenuItem)((JMenuItem)(evt.getSource())).getClientProperty("connect")).setEnabled(true);
        clearChart();
    }

    private void btn_conectarActionPerformed(ActionEvent evt) {
        port = SerialPort.getCommPort(cmbbox_ports.getSelectedItem().toString());
        port.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        port.setBaudRate(Integer.parseInt(cmbbox_baudrate.getSelectedItem().toString()));
        if(port.openPort()){
            ((JMenuItem)((JMenuItem)(evt.getSource())).getClientProperty("disconnect")).setEnabled(true);
            ((JMenuItem)(evt.getSource())).setEnabled(false);
            cmbbox_ports.setEnabled(false);
            cmbbox_baudrate.setEnabled(false);
            frequency_text.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Não foi possível conectar na porta serial.", "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(aq_dados_gui.class.getName()).log(Level.SEVERE, null, ex);
        }
        Thread thread =new Thread(){
        @Override

        public void run(){
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            Integer lastIndex = -1;
            for (String id : sensorsConfiguration.keySet()) {
                String[] getIndex = id.split("s");
                Integer index = Integer.valueOf(getIndex[1]);
                List list = sensorsConfiguration.get(id);
                String name = (String)list.get(0);
                checkBoxList.get(index).setVisible(true);
                checkBoxList.get(index).setEnabled(true);
                checkBoxList.get(index).setText(name);
                if (index > lastIndex) {
                    lastIndex = index;
                }
            }
            for (int i = lastIndex+1; i < 10; i++) {
                checkBoxList.get(i).setVisible(false);
                checkBoxList.get(i).setEnabled(false);
                checkBoxList.get(i).setText("");
            }
            Scanner scanner = new Scanner(port.getInputStream());
            while(scanner.hasNext()) {
                try {
                    String line = scanner.nextLine();
                    try{
                        String[] reads = line.split(";");
                        HashMap<Integer, List> seriesMap = new HashMap<Integer, List>();
                        for (int i = 0; i < reads.length; i++) {
                            Double rawValue = Double.valueOf(reads[i]);
                            String expression = "0.0";
                            if (sensorsConfiguration.containsKey("s"+String.valueOf(i))) {
                                String helpExpression = expression = (String)sensorsConfiguration.get("s"+String.valueOf(i)).get(1);
                                Pattern pattern = Pattern.compile("s\\d+", Pattern.MULTILINE);
                                Matcher matcher = pattern.matcher(helpExpression);
                                while (matcher.find()) {
                                    String sensorId = helpExpression.subSequence(matcher.start(), matcher.end()).toString();
                                    String[] getIndex = sensorId.split("s");
                                    expression = expression.replaceAll(sensorId, String.valueOf(reads[Integer.valueOf(getIndex[1])]));
                                }
                            }
                            Double parsedValue = 0.0;
                            try {
                                parsedValue = Double.valueOf(String.valueOf(engine.eval(expression)));
                            } catch (ScriptException ignored) {}
                            List<Double> seriesList = new ArrayList<Double>();
                            seriesList.add(rawValue);
                            seriesList.add(parsedValue);
                            seriesMap.put(i, seriesList);
                        }
                        for (Integer index : seriesMap.keySet()) {
                            List list = seriesMap.get(index);
                            dataset.getSeries(index).add(x, (Double)list.get(1));
                            renderer.setSeriesVisible(index, checkBoxList.get(index).isSelected());
                        }
                        x++;
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
    }

    private void clearChart()
    {
        series0.clear();
        series1.clear();
        series2.clear();
        series3.clear();
        series4.clear();
        series5.clear();
        series6.clear();
        series7.clear();
        series8.clear();
        series9.clear();
        x=0;
    }
}

//((Math.pow((1/(initialTemperature + 273.15)) + (1/beta)*(Math.log((initialResistance * (outputVoltage/inputVoltage)) / ((-outputVoltage/inputVoltage) + 1)/initialResistance)), -1)) - 273.15)
//((Math.pow((1/(29 + 273.15)) + (1/4607.3)*(Math.log((6440 * (s0/5110)) / ((-s0/5110) + 1)/6440)), -1)) - 273.15)