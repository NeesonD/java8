package com.neeson.thread.course2;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by daile on 2017/8/29.
 */
public class OneValueCache {

    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger lastNumber, BigInteger[] lastFactors) {
        this.lastNumber = lastNumber;
        this.lastFactors = Arrays.copyOf(lastFactors,lastFactors.length);
    }

    public BigInteger[] getLastFactors(BigInteger i){
        if (lastNumber == null||!lastNumber.equals(i))
            return null;
        else
            return Arrays.copyOf(lastFactors,lastFactors.length);
    }
}
