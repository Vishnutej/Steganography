
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.sql.*;
import java.lang.*;
import java.awt.event.ActionEvent;
import java.awt.font.*;
import java.lang.String;
import java.awt.geom.*;
import javax.swing.text.EditorKit;
import javax.swing.event.MouseInputAdapter;
import java.awt.image.BufferedImage;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.imageio.ImageIO;
import java.util.Vector;
import javax.swing.text.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.String;
import java.lang.Byte;
import java.math.*;
import java.security.*;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import javax.crypto.*;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.interfaces.*;
import java.security.KeyException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;

class Decryption implements Serializable {

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JButton button1;
    JButton button2;
    JTextField textfield1;
    JTextField textfield2;
    JTextArea textarea3;
    JScrollPane sp_textarea3;
    JButton button3;
    JButton button4;
    JFileChooser filechooser;
    File f, tempfilename, Ofilename, Sfilename;
    int Copened, Cdecrypt;
    String name, Dkey;
    String chosenFile;    

    public void Imagedecrypt(File filename, int key) throws java.io.IOException {
        FileInputStream ins = new FileInputStream(filename);
        byte b[] = new byte[2];
        BigInteger bb1;
        char mess[] = new char[8];
        int c = 0;
        for (int i = 0; i < key; i++) {
            int n = ins.read();
        }
        for (int i = 0; i < 8; i++) {
            ins.read(b);
            bb1 = new BigInteger(b);
            String str = bb1.toString(2);
            int len = bb1.bitLength();
            if (b[0] < 0) {
                len++;
            }
            char ch[] = new char[len + 1];
            str.getChars(0, len, ch, 0);
            if (b[0] == 0) {
                mess[i] = '0';
            } else {
                mess[i] = ch[len - 1];
            }
        }
        String dd = new String(mess);
        BigInteger bb = new BigInteger(dd, 2);
        String s = bb.toString(2);
        int l = bb.intValue();

        char me[] = new char[l];
        int count = 0;

        for (int m = 0; m < l; m++) {
            for (int i = 0; i < 8; i++) {
                ins.read(b);
                bb1 = new BigInteger(b);
                String str = bb1.toString(2);
                int len = bb1.bitLength();
                if (b[0] < 0) {
                    len++;
                }
                char ch[] = new char[len + 1];
                str.getChars(0, len, ch, 0);
                if (b[0] == 0) {
                    mess[i] = '0';
                } else {
                    mess[i] = ch[len - 1];
                }
            }
            String dd1 = new String(mess);
            BigInteger bb2 = new BigInteger(dd1, 2);
            String s1 = bb2.toString(2);
            int l1 = bb2.intValue();
            me[count] = (char) l1;
            count++;
        }
        String message = new String(me);        
        System.out.println(message);
        ins.close();
    }
}
