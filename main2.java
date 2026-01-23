package practice;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class main2 {
    static final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        boolean running = true;

        while (running) {
            int rounds = 0;
            int time = 0;
            int score = 0;
            int user_count_letters = 0;
            boolean start_game = false;

            System.out.println("\n=== ГРА ЗАПОМ'ЯТАЙ ЛIТЕРИ У ПРАВИЛЬНІЙ ПОСЛIДОВНОСТI ===");
            System.out.println("--= Головне меню =--");
            System.out.println("1. Обрати рiвень складностi");
            System.out.println("2. Обрати свої налаштування");
            System.out.println("3. Вийти з гри");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.println("---Оберiть рiвень складностi---");
                    System.out.println("1. Легка (2 раунди, 5 сек, 3 літери)");
                    System.out.println("2. Середня (4 раунди, 3 сек, 5 літер)");
                    System.out.println("3. Для кiтайцив (5 раундів, 1 сек, 6 літер)");
                    int difficulty = sc.nextInt();
                    sc.nextLine();

                    if (difficulty == 1) {
                        rounds = 3; time = 5000; user_count_letters = 4;
                    } else if (difficulty == 2) {
                        rounds = 4; time = 3000; user_count_letters = 5;
                    } else {
                        rounds = 5; time = 1500; user_count_letters = 6;
                    }
                    start_game = true;
                    break;

                case 2:
                    System.out.println("Оберiть кiлькiсть раундiв (3, 4 або 5): ");
                    rounds = sc.nextInt();
                    System.out.println("Виберiть час (2, 3 або 5 секунд): ");
                    int user_time = sc.nextInt();
                    time = user_time * 1000;
                    System.out.println("Оберiть кiлькiсть лiтер: ");
                    user_count_letters = sc.nextInt();
                    sc.nextLine();
                    start_game = true;
                    break;

                case 3:
                    running = false;
                    System.out.println("Бувай!");
                    break;

                default:
                    System.out.println("Невiрний вибiр!");
            }

            if (start_game) {
                char[] secret_letters = new char[user_count_letters];

                System.out.println("Гра розпочалась 😈😈😈!!!");
                Thread.sleep(1000);

                for (int i = 1; i <= rounds; i++) {
                    System.out.println("\nРаунд " + i);
                    System.out.println("Запам'ятайте лiтери!!!");

                    for (int j = 0; j < user_count_letters; j++) {
                        char letter = alphabet.charAt(rand.nextInt(alphabet.length()));
                        System.out.print(letter + " ");
                        secret_letters[j] = letter;
                    }
                    System.out.println();

                    Thread.sleep(time);

                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                    System.out.println("Введiть лiтери у правильнiй послiдовностi: ");
                    String user_input = sc.nextLine();
                    String secret = new String(secret_letters);

                    if (user_input.equals(secret)) {
                        score++;
                        System.out.printf("Вiрно, у вас %d балiв\n", score);
                    } else {
                        System.out.print("\007");
                        System.out.printf("Не вiрно! Було: %s. У вас %d балiв\n", secret, score);
                    }
                }

                System.out.println("\n=== Пiдсумок ===");
                if (score >= rounds - 1) {
                    System.out.printf("Вiтаю, ви перемогли! Балiв: %d/%d\n", score, rounds);
                } else {
                    System.out.printf("Нажаль, ви програли. Балiв: %d/%d\n", score, rounds);
                }
            }
        }
        sc.close();
    }
}