package com.tobeto.rentACar.core.concretes;

import com.tobeto.rentACar.core.abstracts.Logger;

public class Mail implements Logger {
    @Override
    public void log(String data) {
        System.out.println("Mail has been sent. Data: " + data);
    }
}
