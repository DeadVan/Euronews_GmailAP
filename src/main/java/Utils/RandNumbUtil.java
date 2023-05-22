package Utils;

import java.util.Random;

import static Utils.SettingsReader.readJsonInt;

public class RandNumbUtil {
    public static Random random = new Random();
    public static int randNumb = random.nextInt(readJsonInt("SletterSize"));

}
