import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 다음 규칙을 모두 충족하면 매우 강함이다.
 *   길이가 8글자 이상
 *   0부터 9사이 숫자를 포함
 *   대문자 포함
 * 2개의 규칙을 충족하면 보통이다.
 * 1개의 규칙을 총족하면 약함이다.
 *  0개의 규칙을 총족하면 약함이다.
 */
class PasswordCheckerTest {

    @DisplayName("null 값이 들어왔을때 예외 발생")
    @Test
    void checkNull() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> PasswordChecker.check(null));
    }

    @DisplayName("빈 값이 들어왔을때 예외 발생")
    @Test
    void checkEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->PasswordChecker.check(""));
    }

    @DisplayName("모든 조건이 참일때 강함")
    @Test
    void checkAllTrue(){
        checkStrength("123ABCDE", PasswordStrength.STRONG);
    }

    @DisplayName("길이가 8미만 나머지가 참일때 보통")
    @Test
    void exceptLengthAndAnotherTrue(){
        checkStrength("ABCD123", PasswordStrength.NORMAL);
        checkStrength("123ABcd", PasswordStrength.NORMAL);
    }

    @DisplayName("숫자 미포함 나머지가 참일때 보통")
    @Test
    void exceptNumberAndAnotherTrue(){
        checkStrength("ABCDEFGH", PasswordStrength.NORMAL);
        checkStrength("abcdEFGH", PasswordStrength.NORMAL);
    }

    @DisplayName("대문자 미포함 나머지가 참일때 보통")
    @Test
    void exceptUpperCaseAndAnotherTrue(){
        checkStrength("abcdef1234", PasswordStrength.NORMAL);
        checkStrength("1234abcdef", PasswordStrength.NORMAL);
    }

    @DisplayName("대문자만 포함 약함")
    @Test
    void compriseUpperCase(){
        checkStrength("ABCD", PasswordStrength.WEAKNESS);
    }

    @DisplayName("숫자만 포함 약함")
    @Test
    void compriseNumber(){
        checkStrength("1234", PasswordStrength.WEAKNESS);
    }

    @DisplayName("길이가 8 이상만 포함 약함")
    @Test
    void compriseLength(){
        checkStrength("abcdefgh", PasswordStrength.WEAKNESS);
    }

    @DisplayName("아무것도 포함 안함 약함")
    @Test
    void compriseNone(){
        checkStrength("abcd", PasswordStrength.WEAKNESS);
    }

    private void checkStrength(String pw, PasswordStrength result) {
        Assertions.assertEquals(PasswordChecker.check(pw), result);
    }
}