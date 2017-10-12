/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;
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
        
        Button previousPageBtn = new Button("上一頁");
        previousPageBtn.setVisible(false);
        Button nextPageBtn = new Button("下一頁");
        nextPageBtn.setVisible(false);
        Button newPageBtn = new Button("new Page");
        newPageBtn.setVisible(false);
        
        Button penBtn = new Button("Pen");
        penBtn.setVisible(false);
        
        
        Button startBtn = new Button("Start");
        this.add(startBtn);
        startBtn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
//                previousPageBtn.setVisible(false);
//                nextPageBtn.setVisible(false);
                ep.activatePage = new Page();
                ep.pages.add(ep.activatePage);
                ep.mainWin.add(ep.activatePage, BorderLayout.CENTER);  //在中間
                
                ep.numPages++ ;
                ep.curPage++ ;
                ep.megBar.updateInfo(ep.curPage, ep.numPages);
                startBtn.setVisible(false);
                newPageBtn.setVisible(true);
                penBtn.setVisible(true);
                ep.mainWin.setVisible(true);
            }
        });
        
//        Button newPageBtn = new Button("new Page");
        this.add(newPageBtn);
        newPageBtn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                
//                if(ep.numPages < ep.activatePage.pageColors.length){
                if(ep.numPages < 8){
                
                    if (ep.curPage == 1){
                        previousPageBtn.setVisible(true);
//                        nextPageBtn.setVisible(true);
                    }
                    
                    if (ep.activatePage != null )
                           ep.mainWin.remove(ep.activatePage); //當新增過後時就要先 remove

                    ep.activatePage = new Page();
                    ep.pages.add(ep.activatePage);
                    ep.mainWin.add(ep.activatePage, BorderLayout.CENTER);  //在中間
                       //到這裡結束會因為畫面沒有更新導致畫面重疊

                    if(ep.numPages == ep.curPage){
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
        
        
//        Button previousPageBtn = new Button("上一頁");
        this.add(previousPageBtn);
        previousPageBtn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
            
                if (ep.curPage > 1){
                    ep.mainWin.remove(ep.activatePage);
                    ep.activatePage = ep.pages.elementAt(ep.pages.indexOf(ep.activatePage)-1);
                    ep.mainWin.add(ep.activatePage, BorderLayout.CENTER);
                    ep.megBar.updateInfo(--ep.curPage, ep.numPages);
                }
                if(ep.curPage == 1){
                    previousPageBtn.setVisible(false);
                }
                if(ep.curPage != ep.numPages){
                    nextPageBtn.setVisible(true);
                }
                ep.mainWin.setVisible(true);
            }
        });
        
        
//        Button nextPageBtn = new Button("下一頁");
        this.add(nextPageBtn);
        nextPageBtn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
            
                if (ep.curPage < ep.numPages ){
                    ep.mainWin.remove(ep.activatePage);
                    ep.activatePage = ep.pages.elementAt(ep.pages.indexOf(ep.activatePage)+1);
                    ep.mainWin.add(ep.activatePage, BorderLayout.CENTER);
                    ep.megBar.updateInfo(++ep.curPage, ep.numPages);
//                    System.out.println(ep.curPage + "|" + ep.numPages);
                }
                if(ep.curPage == ep.numPages){
                    nextPageBtn.setVisible(false);
                }
                if(ep.curPage >1){
                    previousPageBtn.setVisible(true);
                }
                
                ep.mainWin.setVisible(true);
            }
        });
        
        this.add(penBtn);
        penBtn.addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent e){
               System.out.println("pen_start");
                          
               
           }
        });
        
    
    }
}
