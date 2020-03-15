package 실습;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

/**
 * A frame with a panel that demonstrates color change actions.
 */
public class ActionFrame extends JFrame
{
   private JPanel buttonPanel;
   private DrawComponent D;
   private static final int DEFAULT_WIDTH = 700;
   private static final int DEFAULT_HEIGHT = 600;

   public ActionFrame()
   {
	   
      setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
      
      //패널생성
      buttonPanel = new JPanel();
      

      //버튼생성
      JButton Y = new JButton("yellow"); 
      JButton B = new JButton("blue");
      JButton R = new JButton("red");
      
      
      //버튼에 액션추가
      Y.addActionListener(new ColorAction("Yellow", new ImageIcon("yellow-ball.gif"), Color.YELLOW));
      B.addActionListener(new ColorAction("Blue", new ImageIcon("blue-ball.gif"), Color.BLUE));
      R.addActionListener(new ColorAction("Red", new ImageIcon("red-ball.gif"), Color.RED));
      
      //패널에 버튼추가
      buttonPanel.add(Y);
      buttonPanel.add(B);
      buttonPanel.add(R);
      
      //그림생성
      D = new DrawComponent();
      
      
      //컨테이너 생성
      Container c = getContentPane();
      
      //컨테이너에 패널추가
      c.add(buttonPanel, BorderLayout.NORTH);
      c.add(D, BorderLayout.CENTER);
      

      
     
      
   }
   
   class DrawComponent extends JComponent
   {
      private static final int DEFAULT_WIDTH = 400;
      private static final int DEFAULT_HEIGHT = 400;
      public Color color = Color.red;
     

      public void paintComponent(Graphics g)
      {
         Graphics2D g2 = (Graphics2D) g;
         
        
         g2.setColor(color);
         //g2.setColor(Color.RED);

         // draw a rectangle

         double leftX = 100;
         double topY = 100;
         double width = 200;
         double height = 150;

         Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
         g2.draw(rect);

         // draw the enclosed ellipse

         Ellipse2D ellipse = new Ellipse2D.Double();
         ellipse.setFrame(rect);
         g2.draw(ellipse);

         // draw a diagonal line

         g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));

         // draw a circle with the same center

         double centerX = rect.getCenterX();
         double centerY = rect.getCenterY();
         double radius = 150;

         Ellipse2D circle = new Ellipse2D.Double();
         circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
         g2.draw(circle);
      }
      
      
      public void repaint() {
    	  
      }
      
      public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }
   }
   
   public class ColorAction extends AbstractAction implements ActionListener
   {
      /**
       * Constructs a color action.
       * @param name the name to show on the button
       * @param icon the icon to display on the button
       * @param c the background color
       */
      public ColorAction(String name, Icon icon, Color c)
      {
         putValue(Action.NAME, name);
         putValue(Action.SMALL_ICON, icon);
         putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
         putValue("color", c);
      }

      public void actionPerformed(ActionEvent event)
      {
         Color c = (Color) getValue("color");
         buttonPanel.setBackground(c);
         D.color = c;
         D.repaint(0);
      }
   }
   
  
   
   
   
}
