import jssc.SerialPort;
import jssc.SerialPortList;

import javax.swing.*;
import java.awt.*;

public class PongGame {
        public static SerialPort serialPort = null;

        public static void main(String[] args) {
            JFrame startFrame = new JFrame("Настройка COM");
            startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String[] portNames = SerialPortList.getPortNames(); // получаем список портов
            JComboBox<String> comPorts = new JComboBox<>(portNames); // создаем комбобокс с этим списком
            comPorts.setSelectedIndex(-1); // чтоб не было выбрано ничего в комбобоксе
            comPorts.addActionListener(arg -> { // слушатель выбора порта в комбобоксе
                        String choosenPort = comPorts.getItemAt(comPorts.getSelectedIndex()); // получаем название выбранного порта
                        //если serialPort еще не связана с портом или текущий порт не равен выбранному в комбо-боксе
                        if (serialPort == null || !serialPort.getPortName().contains(choosenPort)) {
                            serialPort = new SerialPort(choosenPort); //задаем выбранный порт
                            }});
            JButton button = new JButton("Старт");
            button.addActionListener(e -> {
                if(comPorts.getSelectedIndex() != -1 && serialPort != null) {
                    startFrame.setVisible(false);
                    new GameFrame(serialPort);
                }
            });
            startFrame.add(comPorts, BorderLayout.NORTH);
            startFrame.add(button, BorderLayout.SOUTH);
            startFrame.pack();
            startFrame.setVisible(true);
    }
}