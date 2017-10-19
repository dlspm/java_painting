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
    public MessageBar megBar;
    
    
    
    public int numPages = 0; // 存放總 Page 頁
    public int curPage = 0;  // 當前 Page 頁
    
    public Page activatePage = null ; //判斷是否有新增 Page
    public Pen pen = null;
    public Square react = null;
    
    public Vector<Page> pages = null; 
    public Vector<Pen> pens = null; 
    public Vector<Square> reacts = null; 
//    public ArrayList colorpage = new ArrayList();

    public Line size;
    
    
    EasyPainter(){
    
        init();
    }
    
    public void init(){
        pages = new Vector<Page>();
        pens = new Vector<Pen>() ;
        reacts = new Vector<Square>();
        
        mainWin = new MainWindow(this);
        
        toolBar = new ToolBar(this);
        mainWin.setToolBar(toolBar); //把ToolBar 加到         
        
        // 畫面更新
        megBar = new MessageBar(this); 
        mainWin.setMessageBar(megBar);        
                
        mainWin.setVisible(true);
        
    }

}
