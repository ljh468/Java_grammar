package Object_grammer06;

import java.util.*;

public class ch11_15_Stack과Queue {
    /*******************************************************************
     * 스택과 큐(Stack & Queue)
     * 스택 : LIFO(Last In First Out) 구조. 마지막에 저장된 것을 제일 먼저 꺼내게 된다. -> 배열
     * 큐 : FIFO(First In First Out) 구조. 제일 먼저 저장한 것을 제일 먼저 꺼내게 된다. -> 링크드리스트
     *******************************************************************/
    public static void main(String[] args) {
        Stack st = new Stack();
        Queue q = new LinkedList(); // Queue 인터페이스의 구현체인 LinkedList

        // 스택에 값 저장
        st.push("0");
        st.push("1");
        st.push("2");

        // 큐에 값 저장
        q.offer("0");
        q.offer("1");
        q.offer("2");
        System.out.println(" = Stack =");
        while(!st.empty()){
            System.out.println(st.pop()); // 스택에서 요소 하나를 꺼냅
        }
        System.out.println(" = Queue =");
        while(!q.isEmpty()){
            System.out.println(q.poll()); // 큐에서 요소 하나를 꺼냄
        }

        /*******************************************************************
         * 스택과 큐의 활용
         * 스택의 활용 예 - 수식계산, 수식괄호검사, 웹브라우저의 뒤로/앞으로
         * 큐의 활용 예 - 최근사용문서, 인쇄작업 대기목록, 버퍼(buffer)
         *******************************************************************/
//        if(args.length != 1){
//            System.out.println("Usage:java \"EXPRESSION\"");
//            System.out.println("Example:java \"((2+3)*1)+3\"");
//            System.exit(0);
//        }
        Stack st1 = new Stack();
        String expression = "((3+5)*8-2)";//args[0];
        System.out.println("expression = " + expression);

        /**
         * 수식 괄호검사 (Stack 활용)
         */
        try{
            for(int i = 0; i < expression.length(); i++){
                char ch = expression.charAt(i);
                if(ch == '('){
                    st.push(ch + "");
                }else if(ch == ')'){
                    st.pop();
                }
            }
            if(st.isEmpty()){
                System.out.println("괄호가 일치합니다.");
            }else{
                System.out.println("괄호가 일치하지 않습니다.");
            }
        } catch (EmptyStackException e){
            // 꺼낼것이 없으면 예외발생
            System.out.println("괄호가 일치하지 않습니다." );
        }
    }
}
