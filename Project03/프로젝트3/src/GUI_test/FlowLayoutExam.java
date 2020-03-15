package GUI_test;
/*FlowLayoutExam.java*/


import java.awt.FlowLayout; 
import javax.swing.JButton; 
import javax.swing.JFrame; 

public class FlowLayoutExam extends JFrame { 

    /** 
     * 필요한 필드 선언 
     */ 
    JButton btn1 = new JButton("버튼1"); 
    JButton btn2 = new JButton("버튼2"); 
    JButton btn3 = new JButton("버튼3"); 
    FlowLayout flow = new FlowLayout(); 

    /** 
     * 화면구성 생성자 
     */ 
    public FlowLayoutExam() { 
        super("First Swing"); // 타이틀지정 
        //setLayout(new FlowLayout(FlowLayout.CENTER, 10, 150)); // 
        //public FlowLayout(int align, int hgap, int vgap)//생성자참고
        //레이아웃 변경 
        super.setLayout(flow); 

        // 추가 
        add(btn1); // 컨테이너에 컴포넌트 추가 
        add(btn2); 
        add(btn3); 

        // 크기지정 
        setSize(300, 400); 
        // 보여줘 
        setVisible(true); 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 활성 
    } 

    public static void main(String[] args) { 
        new FlowLayoutExam(); 
    } 
} 

