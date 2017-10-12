/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Vector;


/**
 *
 * @author angus
 */
public class Page extends Panel{
    
    // 建立一個顏色的陣列
    public Color pageColors[] = {Color.BLACK, Color.white, Color.CYAN, Color.darkGray, Color.BLUE, Color.pink, Color.GRAY, Color.ORANGE};
    public static int id = 0; //定義一個 常數 id
    Point lp, cp; //記錄滑鼠位置，要小心如果沒有在 new 之後再使用，就很容易會出錯
    public Vector<Line> lines = null; 
    
    Page(){
        
        this.setBackground(pageColors[id++]); // 讓每個 Page 新增後的 Background 都依照 pageColors[]
        lines = new Vector<Line>();
//         addMouseMotionListener 專門是滑鼠移動的，回去要看文獻去看監聽什麼事件（mouseDragged）
    }
    
    public void DrawLine(){
            
        this.addMouseMotionListener(new MouseAdapter(){ //針對滑鼠移動軌跡監聽
            public void mouseDragged(MouseEvent e){ //移動軌跡
                System.out.println("mouse");
                cp = e.getPoint() ; //當下位置
                
                //先取得一個繪圖的裝置
                Graphics g = Page.this.getGraphics(); 
                
                g.drawLine(lp.x, lp.y, cp.x, cp.y); //畫線
                Page.this.lines.add( new Line(lp, cp)); 
                //把 g.drawLine(lp.x, lp.y, cp.x, cp.y); 的線畫到 lines 已便記錄到 Vector
                
                lp = cp; //每一次都有上一次（除了第一次外）
            }
        }); 
        
        this.addMouseListener(new MouseAdapter(){ //針對各式各樣的滑鼠動作
            public void mousePressed(MouseEvent e){ //按下
                System.out.println("mousePressed");
                lp = e.getPoint() ; //第一次
            }
            public void mouseReleased(MouseEvent e){ //放開
                System.out.println("mouseReleased");
                
            }
            public void mouseClick(MouseEvent e){
                System.out.println("mouseClick");
            }
        }); 

    }
    
    public void DrawRect(){
        this.addMouseMotionListener(new MouseAdapter(){ //針對滑鼠移動軌跡監聽
            public void mouseDragged(MouseEvent e){ //移動軌跡
                System.out.println("mouse");
                cp = e.getPoint() ; //當下位置
                
                //先取得一個繪圖的裝置
                Graphics g = Page.this.getGraphics(); 
                
                g.drawLine(lp.x, lp.y, cp.x, cp.y); //畫線
                Page.this.lines.add( new Line(lp, cp)); 
                //把 g.drawLine(lp.x, lp.y, cp.x, cp.y); 的線畫到 lines 已便記錄到 Vector
                
                lp = cp; //每一次都有上一次（除了第一次外）
            }
        }); 
        
        this.addMouseListener(new MouseAdapter(){ //針對各式各樣的滑鼠動作
            public void mousePressed(MouseEvent e){ //按下
                System.out.println("mousePressed");
                lp = e.getPoint() ; //第一次
            }
            public void mouseReleased(MouseEvent e){ //放開
                System.out.println("mouseReleased");
                
            }
            public void mouseClick(MouseEvent e){
                System.out.println("mouseClick");
            }
        }); 
    }
    
    public void paint(Graphics g){  //記錄Line

        for(int i=0;i<Page.this.lines.size();i++){
            Line l = this.lines.elementAt(i);
            g.drawLine(l.sp.x, l.sp.y, l.ep.x, l.ep.y);
        }
        
    }

    public void Clean(){
        System.out.println("Page_Clean");
        lines.clear();
        repaint();
    }
}
