import java.util.LinkedList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import static java.lang.Math.abs;

abstract class PersonInputStringsParser {
    public static String[] parse(String[] rawData) throws RuntimeException {
        String surname = null;
        String firstname = null;
        String patronymic = null;
        String phoneNumber = null;
        String birthDate = null;
        String sex = null;

        for (String element : rawData) {
            //фамилия, имя, отчество - строки
            if (element.matches("[a-zA-Zа-яА-ЯЁё]+") && element.length() > 1) {
                if (surname == null) {
                    surname = element;
                    continue;
                } else if (firstname == null) {
                    firstname = element;
                    continue;
                } else if (patronymic == null) {
                    patronymic = element;
                    continue;
                }
            }
            //номертелефона - целое беззнаковое число без форматирования
            if (isUnsignedIntNumeric(element)) {
                phoneNumber = element;
                continue;
            }
            //датарождения - строка формата dd.mm.yyyy
            if (element.matches("(0[1-9]|[12][0-9]|3[01])[.](0[1-9]|1[0-2])[.](19[0-9][0-9]|20[0-9][0-9])") &&
                    isValidBirthDate(element)) {
                birthDate = element;
                continue;
            }
            //пол - символ латиницей f или m
            if (element.matches("[mfMF]")) {
                sex = element;
            }
        }

        String[] parsedData = new String[6];
        if (firstname == null || surname == null || patronymic == null) {
            throw new RuntimeException("The correct firstname, surname or patronymic were not found.");
        } else {
            parsedData[0] = firstname;
            parsedData[1] =surname;
            parsedData[2] = patronymic;
        }
        if (phoneNumber == null) {
            throw new RuntimeException("The correct phone number was not found.");
        } else {
            parsedData[3] =phoneNumber;
        }
        if (birthDate == null) {
            throw new RuntimeException("The correct birthdate was not found.");
        } else {
            parsedData[4] = birthDate;
        }
        if (sex == null) {
            throw new RuntimeException("The correct gender was not found.");
        } else {
            parsedData[5] =sex;
        }

        return parsedData;
    }

    public static boolean isUnsignedIntNumeric(String str) {
        try {
            int num = Integer.parseInt(str);
            return num == abs(num) ? true : false;//check Unsigned
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidBirthDate(String str) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate DateOfBirth = LocalDate.parse(str, formatter);
            LocalDate currentDate = LocalDate.now();
            if (DateOfBirth.compareTo(currentDate) > 0 || DateOfBirth.getYear() < currentDate.getYear() - 150) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}