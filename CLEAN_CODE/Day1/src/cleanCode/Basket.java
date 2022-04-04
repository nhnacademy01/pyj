package cleanCode;

public class Basket {
    double calculateTotal() {
        if (basePrice() > 1000) {
            return basePrice() * 0.95;
        }
        return basePrice() * 0.98;
    }
    double basePrice() {
        return this.quantity * this.itemPrice;
    }
}

