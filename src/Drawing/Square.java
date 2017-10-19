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
public class Square extends JPanel{
    
    Point lp, cp; //記錄滑鼠位置，要小心如果沒有在 new 之後再使用，就很容易會出錯
    public int width, height;
    public Vector<Rect> square = null;
    public int status = 0;
    
    private boolean selected; 
    
    Square(EasyPainter ep){
        init(ep);
        
        //拖曳
//        DragObjectListener listener = new DragObjectListener();
//        this.addMouseListener(listener);
//        this.addMouseMotionListener(listener);
        
    }
    
    public void init(EasyPainter ep){
        this.setBackground(Color.red);
        this.setSize(300,200);
        square = new Vector<Rect>();
        
        this.addMouseMotionListener(new MouseAdapter(){ //針對滑鼠移動軌跡監聽
            public void mouseDragged(MouseEvent e){ //移動軌跡
                System.out.println("mouse");
                
                System.out.println("x: " + e.getX() + ", y: " + e.getY());
                cp = e.getPoint() ; //當下位置
                
                //先取得一個繪圖的裝置
                Graphics g = Square.this.getGraphics(); 
                
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

                repaint(); //沒有repaint() 會重疊
            }
        }); 
        
        this.addMouseListener(new MouseAdapter(){ //針對各式各樣的滑鼠動作
            public void mousePressed(MouseEvent e){ //按下
                // 要先記錄第一點的座標，之後再透過 mouseDragged 繪畫出與拖曳過每一點來畫出 drawRect
                System.out.println("mousePressed");
                status = 0;
                lp = e.getPoint() ; //第一次
                //1.
//                Page.this.rects.add( new Rect(lp,lp)); //要 add 不然拖曳的時候不會有軌跡
                //2.
                Square.this.square.add( new Rect(lp)); 
            }
            public void mouseReleased(MouseEvent e){ //放開
                System.out.println("mouseReleased");
                status = 1;
                Graphics g = Square.this.getGraphics(); 
                cp = e.getPoint();
                //1.
//                Page.this.rects.add( new Rect(lp,cp)); 
                //2.
                Square.this.square.add( new Rect(cp)); 
                repaint();
            }
            public void mouseClick(MouseEvent e){
                System.out.println("mouseClick");
            }
        }); 
    }
    
    public void paint(Graphics g){  //記錄Line
        
//        

//        super.paint(g);
        //1
//        for(int i=0;i<Square.this.rects.size();i++){
//            width = Math.abs(rects.get(i).xy.x - rects.get(i).y.x);
//            height = Math.abs(rects.get(i).xy.y - rects.get(i).y.y);
//            g.drawRect(rects.get(i).xy.x, rects.get(i).xy.y, width, height);
//
//        }
        //2
        for(int i=0;i<Square.this.square.size()-1;i+=2){

            width = Math.abs(square.get(i+1).xy.x - square.get(i).xy.x);
            height = Math.abs(square.get(i+1).xy.y - square.get(i).xy.y);
            g.drawRect(square.get(i).xy.x, square.get(i).xy.y, width, height);
        }if(square.size()>=1){
            width = Math.abs(cp.x - square.get(square.size()-1).xy.x);
            height = Math.abs(cp.y - square.get(square.size()-1).xy.y);
            g.drawRect(square.get(square.size()-1).xy.x, square.get(square.size()-1).xy.y, width, height);
        }        
    }

    public void Clean(){
        System.out.println("Page_Clean");
        square.clear();
        repaint();
    }
    
    public void setSelected(boolean flag){
        selected = flag;
        System.out.println(flag);
    }
    
}
