import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Calc {
    public static void main(String[] args) throws Exception {
        int value1 = 0;
        int value2 = 0;
        String operation = null;

        System.out.println("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b." +
                " Введите задачу представленного вида: ");
        Scanner lineScanner = new Scanner(System.in);
        String parsedLine = lineScanner.nextLine();
        String[] elements = parsedLine.split( " ");
        if (elements.length != 3) {
            throw new Exception("Формат математической операции не удовлятворяет заданию: введите два операнда и оператор");
        }
        Scanner scanner = new Scanner(new ByteArrayInputStream(parsedLine.getBytes()));
        String[] romans = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX" };
        if (scanner.hasNextInt()) {
            value1 = scanner.nextInt();
            operation = scanner.next();
            if (scanner.hasNextInt()) {
                value2 = scanner.nextInt();
                if (value1 > 0 && value1 < 11 && value2 > 0 && value2 < 11) {
                    switch (operation){
                        case "+": System.out.println(value1 + value2);
                            break;
                        case "-": System.out.println(value1 - value2);
                            break;
                        case "*": System.out.println(value1 * value2);
                            break;
                        case "/": System.out.println(value1 / value2);
                            break;
                        default: throw new Exception("Формат математической операции не удовлетворяет заданию: неподдерживаемый оператор");
                    }
                } else throw new Exception("Формат математической операции не удовлетворяет заданию: Калькулятор принимает на вход числа от 1 до 10 включительно, не более.");
            } else { String Test1 = scanner.next();
                for (int i = 0; i < 10; i++) {
                    if (romans[i].equals(Test1)) {
                        throw new Exception("Формат математической операции не удовлетворяет заданию: используются одновременно разные системы счисления");  //второе;
                    }}}
            //второе введенное не число
        } else {
            String val1 = scanner.next();
            String operat1 = scanner.next();
            if (scanner.hasNextInt()) {
                throw new Exception("Формат математической операции не удовлетворяет заданию: строка не является математической операцией");   //первое
            } //первое введенное не число
            else {
                String val2 = scanner.next();
                int vals1 = 0;
                for (int i = 0; i < 10; i++) {
                    if (romans[i].equals(val1)) {
                        vals1 = (i + 1);
                    }
                }
                int vals2 = 0;
                for (int j = 0; j < 10; j++) {
                    if (romans[j].equals(val2)) {
                        vals2 = (j + 1);
                    }
                }
                if (vals1 > 0 && vals1 < 11 && vals2 > 0 && vals2 < 11) {
                    int rezs1 = 0;
                    switch(operat1){
                        case "+":
                            rezs1 = (vals1 + vals2)-1;
                            System.out.println(romans[rezs1]);
                            break;
                        case "-":
                            rezs1 = (vals1 - vals2)-1;
                            if (rezs1 <=0 ) throw new Exception("Формат математической операции не удовлетворяет заданию: в римской системе нет отрицательных чисел (и нуля)");
                            else System.out.println(romans[rezs1]);
                            break;
                        case "*":
                            rezs1 = (vals1 * vals2);
                            int desuat = rezs1/10;
                            int rezs2 = (rezs1-10*desuat);
                            if (rezs2 != 0) {
                                rezs2 = rezs2 - 1;
                            }
                            switch(desuat){
                                case 0: System.out.println(romans[rezs2]); break;
                                case 1: System.out.println("X"+romans[rezs2]); break;
                                case 2: System.out.println("XX"+romans[rezs2]); break;
                                case 3: System.out.println("XXX"+romans[rezs2]); break;
                                case 4: System.out.println("XL"+romans[rezs2]); break;
                                case 5: System.out.println("L"+romans[rezs2]); break;
                                case 6: System.out.println("LX"+romans[rezs2]); break;
                                case 7: System.out.println("LXX"+romans[rezs2]); break;
                                case 8: System.out.println("LXXX"+romans[rezs2]); break;
                                case 9: System.out.println("XC"); break;
                                case 10: System.out.println("C"); break;
                            }
                            break;
                        case "/":
                            rezs1 = (vals1 / vals2)-1;
                            System.out.println(romans[rezs1]);
                            break;
                    }
                } else throw new Exception("Формат математической операции не удовлетворяет заданию: Калькулятор принимает на вход числа от 1 до 10 включительно, не более.");
            }
        }
    }
}