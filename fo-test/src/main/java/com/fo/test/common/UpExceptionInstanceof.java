package com.fo.test.common;

import com.fo.common.core.exception.FoException;

public class UpExceptionInstanceof {
    
    public static void main(String[] args) {
        FoException a = new FoException();
        System.out.println(a instanceof FoException);
    }

}
