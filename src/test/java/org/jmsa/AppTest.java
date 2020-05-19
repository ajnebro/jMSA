package org.jmsa;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.jmsa.substitutionmatrix.impl.Blosum62;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    //@Test
    //public void shouldAnswerWithTrue()
    //{
    //    assertTrue( true );
    //}

    public static void main( String[] args ) throws IOException
    {
        Blosum62 bs62=new Blosum62();
        System.out.println(bs62.getDistance('B','A'));
        /*String filePath = new File("resources\\data\\Blosum62.txt").getAbsolutePath();
        HashMap<List, String> map = new HashMap<List, String>();

        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null)
        {
            String[] parts = line.split(":", 2);
            if (parts.length >= 2)
            {
                String[] lp=parts[0].split(",");
                List key = List.of(lp[0].charAt(0),lp[1].charAt(0));
                String value = parts[1];
                map.put(key, value);
            } else {
                System.out.println("ignoring line: " + line);
            }
        }
        List aux=List.of('B','A');
        System.out.println(aux + ":" + map.get(aux));
        for (List key : map.keySet())
        {
            System.out.println(key + ":" + map.get(key));
            System.out.println(key.equals(aux));
        }
        reader.close();*/
    }
}
