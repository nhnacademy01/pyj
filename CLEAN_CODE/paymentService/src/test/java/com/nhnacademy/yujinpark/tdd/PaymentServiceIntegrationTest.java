package com.nhnacademy.yujinpark.tdd;

import clean.Discount;
import clean.DiscountPolicyRepository;
import clean.JsonDiscountPolicyRepository;
import clean.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class PaymentServiceIntegrationTest {

    private PaymentService service;

    // DOC
    private DiscountPolicyRepository discountPolicyRepository;

    @BeforeEach
    void setUp(){
        discountPolicyRepository = new JsonDiscountPolicyRepository();
        service = new PaymentService(discountPolicyRepository);

    }

    @DisplayName("대부분의 상황에서 할인 금액을 알 수 있는 테스트. (코드 상품가격 조합)")
    @ParameterizedTest
    @CsvFileSource(resources = "" , numLinesToSkip = 1)
    void getDiscount(String discountCode, long productAmt, long discountAmt){

        //given

        // when
        Discount discount = service.getDiscount(productAmt, discountCode);

        //then
        assertThat(discount.getAmount()).isEuqalTo(discountAmt);

    }

    @Test
    void payment(){

    }


}
