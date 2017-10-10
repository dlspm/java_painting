/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package new_toolbar;

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
    
    public int numPages = 1; // 存放總 Page 頁
    public int curPage = 1;  // 當前 Page 頁
    
    public Page activatePage = null ; //判斷是否有新增 Page
//    public Page pages = null; //不知道要幹麻
    
    public ArrayList colorpage = new ArrayList();
    
    EasyPainter(){
        
        mainWin = new MainWindow(this);
        
        toolBar = new ToolBar(this);
        mainWin.setToolBar(toolBar); //把ToolBar 加到         
        
        // 畫面更新
        megBar = new MessageBar(this); 
        mainWin.setMessageBar(megBar);        
                
        mainWin.setVisible(true);
        
    }

    Object activatePage(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
