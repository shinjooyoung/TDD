import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("금액이 부족한 경우 예외 발생")
    void buy() {
        Lotto lotto = new Lotto();
        Assertions.assertThrows(IllegalArgumentException.class,()-> lotto.buy(400));
        Assertions.assertThrows(IllegalArgumentException.class,()-> lotto.buy(900));

    }

}