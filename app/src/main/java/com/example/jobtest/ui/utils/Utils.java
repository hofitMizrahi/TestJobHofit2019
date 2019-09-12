package com.example.jobtest.ui.utils;

import java.util.List;

public class Utils {

    public static <T> boolean isListFull(List<T> list){
        return list != null && list.size() > 0;
    }
}
