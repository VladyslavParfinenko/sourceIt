package Payment;

public class PaymentMain {
    public static void main(String[] args) {
        Payment pay1 = new Payment("Супермаркет Класс");
        pay1.setPayment();
        pay1.printCheque();

        Payment pay2 = new Payment("Супермаркет Рост");
        pay2.setPayment();
        pay2.printCheque();

    }


}
