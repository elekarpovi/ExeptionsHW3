abstract class ExceptionCodeRunner {
    public static void runCode(String code) {

        switch (code) {
            case "200" -> {}
            case "300" -> {System.out.println("Fewer elements than necessary. Please try again!");
            }
            case "350" -> System.out.println("More elements than needed. Please, try again!");
            default -> System.out.println("UnknownError");
        }

    }
}