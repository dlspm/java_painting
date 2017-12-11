/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.Shape;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author angus
 */
public class Page extends JPanel{
    
    Color pageColors[] = {Color.CYAN, Color.white, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK};
    public static int id=0;
    public Vector<Line> lines = null;
    public Vector<Rect> rects = null;
    public Vector<Rect> ovals = null;
    public Status status;
    public Point begin, end;
    private java.util.List shapeList = new ArrayList(50);
    
    Point lp,cp;

    public Rectangle rect = null;
    
    Page(){
        init();
    }
    
    public void init(){
        this.setOpaque(true);
        this.setLayout(null);
        this.setBackground(pageColors[id++]);
        
        lines = new Vector<Line>();
        rects = new Vector<Rect>();
        ovals = new Vector<Rect>();
        status = Status.Selection;
        
        this.addMouseMotionListener( new MouseAdapter()
        {
            public void mouseDragged(MouseEvent e)
            {
                System.out.println("mouse dragged");
                System.out.println(Page.this.status);
                if(Page.this.status == Status.Drawing){
                    cp=e.getPoint();
                    Graphics g = Page.this.getGraphics();
                    g.drawLine(lp.x, lp.y, cp.x, cp.y);
                    Page.this.lines.add(new Line(lp, cp));
                    lp = cp;
                }else if(Page.this.status == Status.CreatingOBJ || Page.this.status == Status.EllipseOBJ){
                    end = e.getPoint();
                    repaint();
                
                }
            }
        });
        
        this.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                System.out.println("mouse pressed");
                if(Page.this.status == Status.Drawing){
                    lp=e.getPoint();
                }else if(Page.this.status == Status.CreatingOBJ || Page.this.status == Status.EllipseOBJ){
                    begin = e.getPoint();
                    end = null;
                }
            }
            
            public void mouseReleased(MouseEvent e)
            {
                System.out.println("mouse released");
                if(Page.this.status == Status.CreatingOBJ){
                    end = e.getPoint();
//                    shapeList.add(makeRect(begin, end));
                    Page.this.rects.add(new Rect(begin, end));
                    begin = end = null;
//                    repaint();
                }if(Page.this.status == Status.EllipseOBJ){
                    end = e.getPoint();
//                    shapeList.add(makeRect(begin, end));
                    Page.this.ovals.add(new Rect(begin, end));
                    begin = end = null;
                }
                repaint();
            }
        });
    
    }
    
    
    protected Rectangle makeRect(Point p1, Point p2)
    {
        final int x = Math.min(p1.x, p2.x);
        final int y = Math.min(p1.y, p2.y);
        final int width = Math.abs(p1.x - p2.x);
        final int height = Math.abs(p1.y - p2.y);
        return new Rectangle(x, y, width, height);
    }
    
    protected Ellipse2D.Double makeOval(Point p1, Point p2)
    {
      final int x = Math.min(p1.x, p2.x);
      final int y = Math.min(p1.y, p2.y);
      final int width = Math.abs(p1.x - p2.x);
      final int height = Math.abs(p1.y - p2.y);
      return new Ellipse2D.Double(x, y, width, height);
    }
    

    protected void paintComponent(Graphics g)
    {
        if (isOpaque()) { //如果此組件完全不透明，則返回true。
            g.clearRect(0, 0, getWidth(), getHeight());
        }
        
        g.setColor(Color.BLUE);
        for (int i = 0; i < this.lines.size(); i++) {
            Line l = this.lines.elementAt(i);
            g.drawLine(l.sp.x, l.sp.y, l.ep.x, l.ep.y);
        }
        final Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.BLUE);

         //只有在mouseReleased才會寫入所以mouseDragged時不引響
        for(int i=0;i<this.rects.size();i++){
            Rect r = this.rects.elementAt(i);
            g2d.draw(makeRect(r.begin, r.end));
        }
        
        for(int i=0;i<this.ovals.size();i++){
            Rect r = this.ovals.elementAt(i);
            g2d.draw(makeOval(r.begin, r.end));
            
        }
        
        if (begin != null) { //繪製的時候mouseDragged
            g2d.setPaint(Color.BLACK);
            if(Page.this.status == Status.CreatingOBJ){
                g2d.draw(makeRect(begin, end));
            }else if(Page.this.status == Status.EllipseOBJ){
                g2d.draw(makeOval(begin, end));
            }
            
        }
        
    }
    

   
}
