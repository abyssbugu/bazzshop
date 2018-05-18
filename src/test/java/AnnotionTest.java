import com.abyss.dao.LoginDao;
import com.abyss.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Abyss on 2018/5/17.
 * description:
 */
public class AnnotionTest {

//    @Autowired
//    private UserDao dao;

    @Test
    public void Test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = (UserDao) context.getBean("userDao");
        dao.save();
//        dao.save();
    }

    @Test
    public void Test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        LoginDao dao = (LoginDao) context.getBean("loginDao");
        dao.printSome();
//        dao.save();
    }
}
