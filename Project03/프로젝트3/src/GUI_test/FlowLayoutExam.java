package GUI_test;
/*FlowLayoutExam.java*/


import java.awt.FlowLayout; 
import javax.swing.JButton; 
import javax.swing.JFrame; 

public class FlowLayoutExam extends JFrame { 

    /** 
     * �ʿ��� �ʵ� ���� 
     */ 
    JButton btn1 = new JButton("��ư1"); 
    JButton btn2 = new JButton("��ư2"); 
    JButton btn3 = new JButton("��ư3"); 
    FlowLayout flow = new FlowLayout(); 

    /** 
     * ȭ�鱸�� ������ 
     */ 
    public FlowLayoutExam() { 
        super("First Swing"); // Ÿ��Ʋ���� 
        //setLayout(new FlowLayout(FlowLayout.CENTER, 10, 150)); // 
        //public FlowLayout(int align, int hgap, int vgap)//����������
        //���̾ƿ� ���� 
        super.setLayout(flow); 

        // �߰� 
        add(btn1); // �����̳ʿ� ������Ʈ �߰� 
        add(btn2); 
        add(btn3); 

        // ũ������ 
        setSize(300, 400); 
        // ������ 
        setVisible(true); 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x��ư Ȱ�� 
    } 

    public static void main(String[] args) { 
        new FlowLayoutExam(); 
    } 
} 

