import com.example.dao.imp.UserDaoImp;
import com.example.pojo.User;
import org.junit.jupiter.api.Test;

public class testUser {

    @Test
    void testSaveUser() {
        UserDaoImp userDaoImp = new UserDaoImp();
        Object obj = userDaoImp.saveUser(new User(null, "kilito", "1234", "test@gmail.com"));
        System.out.println(obj);
    }

    @Test
    void testQueryUserByUserNameAndPassword(){
        UserDaoImp userDaoImp = new UserDaoImp();
        Object obj = userDaoImp.queryUserByUserNameAndPassword("kilito","1234");
        System.out.println(obj);
    }

    @Test
    void testEmpty(){
        String st = null;
        System.out.print(st==null);
    }


}
