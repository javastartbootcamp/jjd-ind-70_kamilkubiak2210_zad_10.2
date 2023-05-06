package pl.javastart.task;

public interface Contract {
    boolean sendSms();

    boolean sendMms();

    boolean call(int seconds);

    void printAccount();

    int timeDiffer();
}
