package clean;

public interface DiscounterFactory {
    Discountable getDiscounter(String discountName);
}

