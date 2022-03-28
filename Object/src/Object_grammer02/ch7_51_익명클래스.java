package Object_grammer02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ch7_51_익명클래스 {
    /*******************************************************************
     * 익명 클래스(anonymous class)
     * 이름이 없는 일회용 클래스. 정의와 생성을 동시에
     * 조상 or 인터페이스이름으로 정의
     *******************************************************************/
    public static void main(String[] args) {
        Button b = new Button("Start");
        
        // 익명 클래스 (1회용)
        // 클래스의 정의와 객체 생성을 동시에
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("ActionEvent occurred!!!");
            }
        });
    }
}
