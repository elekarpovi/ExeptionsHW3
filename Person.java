import java.util.LinkedList;
import java.util.Locale;

public class Person {
    String firstname;
    String surname;
    String patronymic;
    String birthDate;
    String phoneNumber;
    String sex;

    Person(String[] data){
        this.firstname = data[0].toUpperCase();
        this.surname = data[1].toUpperCase();
        this.patronymic = data[2].toUpperCase();
        this.birthDate = data[3];
        this.phoneNumber = data[4];
        this.sex = data[5].toLowerCase();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        stringBuilder.append(surname);
        stringBuilder.append("><");
        stringBuilder.append(firstname);
        stringBuilder.append("><");
        stringBuilder.append(patronymic);
        stringBuilder.append("><");
        stringBuilder.append(birthDate);
        stringBuilder.append("><");
        stringBuilder.append(phoneNumber);
        stringBuilder.append("><");
        stringBuilder.append(sex);
        stringBuilder.append(">");
        stringBuilder.append("\n");
        return stringBuilder.toString();//<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
    }
}
