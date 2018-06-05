package com.app.condominioplus.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormataData {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static String formatarData(Date date) {
        return dateFormat.format(date);
    }
}
