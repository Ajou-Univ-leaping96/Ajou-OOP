package GUI_test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
//JFrame 클래스를 상속
public class DialogMaker1018p extends JFrame
{
   
    //컨테이너 객체 변수를 선언하고, null 대입
    Container myContainer = null;
   
    public DialogMaker1018p(String title){
        //부모 클래스(JFrame)의 생성자를 불러낸다.
        super(title);
 
        //프레임의 컨텐츠페인을 이용하여 컨테이너 객체를 생성
        myContainer = this.getContentPane();
 
        //지시 메시지 표시용 라벨을 작성
        JLabel myLabel = new JLabel(
            "메시지를 지정하여 [작성] 버튼을 클릭", JLabel.CENTER);
 
        //입력용 텍스트 필드 작성
        final JTextField myText = new JTextField("여기에 메시지 입력", 20);
       
        //버튼 작성
        JButton myBtn = new JButton("작성!");
 
        //버튼이 클릭되었을 때의 이벤트를 정의
        myBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
               
                //옵션페인 작성
                JOptionPane myOptPane = new
                    JOptionPane(myText.getText(), JOptionPane.INFORMATION_MESSAGE);
               
                //createDialog 메소드로 대화상장을 작성
                JDialog myDialog = myOptPane.createDialog(myContainer, "Dialog Generated!");
 
                //대화 상자를 가시 상태로
                myDialog.setVisible(true);
               
            }
        });
 
        //Panel 작성(FlowLayout)
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new FlowLayout());
 
        //텍스트 필드와 버튼을 만든다.
        myPanel.add(myText);
        myPanel.add(myBtn);
 
        //컨테이너 객체의 레이아웃을 설정(2행 1열 GridLayout)
        myContainer.setLayout(new GridLayout(2,1));
       
        //Label과 Panel를 설정
        myContainer.add(myLabel);
        myContainer.add(myPanel);
 
        //프레임(윈도우)이 닫힐때의 처리를 정의
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
   
        //Look & Feel 설정
 
        try{
           
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }catch(Exception e){
            System.out.println(e + "오류 발생!");
        }      
       
        //프레임의 크기를 정의하여 표시
        this.setSize(350, 100);
        this.setVisible(true);
    }
 
    public static void main(String[] args)
    {
        //DialogMaker1018p 클래스의 신규 인스턴스 생성
        DialogMaker1018p myApp = new DialogMaker1018p("Dialog Generator");
 
    }
}