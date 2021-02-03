import java.time.ZonedDateTime;

/**
 * @Author zhangsihang
 * @Time 2021/1/5 17:04
 */


public class GetTime {

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();   //默认时区
        System.out.println(zonedDateTime);
    }
}
