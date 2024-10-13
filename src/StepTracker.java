import java.util.Scanner;

class StepTracker {
    Converter converter = new Converter();
    MonthData dataMonth = new MonthData();
    MonthData[] monthToData = new MonthData[12];
    Scanner scanner;
    int goalByStepsPerDay = 10000;


    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int monthNum = scanner.nextInt();
        if (monthNum < 1 || monthNum > 12) {
            System.out.println("Неверный номер месяца");
            return;
        }
        System.out.println("Введите день от 1 до 30 (включительно)");
        int dayNum = scanner.nextInt();
        if (dayNum < 1 || dayNum > 30) {
            System.out.println("Введен некорректный день");
            return;
        }

        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();

        if (steps <= 0) {
            System.out.println("Указано неверное количество шагов");
        }
        MonthData dataMonth = monthToData[monthNum - 1];

        dataMonth.days[dayNum - 1] = steps;
    }

    void changeStepGoal() {
        System.out.println("Какая у вас цель шагов за день?");
        int goal = scanner.nextInt();
        if (goal > 0) {
            System.out.println("Сохранено!");
            goalByStepsPerDay = goal;
        } else {
            System.out.println("Цель должна быть больше нуля!");
        }
    }

    void printStatistic() {

        System.out.println("Введите число месяца");
        int month = scanner.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Ошибка");
        } else {
            System.out.println("Вот статистика за " + month + " месяц:");
        }

        dataMonth = monthToData[month - 1];
        int sumSteps = dataMonth.sumStepsFromMonth();
        dataMonth.printDaysAndStepsFromMonth();
        System.out.println("За этот месяц вы прошли " + sumSteps + " шагов");
        int maxSteps = dataMonth.maxSteps();
        System.out.println("Максимально пройденное количество шагов за месяц составило " + maxSteps);
        int sum = converter.convertToKm(sumSteps);
        System.out.println("За этот месяц вы прошли " + sum + " километров");
        int answer = converter.convertStepsToKilocalories(sumSteps);
        System.out.println("За этот месяц вы сожгли " + answer + " килокалорий");
        int finalSeries = dataMonth.bestSeries(goalByStepsPerDay);
        System.out.println("Лучшая серия шагов за месяц");
        System.out.println(finalSeries);
        System.out.println();
    }
}
