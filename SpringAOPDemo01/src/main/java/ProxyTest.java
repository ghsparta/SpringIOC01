import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyTest {
    public static void main(String[] args) {
        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        final List list = new ArrayList();
        list.add("abc");

        List o =(List) Proxy.newProxyInstance(list.getClass().getClassLoader(),
                new Class[]{List.class}, new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("size")){
                    System.out.println("hi there......");
                }
                Object o = method.invoke(list, args);
                return o;
            }
        });
        System.out.println(list.getClass().getName());
        System.out.println(o.getClass().getName());
        for (Class<?> anInterface : o.getClass().getInterfaces()) {
            System.out.println(anInterface.getName());
        }
        System.out.println(o.size());
    }
}