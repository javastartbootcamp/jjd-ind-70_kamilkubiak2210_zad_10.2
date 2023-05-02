package pl.javastart.task;

public class SubscriptionPhoneContract extends Phone{

    private static double price;


    public SubscriptionPhoneContract(double price) {
        SubscriptionPhoneContract.price =price;
    }

    public static double getPrice() {
        return price;
    }
}
