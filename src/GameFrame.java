import jssc.SerialPort;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{

    GamePanel panel;
    GameFrame(SerialPort serialPort){
        panel = new GamePanel(serialPort);
        this.add(panel);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}