import java.lang.reflect.InvocationTargetException;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        Car car=new Car(new Engine(
        Class carclazz = Class.forName("Car");
        Class engineclazz = Class.forName("Engine");
        Class brakeclazz = Class.forName("Brake");

        Car car = (Car) carclazz.getConstructor(IEngine.class,IBrake.class)
                .newInstance(engineclazz.newInstance(),brakeclazz.newInstance());

        System.out.println(car);
    }
}
