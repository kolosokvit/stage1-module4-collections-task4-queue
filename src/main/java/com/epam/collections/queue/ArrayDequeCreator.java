package com.epam.collections.queue;

import java.util.*;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> resultDeque = new ArrayDeque<>();
        resultDeque.add(firstQueue.remove());
        resultDeque.add(firstQueue.remove());
        resultDeque.add(secondQueue.remove());
        resultDeque.add(secondQueue.remove());

        while (!firstQueue.isEmpty() && !secondQueue.isEmpty()) {
            firstQueue.add(resultDeque.removeLast());
            resultDeque.add(firstQueue.remove());
            resultDeque.add(firstQueue.remove());
            secondQueue.add(resultDeque.removeLast());
            resultDeque.add(secondQueue.remove());
            resultDeque.add(secondQueue.remove());
        }
        return resultDeque;
    }
}
