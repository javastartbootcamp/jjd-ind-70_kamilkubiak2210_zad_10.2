package pl.javastart.task;

public class MixPhoneContract extends Phone {

    private final int amountOfSms;
    private final int amountOfMms;
    private final int amountOfTalk;
    private final int accountBalance;


    public MixPhoneContract(int amountOfSms, int amountOfMms, int amountOfTalk, int accountBalance) {
        this.amountOfSms = amountOfSms;
        this.amountOfMms = amountOfMms;
        this.amountOfTalk = amountOfTalk;
        this.accountBalance = accountBalance;
    }

    public int getAmountOfSms() {
        return amountOfSms;
    }

    public int getAmountOfMms() {
        return amountOfMms;
    }

    public int getAmountOfTalk() {
        return amountOfTalk;
    }

    public int getAccountBalance() {
        return accountBalance;
    }
}
