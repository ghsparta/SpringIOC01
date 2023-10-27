package aopsolution;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;


@Component
public class RealSubject {
    @Timing
    public void doSomething(){
        try {
            System.out.println("do something...");
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Timing
    @Retry
    public void doSomethingElse() throws Exception {
        try {
            int millis = new Random().nextInt(1000);
            System.out.println("do somethingelse with a delay of " + millis + "ms...");
            Thread.sleep(millis);
            if(millis%10!=0)
                throw new Exception();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
