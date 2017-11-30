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
public class Page extends Panel{
    
    Color pageColors[] = {Color.white, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK};
    public static int id=0;
    public Vector<Line> lines=null;
    
    
    
    Page(){
        init();
    }
    
    public void init(){
        this.setLayout(null);
        this.setBackground(pageColors[id++]);
        lines = new Vector<Line>();
        
        this.addMouseMotionListener( new MouseAdapter()
        {
            public void mouseDragged(MouseEvent e)
            {
                System.out.println("mouse dragged");
            }
        });
        
        this.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                System.out.println("mouse pressed");
                
            }
            
            public void mouseReleased(MouseEvent e)
            {
                System.out.println("mouse released");
            }
        });
    
    }
    
    
}
