package newmind_2409;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStacks_232 {
    public static class MyQueue {
        Deque<Integer> originStack; // 삽입용 스택
        Deque<Integer> tempStack; // 제거용 스택
        int size; // MyQueue 사이즈

        // 생성자 호출시 스택 초기화
        public MyQueue() {
            originStack = new ArrayDeque<>();
            tempStack = new ArrayDeque<>();
            size = 0;
        }

        // push 호출시 스택 맨 뒤 요소 추가. size 1 증가
        public void push(int x) {
            originStack.push(x);
            size++;
        }

        // pop 호출시 원본/임시 스택 사용해 맨 밑 요소 제거 후 가져오기. size 1 감소
        public int pop() {
            while (!originStack.isEmpty()) {
                tempStack.push(originStack.pop());
            }

            int bottomElement = tempStack.pop();
            size--;

            while (!tempStack.isEmpty()) {
                originStack.push(tempStack.pop());
            }

            return bottomElement;
        }

        // peek 호출시 원본/임시 스택 사용해 맨 밑 요소 가져오기
        public int peek() {
            while (!originStack.isEmpty()) {
                tempStack.push(originStack.pop());
            }

            if (tempStack.isEmpty()) { // 임시 스택 비어있을 경우
                return -1;
            }

            int bottomElement = tempStack.peek();

            while (!tempStack.isEmpty()) {
                originStack.push(tempStack.pop());
            }

            return bottomElement;
        }

        // empty 호출시 size 값 반환
        public boolean empty() {
            return size == 0;
        }

        @Override
        public String toString() {
            return "MyQueue{" +
                    "originStack=" + originStack +
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
        System.out.println(myQueue.empty()); // return false

    }
}
