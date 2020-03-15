package GUI_test;
 /*GridLayoutExam*/


import java.awt.GridLayout; 

import javax.swing.JButton; 
import javax.swing.JFrame; 

public class GridLayoutExam extends JFrame { 
    public GridLayoutExam() { // 생성자 
        super("GridLayoutExam"); 
        // 레이아웃 변경 
        super.setLayout(new GridLayout(3, 2)); // 3행 2열 
        // super.setLayout(new GridLayout(0,3)); //열은 무조건 3열이고 행이 늘어난다 
        // super.setLayout(new GridLayout(2,0)); //행은 무조건 2행이고 열이 늘어난다. 
        // super.setLayout(new GridLayout()); //한행에 열이 늘어난다. 

        // 추가 
        add(new JButton("버튼 1")); 
        add(new JButton("버튼 2")); 
        add(new JButton("버튼 3")); 
        add(new JButton("버튼 4")); 
        add(new JButton("버튼 5")); 
        add(new JButton("버튼 6")); 
        // 크기 
        super.setSize(300, 400); 
        // 보이기 
        super.setVisible(true); 
        // x 버튼 활성화 
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    } 

    public static void main(String[] args) { 
        new GridLayoutExam(); 
    } 
} 
