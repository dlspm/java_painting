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

import javax.swing.*;
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
        this.addMouseMotionListener(new MouseAdapter(){ //針對滑鼠移動軌跡監聽
            public void mouseDragged(MouseEvent e){ //移動軌跡
                System.out.println("mouse");
                cp = e.getPoint() ; //當下位置
                
                //先取得一個繪圖的裝置
                Graphics g = Page.this.getGraphics(); 
                
                g.drawLine(lp.x, lp.y, cp.x, cp.y); //畫線
//                Page.this.lines.add( new Line(lp, cp));
                lp = cp;
            }
        }); 
        
        this.addMouseListener(new MouseAdapter(){ //針對各式各樣的滑鼠動作
            public void mousePressed(MouseEvent e){ //點
                System.out.println("mousePressed");
                lp = e.getPoint() ; //第一次
                
                //每一次都有上一次只有第一次沒有上一次
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
        Graphics2D g2 = (Graphics2D)g;
//        g2.setStroke(new BasicStroke(10.0f,CAP_ROUND,JOIN_ROUND));
        g.setColor(Color.red);
        for(int i=0;i<Page.this.lines.size();i++){
            Line l = this.lines.elementAt(i);
            g.drawLine(l.sp.x, l.sp.y, l.ep.x, l.ep.y);
        }
        

    }
     public void paintComponent(Graphics g) {
        super.paint(g);
        for(int i=0;i<Page.this.lines.size()-1;i++){
            Line l = this.lines.elementAt(i);
            g.drawLine(l.sp.x, l.sp.y, l.ep.x, l.ep.y);
        }
        //paint
    }

}
