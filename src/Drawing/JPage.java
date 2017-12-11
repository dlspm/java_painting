/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

/**
 *
 * @author angus
 */
public class JPage extends Panel{
    
    Color pageColors[] = {Color.white, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK};
    public static int id=0;
    public Vector<Line> lines=null;
    public Status status;
    
    Point lp,cp;

    public Rectangle rect = null;
    
    JPage(){
        init();
    }
    
    public void init(){
        this.setLayout(null);
        this.setBackground(pageColors[id++]);
        lines = new Vector<Line>();
        status = Status.Selection;
        
        this.addMouseMotionListener( new MouseAdapter()
        {
            public void mouseDragged(MouseEvent e)
            {
                System.out.println("mouse dragged");
                if(JPage.this.status == Status.Drawing){
                    cp=e.getPoint();
                    Graphics g = JPage.this.getGraphics();
                    g.drawLine(lp.x, lp.y, cp.x, cp.y);
                    JPage.this.lines.add(new Line(lp, cp));
                    lp = cp;
                }
            }
        });
        
        this.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                System.out.println("mouse pressed");
                if(JPage.this.status == Status.Drawing){
                    lp=e.getPoint();
                }
                
            }
            
            public void mouseReleased(MouseEvent e)
            {
                System.out.println("mouse released");
            }
        });
    
    }
    
    public void paint(Graphics g){//重新繪製
        for(int i=0;i< this.lines.size();i++)
        {
            Line l = this.lines.elementAt(i);
            g.drawLine(l.sp.x, l.sp.y, l.ep.x, l.ep.y);
        }
    
    
    }
    
    
}
