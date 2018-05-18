import com.abyss.domain.User;
import com.abyss.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Abyss on 2018/4/20.
 * description:
 */
public class LoginTest {
    private QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

    @Test
    public void login() {
        User user = null;
        try {
            user = queryRunner.query("select username from user where username=?",
                    new BeanHandler<>(User.class), "小虎");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user != null) {
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
        }
    }

    @Test
    public void forTest() {
        String strings[] = {"1", "2"};
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void queryShop() throws SQLException {
        List<Object[]> list = queryRunner.query("select * from user", new ArrayListHandler());
        list.forEach(objects -> System.out.println(Arrays.toString(objects)));
    }

}
