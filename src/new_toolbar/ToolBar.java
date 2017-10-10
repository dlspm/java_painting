/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package new_toolbar;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author angus
 */
public class ToolBar extends Panel{
    ToolBar(EasyPainter ep){ //工具列
        
        this.setBackground(Color.lightGray);
        this.setLayout(new FlowLayout());
        
        Button newPageBtn = new Button("new Page");
        this.add(newPageBtn);
        newPageBtn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                
//                if(ep.numPages < ep.activatePage.pageColors.length){
                if(ep.numPages < 8){
                
                    if (ep.activatePage != null )
                           ep.mainWin.remove(ep.activatePage); //當新增過後時就要先 remove

                    ep.activatePage = new Page();
                    ep.mainWin.add(ep.activatePage, BorderLayout.CENTER);  //在中間
                       //到這裡結束會因為畫面沒有更新導致畫面重疊

//                    System.out.println( ep.activatePage + "\n" + ep.activatePage.pageColors[ep.curPage] + "\n" 
   //                  +          ep.activatePage[]);
//                     );
                    
                    if(ep.numPages == ep.curPage){
    //                    System.out.print(ep.numPages + "|" + ep.activatePage.pageColors[ep.curPage]);
                       
                        ep.numPages++ ;
                        ep.curPage++ ;
                    
                    }else{
                        ep.curPage = ++ep.numPages ;
                        
                    }
                    ep.megBar.updateInfo(ep.curPage, ep.numPages);
                    ep.mainWin.setVisible(true);
                }
            }
        });
        
        
        Button previousPageBtn = new Button("上一頁");
        this.add(previousPageBtn);
        previousPageBtn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
            
                if (ep.curPage > 1){
                    
                    ep.mainWin.remove(ep.activatePage);
                    ep.activatePage.setBackground(ep.activatePage.pageColors[ep.curPage-2]);
                    ep.mainWin.add(ep.activatePage, BorderLayout.CENTER);
                    ep.megBar.updateInfo(--ep.curPage, ep.numPages);
                }
            }
        });
        
        
        Button nextPageBtn = new Button("下一頁");
        this.add(nextPageBtn);
        nextPageBtn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
            
                if (ep.curPage < ep.numPages ){
                    
                    ep.mainWin.remove(ep.activatePage);
                    ep.activatePage.setBackground(ep.activatePage.pageColors[ep.curPage]);
                    ep.mainWin.add(ep.activatePage, BorderLayout.CENTER);
                    ep.megBar.updateInfo(++ep.curPage, ep.numPages);
                    System.out.println(ep.curPage + "|" + ep.numPages);
                }
            }
        });
        
    
    }
}
