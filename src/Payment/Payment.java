package Payment;


import java.util.Scanner;

public class Payment implements PrintCheque {
    private String name;
    private Product[] prodArray; // товары
    private int cost; // стоимость покупки


    private class Product {
        private String productName;
        private int productCost;

        public Product(String productName, int productCost) {
            super();
            this.productName = productName;
            this.productCost = productCost;
        }

        public String getProductName() {
            return productName;
        }

        public int getProductCost() {
            return productCost;
        }
    }

    public Payment(String name) {
        this.name = name;
    }

    public void setPayment() {
        this.cost = 0;
        Scanner in = new Scanner(System.in);

        int line = in.nextInt();

        prodArray = new Product[line];

        for (int i = 0; i < line; i++) {
            System.out.print("Наименование: ");
            String str_name = in.next();
            System.out.print("Цена: ");
            int prod_cost = in.nextInt();
            prodArray[i] = new Product(str_name, prod_cost);
            this.cost = this.cost + prodArray[i].productCost;

        }

    }

    @Override
    public void printCheque(){
        System.out.println("============================");
        System.out.println(" " + this.name);
        System.out.println("============================");

            for (int i = 0; i < this.prodArray.length; i++) {

                System.out.printf("%3d", i + 1);
                System.out.printf("%15s",this.prodArray[i].productName);
                System.out.printf("%10d",this.prodArray[i].productCost);
                System.out.println();

            }

        System.out.println("============================");
        System.out.print("Общая стоимость: ");
        System.out.printf("%11d", this.cost);
        System.out.println();
        System.out.println("============================");

    }
}




