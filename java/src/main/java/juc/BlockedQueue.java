package juc;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fan.li
 * @date 2021-10-15
 * @description
 */

public class BlockedQueue<T> {
    final Lock lock =
            new ReentrantLock();
    // 条件变量：队列不满
    final Condition notFull =
            lock.newCondition();
    // 条件变量：队列不空
    final Condition notEmpty =
            lock.newCondition();


    private List<T> data;
    private Integer maxSize;
    public BlockedQueue(int size) {
        data = new LinkedList<>();
        maxSize = size;
    }

    // 入队
    void enq(T x) {
        lock.lock();
        try {
            while (data.size() >= maxSize){
                // 等待队列不满
                notFull.await();
            }
            // 省略入队操作...
            //入队后,通知可出队
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    // 出队
    void deq(){
        lock.lock();
        try {
            while (data.isEmpty()){
                // 等待队列不空
                notEmpty.await();
            }
            // 省略出队操作...
            //出队后，通知可入队
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

