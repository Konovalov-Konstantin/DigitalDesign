import java.awt.*;
import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        String a = "3[xyz]4[mn]k";
        int f = 0;
        int first = 0;
        int second = 0;
        int third = 0;
        ArrayList<Integer> intlist = new ArrayList<>();
        ArrayList<String> strlist = new ArrayList<>();
        char[] arrays = a.toCharArray();
        for (int i = 0; i < arrays.length; ) {
            char c = arrays[i];
            if (Character.isDigit(c)) {
                intlist.add(Character.digit(c, 10));
                i++;
            } else {
                if (f == 0) {
                    String s1 = a.substring(a.indexOf("[") + 1, a.indexOf("]"));
                    strlist.add(s1);
                    first = a.indexOf("[");
                    second = a.indexOf("[", first + 1);
                    third = a.indexOf(']');
                    f++;
                    i = i + third;
                } else if (f == 1) {
                    String s1 = a.substring(second + 1, a.indexOf(']', third + 1));
                    strlist.add(s1);
                    f++;
                    i = i + s1.length() + 2;
                } else if (f == 2) {
                    String s1 = a.substring(a.indexOf(']', third + 1) + 1, a.length());
                    strlist.add(s1);
                    i++;
                }
            }
        }
        int m = intlist.get(0);
        int n = intlist.get(1);
        while (m > 0) {
            System.out.print(strlist.get(0));
            m--;
        }
        while (n > 0) {
            System.out.print(strlist.get(1));
            n--;
        }
        System.out.print(strlist.get(2));
    }
}

