
package io.digitalbits.sdk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import io.digitalbits.sdk.xdr.XdrDataInputStream;
import io.digitalbits.sdk.xdr.XdrDataOutputStream;


public class XdrDataStreamTest {
    //helper for tests below.
     public static String backAndForthXdrStreaming(String inputString) throws IOException {

        //String to XDR
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        XdrDataOutputStream xdrOutputStream = new XdrDataOutputStream(byteOutputStream);

        io.digitalbits.sdk.xdr.Memo xdrMemo = Memo.text(inputString).toXdr();
        xdrMemo.encode(xdrOutputStream);

        byte[] xdrByteOutput = byteOutputStream.toByteArray();

        //XDR back to String
        XdrDataInputStream xdrInputStream = new XdrDataInputStream(new ByteArrayInputStream(xdrByteOutput));
        xdrMemo = io.digitalbits.sdk.xdr.Memo.decode(xdrInputStream);

        return xdrMemo.getText().toString();
    }

    @Test
    public void backAndForthXdrStreamingWithStandardAscii() throws IOException {
        String memo = "Dollar Sign $";
        assertEquals(memo, backAndForthXdrStreaming(memo));

    }

    @Test
    public void backAndForthXdrStreamingWithNonStandardAscii() throws IOException {
        String memo = "Euro Sign €";
        assertEquals(memo, backAndForthXdrStreaming(memo));
    }
    
     @Test
    public void backAndForthXdrStreamingWithAllNonStandardAscii() throws IOException {
        String memo = "øûý™€♠♣♥†‡";
        assertEquals(memo, backAndForthXdrStreaming(memo));
    }
}
