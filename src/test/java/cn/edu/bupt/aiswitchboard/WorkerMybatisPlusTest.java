package cn.edu.bupt.aiswitchboard;

import cn.edu.bupt.aiswitchboard.dao.WorkerDao;
import cn.edu.bupt.aiswitchboard.model.Worker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkerMybatisPlusTest {

    @Autowired
    private WorkerDao workerDao;

    @Test
    public void testGetAllWorker() {
        List<Worker> workerList = workerDao.selectList(null);  // 查询全部，入参是null
        System.out.println("workerList: " + workerList);
    }
}