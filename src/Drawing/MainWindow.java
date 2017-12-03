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
    
    MainWindow(EasyPainter ep)
    {
        this.setBackground(Color.LIGHT_GRAY);
        this.setSize(600, 500);
        this.setLocation(100, 100);

        this.setTitle(ep.swTitle + " version " + ep.version);

        this.setLayout(new BorderLayout());
       // this.setVisible(true);
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
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