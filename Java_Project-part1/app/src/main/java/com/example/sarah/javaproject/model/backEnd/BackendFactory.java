package com.example.sarah.javaproject.model.backEnd;
import android.content.Context;

import com.example.sarah.javaproject.model.dataSource.DatabaseList;

public final class BackendFactory {
    static Backend instance = null;

     public static String mode ="fb";

     public final static Backend getInstance(Context context) {

        if (mode == "lists") {
            if (instance == null)
                instance = new DatabaseList();
            return instance;
        }
        if (mode == "fb") {
            if (instance == null)
                instance = new com.example.sarah.javaproject.model.dataSource.DatabaseFb();
            return instance;

        }
        else
            return null;
     }
}
