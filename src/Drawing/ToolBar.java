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
        
        
        Button prevPageBtn = new Button("Previous Page");
        this.add(prevPageBtn);
        prevPageBtn.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                System.out.println(ep.curPage);
                if(ep.curPage-1 > 0){
                    ep.mainWin.remove(ep.activePage);
                    ep.activePage = ep.pages.elementAt(ep.pages.indexOf(ep.activePage)-1);
                    ep.mainWin.add(ep.activePage);
                    ep.megBar.updateInfo(--ep.curPage, ep.numPages);
                }
            }
        });
        
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
                ep.mainWin.setVisible(true);
                ep.curPage = ++ep.numPages;// 為了讓每次新增都確保回到最後面
//                ep.numPages++;
//                ep.curPage++;
                ep.megBar.updateInfo(ep.curPage, ep.numPages);
            }
        });
        
        Button nextPageBtn = new Button("Next Page");
        this.add(nextPageBtn);
        nextPageBtn.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(ep.numPages<7 && ep.numPages>0 && ep.curPage < ep.numPages ){
                    ep.mainWin.remove(ep.activePage);
                    ep.activePage = ep.pages.elementAt(ep.pages.indexOf(ep.activePage)+1);
                    ep.mainWin.add(ep.activePage);
                    ep.megBar.updateInfo(++ep.curPage, ep.numPages);
                } 
            }
        });
    }
}
