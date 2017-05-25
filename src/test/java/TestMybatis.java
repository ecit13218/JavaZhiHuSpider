import com.zhengyao.dao.UserDao;
import com.zhengyao.dao.ZhihuUserDao;
import com.zhengyao.entity.ZhiHuUser;
import com.zhengyao.util.ZhihuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/5/22.
 */
@ContextConfiguration("classpath*:/applicationContext.xml")
public class TestMybatis extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ZhihuUserDao zhihuuserDao;//这里报错无关紧要，还是依然可以使用，可以将设置中spring的检查级别改为warning（Spring | Spring Core | Code | Autowiring for Bean Class）

    @org.testng.annotations.Test
    public void TestMybatis(){
        ZhiHuUser user=new ZhiHuUser();
        user.setName("zhengyao");
        zhihuuserDao.insert(user);

    }
    @org.testng.annotations.Test
    public void TestHandleTopic() throws InterruptedException, SQLException, IOException {
        ZhihuUtil.getTopicID();
        ZhihuUtil.getAllSubTopic();
        ZhihuUtil.getAllUserUrl();
        ZhihuUtil.getAllUser();
    }
}
