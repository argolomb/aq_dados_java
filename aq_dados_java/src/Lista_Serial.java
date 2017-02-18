/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miguel
 */
import com.fazecast.jSerialComm.*;
import java.util.ArrayList;
import java.util.Scanner;



public class Lista_Serial {
    
    public  SerialPort[] lista_serial(){
        
    SerialPort[] portnames=SerialPort.getCommPorts();
        
    for (int i=0; i<portnames.length; i++) {
                        
        System.out.println(portnames[i].getSystemPortName());

        }
    return portnames;
    }
    
}
