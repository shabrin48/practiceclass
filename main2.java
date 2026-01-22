package practice;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class main2 {
    static final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int rounds;
        int time;
        int score = 0;
        String user_letters;
        int user_count_letters;

        System.out.println("===ГРА ЗАПОМ'ЯТАЙ ЛIТЕРИ У ПРАВЕЛЬНIЙ ПОСЛIДОВНОСТI===");

        System.out.println("--=Головне меню=--");
        System.out.println("1. Обрати рівень складності");
        System.out.println("2. Обрати свої налаштуння");
        int setting_score = sc.nextInt();

        switch (setting_score) {
            case 1:
        }

        System.out.println("Оберiть кiлькiсть раундiв\n3, 4 або 5 раундiв: ");
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
                System.out.println("Невiрне обрана кiлькiсть раундiв\nУставленна кiлькiсть раундiв 3");
                rounds = 3;
        }

        System.out.println("Виберiть час для запом'ятовування\n2, 3 або 5 секунд: ");
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
                System.out.println("Невiрний обраний час!!!\nУстановленний час: 3 секунди");
        }

        System.out.println("Оберiть кiлькiсть лiтер");
        user_count_letters = sc.nextInt();
        char[] secret_letters = new char[user_count_letters];
        sc.nextLine();

        System.out.println("Гра розпочалась😈😈😈!!!");

        for (int i = 1; i <= rounds; i++) {
            System.out.println("\nРаунд " + i);
            System.out.println("Запом'ятайте лiтери!!!");
            for (int j = 0; j < user_count_letters; j++) {
                char letter = alphabet.charAt(rand.nextInt(alphabet.length()));
                System.out.print(letter + " ");
                secret_letters[j] = letter;
            }

            Thread.sleep(time); // задержка
            // очистка
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            System.out.println("\nВведiть лiтерi у правельнiй послiдовностi: ");
            user_letters = sc.nextLine();
            String secret = new String(secret_letters).trim();

            if (user_letters.equals(secret)) {
                score++;
                System.out.printf("\nВiрно, у вас %d балiв", score);
            } else {
                System.out.printf("\nНе вiрно!!! У вас %d балiв", score);
            }
        }

        System.out.println("\n===Пiдсумок===");
        if (score >= rounds - 1) {
            System.out.printf("Вiтаю, ви перемогли!!!\nУ вас %d балiв!!!", score);
        } else {
            System.out.printf("Нажаль, ви програли((\nУ вас %d балiв\nСпробуйте ще раз😘", score);
        }
        sc.close();
    }
}