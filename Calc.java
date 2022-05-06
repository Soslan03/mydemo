import java.io.IOException;
import java.util.Scanner;


public class Calc {
    public static int aRome;
    public static int bRome;
    public static int result;
    public static boolean aRomeFlag = false;
    public static boolean bRomeFlag = false;
    public static String calc;
    public static char[] opr = {'-', '+', '*', '/'};
    public static String[] rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    public static String[] tokens;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter  an expression, arguments from 0-10:");
        calc = scanner.nextLine();
        calc = calc.trim();
        calc = calc.replace(" ", "");
        int i;
        int l1 = -1;
        int l2 = -1;

        boolean flag = false;

        for (i = 0; i < opr.length; i++) { // поиск арифм знака
            l1 = calc.indexOf(opr[i]);
            l2 = calc.lastIndexOf(opr[i]);
            if (((l1) != -1) && (l1 == l2)) {
                flag = true;
                break;
            } else if ((i == 3) && flag == false) {
                break;

            }

        }

        if (flag && romeChe(i)) romeEx(i); // определение римских символов и выполнение выисления
        else if (flag && romeChe(i) == false) arabEx(i);
        else if (flag == false) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception-incorrect expression ");
                // e.printStackTrace();
            }
        }


    }


    static boolean romeChe(int i) { // определение римских символов
        aRome = 0;
        bRome = 0;
        tokens = calc.split("\\" + String.valueOf((opr[i])));

        for (int i1 = 0; i1 < rome.length; i1++) {
            if (tokens[0].equals(rome[i1])) {
                aRome = i1 + 1;
                aRomeFlag = true;
            }
            if (tokens[1].equals(rome[i1])) {
                bRome = i1 + 1;
                bRomeFlag = true;
            }
        }

        if (aRomeFlag && bRomeFlag) return true;
        else return false;
    }

    static void romeEx(int i) { //  выполнение выисления

        if ((i == 0) && (aRome > bRome)) {
            result = aRome - bRome;
            System.out.println("calculated " + rome[result - 1]);
        } else if ((i == 0) && (aRome <= bRome)) {

            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception-incorrect expression ");
                // e.printStackTrace();
            }
        }
        if (i == 1) {
            result = aRome + bRome;
            romeResPrn();
        }
        if (i == 2) {
            result = aRome * bRome;
            romeResPrn();
        }
        if ((i == 3) && (aRome >= bRome)) {
            result = aRome / bRome;
            System.out.println("calculated " + rome[result - 1]);
        } else if ((i == 3) && (aRome < bRome)) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("throws Exception-incorrect expression ");
                // e.printStackTrace();
            }
        }
    }

    static void romeResPrn() { // печать ответа в римских символах
        int resTem;
        if (result <= 10) System.out.println("calculated " + rome[result - 1]);

        if (result > 10 && result <= 20) {
            resTem = result - 10;
            System.out.println("calculated X" + rome[resTem - 1]);
        }
        if (result > 20 && result < 30) {
            resTem = result - 20;
            System.out.println("calculated XX" + rome[resTem - 1]);
        }
        if (result == 30) System.out.println("calculated XXX");
        if (result > 30 && result < 40) {
            resTem = result - 30;
            System.out.println("calculated XXX" + rome[resTem - 1]);
        }
        if (result == 40) System.out.println("calculated XL");
        if (result > 40 && result < 50) {
            resTem = result - 40;
            System.out.println("calculated XL" + rome[resTem - 1]);
        }
        if (result == 50) System.out.println("calculated L");
        if (result > 50 && result < 60) {
            resTem = result - 50;
            System.out.println("calculated L" + rome[resTem - 1]);
        }
        if (result == 60) System.out.println("calculated LX");
        if (result > 60 && result < 70) {
            resTem = result - 60;
            System.out.println("calculated LX" + rome[resTem - 1]);
        }
        if (result == 70) System.out.println("calculated LXX");
        if (result > 70 && result < 80) {
            resTem = result - 70;
            System.out.println("calculated LXX" + rome[resTem - 1]);
        }
        if (result == 80) System.out.println("calculated LXXX");
        if (result > 80 && result < 90) {
            resTem = result - 80;
            System.out.println("calculated LXXX" + rome[resTem - 1]);
        }
        if (result == 90) System.out.println("calculated XC");
        if (result > 90 && result < 100) {
            resTem = result - 90;
            System.out.println("calculated XC" + rome[resTem - 1]);
        }
        if (result == 100) System.out.println("calculated C");
    }

    static void arabEx(int i) { // вычисление в арабских символах и вывод ответа

        try {
            aRome = Integer.parseInt(tokens[0]);
            bRome = Integer.parseInt(tokens[1]);
            if ((aRome > 0 && aRome <= 10) && (bRome > 0 && bRome <= 10)) {
                if ((i == 0)) {
                    result = aRome - bRome;
                    System.out.println("calculated " + result);
                }

                if (i == 1) {
                    result = aRome + bRome;
                    System.out.println("calculated " + result);
                }
                if (i == 2) {
                    result = aRome * bRome;
                    System.out.println("calculated " + result);
                }
                if ((i == 3) && (aRome >= bRome)) {
                    result = aRome / bRome;
                    System.out.println("calculated " + result);
                } else if ((i == 3) && (aRome < bRome)) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("throws Exception-incorrect expression ");
                        // e.printStackTrace();
                    }
                }
            } else {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("throws Exception-incorrect expression ");
                    // e.printStackTrace();
                }
            }
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("throws Exception-Wrong expression");

            //System.out.println("incorrect expression");
        }
    }
}
