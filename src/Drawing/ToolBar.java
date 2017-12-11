/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
/**
 *
 * @author angus
 */

public class ToolBar extends JPanel{
    
    ToolBar(EasyPainter ep){
        this.setBackground(Color.lightGray);
        this.setLayout(new FlowLayout());
        
        Button prevPageBtn = new Button("Previous Page");
        this.add(prevPageBtn);
        prevPageBtn.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                
                if(ep.curPage-1 > 0){
                    ep.mainWin.remove(ep.activePage);
                    ep.activePage = ep.pages.elementAt(ep.pages.indexOf(ep.activePage)-1);
                    ep.mainWin.add(ep.activePage);
                    ep.megBar.updateInfo(--ep.curPage, ep.numPages);
                }
                System.out.println(ep.curPage);
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
                System.out.println(ep.curPage);
            }
        });
        
        
        Button penBtn = new Button("Pen");
        this.add(penBtn);
        penBtn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
//                System.out.println("pen tool selected");
                
                if(ep.activePage!=null)
                {
                    ep.activePage.status = Status.Drawing;
                }
                System.out.println(ep.activePage.status);
            }
        });
        
        
        
        
        
        Button creatOBJBtn = new Button("Oval");
        this.add(creatOBJBtn);
        creatOBJBtn.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                
                if(ep.activePage!=null)
                {
                    ep.activePage.status = Status.EllipseOBJ;
                }
                System.out.println(ep.activePage.status);
            }
        });
        
        Button ovalOBJBtn = new Button("React");
        this.add(ovalOBJBtn);
        ovalOBJBtn.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                
                if(ep.activePage!=null)
                {
                    ep.activePage.status = Status.CreatingOBJ;
                }
                System.out.println(ep.activePage.status);
            }
        });
        
        
        
    }

   
}
