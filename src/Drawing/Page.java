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
    Point lp, cp, z; //記錄滑鼠位置，要小心如果沒有在 new 之後再使用，就很容易會出錯
//    Point x, y;
    public int width, height;
    
    
    public Vector<Line> lines = null;
    public Vector<Rect> rects = null;
    
    
    Page(){
        init();
    }
    
    public void init(){
        this.setBackground(pageColors[id++]); // 讓每個 Page 新增後的 Background 都依照 pageColors[]
        lines = new Vector<Line>();
        rects = new Vector<Rect>();
        //         addMouseMotionListener 專門是滑鼠移動的，回去要看文獻去看監聽什麼事件（mouseDragged）
    }
    
    public void DrawLine(){
            
        this.addMouseMotionListener(new MouseAdapter(){ //針對滑鼠移動軌跡監聽
            public void mouseDragged(MouseEvent e){ //移動軌跡
                System.out.println("x: " + e.getX() + ", y: " + e.getY());
                cp = e.getPoint() ; //當下位置
                
                //先取得一個繪圖的裝置
                Graphics g = Page.this.getGraphics(); 
                
                g.drawLine(lp.x, lp.y, cp.x, cp.y); //畫線
                Page.this.lines.add( new Line(lp, cp)); 
                //把 g.drawLine(lp.x, lp.y, cp.x, cp.y); 的線畫到 lines 已便記錄到 Vector
                
                lp = cp; //每一次都有上一次（除了第一次外）不然 lp 會固定住
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
                
                System.out.println("x: " + e.getX() + ", y: " + e.getY());
                cp = e.getPoint() ; //當下位置
                
                //先取得一個繪圖的裝置
                Graphics g = Page.this.getGraphics(); 
                
                // 繪畫舉行，需要先計算 width, height.
                // width 只需要把 cp.x - lp.x 即可知道寬度
                // height 只需要把 cp.y - lp.y 即可知道高度

                width = Math.abs(lp.x - cp.x);
                height = Math.abs(lp.y - cp.y);
//                g.drawRect(lp.x, lp.y, width, height); //右下
//                g.drawRect(lp.x, lp.y-height , width, height); //右上
//                g.drawRect(lp.x-width, lp.y, width, height); //左下
//                g.drawRect(lp.x-width, lp.y-height , width, height); //左上
                System.out.println("draw" + lp.x + "+" + lp.y + "+" + width + "+" + height);  

//                Page.this.lines.add( new Line(lp, cp));                 
                repaint(); //沒有repaint() 會重疊
                
            }
        }); 
        
        this.addMouseListener(new MouseAdapter(){ //針對各式各樣的滑鼠動作
            public void mousePressed(MouseEvent e){ //按下
                // 要先記錄第一點的座標，之後再透過 mouseDragged 繪畫出與拖曳過每一點來畫出 drawRect
                
                System.out.println("mousePressed");
                lp = e.getPoint() ; //第一次
//                Page.this.rects.add( new Line(lp, width, height));
                Page.this.rects.add( new Rect(lp));
                
            }
            public void mouseReleased(MouseEvent e){ //放開
                System.out.println("mouseReleased");
                Graphics g = Page.this.getGraphics(); 
                
                cp = e.getPoint();
//                width = Math.abs(lp.x - cp.x);
//                height = Math.abs(lp.y - cp.y);

//                Page.this.rects.add( new Rect(lp, width, height)); 
                Page.this.rects.add( new Rect(cp)); 
                repaint();
            }
            public void mouseClick(MouseEvent e){
                System.out.println("mouseClick");
            }
        }); 
    }
    
    public void paint(Graphics g){  //記錄Line
        super.paint(g);
        
//        for(int i=0;i<Page.this.lines.size();i++){
//            Line l = this.lines.elementAt(i);
//            g.drawLine(l.sp.x, l.sp.y, l.ep.x, l.ep.y);
//        }
        
        for(int i=0;i<Page.this.rects.size()-1;i+=2){
            
//            g.drawRect(l.xy.x , l.xy.y, width, height);   
            width = Math.abs(rects.get(i+1).xy.x - rects.get(i).xy.x);
            height = Math.abs(rects.get(i+1).xy.y - rects.get(i).xy.y);
            g.drawRect(rects.get(i).xy.x, rects.get(i).xy.y, width, height);
//            System.out.println("ppaint" + l.sp.x + "+" + l.sp.y + "+" + Math.abs(l.sp.x - l.ep.x) + "+" + Math.abs(l.sp.y - l.ep.y));
        }if(rects.size()>=1){
            width = Math.abs(cp.x - rects.get(rects.size()-1).xy.x);
            height = Math.abs(cp.y - rects.get(rects.size()-1).xy.y);
            g.drawRect(rects.get(rects.size()-1).xy.x, rects.get(rects.size()-1).xy.y, width, height);
        }
    }
    

    public void Clean(){
        System.out.println("Page_Clean");
        lines.clear();
        rects.clear();
        repaint();
    }
}