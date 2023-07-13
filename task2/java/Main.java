import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args)  {
        TextContainer container = new TextContainer();
        Class<?> containerClass = container.getClass();

        Method[] methods = containerClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Saver.class)) {
                try {
                    method.invoke(container);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

