import com.example.dao.imp.UserDaoImp;
import com.example.pojo.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class testUser {

    @Test
    void testSaveUser() {
        UserDaoImp userDaoImp = new UserDaoImp();
        Object obj = userDaoImp.saveUser(new User(null, "kilito", "1234", "test@gmail.com"));
        System.out.println(obj);
    }

    @Test
    void testQueryUserByUserNameAndPassword() {
        UserDaoImp userDaoImp = new UserDaoImp();
        Object obj = userDaoImp.queryUserByUserNameAndPassword("kilito", "1234");
        System.out.println(obj);
    }

    @Test
    void TestUserByName() {
        UserDaoImp userDaoImp = new UserDaoImp();
        Object obj = userDaoImp.queryUserByUserName("kilito");
        System.out.println(obj);
    }

    @Test
    void testEmpty() {
        String st = null;
        System.out.print(st == null);
    }

    @Test
    void testMethod() {
        try {
            // parameter type is null
            Method m = this.getClass().getDeclaredMethod("show", null);
            System.out.println("method1 = " + m.toString());
            m.invoke(this);

            // method Integer
            Class[] cArg = new Class[1];
            cArg[0] = Integer.class;
            Method lMethod = this.getClass().getDeclaredMethod("showInteger", Integer.class);
            System.out.println("method2 = " + lMethod.toString());
            lMethod.invoke(this,999);

        } catch (NoSuchMethodException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void show() {
        System.out.println("hello this is a show");
    }

    void showInteger(Integer id) {
        System.out.println(id);
    }

    @org.junit.Test
    public void queryUserTest() {
        UserDaoImp userDaoImp = new UserDaoImp();
        String sql = "SELECT id , username FROM t_user WHERE 1 = 1";
        List<User> obj = userDaoImp.QueryForList(User.class, sql);
        System.out.println(obj);
    }

}
