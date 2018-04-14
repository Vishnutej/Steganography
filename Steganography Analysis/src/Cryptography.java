import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Cryptography
{
    private SecretKeySpec secretKeySpecs;
    private Cipher ciphInst;

    public Cryptography(String key, int wantedlength, String algo)
    {
        byte[] bkey = new byte[wantedlength];
        bkey = checkLength(key, wantedlength);
        this.secretKeySpecs = new SecretKeySpec(bkey, algo);
        try
        {
            this.ciphInst = Cipher.getInstance(algo);
        }
        catch(Exception e)
        {
            System.out.println("Wrong Algo");
        }
    }

    private byte[] checkLength(String s, int length){
        if (s.length() < length){
            int missingLength = length - s.length();
            for (int i = 0; i < missingLength; i++)
            {
                s += " ";
            }
        }
        return s.substring(0, length).getBytes();
    }

    public byte[] encryptString(String s)
    {
        try{
            this.ciphInst.init(Cipher.ENCRYPT_MODE, this.secretKeySpecs);
        }
        catch(Exception e)
        {
            System.out.println("Problem with key");
        }
        byte[] x = s.getBytes();
        byte[] y=null;
        try{
            y = ciphInst.doFinal(x);
        }
        catch(Exception e)
        {
            System.out.println("Problem with input");
        }

        if(y==null)
        {
            return null;
        }
        else
        {
            return y;
        }
    }

    public String decryptString(byte[] encrypted)
    {
        try{
            this.ciphInst.init(Cipher.DECRYPT_MODE, this.secretKeySpecs);
        }
        catch(Exception e)
        {
            System.out.println("Problem with key");
        }
        byte[] y=null;
        try{
            y = ciphInst.doFinal(encrypted);
        }
        catch(Exception e)
        {
            System.out.println("Problem with Encryption");
        }
        if(y==null)
        {
            return null;
        }
        String decrypted = new String(y);
        return decrypted;
    }

 /*   public static void main(String args[])
    {
        Cryptography c = new Cryptography("Jain",16,"AES");
        byte[] l = c.encryptString("Naman");
        System.out.println(l);
        System.out.println(c.decryptString(l));
    }*/

}