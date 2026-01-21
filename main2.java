package practice;

import java.util.Random;
import java.util.Scanner;

public class main2 {
    static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int rounds;
        int time;
        int score = 0;
        String user_letters;
        char[] secret_letters = new char[4];

        System.out.println("Оберіть кількість раундів\n3, 4 або 5 раундів: ");
        int user_rounds = sc.nextInt();
        switch (user_rounds) {
            case 3:
                rounds = 3;
                break;
            case 4:
                rounds = 4;
                break;
            case 5:
                rounds = 5;
                break;
            default:
                System.out.println("Невірне обрана кількість раундів\nУставленна кількість раундів 3");
                rounds = 3;
        }

        System.out.println("Виберіть час для запом'ятовування\n2, 3 або 5 секунд: ");
        int user_time = sc.nextInt();
        sc.nextLine();

        switch (user_time) {
            case 2:
                time = 2000;
                break;
            case 3:
                time = 3000;
                break;
            case 5:
                time = 5000;
                break;
            default:
                time = 3000;
                System.out.println("Невірний обраний час!!!\nУстановленний час 3 секунди");
        }

        System.out.println("Гра розпочалась😈😈😈!!!");

        for (int i = 1; i <= rounds; i++) {
            System.out.println("\nРаунд " + i);
            System.out.println("Запом'ятайте літери!!!");
            for (int j = 0; j < 4; j++) {
                char letter = alphabet.charAt(rand.nextInt(alphabet.length()));
                System.out.print(letter + " ");
                secret_letters[j] = letter;
            }

            Thread.sleep(time); // задержка
            // очистка
            for (int h = 0; h < 50; h++) {
                System.out.println();
            }

            System.out.println("\nВведіть літері у правельній послі довності: ");
            user_letters = sc.nextLine().toUpperCase();
            String secret = new String(secret_letters).trim();

            if (user_letters.equals(secret)) {
                score++;
                System.out.printf("\nВірно, у вас %d балів" , score);
            } else {
                System.out.printf("\nНе вірно!!! У вас %d", score);
            }
        }

        System.out.println("\n---Підсумок---");
        if (score >= rounds - 1) {
            System.out.println("Вітаю, ви перемогли!!!");
        } else {
            System.out.println("Нажаль, ви програли((\nСпробуйте ще раз😘");
        }
        sc.close();
    }
}