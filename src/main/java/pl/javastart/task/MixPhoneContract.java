package pl.javastart.task;

public class MixPhoneContract extends CardPhoneContract {

    private int amountOfSms;
    private int amountOfMms;
    private double amountOfTalk;

    public MixPhoneContract(double balance, double smsCost, double mmsCost, double oneMinuteTalkCost, int amountOfSms, int amountOfMms, int amountOfTalk) {
        super(balance, smsCost, mmsCost, oneMinuteTalkCost);
        this.amountOfSms = amountOfSms;
        this.amountOfMms = amountOfMms;
        this.amountOfTalk = amountOfTalk;
    }

    @Override
    public boolean sendSms() {
        if (amountOfSms > 0) {
            amountOfSms--;
            return true;
        } else {
            balance -= smsCost;
        }
        return true;
    }

    @Override
    public boolean sendMms() {
        if (amountOfMms > 0) {
            amountOfMms--;
            return true;
        } else {
            balance -= mmsCost;
        }
        return true;
    }

    @Override
    public int call(int seconds) {
        double amountOfTalkInSeconds = amountOfTalk * 60;
        if (amountOfTalkInSeconds >= seconds) {
            double secondsToMin = seconds / 60.0;
            amountOfTalk -= secondsToMin;
            return seconds;
        } else {
            double secondsDifference = seconds - amountOfTalkInSeconds;
            amountOfTalk -= amountOfTalkInSeconds / 60;

            return super.call((int) secondsDifference);
        }
    }

    @Override
    public void printAccount() {
        System.out.printf("Pozostałe SMS'y: " + amountOfSms + "\nPozostałe MMS'y: " + amountOfMms + "\nPozostałe minuty: %.2f"
                + "\nStan konta: " + " %.2f" + " zł\n", amountOfTalk, balance);
    }
}