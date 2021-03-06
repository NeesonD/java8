package com.neeson.serialization;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import com.neeson.basic.domain.MyObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author daile
 * @date 2017/9/12
 */
public class HessianSerialization {

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        HessianOutput ho = new HessianOutput(os);
        MyObject myObject = new MyObject("nwwson");
        ho.writeObject(myObject);

        byte[] zhansanByte = os.toByteArray();
        System.out.println(Arrays.toString(zhansanByte));

        ByteArrayInputStream is = new ByteArrayInputStream(zhansanByte);

        HessianInput hi = new HessianInput(is);
        MyObject object = (MyObject) hi.readObject();
        System.out.println(object);
    }

}
