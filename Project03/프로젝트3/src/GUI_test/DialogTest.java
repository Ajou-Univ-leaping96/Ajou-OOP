package GUI_test;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
public class DialogTest extends JFrame {
 
    public DialogTest() {
 
        JButton btn1 = new JButton("메시지");
        JButton btn2 = new JButton("확인");
        JButton btn3 = new JButton("입력");
        JPanel p = new JPanel();
 
        // 버튼의 이벤트 처리를 위한 익명클래스
 
        ActionListener handler = new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("메시지")) {// 참조형은 == 비교가아닌
                                                            // .equals
                    JOptionPane.showMessageDialog(null, "화면에 출력할 메세지", "제목", JOptionPane.WARNING_MESSAGE);
                } else if (e.getActionCommand().equals("확인")) {
                    int result = JOptionPane.showConfirmDialog(null, "프로그램을 종료하시 것습니까?", "제목",
                            JOptionPane.OK_CANCEL_OPTION);
 
                    System.out.printf("%d\n", result);
                    if (result == 0) { //OK=0 , Cancel=2 리턴
                        System.exit(0);
                    }
                } else {
                    // 기본적으로 하나 입력받을때만 사용한다. 2개이상만들라면 프레임을 새로 만들어야지 뭐...
                    String id = JOptionPane.showInputDialog(null, "뭐가 문제야?", "문제들", JOptionPane.OK_CANCEL_OPTION);
                    System.out.println(id);
                }
            }
        };
 
        btn1.addActionListener(handler);
        btn2.addActionListener(handler);
        btn3.addActionListener(handler);
 
        p.add(btn1);
        p.add(btn2);
        p.add(btn3);
 
        add(p);
        // 크기를 하위 컴포넌트의 크기대로 설정
        pack(); // size를 설정하지 안항도 된다~~~
 
        setLocation(100, 100);
        setVisible(true);
 
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
            new DialogTest();
    }
 
}