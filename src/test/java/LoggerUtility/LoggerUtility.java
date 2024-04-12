package LoggerUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

    // trebuie sa definesc o instanta de logger
    private static final Logger logger = LogManager.getLogger();

    // trebuie sa definesc o metoda care sa porneasca un test
    public static void startTestCase(String testName) {
        logger.info("****** Execution started: " + testName + " ******");
    }

    // trebuie sa definesc o metoda care sa opreasca un test
    public static void finishTestCase(String testName) {
        logger.info("****** Execution finished: " + testName + " ******");
    }

    // metoda de info, metoda de error
    public static void infoTest(String message) {
        logger.info(message);
    }

    public static void errorTest(String message) {
        logger.error(message);
    }
}
