public class PasswordChecker {
    public static PasswordStrength check(String pw) {
        if(confirmEmptyAndNull(pw)){
            throw new IllegalArgumentException();
        }

        return confirmStrength(confirmStrengthNum(pw));

    }

    private static boolean confirmEmptyAndNull(String pw) {
        return pw == null || pw.isBlank();
    }

    private static PasswordStrength confirmStrength(int checkerNum) {
        switch (checkerNum){
            case 1 :
                return PasswordStrength.WEAKNESS;
            case 2 :
                return PasswordStrength.NORMAL;
            case 3 :
                return PasswordStrength.STRONG;
        }
        return PasswordStrength.WEAKNESS;
    }

    private static int confirmStrengthNum(String pw) {
        int checkerNum = 0;
        if(isLength(pw)) checkerNum++;
        if(containNumber(pw)) checkerNum++;
        if(containUpperCase(pw)) checkerNum++;
        return checkerNum;
    }

    private static boolean containNumber(String pw) {
        return pw.matches(".*[0-9].*");
    }

    private static boolean isLength(String pw) {
        return pw.length() >= 8;
    }

    private static boolean containUpperCase(String pw) {
        for (char ch : pw.toCharArray()) {
            if(ch >= 'A' && ch <='Z') return true;
        }
        return false;
    }
}
