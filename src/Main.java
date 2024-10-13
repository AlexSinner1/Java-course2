import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать! Что вы хотите сделать?");
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {
            printMenu();
            int i = scanner.nextInt();
            if (i == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (i == 2) {
                stepTracker.changeStepGoal();
            } else if (i == 3) {
                stepTracker.printStatistic();
            } else if (i == 4) {
                System.out.println("До скорых встреч!");
                break;
            } else {
                System.out.println("Неизвестная команда!");
            }

        }
    }

    static void printMenu() {
        System.out.println("1 - ввести количество шагов за определённый день");
        System.out.println("2 - изменить цель по количеству шагов в день");
        System.out.println("3 - напечатать статистику за определённый месяц");
        System.out.println("4 - выйти из приложения");
    }
}