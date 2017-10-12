/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JButton;
/**
 *
 * @author angus
 */
public class ToolBar extends Panel{
    
    Button previousPageBtn = new Button("上一頁");
    
    Button nextPageBtn = new Button("下一頁");
    
    Button newPageBtn = new Button("new Page");
    
        
    Button penBtn = new Button("Pen");
    Button rectBtn = new Button("React");
    Button cleanBtn = new Button("Clean");
    
    
    
    ToolBar(EasyPainter ep){ //工具列
        
        this.setBackground(Color.lightGray);
        this.setLayout(new FlowLayout());
        
        //先把 Button 隱藏是為了在有 newPage 之後在出現
        previousPageBtn.setVisible(false);
        nextPageBtn.setVisible(false);
        newPageBtn.setVisible(false);
        penBtn.setVisible(false);
        cleanBtn.setVisible(false);
        
        
     
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
                cleanBtn.setVisible(true);
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
        //               ep.pen = new Pen();
               ep.activatePage.DrawLine();
           }
        });
        //建立penBtn的ActionListener，用來監聽按下按鈕後。
        penBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 按下按鈕之後執行的動作
                System.out.println("click Pen");
                
            }
        });
        
        this.add(rectBtn);
        rectBtn.addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent e){
               System.out.println("pen_start");
        //               ep.pen = new Pen();
               ep.activatePage.DrawRect();

           }
        });
        
    
        this.add(cleanBtn);
        cleanBtn.addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent e){
               System.out.println("Clean");
               ep.activatePage.Clean();
           }
        });
        cleanBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        
    }
    
    
}
