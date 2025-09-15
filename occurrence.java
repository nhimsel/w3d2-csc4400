import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        String words = "In the beginning God created the heavens and the earth.";
        String key1 = "the";
        String key2 = "begin";
        String key3 = "recreate";

        System.out.println(Occurrence.occurrence(words, key1));
        System.out.println(Occurrence.occurrence(words, key2));
        System.out.println(Occurrence.occurrence(words, key3));
    }
}

class Occurrence {
    static int occurrence(String input, String key) {
        String[] args = breakString(input);
        key = cleanString(key);

        int c = 0;
        for (int i=0; i<args.length; i++) {
            /*
             * instructions show "begin" matching "beginning", thus .contains
             * if we want to only find exact words, we can use .equals instead
             */
            if (args[i].contains(key)) {
                c++;
            }
        }

        return c;
    }

    // breaks input string into an array of separate words.
    static String[] breakString(String s) {
        s = cleanString(s);
        char[] c = s.toCharArray();

        ArrayList<String> strings = new ArrayList<String>();
        int startPos = 0;
        for (int currPos=0; currPos<c.length; currPos++) {
            if (c[currPos] == ' ') {
                if (!(currPos == startPos)) {
                   char[] tmp = new char[currPos-startPos];
                   for (int n=startPos; n<currPos; n++) {
                       tmp[n-startPos] = c[n];
                   }
                   String temp = new String(tmp);
                   strings.add(temp);
                }
                startPos = currPos+1;
            }
        }

        String[] broken = new String[strings.size()];
        for (int i=0; i<strings.size(); i++) {
            broken[i] = strings.get(i);
        }
        return broken;
    }

    static String cleanString(String s) {
        s = s.toLowerCase();
        char[] c = s.toCharArray();
        for (int i=0; i<c.length; i++) {
            if (!isLegalChar(c[i])) {
                //unclean char, replace w/ space
                c[i] = ' ';
            }
        }
        s = new String(c);
        return s;
    }

    //assumes input has been run through toLowerCase
    static boolean isLegalChar(char c) {
        if (c == ' ') return true;
        if (c >= 'a' && c <= 'z') return true;
        //if (c>='A' && c<= 'Z') return true;
        if (c >= '0' && c <= '9') return true;
        if (c == '\'') return true;
        if (c == '-') return true;
        return false;
    }
}
