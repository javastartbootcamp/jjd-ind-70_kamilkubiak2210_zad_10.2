package pl.javastart.task;

public class Main {

    public static void main(String[] args) {
        Phone phone = new Phone(new CardPhoneContract(1, 1, .2, .5));

        phone.printAccountState();

        phone.sendSms();

        phone.printAccountState();

        phone.call(90);

        phone.printAccountState();

        phone.sendSms();

        phone.printAccountState();

        phone.call(60);

        phone.printAccountState();

        phone.sendMms();

        phone.printAccountState();

        phone.sendMms();

        phone.printAccountState();

    }
}
