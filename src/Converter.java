public class Converter {
    int distance = 75;
    int kilocalories = 50;

    int convertToKm(int sumSteps) {
        int sum = (distance * sumSteps) / 100_000;
        return sum;
    }

    int convertStepsToKilocalories(int sumSteps) {
        int answer = sumSteps * kilocalories / 1_000;
        return answer;
    }
}