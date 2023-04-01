package homework_03.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Processing {
    public static int dataCount = 6;

    private String firstname;
    private String lastname;
    private String patronymic;
    private LocalDate birthday;
    private Long phone;
    private Gender gender;

    public Processing() {
    }

    public void CheckProcessing(String[] splitedString) throws Parsing {
        if (splitedString == null) {
            throw new NullPointerException("Нет данных");
        }

        StringBuilder fullErrorsMessages = new StringBuilder();
        for (String string : splitedString) {
            if (Character.isLetter(string.charAt(0))) {
                if (string.length() == 1) {
                    if (this.gender == null) {
                        try {
                            this.gender = checkGender(string);
                        } catch (GenderExceptions e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Пол указан больше 1 раза\n");
                    }
                } else {
                    if (this.lastname == null) {
                        try {
                            this.lastname = checkName(string);
                        } catch (NameExceptions e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else if (this.firstname == null) {
                        try {
                            this.firstname = checkName(string);
                        } catch (NameExceptions e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else if (this.patronymic == null) {
                        try {
                            this.patronymic = checkName(string);
                        } catch (NameExceptions e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Слишком много элементов распознаны как ФИО.\n");
                    }
                }
            } else {

                if (string.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}")) {
                    if (this.birthday == null) {
                        try {
                            this.birthday = checkBirthday(string);
                        } catch (BirthdayExceptions e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Дата рождения должна быть только одна, а обнаружены две: '"
                                + this.birthday + "','" + string + "'\n");
                    }
                } else {
                    if (this.phone == null) {
                        try {
                            this.phone = checkPhone(string);
                        } catch (PhoneExceptions e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Должен быть только один телефонный норме, а не несколько: '"
                                + this.phone + "','" + string + "'\n");
                    }
                }

            }
        }
        if (!fullErrorsMessages.isEmpty()) {
            throw new Parsing(fullErrorsMessages.toString());
        }
    }

    public String getLastname() {
        return lastname;
    }

    private String checkName(String inputString) throws NameExceptions {
        if (inputString.toLowerCase().matches("^[a-zа-яё]*$")) {
            return inputString;
        } else {
            throw new NameExceptions(inputString);
        }
    }

    private long checkPhone(String inpuString) throws PhoneExceptions {
        if (inpuString.length() == 10) {
            try {
                return Long.parseLong(inpuString);
            } catch (NumberFormatException e) {
                throw new PhoneExceptions(inpuString);
            }
        } else {
            throw new PhoneExceptions(inpuString);
        }
    }

    private Gender checkGender(String inputString) throws GenderExceptions {
        try {
            return Gender.valueOf(inputString);
        } catch (IllegalArgumentException e) {
            throw new GenderExceptions(inputString);
        }
    }

    private LocalDate checkBirthday(String inputString) throws BirthdayExceptions {
        try {
            return LocalDate.parse(inputString,
                    DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            throw new BirthdayExceptions(inputString);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(lastname).append(">")
                .append("<").append(firstname).append(">")
                .append("<").append(patronymic).append(">")
                .append("<").append(birthday.toString()).append(">")
                .append("<").append(phone).append(">")
                .append("<").append(gender).append(">");
        return sb.toString();
    }

}
