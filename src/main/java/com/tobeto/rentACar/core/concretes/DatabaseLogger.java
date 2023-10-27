package com.tobeto.rentACar.core.concretes;

import com.tobeto.rentACar.core.abstracts.Logger;

public class DatabaseLogger implements Logger {

    @Override
    public void log(String data) {
        System.out.println("Data has been logged to database. Data: " + data);
    }
}
