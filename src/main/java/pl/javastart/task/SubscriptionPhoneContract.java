package pl.javastart.task;

public class SubscriptionPhoneContract implements Contract {

    private static double price;

    public static double getPrice() {
        return price;
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
    public boolean call(int seconds) {

        return true;
    }

    @Override
    public void printAccount() {
        System.out.println("Abonament: " + SubscriptionPhoneContract.getPrice() + " zł");
    }

    @Override
    public int timeDiffer() {
        return 0;
    }
}
