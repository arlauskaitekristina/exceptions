package homework_03.Model;

public class PhoneExceptions extends Exception {
    String inputString;

    public PhoneExceptions(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Не получилось преобразовать " + inputString + " в телефонный номер, (нужный формат телефона 10 цифр без разделителей 5556667788)\n";
    }
}