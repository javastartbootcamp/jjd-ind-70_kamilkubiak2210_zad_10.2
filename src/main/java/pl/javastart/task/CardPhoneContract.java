package pl.javastart.task;

public class CardPhoneContract extends Phone {
    private final double balance;
    private final double smsCost;
    private final double mmsCost;
    private final double oneMinuteTalkCost;

    public CardPhoneContract(double balance, double smsCost, double mmsCost, double oneMinuteTalkCost) {
        this.balance = balance;
        this.smsCost = smsCost;
        this.mmsCost = mmsCost;
        this.oneMinuteTalkCost = oneMinuteTalkCost;
    }

    public double getBalance() {
        return balance;
    }

    public double getSmsCost() {
        return smsCost;
    }

    public double getMmsCost() {
        return mmsCost;
    }

    public double getOneMinuteTalkCost() {
        return oneMinuteTalkCost;
    }

}
