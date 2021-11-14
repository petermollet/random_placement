import com.sun.istack.internal.NotNull;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] firstNames = {
            "Alexandre", "Amelie", "Brice",
            "Dylan", "Jason", "Joachim",
            "Kevin", "Romain", "Tanguy",
            "Timothé", "Valentin", "Walid"
        };
        firstNames = randomize(firstNames);
        System.out.println(group(firstNames, 2));
    }

    static String[] randomize(@NotNull final String[] strings) {
        String[] randomized = new String[strings.length];
        int r;
        for (int i = 0; i < strings.length; i++) {
            r = new Random().nextInt(strings.length - i);
            randomized[i] = strings[r];
            for (; r < strings.length - 1; r++) {
                strings[r] = strings[r + 1];
            }
        }
        return randomized;
    }

    static String group(@NotNull final String[] strings, @NotNull final int numberByGroup){
        StringBuilder groups = new StringBuilder();
        final String SEPARATOR  = "---------------\n";
        groups.append(SEPARATOR);
        for (int i = 0; i < strings.length; i++) {
            groups.append(strings[i]).append("\n");
            if((i+1)%numberByGroup == 0)
                groups.append(SEPARATOR);
        }
        return groups.toString();
    }

}
