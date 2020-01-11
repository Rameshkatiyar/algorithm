package tech.ds.priorityQueue;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

    public static void main(String rn[]){
        javaQueueUse();
    }

    public static void javaQueueUse(){
        Queue<Task> tasksQueue = new PriorityQueue<>(10, new TaskComparator());

        tasksQueue.add(new Task("A", 3));
        tasksQueue.add(new Task("B", 1));
        tasksQueue.add(new Task("C", 2));
        tasksQueue.add(new Task("D", 2));
        tasksQueue.add(new Task("E", 4));
        tasksQueue.add(new Task("F", 1));

        Iterator<Task> iterator = tasksQueue.iterator();
        while (iterator.hasNext()){
            Task next = iterator.next();
            System.out.println(next.getTask() +" - "+ next.getPriority());
        }

        System.out.println("Poll: "+tasksQueue.poll().getTask());
        System.out.println("Poll: "+tasksQueue.poll().getTask());
        System.out.println("Poll: "+tasksQueue.poll().getTask());
    }
}
