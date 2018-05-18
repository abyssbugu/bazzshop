import com.abyss.dao.LoginDao;
import com.abyss.dao.UserDao;
import com.abyss.domain.Product;
import com.abyss.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Abyss on 2018/5/17.
 * description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AnnotationTest {

    @Autowired
    private UserDao dao;
    @Autowired
    private LoginDao loginDao;
    @Autowired
    private ProductService productService;


    @Test
    public void Test1() {
        dao.save();
    }

    @Test
    public void Test2() {
        loginDao.printSome();
    }

    @Test
    public void Test3() {
        List<Product> all = productService.findAll();
        for (Product product : all) {
            System.out.println(product);
        }
    }
}
