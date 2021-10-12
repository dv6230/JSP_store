import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class UserServletTest {

    public void login() {
        System.out.println("login 方法");

    }

    public void register() {
        System.out.println("register 方法");

    }

    public void updateUser() {
        System.out.println("updateUser 方法");
    }

    public static void main(String[] args) {

        String action = "register";
        try {
            Method method = UserServletTest.class.getDeclaredMethod(action);
            System.out.println(method);
            method.invoke(new UserServletTest());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
