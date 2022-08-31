public class LottoShop {

    public Lotto buy(int money) {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return new Lotto(money/1000);
    }
}
