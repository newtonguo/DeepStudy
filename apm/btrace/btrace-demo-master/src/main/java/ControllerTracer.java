
import com.sun.btrace.AnyType;
import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;
import java.util.logging.*;
import java.lang.reflect.Field;


@BTrace public class ControllerTracer {


    @OnMethod(
                clazz="/com\\.zhiyin\\..*/",
                method="/.*/"
        )
        public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args) {
            println(pcn);
            println(pmn);
            printArray(args);
        }
    }
