package pl.javastart.task;

public class Phone {
    private final Contract contract;
    private int secondsOfTalk;
    private int numberOfSmsSent = 0;
    private int numberOfMmsSent = 0;

    public Phone(Contract contract) {
        this.contract = contract;
    }

    public void printAccountState() {
        printGeneralInfoAboutAccount();
        contract.printAccount();
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
        if (contract.sendSms()) {
            System.out.println("SMS wysłany");
            numberOfSmsSent++;
        } else {
            System.out.println("Nie udało się wysłać SMS");
        }
    }

    public void sendMms() {
        System.out.println();
        if (contract.sendMms()) {
            System.out.println("MMS wysłany");
            numberOfMmsSent++;
        } else {
            System.out.println("Nie udało się wysłać MMS");
        }
    }

    public void call(int seconds) {
        System.out.println();
        if (contract.call(seconds)) {
            secondsOfTalk += seconds;
            System.out.println("Rozmowa trwała: " + seconds + " sec\n");
        } else {
            int timeDifference = contract.timeDiffer();
            secondsOfTalk += timeDifference;
            System.out.println("przerwano połączenie");
            System.out.println("Rozmowa trwała: " + timeDifference + " sec\n");
        }
    }

}


