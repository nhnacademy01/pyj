package com.nhnacademy.yujinpark.tdd.mockito;

public class DummyAccount extends Account{

    public DummyAccount(String username, String password) {
        super(null, null);
    }

    public DummyAccount() {
        super(null, null);
    }

    @Override
    public Long getId(){
        return null;
    }

    @Override
    public String getUsername(){
        return null;
    }

    @Override
    public String getPassword(){
        return null;
    }
}
