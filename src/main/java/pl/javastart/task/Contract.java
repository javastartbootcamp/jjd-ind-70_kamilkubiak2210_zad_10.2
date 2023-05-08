package pl.javastart.task;

public interface Contract {
    boolean sendSms();

    boolean sendMms();

    int call(int seconds);

    void printAccount();
}
