package pl.javastart.task.contract;

public class SubscriptionPhoneContract implements Contract {

    double price;

    public SubscriptionPhoneContract(double price) {
        this.price = price;
    }

    @Override
    public boolean sendSms() {
        return true;
    }

    @Override
    public boolean sendMms() {
        return true;
    }

    @Override
    public int call(int seconds) {
        return seconds;
    }

    @Override
    public void printAccount() {
        System.out.println("Abonament: " + price + " zł");
    }

}
