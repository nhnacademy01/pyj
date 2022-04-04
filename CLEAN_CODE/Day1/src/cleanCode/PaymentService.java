//package cleanCode;
//
//public class PaymentService {
//    /**
//     * 실시간 할인내역 조회
//     *
//     * @param productAmt   상품금액
//     * @param discountCode 할인코드 (NAVER:네이버검색-10%, DANAWA:다나와검색-15% FANCAFE:팬카페-1000원)
//     * @return 할인내역
//     */
//    public Discount getDiscount(long productAmt, String discountCode) {
//        // 할인금액
//        long discountAmt = getDiscountAmt(productAmt, discountCode);
//        return Discount.of(discountAmt);
//    }
//
//    private long getDiscountAmt(String discountCode, long productAmt) {
//        long discountAmt = 0;
//        if ("NAVER".equals(discountCode)) {   // 네이버검색 할인
//            discountAmt = (long) productAmt * 0.1;
//        } else if ("DANAWA".equals(discountCode)) { // 다나와검색 할인
//            discountAmt = (long) productAmt * 0.15;
//        } else if ("FANCAFE".equals(discountCode)) {  // 팬카페인입 할인
//            if (productAmt < 1000)  // 할인쿠폰 금액보다 적은경우
//            {
//                discountAmt = productAmt;
//            } else {
//                discountAmt = 1000;
//            }
//        }
//        return discountAmt;
//    }
//
//
//    /**
//     * 결재 처리
//     *
//     * @param productAmt   상품금액
//     * @param discountCode 할인코드 (NAVER:네이버검색-10%, DANAWA:다나와검색-15% FANCAFE:팬카페-1000원)
//     */
//    public void payment(Customer customer, long productAmt, String discountCode) {
//        // 결제금액
//        long paymentAmt;
//        if ("NAVER".equals(discountCode)) {   // 네이버검색 할인
//            paymentAmt = (long) (productAmt * 0.9);
//        } else if ("DANAWA".equals(discountCode)) { // 다나와검색 할인
//            paymentAmt = (long) (productAmt * 0.85);
//        } else if ("FANCAFE".equals(discountCode)) {  // 팬카페인입 할인
//            if (productAmt < 1000)  // 할인쿠폰 금액보다 적은경우
//            {
//                paymentAmt = 0;
//            } else {
//                paymentAmt = productAmt - 1000;
//            }
//        } else {
//            paymentAmt = productAmt;
//        }
//        // TODO: 결제 처리...
//    }
//}
//
//
