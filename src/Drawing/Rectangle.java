/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author angus
 */
public class Rectangle extends JPanel{

    private Point begin, end;
    private List shapeList = new ArrayList(50);
    
    Rectangle(){
        setPreferredSize(new Dimension(300, 300));
        addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e)
            {
              end = e.getPoint();
              shapeList.add(makeRect(begin, end));
              begin = end = null;
              repaint();
            }

            public void mousePressed(MouseEvent e)
            {
              end = begin = e.getPoint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e)
            {
              end = e.getPoint();
              repaint();
            }      
        });
    }

    protected java.awt.Rectangle makeRect(Point p1, Point p2)
    {
      final int x = Math.min(p1.x, p2.x);
      final int y = Math.min(p1.y, p2.y);
      final int width = Math.abs(p1.x - p2.x);
      final int height = Math.abs(p1.y - p2.y);
      return new java.awt.Rectangle(x, y, width, height);
    }
    
    protected void paintComponent(Graphics g)
    {
      if (isOpaque())
        g.clearRect(0, 0, getWidth(), getHeight());
      
      final Graphics2D g2d = (Graphics2D) g;
      g2d.setPaint(Color.BLUE);
      for (Iterator it = shapeList.iterator(); it.hasNext();) {
        Shape shape = (Shape) it.next();
        g2d.draw(shape);
      }
      if (begin != null) {
        g2d.setPaint(Color.BLACK);
        g2d.draw(makeRect(begin, end));
      }
    }   
}
