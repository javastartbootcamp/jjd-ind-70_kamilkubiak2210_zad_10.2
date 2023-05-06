package pl.javastart.task;

public class MixPhoneContract extends CardPhoneContract {
    private double balance;
    private int amountOfSms;
    private int amountOfMms;
    private double amountOfTalk;
    private double timeDifference;
    private final double cardContractSmsCost;
    private final double cardContractMmsCost;
    private final double cardContractOneMinutTalkCost;

    public MixPhoneContract(double balance, double smsCost, double mmsCost, double oneMinuteTalkCost, int amountOfSms, int amountOfMms, int amountOfTalk) {
        super(balance, smsCost, mmsCost, oneMinuteTalkCost);
        this.amountOfSms = amountOfSms;
        this.amountOfMms = amountOfMms;
        this.amountOfTalk = amountOfTalk;
        this.balance = balance;
        cardContractSmsCost = smsCost;
        cardContractMmsCost = mmsCost;
        cardContractOneMinutTalkCost = oneMinuteTalkCost;

    }

    @Override
    public boolean sendSms() {
        if (amountOfSms > 0) {
            amountOfSms--;
            return true;
        } else {
            balance -= cardContractSmsCost;
        }
        return true;
    }

    @Override
    public boolean sendMms() {
        if (amountOfMms > 0) {
            amountOfMms--;
            return true;
        } else {
            balance -= cardContractMmsCost;
        }
        return true;
    }

    @Override
    public boolean call(int seconds) {
        double amountOfTalkInSeconds = amountOfTalk * 60;
        if (amountOfTalkInSeconds > seconds) {
            double secondsToMin = seconds / 60.0;
            amountOfTalk -= secondsToMin;

            return true;
        } else if (amountOfTalkInSeconds <= seconds) {
            double timeDifferenceInSeconds = seconds - amountOfTalkInSeconds;
            timeDifference = seconds - timeDifferenceInSeconds;
            double timeDifferencePrice = timeDifferenceInSeconds * cardContractOneMinutTalkCost / 60;

            amountOfTalk -= timeDifference / 60;
            balance -= timeDifferencePrice;

        }
        return true;
    }

    @Override
    public int timeDiffer() {
        return (int) timeDifference;
    }

    @Override
    public void printAccount() {
        System.out.printf("Pozostałe SMS'y: " + amountOfSms + "\nPozostałe MMS'y: " + amountOfMms + "\nPozostałe minuty: "
                + amountOfTalk + "\nStan konta: " + " %.2f" + " zł\n", balance);
    }
}


