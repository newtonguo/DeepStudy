
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Test {

    public static void main(String[] args) {

        double x1 = 1;
        double x2 = 22;
        double y1 = 1;
        double y2 = 19;


        int qu = 4;

         double recWidth = x2 -x1 ;
        double recLength = y2 -y1;

        int lenSize = (int)recLength / qu + 1;

        int widSize = (int)recWidth / qu + 1;

        for(int i=0 ;i < lenSize ;i++){
//            log.info("");
            System.out.println( y1 + qu * i);
        }

    }
}
