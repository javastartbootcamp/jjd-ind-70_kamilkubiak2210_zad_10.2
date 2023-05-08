package pl.javastart.task;

import pl.javastart.task.contract.MixPhoneContract;

public class Main {

    public static void main(String[] args) {
        Phone phone = new Phone(new MixPhoneContract(.5, .1, .2, .5,
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

        phone.call(300);

        phone.printAccountState();
    }
}
