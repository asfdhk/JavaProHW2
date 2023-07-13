import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Main {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Test {
        int a();
        int b();
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Main main = new Main();
        Method method = main.getClass().getMethod("test", int.class, int.class);

        if (method.isAnnotationPresent(Test.class)) {
            Test annotation = method.getAnnotation(Test.class);
            int a = annotation.a();
            int b = annotation.b();

            method.invoke(main, a, b);
        }
    }
    @Test(a = 2, b = 5)
    public void test(int a, int b) {
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
}

