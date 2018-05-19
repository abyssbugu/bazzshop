import com.abyss.dao.UserDao;
import com.abyss.dao.impl.UserDaoImpl;
import com.abyss.domain.User;
import com.abyss.proxy.CgLibProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Abyss on 2018/5/19.
 * description:
 */
public class ProxyTest {
    @Test
    public void jdkProxy() {
        UserDao dao = (UserDao) Proxy.newProxyInstance(UserDaoImpl.class.getClassLoader(), UserDaoImpl.class.getInterfaces(), new InvocationHandler() {
            private UserDaoImpl userDao = new UserDaoImpl();

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开始添加");
                Object invoke = method.invoke(userDao, args);
                System.out.println("结束添加");
                return invoke;
            }
        });
        dao.save();
    }

    @Test
    public void cgLibProxy() {
        User proxy = (User) new CgLibProxy(new User("灭霸", "5555")).getProxyInstance();
        proxy.printSome();
    }

}
