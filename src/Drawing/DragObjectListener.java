/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drawing;


import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;
/**
 *
 * @author angus
 */
public class DragObjectListener implements MouseInputListener{ //一個監聽器實現了所有的方法MouseListener和 MouseMotionListener接口。
    
    Point p = new Point(0, 0); // 坐标点
    public JPanel state;
    DragObjectListener() {
        
    }
    
    public void mouseMoved(MouseEvent e) {

    }
    
    public void mouseDragged(MouseEvent e) { // 拖拉
        // 如果是左键则做一下操作
        if (SwingUtilities.isLeftMouseButton(e)) { //isLeftMouseButton 如果鼠標事件指定鼠標左鍵，則返回true。
            Component jl = (Component) e.getSource();
            // 坐标转换
            
//            轉換aPoint的source坐標系 destination坐標系。如果source是null，aPoint則假定為destination根組成坐標系。如果destination是null，aPoint將被轉換為source根組件坐標系。如果這兩個source和destination是null，返回aPoint 無需任何轉換。
//            轉換點(x,y)在source坐標系 destination坐標系。如果source是null，(x,y)則假定為destination根組成坐標系。如果destination是null，(x,y)將被轉換為source根組件坐標系。如果這兩個source和destination是null，返回(x,y) 無需任何轉換。
            Point newP = SwingUtilities.convertPoint(jl, e.getPoint(),
                    jl.getParent()); // 转换坐标系统, getParent獲取此組件的父項。
            
            jl.setLocation(jl.getX() + (newP.x - p.x), jl.getY()
                    + (newP.y - p.y)); // 设置标签的新位置
            p = newP; // 更改坐标点
            // jl.getParent().repaint();

        } else if (SwingUtilities.isRightMouseButton(e)) {// 右键操作

        } else if (SwingUtilities.isMiddleMouseButton(e)) {// 中键操作，一般鼠标没有

        }
    }
    
    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) { 
        Component source = (Component) e.getSource();
//        ((JButton)source).setSelected(false);
        ((Pen)source).setSelected(false);
    }

    public void mouseClicked(MouseEvent e) { //點
        if (SwingUtilities.isLeftMouseButton(e)) {        
            if (e.getClickCount() == 2) { //返回與此事件關聯的鼠標點擊次數。
                Component source = (Component) e.getSource(); //getSource()事件最初發生的對象。
//                ((JButton)source).setSelected(true); //setSelected() 設置選項（物件）可不可用
                ((Pen)source).setSelected(true); //setSelected() 設置選項（物件）可不可用
            }
        }
    }

    public void mousePressed(MouseEvent e) { // 按下
        if (SwingUtilities.isLeftMouseButton(e)) {
            Component jl = (Component) e.getSource();
            p = SwingUtilities.convertPoint(jl, e.getPoint(), jl.getParent()); // 得到当前坐标点
            // jl.getParent().repaint();
        } else if (SwingUtilities.isRightMouseButton(e)) {// 右键操作

        } else if (SwingUtilities.isMiddleMouseButton(e)) {// 中键操作，一般鼠标没有

        }
    }
    
}
