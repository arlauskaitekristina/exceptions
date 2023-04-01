package homework_03;
import homework_03.Presenter.Presenter;
import homework_03.View.ConsoleView;
import homework_03.View.View;

public class Main {
    public static void main(String[] args) {
        Presenter<View> prog = new Presenter<View>(new ConsoleView());
        prog.start();
    }
}