package Generator;

import java.util.Random;

public class PasswordGenerator{

    public static String generatePassword(int length) {
        // Creation of the first Randomizer, to randomize the randomizer for the password
        Random random = new Random();

        String pw = "";
        for (int i = 0; i < length; i++) {
            Random rdm = new Random(random.nextLong());
            char c = (char) (rdm.nextInt(106) + 21);
            while (c == '`' || c == '´' || c == ' ' || pw.indexOf(Character.toString(c))!=-1) {
                c = (char) (rdm.nextInt(106) + 21);
            }
            pw += Character.toString(c);
        }
        return pw;
    }
}
