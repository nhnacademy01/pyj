package clean;

public class PaymentService {
    private DiscountPolicyRepository repository;

    public static void main(String[] args) {
        DiscountPolicy payco = DiscountPolicy.rate("PAYCO", 0.1f);
        DiscountPolicy daannawa = DiscountPolicy.rate("DAANNAWA", 0.15f);
        DiscountPolicy fancafe = DiscountPolicy.amount("FANCAFE", 1_000);
        DiscountPolicy nhnacademy = DiscountPolicy.amount("NHNACADEMY", 2_000);

//        MapDiscountPolicyRepository repository = new MapDiscountPolicyRepository();
//        repository.insert(payco);
//        repository.insert(daannawa);
//        repository.insert(fancafe);
//        repository.insert(nhnacademy);

        FileDiscountPolicyRepository repository = new FileDiscountPolicyRepository();
        repository.insert(payco);
        repository.insert(daannawa);
        repository.insert(fancafe);
        repository.insert(nhnacademy);

        PaymentService paymentService = new PaymentService(repository);
        Discount discount = paymentService.getDiscount(10_000, "PAYCO");

        System.out.println(discount);

    }

    public PaymentService(DiscountPolicyRepository repository) {
        this.repository = repository;
    }

    /**
     * 실시간 할인내역 조회
     *
     * @param productAmt   상품금액
     * @param discountCode 할인코드 (PAYCO:페이코-10%, DAANNAWA:다안나와검색-15% FANCAFE:팬카페-1000원)
     * @return 할인내역
     */
    public Discount getDiscount(long productAmt, String discountCode) {
        // 할인금액
        long discountAmt = getDiscountAmt(productAmt, discountCode);
        return Discount.of(discountAmt);
    }

    public Discount getDiscount(long productAmt, String... codes) {
        // 할인금액
        long discountAmt = getDiscountAmt(productAmt, codes);
        return Discount.of(discountAmt);
    }

    /**
     * 결재 처리
     *
     * @param productAmt   상품금액
     * @param discountCode 할인코드 (PAYCO:페이코-10%, DAANNAWA:다안나와검색-15% FANCAFE:팬카페-1000원)
     */
    public void payment(Customer customer, long productAmt, String discountCode) {
        // 결제금액
        long paymentAmt = productAmt - getDiscountAmt(productAmt, discountCode);
        // TODO: 결제 처리...
    }

    private long getDiscountAmt(long productAmt, String... discountCodes) {
        // TODO loop
        if (discountCodes.length == 1) {
            return repository.findByCode(discountCodes[0]).getDiscountAmt(productAmt);
        }
        return new CompositeDiscounter(repository, discountCodes).getDiscountAmt(productAmt);
    }
}
