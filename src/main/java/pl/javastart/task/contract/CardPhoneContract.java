package pl.javastart.task.contract;

public class CardPhoneContract implements Contract {
    double balance;
    final double smsCost;
    final double mmsCost;
    final double oneMinuteTalkCost;
    final double oneMinuteInSeconds = 60.0;

    public CardPhoneContract(double balance, double smsCost, double mmsCost, double oneMinuteTalkCost) {
        this.balance = balance;
        this.smsCost = smsCost;
        this.mmsCost = mmsCost;
        this.oneMinuteTalkCost = oneMinuteTalkCost;
    }

    @Override
    public boolean sendSms() {
        if (balance >= smsCost) {
            balance -= smsCost;
            return true;
        }
        return false;
    }

    @Override
    public boolean sendMms() {
        if (balance >= mmsCost) {
            balance -= mmsCost;
            return true;
        }
        return false;
    }

    @Override
    public int call(int seconds) {
        double priceForGivenSeconds = seconds * oneMinuteTalkCost / oneMinuteInSeconds;

        if (balance > priceForGivenSeconds) {
            balance -= priceForGivenSeconds;
            return seconds;
        } else {
            double timeDifference = balance * oneMinuteInSeconds / oneMinuteTalkCost;
            double price = timeDifference * oneMinuteTalkCost / oneMinuteInSeconds;
            balance -= price;
            return (int) timeDifference;
        }
    }

    @Override
    public void printAccount() {
        System.out.printf("Na koncie zostało: " + " %.2f" + " zł\n", balance);
    }

}
