import com.abyss.dao.UserDao;
import com.abyss.domain.CollectionBean;
import com.abyss.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Abyss on 2018/5/16.
 * description:
 */
public class SpringTest {

    @Test
    public void IOCTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.save();
    }

    @Test
    public void IOCTest2() {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("file:" + "/Users/abyss/MyLog/applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.save();
    }

    @Test
    public void IOCTest3() {
        XmlBeanFactory context = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.save();
    }

//    @Test
//    public void log4jTest() {
//        System.out.println(5 / 0);
//    }

    @Test
    public void initTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = (UserDao) context.getBean("userDao");
        dao.save();
    }

    @Test
    public void destroyTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = (UserDao) context.getBean("userDao");
        dao.save();
        ((ClassPathXmlApplicationContext) context).close();
    }

    @Test
    public void factoryTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = (UserDao) context.getBean("userDao");
        dao.save();
        ((ClassPathXmlApplicationContext) context).close();
    }
//
//    @Test
//    public void constructorDITest() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        User user = (User) context.getBean("user");
//        System.out.println(user);
//    }
//    @Test
//    public void collectionDITest() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        CollectionBean collectionBean = (CollectionBean) context.getBean("collectionBean");
//        System.out.println(collectionBean);
//    }
    @Test
    public void multiContextDITest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext2.xml");
        CollectionBean collectionBean = (CollectionBean) context.getBean("collectionBean");
        System.out.println(collectionBean);
    }
}
