package homework_03.Model;

public class BirthdayExceptions extends Exception {
    
    String inputString;

    public BirthdayExceptions(String inputString) {
        this.inputString = inputString;
    }

    @Override
    public String getMessage() {
        return "Ошибка при вводе даты '" + inputString + "', требуем формат 'дд.мм.гггг'.\n";
    }
}