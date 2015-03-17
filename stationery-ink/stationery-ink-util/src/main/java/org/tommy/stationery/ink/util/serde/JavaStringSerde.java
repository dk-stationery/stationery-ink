package org.tommy.stationery.ink.util.serde;

import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.io.*;

/**
 * Created by kun7788 on 15. 2. 6..
 */
public class JavaStringSerde implements IInkSerde  {

    @Override
    public String serialize(Object obj) throws Exception {
        return null;
    }

    /** Read the object from Base64 string. */
    public Object deserialize( String s ) throws Exception {
        byte [] data = Base64Coder.decode(s);
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(  data ) );
        Object o  = ois.readObject();
        ois.close();
        return o;
    }

    /** Write the object to a Base64 string. */
    public String serialize( Serializable o ) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( o );
        oos.close();
        return new String( Base64Coder.encode( baos.toByteArray() ) );
    }

}
