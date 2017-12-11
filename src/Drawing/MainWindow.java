/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

/**
 *
 * @author angus
 */
public class MainWindow extends JFrame{  //用extends 去繼承 Frame
    //呈現視窗裡面的一些內容(功能表)
    
    MainWindow(EasyPainter ep)
    {
        this.setBackground(Color.CYAN);
        this.setSize(600, 500);
        this.setLocation(100, 100);

        this.setTitle(ep.Title + " version " + ep.version);

        this.setLayout(new BorderLayout());
       // this.setVisible(true);

    }
    
    
    void setToolBar(ToolBar tb)
    {
        this.add(tb,BorderLayout.NORTH);
    }
    void setMessageBar(MessageBar mb)
    {
        this.add(mb, BorderLayout.SOUTH);
    }
    
}