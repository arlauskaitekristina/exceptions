package homework_03.Model;

public class GenderExceptions extends Exception {
    String inputString;

    public GenderExceptions(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Неправильно указан пол (используйте только латинские буквы f или m), а не '" + inputString + "'\n";
    }
}