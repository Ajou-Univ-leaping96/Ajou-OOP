package GUI_test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
//JFrame Ŭ������ ���
public class DialogMaker1018p extends JFrame
{
   
    //�����̳� ��ü ������ �����ϰ�, null ����
    Container myContainer = null;
   
    public DialogMaker1018p(String title){
        //�θ� Ŭ����(JFrame)�� �����ڸ� �ҷ�����.
        super(title);
 
        //�������� ������������ �̿��Ͽ� �����̳� ��ü�� ����
        myContainer = this.getContentPane();
 
        //���� �޽��� ǥ�ÿ� ���� �ۼ�
        JLabel myLabel = new JLabel(
            "�޽����� �����Ͽ� [�ۼ�] ��ư�� Ŭ��", JLabel.CENTER);
 
        //�Է¿� �ؽ�Ʈ �ʵ� �ۼ�
        final JTextField myText = new JTextField("���⿡ �޽��� �Է�", 20);
       
        //��ư �ۼ�
        JButton myBtn = new JButton("�ۼ�!");
 
        //��ư�� Ŭ���Ǿ��� ���� �̺�Ʈ�� ����
        myBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
               
                //�ɼ����� �ۼ�
                JOptionPane myOptPane = new
                    JOptionPane(myText.getText(), JOptionPane.INFORMATION_MESSAGE);
               
                //createDialog �޼ҵ�� ��ȭ������ �ۼ�
                JDialog myDialog = myOptPane.createDialog(myContainer, "Dialog Generated!");
 
                //��ȭ ���ڸ� ���� ���·�
                myDialog.setVisible(true);
               
            }
        });
 
        //Panel �ۼ�(FlowLayout)
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new FlowLayout());
 
        //�ؽ�Ʈ �ʵ�� ��ư�� �����.
        myPanel.add(myText);
        myPanel.add(myBtn);
 
        //�����̳� ��ü�� ���̾ƿ��� ����(2�� 1�� GridLayout)
        myContainer.setLayout(new GridLayout(2,1));
       
        //Label�� Panel�� ����
        myContainer.add(myLabel);
        myContainer.add(myPanel);
 
        //������(������)�� �������� ó���� ����
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
   
        //Look & Feel ����
 
        try{
           
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }catch(Exception e){
            System.out.println(e + "���� �߻�!");
        }      
       
        //�������� ũ�⸦ �����Ͽ� ǥ��
        this.setSize(350, 100);
        this.setVisible(true);
    }
 
    public static void main(String[] args)
    {
        //DialogMaker1018p Ŭ������ �ű� �ν��Ͻ� ����
        DialogMaker1018p myApp = new DialogMaker1018p("Dialog Generator");
 
    }
}