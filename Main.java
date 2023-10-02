public class Main {
    public static void main(String[] args) {
        boolean flag = true;

        String[] input = null;
        
        input = Terminal.terminalInput("Введите через пробел: ФИО Дату рождения (ДД.ММ.ГГГГ) Телефон(только цифры) Пол(f/m):");                                           //Ask the user on Terminal
        String exceptionCode = PersonInputSizeChecker.check(input);
        ExceptionCodeRunner.runCode(exceptionCode);

        
        try {
            Person person = new Person(PersonInputStringsParser.parse(input));
            System.out.println("The information is valid.");
            System.out.println(person);
            FileWriterPerson.write(person);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println("Something went wrong. Please, try again!");
        }

    }
}
