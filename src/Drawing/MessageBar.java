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
public class MessageBar extends Panel {
    Label pageInfo;
    MessageBar(EasyPainter ep)
    {
        this.setLayout(new FlowLayout());
        this.setBackground(Color.lightGray);
        pageInfo = new Label();
        this.updateInfo(ep.curPage, ep.numPages);
//        pageInfo=new Label("[" + ep.curPage + "/" + ep.numPages + "]");
        this.add(pageInfo);
        
    }
    
    void updateInfo(int cp, int np)
    {
        pageInfo.setText("[" + cp + "/" + np + "]");
    }
}
