/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;

import java.awt.*; 
import java.awt.event.*;



//Label在awt裡面

/**
 *
 * @author angus
 */
public class MessageBar extends Panel{
    Label pageInfo = new Label();  //因為updateInfo也要用
    
    MessageBar(EasyPainter ep){
        this.setLayout(new FlowLayout());
        this.setBackground(Color.lightGray);
        
        this.updateInfo(ep.curPage, ep.numPages); //更新訊息框的 page 數
        this.add(pageInfo);
                
    }
    
    void updateInfo(int cp, int np){  // 只要按一次就要更新
        pageInfo.setText("[" + cp + "/" + np + "]");
    
    }
       
}
