class Main {
    public static void main(String[] args) {
        System.out.println(unique.unique("unique"));
        System.out.println(unique.unique("word"));
        System.out.println(unique.unique("?%>?"));
        System.out.println(unique.unique("123456789"));
        System.out.println(unique.unique("シツ"));
    }
}

class unique {
    static boolean unique(String s) {
        char[] word = s.toCharArray();
        char[] used = new char[word.length];
        for (int i=0; i<word.length; i++) {
            if (findChar(used, word[i])) {
                return false;
            }
            else {
                used[i] = word[i];
            }
        }
        return true;
    }

    static boolean findChar(char[] arr, char c) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i]==c) {
                return true;
            }
        }
        return false;
    }
}
