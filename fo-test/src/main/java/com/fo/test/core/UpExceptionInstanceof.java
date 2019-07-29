package com.fo.test.core;

import com.fo.common.core.exception.FoException;

public class UpExceptionInstanceof {
    
    public static void main(String[] args) {
        FoException a = new FoException();
        System.out.println(a instanceof FoException);
    }

}
