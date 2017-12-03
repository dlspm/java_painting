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

public class ToolBar extends Panel{
    
    ToolBar(EasyPainter ep){
        this.setBackground(Color.lightGray);
        this.setLayout(new FlowLayout());
        
        Button newPageBtn = new Button("New Page");
        this.add(newPageBtn);
        newPageBtn.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(ep.activePage!=null)
                {
                    ep.mainWin.remove(ep.activePage);
                }
                
                ep.activePage = new Page();
                ep.pages.add(ep.activePage);
                ep.mainWin.add(ep.activePage, BorderLayout.CENTER);
                //ep.mainWin.setVisible(false);
                ep.mainWin.setVisible(true);
                
                ep.numPages++;
                ep.curPage++;
                ep.megBar.updateInfo(ep.curPage, ep.numPages);
            }
        });
    }
}
