package blackboard.main;

import java.util.logging.Logger;


public class Constant {
    static Logger logger = Logger.getLogger("BlackBoard");


    private Constant() throws IllegalAccessException {
        throw new IllegalAccessException("Utility class");
    }

    public static void writeLog(String msg){
        logger.info(msg);
    }
}
