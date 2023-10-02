abstract class PersonInputSizeChecker {
    public static String check(String[] input) {
        String exceptionCode;

        if (input.length == 6) {
            exceptionCode = "200";// 200 - Enough_elements_exception code
        } else if (input.length < 6) {
            exceptionCode = "300";// 300 - Less_elements_than_need_exception code
        } else {
            exceptionCode = "350";// 350 - More_elements_than_need_exception code
        }
        return exceptionCode;
    }
}