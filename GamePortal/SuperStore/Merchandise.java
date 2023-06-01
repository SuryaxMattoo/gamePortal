public class Merchandise extends Item {
    Merchandise(String name, int price) {
        super(name, "Merchandise", price);
    }

    @Override
    public void effectswhenbuying() {
        System.out.println("thanks for buying!");
    }
}
