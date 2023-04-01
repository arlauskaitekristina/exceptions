package homework_03.Presenter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import homework_03.Model.Parsing;
import homework_03.Model.Processing;
import homework_03.View.View;
 
public class Presenter< V extends View> {

    private Processing model;
    private V view;

    public Presenter(V v) {
        view = v;
    }

    public void start() {
        boolean wokring = true;
        do {
            String input = view.getInput(
                    "Введите данные через пробел: Фамилию, Имя, Отчество, Дату рождения(дд.мм.гггг), Номер телефона(10 цифр), Пол(f/m), или Exit для прекращения программы: ");
            if (input.equals("Exit")) {
                wokring = false;
                break;
            } else {
                String[] splitedInput = input.replaceAll("\\s+", " ").split(" ");

                int inputDataCount = checkInputDataCount(splitedInput.length);
                if (inputDataCount == -1) {
                    view.printOutput("Слишком мало данных на вводе (должно быть " + Processing.dataCount
                            + " разделённых пробелом ' ': Фамилия Имя Отчество НомерТелефона ДатаРождения Пол)\n");
                } else if (inputDataCount == 0) {
                    view.printOutput("Слишком много данных на вводе (должно быть " + Processing.dataCount
                            + " разделённых пробелом ' ': Фамилия Имя Отчество НомерТелефона ДатаРождения Пол)\n");
                } else {
                    try {
                        model = new Processing();
                        model.CheckProcessing(splitedInput);
                        writePersonData(model);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Parsing e) {
                        view.printOutput(e.getMessage());
                    }
                }
            }
        } while (wokring);
    }

    // по заданию проверяем кол-во введённых данных через возврат кода ошибки при
    // несоответствии
    private int checkInputDataCount(int inputDataCount) {
        if (inputDataCount < Processing.dataCount) {
            return -1;
        } else if (inputDataCount > Processing.dataCount) {
            return 0;
        } else {
            return inputDataCount;
        }
    }
    
    //создаём или подключаемся к фаилу по фамилии и дописываем туда новые данные
    private void writePersonData(Processing data) throws IOException {
        File filepath = new File(data.getLastname());
        try (FileWriter fw = new FileWriter(filepath, true)) {
            fw.append(data.toString() + "\n");
        } catch (IOException e) {
            throw e;
        }
    }
}