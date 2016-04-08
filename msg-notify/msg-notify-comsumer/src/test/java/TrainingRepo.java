import com.alibaba.dubbo.config.annotation.Reference;
import com.hg.Application;
import com.hg.msg.service.IMsgNotifyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TrainingRepo {

    @Reference
    private IMsgNotifyService msgNotifyService;

	@Test
	public void testMybatis() {
        System.out.println("==========================:"  );


        System.out.println("==========================:" +  msgNotifyService.testok("admin"));
	}
}