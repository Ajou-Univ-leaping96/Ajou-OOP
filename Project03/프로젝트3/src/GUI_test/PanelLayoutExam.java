package GUI_test;
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 

public class PanelLayoutExam extends JFrame { 

    JButton btn1 = new JButton("WestButton"); 
    JButton btn2 = new JButton("CenterButton"); 

    JPanel jpn = new JPanel(); 
    JButton btn3 = new JButton("File"); 
    JButton btn4 = new JButton("Help"); 

    public PanelLayoutExam() { 
        super("PanelLayoutExam"); 
        // ���̾ƿ� ���� 

        // JPanel�� ������Ʈ �߰� 
        jpn.add(btn3); 
        jpn.add(btn4); 

        // JFrame�� ������Ʈ �߰� 
        add(jpn, "North"); 
        add(btn1, "West"); 
        add(btn2, "Center"); 

        // ũ�� 
        setSize(300, 200); 
        // super.pack(); 
        // ���̱� 
        setVisible(true); 
        // x : ���� 
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    } 

    public static void main(String[] args) { 
        new PanelLayoutExam(); 
    } 
}
