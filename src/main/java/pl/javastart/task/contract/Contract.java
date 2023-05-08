package pl.javastart.task.contract;

public interface Contract {
    boolean sendSms();

    boolean sendMms();

    int call(int seconds);

    void printAccount();
}
