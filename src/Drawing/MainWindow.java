/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;

import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author angus
 */
public class MainWindow extends Frame{  //用extends 去繼承 Frame
    //呈現視窗裡面的一些內容(功能表)
    
    MainWindow(EasyPainter ep){
            
            
            this.setLocation(400, 30);
            this.setSize(600, 500);
            this.setBackground(Color.black);
            this.setTitle(ep.swTitle + " version " + ep.version);
            
            this.setLayout(new BorderLayout()); //可有可無
            

            //關閉的語法
            this.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    System.exit(0);
                }

            });
                  

    }
}