import com.zhengyao.util.ZhihuUtil;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/5/22.
 */
public class Test {

    @org.junit.Test
    public void TestGetTopId() throws IOException, InterruptedException {
        ZhihuUtil.getTopicID();
    }
    @org.junit.Test
    public void TestHandleTopic() throws InterruptedException, SQLException, IOException {
        ZhihuUtil.getTopicID();
        ZhihuUtil.getAllSubTopic();
        ZhihuUtil.getAllUserUrl();
    }
}
