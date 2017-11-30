/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;

import java.awt.*;
import java.util.*;

/**
 *
 * @author angus
 */
public class EasyPainter {
        
    public String swTitle = "EasyPainter";
    public String version = "0.1";
    public MainWindow mainWin;
    public ToolBar toolBar;
    public Page activePage=null;
    public Vector<Page> pages=null;
    
    EasyPainter(){
    
        init();
    }
    
    public void init(){
         
        mainWin = new MainWindow(this);
        toolBar = new ToolBar(this);
        mainWin.setToolBar(toolBar);
        
        pages = new Vector<Page>();
        
        
        mainWin.setVisible(true);
        
    }

}
