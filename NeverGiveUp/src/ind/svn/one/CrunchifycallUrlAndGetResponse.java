package ind.svn.one;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
/**
 * @author Crunchify.com
 * Getting text from URL: Send HTTP request GET/POST in Java - bufferedReader.read()
 */
public class CrunchifycallUrlAndGetResponse {
    public static void main(String[] args) {
        //crunchifyPrint("\nOutput: \n" + crunchifyGETCallURLUtil("https://crunchify.com/wp-content/uploads/code/json.sample.txt"));
    	crunchifyPrint("\nOutput: \n" + crunchifyGETCallURLUtil("https://example-files.online-convert.com/document/txt/example.txt"));
    }
    public static String crunchifyGETCallURLUtil(String crunchifyURL) {
        crunchifyPrint("Requested URL:" + crunchifyURL);
        // A mutable sequence of characters. This class provides an API compatible with StringBuffer,
        // but with no guarantee of synchronization.
        StringBuilder crunchifyStringBuilder = new StringBuilder();
        URLConnection crunchifyURLConnection = null;
        InputStreamReader in = null;
        try {
            URL url = new URL(crunchifyURL);
            crunchifyURLConnection = url.openConnection();
            if (crunchifyURLConnection != null)
                // Set 5 second Read timeout
                crunchifyURLConnection.setReadTimeout(5 * 1000);
            if (crunchifyURLConnection != null && crunchifyURLConnection.getInputStream() != null) {
            	/*int sr;
            	while((sr = crunchifyURLConnection.getInputStream().read()) != -1)
            	{
            		System.out.println((char)sr);
            	}*/
            
                in = new InputStreamReader(crunchifyURLConnection.getInputStream(),
                        Charset.defaultCharset());
                /*int isr;
                while((isr = in.read()) != -1)
                {
                	System.out.println((char) isr);
                }*/
                BufferedReader bufferedReader = new BufferedReader(in);
                /*if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        crunchifyStringBuilder.append((char) cp);
                        System.out.println((char)cp);
                    }
                    bufferedReader.close();
                }*/
                
                if (bufferedReader != null) {
                    String readLine;
                    while ((readLine = bufferedReader.readLine()) != null) {
                        crunchifyStringBuilder.append(readLine).append(System.lineSeparator());
                    }
                    bufferedReader.close();
                }
            }
            //in.close();
        } catch (Exception e) {
            throw new RuntimeException("Exception while calling URL:" + crunchifyURL, e);
        }
        return crunchifyStringBuilder.toString();
    }
    private static void crunchifyPrint(String print) {
        System.out.println(print);
    }
}