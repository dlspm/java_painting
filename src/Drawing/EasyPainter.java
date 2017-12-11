/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;

import java.awt.*;
import java.util.*;
import javax.swing.JFrame;

/**
 *
 * @author angus
 */
public class EasyPainter {
        
    public String Title = "EasyPainter";
    public String version = "0.1";
    public MainWindow mainWin;
    public ToolBar toolBar;
    public MessageBar megBar;
    public Page activePage=null;
    public JPage activeJPage=null;
    public Vector<Page> pages=null;
    
    public int numPages=0;
    public int curPage=0;
    
    
    EasyPainter(){
    
        init();
    }
    
    public void init(){
         
        mainWin = new MainWindow(this);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //關閉語法
        
        
        toolBar = new ToolBar(this);
        mainWin.setToolBar(toolBar);
        
        pages = new Vector<Page>();
        
        megBar = new MessageBar(this);
        mainWin.setMessageBar(megBar);
        
        mainWin.setVisible(true);
        mainWin.validate();
        
    }

}
