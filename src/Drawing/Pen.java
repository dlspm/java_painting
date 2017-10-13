/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;

import java.awt.*; //包含：Panel
import java.awt.event.*;
import java.util.*;
import java.util.Vector;


/**
 *
 * @author angus
 */
public class Pen extends Panel {
    
    Point lp, cp; //記錄滑鼠位置，要小心如果沒有在 new 之後再使用，就很容易會出錯
    public Vector<Line> pen_lines = null; 
    
    Pen(){
        init();
    
    }
    
    public void init(){
        
        this.setBackground(Color.red);
        this.setLayout(new BorderLayout());
        pen_lines = new Vector<Line>();
        this.setSize(300, 300);
//         addMouseMotionListener 專門是滑鼠移動的，回去要看文獻去看監聽什麼事件（mouseDragged）
        this.addMouseMotionListener(new MouseAdapter(){ //針對滑鼠移動軌跡監聽
            public void mouseDragged(MouseEvent e){ //移動軌跡
                System.out.println("mouse");
                cp = e.getPoint() ; //當下位置
                
                //先取得一個繪圖的裝置
                Graphics g = Pen.this.getGraphics(); 
                
                g.drawLine(lp.x, lp.y, cp.x, cp.y); //畫線
                Pen.this.pen_lines.add( new Line(lp, cp));
                lp = cp;
            }
        }); 
        
        this.addMouseListener(new MouseAdapter(){ //針對各式各樣的滑鼠動作
            public void mousePressed(MouseEvent e){ //按下
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
        for(int i=0;i<Pen.this.pen_lines.size();i++){
            Line l = this.pen_lines.elementAt(i);
            g.drawLine(l.sp.x, l.sp.y, l.ep.x, l.ep.y);
        }
    }
    
}
