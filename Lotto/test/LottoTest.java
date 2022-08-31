import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("금액이 1000원 단위로 떨어지지 않는 경우 예외 발생")
    void checkMoney() {
        LottoShop lottoShop = new LottoShop();
        Assertions.assertThrows(IllegalArgumentException.class,()-> lottoShop.buy(400));
        Assertions.assertThrows(IllegalArgumentException.class,()-> lottoShop.buy(900));
    }


    @Test
    @DisplayName("금액만큼의 로또갯수 구입")
    void buyLength() {
        LottoShop lottoShop = new LottoShop();
        Assertions.assertEquals(lottoShop.buy(30000).length(), 30);
        Assertions.assertEquals(lottoShop.buy(4000).length(), 4);
    }


}