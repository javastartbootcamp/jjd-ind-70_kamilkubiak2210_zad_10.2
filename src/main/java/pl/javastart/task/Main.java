package pl.javastart.task;

public class Main {

    public static void main(String[] args) {
        Phone phone = new Phone(new MixPhoneContract(1.5, .1, .2, .5,
                1, 1, 3));

        phone.printAccountState();

        phone.sendSms();

        phone.printAccountState();

        phone.call(90);

        phone.printAccountState();

        phone.sendSms();

        phone.printAccountState();

        phone.call(70);

        phone.printAccountState();

        phone.sendMms();

        phone.printAccountState();

        phone.sendMms();

        phone.printAccountState();

        phone.call(130);

        phone.printAccountState();

    }
}
