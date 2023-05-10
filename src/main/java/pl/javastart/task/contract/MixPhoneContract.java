package pl.javastart.task.contract;

public class MixPhoneContract extends CardPhoneContract {

    int amountOfSms;
    int amountOfMms;
    double amountOfTalk;

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
            return super.sendSms();
        }
    }

    @Override
    public boolean sendMms() {
        if (amountOfMms > 0) {
            amountOfMms--;
            return true;
        } else {
            return super.sendMms();
        }
    }

    @Override
    public int call(int seconds) {
        double amountOfTalkInSeconds = amountOfTalk * oneMinuteInSeconds;

        if (amountOfTalkInSeconds >= seconds) {

            amountOfTalk = (amountOfTalkInSeconds - seconds) / oneMinuteInSeconds;
            return seconds;

        } else {
            double secondsDifference = seconds - amountOfTalkInSeconds;
            double priceForSecondsDifference = secondsDifference * oneMinuteTalkCost / oneMinuteInSeconds;

            if (balance - priceForSecondsDifference >= 0) {

                amountOfTalk = 0;
                balance -= priceForSecondsDifference;
                return (int) (secondsDifference + amountOfTalkInSeconds);

            } else {

                amountOfTalk = 0;
                double balanceSecondsTalk = balance * oneMinuteInSeconds / oneMinuteTalkCost;
                balance -= balance;
                return (int) (amountOfTalkInSeconds + balanceSecondsTalk);

            }
        }
    }

    @Override
    public void printAccount() {
        System.out.printf("Pozostałe SMS'y: " + amountOfSms + "\nPozostałe MMS'y: " + amountOfMms + "\nPozostałe minuty: %.2f"
                + "\nStan konta: " + " %.2f" + " zł\n", amountOfTalk, balance);
    }
}