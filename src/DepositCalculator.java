import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double a, double y, int d) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);

        return rounding(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return rounding(amount + amount * yearRate * depositPeriod, 2);
    }

    double rounding(double value, int places) {
        double scaLe = Math.pow(10, places);

        return Math.round(value * scaLe) / scaLe;
    }

    void inputOfDepositAmount() {
        int period;
        int action;

        Scanner deposit = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = deposit.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = deposit.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = deposit.nextInt();
        double outVar = 0;

        if (action == 1) {
            outVar = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            outVar = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outVar);
    }

    public static void main(String[] args) {
        DepositCalculator depositCalculator = new DepositCalculator();
        depositCalculator.inputOfDepositAmount();
    }
}

