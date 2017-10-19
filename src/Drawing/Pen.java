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
import javax.swing.*;

/**
 *
 * @author angus
 */
public class Pen extends JPanel {
    
    Point lp, cp; //記錄滑鼠位置，要小心如果沒有在 new 之後再使用，就很容易會出錯
    public Vector<Line> pen_lines = null; 
    public Vector<Rect> rects = null;
    public int status = 0;
    
    private boolean selected; 
    Pen(EasyPainter ep){
        init(ep);
    
    }
    
    public void init(EasyPainter ep){
        
        this.setBackground(Color.red);
//        this.setBackground(null);                      // 把背景设置为会  
//        this.setOpaque(false); //背景設為透明，因為這個功能所以使用 JPanel
        
//        this.setLayout(new BorderLayout());
        pen_lines = new Vector<Line>();
        rects = new Vector<Rect>();
        this.setSize(600, 500);
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
                status = 0;
                lp = e.getPoint() ; //第一次
                Pen.this.rects.add( new Rect(lp));
                //每一次都有上一次只有第一次沒有上一次
            }
            public void mouseReleased(MouseEvent e){ //放開
                System.out.println("mouseReleased");
                status = 1;
                cp = e.getPoint() ;
                Pen.this.rects.add( new Rect(cp));
//                this.setLocation(400, 30);
//                ep.size = 0;
            }
            public void mouseClick(MouseEvent e){
                System.out.println("mouseClick");
            }
        });
        
        //拖曳
//        DragObjectListener listener = new DragObjectListener();
//        this.addMouseListener(listener);
//        this.addMouseMotionListener(listener);
    }
    
    public void setSelected(boolean flag){
        selected = flag;
        System.out.println(flag);
    }
    
    public void paint(Graphics g){  //記錄Line
        if(status == 1){
            this.setSize(lp.x-cp.x, lp.y-cp.y);
        }
        for(int i=0;i<Pen.this.pen_lines.size();i++){
            Line l = this.pen_lines.elementAt(i);
            g.drawLine(l.sp.x, l.sp.y, l.ep.x, l.ep.y);
        }
    }
    public void Clean(){
        System.out.println("Page_Clean");
        rects.clear();
        repaint();
    }
}
