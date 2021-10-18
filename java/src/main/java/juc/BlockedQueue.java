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
            // 如果阻塞队列是满了，真放不进了，咋办呢，等着呗，等有消费者消费了，我就有空间了
            while (data.size() >= maxSize){
                // 把这些放不进的生产者都聚集起来，等待通知
                notFull.await();
            }
            // 省略入队操作...
            // 通知一下消费者去消费
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
            // 如果阻塞队列是空的，把当前线程挂起，其实就是调用 notEmpty.await() 方法，这个方法会把线程挂起并放到一个线程队列里
            while (data.isEmpty()){
                // 消费不了，数据是空的，所以要等着，等着有生产者来唤醒我，但是我又不是在阻塞，所以我要自旋
                notEmpty.await();
            }
            // 省略出队操作...
            // 如果不为空，那么就唤醒生产者线程去生产
            // 告诉他阻塞队列有空间了，因为我刚才消费了一个，你们生产者可以放一个进去），当然，如果没有生产者在等待，也无所谓，白喊了而已
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

