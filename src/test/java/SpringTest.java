import com.abyss.dao.UserDao;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
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
    @Test
    public void log4jTest() {
            System.out.println(5 / 0);
    }
}
