import com.abyss.dao.CategoryDao;
import com.abyss.dao.impl.CategoryDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Abyss on 2018/5/19.
 * description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AOPTest {


    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void logTest() {
        categoryDao.save();
    }
    @Test
    public void findTest() {
        categoryDao.findCategoryById("1");
    }
//    @Test
//    public void throwingTest() {
//        categoryDao.error();
//    }
}
