package 复习;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author DreamYee
 * @Create 2020/01/02  14:49
 */
public class Timer定时器  {
    public static void main(String[] args) {
        //创建定时器对象
        TimerTask tt=new MyTask();
        Timer t=new Timer();
        //在3秒后执行mytask类中的run方法
       t.schedule(tt,0,1000);
    }
}

class MyTask extends TimerTask{
    @Override
    public void run() {
        System.out.println("该学习啦！");
    }
}
