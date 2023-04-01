package homework_03.Model;

public class NameExceptions extends Exception {

    String inputString;

    public NameExceptions(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Неправильный формат ФИО '" + inputString + "'. ФИО могут состоять только из букв.\n";
    }
}