package pl.javastart.task;

public class Phone {
    private double balance;
    private double smsCost;
    private double mmsCost;
    private double oneMinuteTalkCost;
    private int secondsOfTalk;
    private int numberOfSmsSent = 0;
    private int numberOfMmsSent = 0;
    private boolean mixContractInfo;
    private boolean cardContractInfo;
    private boolean subscriptionContractInfo;
    private int amountOfSms;
    private int amountOfMms;
    private double amountOfTalk;
    private static final double PRICE_FOR_ONE_MINUTE_TALK = 0.5;
    private static final  double PRICE_FOR_ONE_SMS = 0.1;
    private static final double PRICE_FOR_ONE_MMS = 0.2;
    
    public Phone(MixPhoneContract mixPhoneContract) {
        amountOfMms = mixPhoneContract.getAmountOfMms();
        amountOfTalk = mixPhoneContract.getAmountOfTalk();
        amountOfSms = mixPhoneContract.getAmountOfSms();
        balance = mixPhoneContract.getAccountBalance();
        mixContractInfo = true;
    }

    public Phone(CardPhoneContract cardPhoneContract) {
        balance = cardPhoneContract.getBalance();
        smsCost = cardPhoneContract.getSmsCost();
        oneMinuteTalkCost = cardPhoneContract.getOneMinuteTalkCost();
        mmsCost = cardPhoneContract.getMmsCost();
        cardContractInfo = true;

    }

    public Phone(SubscriptionPhoneContract subscriptionPhoneContract) {
        subscriptionContractInfo = true;
    }

    public Phone() {
    }

    public void printAccountState() {
        if (subscriptionContractInfo) {
            printGeneralInfoAboutAccount();
            System.out.println("Abonament: " + SubscriptionPhoneContract.getPrice() + " zł");
        } else if (cardContractInfo) {
            printGeneralInfoAboutAccount();
            System.out.printf("Na koncie zostało: " + " %.2f" + " zł\n", balance);
        } else if (mixContractInfo) {
            printGeneralInfoAboutAccount();
            System.out.printf("Pozostałe SMS'y: " + amountOfSms + "\nPozostałe MMS'y: " + amountOfMms + "\nPozostałe minuty: "
                    + amountOfTalk + "\nStan konta: " + " %.2f" + " zł\n", balance);
        }
    }

    private void printGeneralInfoAboutAccount() {
        System.out.println();
        System.out.println("=== STAN KONTA ===");
        System.out.println("Wysłanych SMSów: " + numberOfSmsSent);
        System.out.println("Wysłanych MMSów: " + numberOfMmsSent);
        System.out.println("Liczba sekund rozmowy: " + secondsOfTalk);
    }
    
    public void sendSms() {
        System.out.println();
        if (cardContractInfo) {
            if (balance >= smsCost) {
                System.out.println("SMS wysłany");
                balance -= smsCost;
                numberOfSmsSent++;
            } else {
                System.out.println("Nie udało się wysłać wiadomości");
            }
        } else if (subscriptionContractInfo) {
            numberOfSmsSent++;
        } else if (mixContractInfo) {
            if (amountOfSms > 0) {
                amountOfSms--;
                numberOfSmsSent++;
                System.out.println("SMS wysłany");
            } else {
                numberOfSmsSent++;
                balance -= PRICE_FOR_ONE_SMS;
                System.out.println("SMS wysłany");
            }
        }
    }

    public void sendMms() {
        System.out.println();
        if (cardContractInfo) {
            if (balance >= mmsCost) {
                System.out.println("MMs wysłany");
                balance -= mmsCost;
                numberOfMmsSent++;
            } else {
                System.out.println("Nie udało się wysłać wiadomości");
            }
        } else if (subscriptionContractInfo) {
            numberOfMmsSent++;
        } else if (mixContractInfo) {
            if (amountOfMms >= 1) {
                amountOfMms--;
                numberOfMmsSent++;
                System.out.println("MMs wysłany");
            } else {
                numberOfMmsSent++;
                balance -= PRICE_FOR_ONE_MMS;
                System.out.println("MMs wysłany");
            }
        }
    }

    public void call(int seconds) {
        System.out.println();
        double priceForGivenSeconds = seconds * oneMinuteTalkCost / 60;

        if (cardContractInfo) {
            if (balance > priceForGivenSeconds) {
                secondsOfTalk += seconds;
                balance -= priceForGivenSeconds;
                System.out.println("Rozmowa trwała: " + seconds + " sec\n");

            } else if (balance <= priceForGivenSeconds) {
                double priceDifference = priceForGivenSeconds - balance;
                double priceLeft = priceForGivenSeconds - priceDifference;
                double timeDifference = (priceLeft * 60 / oneMinuteTalkCost);
                System.out.println("przerwano połączenie");
                secondsOfTalk += timeDifference;
                balance -= priceLeft;
                System.out.println("Rozmowa trwała: " + timeDifference + " sec\n");
            }
        } else if (subscriptionContractInfo) {
            secondsOfTalk += seconds;
        } else if (mixContractInfo) {
            double amountOfTalkInSeconds = amountOfTalk * 60;
            if (amountOfTalkInSeconds > seconds) {
                secondsOfTalk += seconds;
                double secondsToMin = seconds / 60.0;
                amountOfTalk -= secondsToMin;
                System.out.println("Rozmowa trwała: " + seconds + " sec\n");
            } else if (amountOfTalkInSeconds <= seconds) {
                double timeDifference = seconds - amountOfTalkInSeconds;
                double timeDifference2 = seconds - timeDifference;
                double timeDifference3 = timeDifference * PRICE_FOR_ONE_MINUTE_TALK / 60;
                amountOfTalk -= timeDifference2 / 60;
                secondsOfTalk += seconds;
                balance -= timeDifference3;
                System.out.println("Rozmowa trwała: " + seconds + " sec\n");
                
            }
        }
    }

}


