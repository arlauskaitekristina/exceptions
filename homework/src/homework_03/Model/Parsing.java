package homework_03.Model;

public class Parsing extends Exception {
    String message;

    public Parsing(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}