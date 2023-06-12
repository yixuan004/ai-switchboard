package cn.edu.bupt.aiswitchboard;

import cn.edu.bupt.aiswitchboard.common.Response;
import cn.edu.bupt.aiswitchboard.controller.NameFinderController;
import cn.edu.bupt.aiswitchboard.service.NameFinderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * NameFinder的测试类，可以测Service也可以测Controller
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NameFinderServiceTest {
    @Autowired
    private NameFinderService nameFinderService;

    @Autowired
    private NameFinderController nameFinderController;

//    @Test
//    public void testNameFinderService() {
//        // 除了预期的输入输出，非预期的也要写上，报什么错返回什么，如果能传的话
//        Integer a = nameFinderService.test(5);
//        assertEquals((Integer) 5, a);
//
//        a = nameFinderService.test(4);
//        assertEquals((Integer) 4, a);
//    }

//    @Test
//    public void testNameFinderController() {
//        Response<Object> resp = nameFinderController.find();
//        Response<Object> tmp = new Response<>();
//        tmp.update(200, "SUCCESS", null);
//        assertEquals(tmp, resp);
//    }

}
