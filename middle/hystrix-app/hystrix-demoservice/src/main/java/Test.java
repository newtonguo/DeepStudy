import com.netflix.config.DynamicBooleanProperty;
import com.netflix.config.DynamicPropertyFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by hg on 2016/6/21.
 */
@Slf4j
public class Test {
    private final static DynamicBooleanProperty usePrimary = DynamicPropertyFactory.getInstance().getBooleanProperty("primarySecondary.usePrimary", true);

    public static void main(String[] args){

        log.info(usePrimary.get()+"");

    }
}
