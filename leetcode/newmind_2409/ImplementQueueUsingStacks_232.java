package newmind_2409;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStacks_232 {
    public static class MyQueue {
        Deque<Integer> inStack; // 삽입용 스택
        Deque<Integer> outStack; // 제거용 스택
        int size; // MyQueue 사이즈

        // 생성자 호출시 스택 초기화
        public MyQueue() {
            inStack = new ArrayDeque<>();
            outStack = new ArrayDeque<>();
            size = 0;
        }

        // push 호출시 스택 맨 뒤 요소 추가. size 1 증가
        public void push(int x) {
            inStack.push(x);
            size++;
        }

        // pop 호출시 원본/임시 스택 사용해 맨 밑 요소 제거 후 가져오기. size 1 감소
        public int pop() {
            shiftStacks(); size--;
            return outStack.pop(); // 맨 앞 요소 제거 후 반환
        }

        // peek 호출시 원본/임시 스택 사용해 맨 밑 요소 가져오기
        public int peek() {
            shiftStacks();
            return outStack.peek(); // 맨 앞 요소 반환
        }

        // empty 호출시 size 값 반환
        public boolean empty() {
            return size == 0;
        }

        // inStack에서 outStack으로 요소 이동 (필요할 때만)
        private void shiftStacks() {
            if (outStack.isEmpty()) { // outStack 비어있을 경우
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop()); // inStack의 모든 요소를 outStack으로 이동 (역순 정렬됨)
                }
            }
        }

        @Override
        public String toString() {
            return "MyQueue{" +
                    "originStack=" + inStack +
                    '}';
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue);
        myQueue.push(1); // queue is: [1]
        System.out.println(myQueue);
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue);
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        myQueue.push(3); // queue is: [2, 3]
        System.out.println("inStack: "+myQueue.inStack);
        System.out.println("outStack: "+myQueue.outStack);
        System.out.println(myQueue.pop()); // return 2, queue is [3]
        System.out.println(myQueue.pop()); // return 3, queue is []
        System.out.println(myQueue.empty()); // return true

    }
}
