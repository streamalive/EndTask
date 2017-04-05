package helper;

import java.util.Date;
import java.util.Random;

public class Randomizer {

    final static Random random = new Random();
    final static Date date = new Date();

    public static String getRandomAppendix() {
        return String.valueOf(random.nextInt(10000) + 10000);
    }

    //number -=3; only from second level we have some value
    public static int getRandomSelector(int number) {
        number -= 3;
        return (int) (Math.random() * ++number) + 3;
    }

    public static boolean getRandomBoolean() {
        long num = date.getTime();
        int num2 = (int) num;
        return num2 % 2 != 0 ? false : true;
    }

}
