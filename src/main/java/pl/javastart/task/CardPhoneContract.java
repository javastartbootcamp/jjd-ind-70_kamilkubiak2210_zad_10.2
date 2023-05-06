package pl.javastart.task;

public class CardPhoneContract implements Contract {
    private double balance;
    private double timeDifference;
    private final double smsCost;
    private final double mmsCost;
    private final double oneMinuteTalkCost;

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
    public boolean call(int seconds) {
        double priceForGivenSeconds = seconds * oneMinuteTalkCost / 60;
        if (balance > priceForGivenSeconds) {
            balance -= priceForGivenSeconds;
            return true;

        } else if (balance <= priceForGivenSeconds) {
            double priceDifference = priceForGivenSeconds - balance;
            double priceLeft = priceForGivenSeconds - priceDifference;
            timeDifference = (priceLeft * 60 / oneMinuteTalkCost);
            balance -= priceLeft;

        }
        return false;
    }

    @Override
    public void printAccount() {
        System.out.printf("Na koncie zostało: " + " %.2f" + " zł\n", balance);
    }

    @Override
    public int timeDiffer() {
        return (int) timeDifference;
    }

}
