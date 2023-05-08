package pl.javastart.task;

public class CardPhoneContract implements Contract {
    protected double balance;
    protected final double smsCost;
    protected final double mmsCost;
    protected final double oneMinuteTalkCost;

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
        double priceForGivenSeconds = seconds * oneMinuteTalkCost / 60;

        if (balance > priceForGivenSeconds) {
            balance -= priceForGivenSeconds;
            return seconds;

        } else {
            double priceDifference = priceForGivenSeconds - balance;
            double priceLeft = priceForGivenSeconds - priceDifference;
            double timeDifference = (priceLeft * 60 / oneMinuteTalkCost);
            balance -= priceLeft;
            return (int) timeDifference;
        }
    }

    @Override
    public void printAccount() {
        System.out.printf("Na koncie zostało: " + " %.2f" + " zł\n", balance);
    }

}
