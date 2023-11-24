package aopsolution;


import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Retry
//@Transactional
public class RealSubject {
    @Timing
    public void doSomething(){
        try {
            System.out.println("do something");
            Thread.sleep(new Random().nextInt(1000));
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Timing
    public void doSomethingElse() throws Exception {


            int millis = new Random().nextInt(1000);
            System.out.println("do somethingelse with " + millis + " millis");
            Thread.sleep(millis);
            if(millis%10!=0)
                throw new Exception("test");



    }

}
