package main;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

// 정광호

public class main {
    public static void main(String[] args){
        String[] writek;
        String[] writep;
        try{
            File file = new File("property.html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("<head>\n" +
                    "    <meta charset=\"UTF-8\"/>\n" +
                    "    <style>\n" +
                    "        table { border-collapse: collapse; width: 100%; }\n" +
                    "        th, td { text-align:left; border:solid 1px #000; }\n" +
                    "    </style>\n" +
                    "    <h1>자바 환경정보</h1>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <table border=\"1\">\n" +
                    " <thead>\n" +
                            "            <tr>\n" +
                            "                <th>\n" +
                            "                    <center>키</center>\n" +
                            "                </th>\n" +
                            "                <th>\n" +
                            "                    \n" +
                            "                </th>\n" +
                            "            </tr>\n" +
                            "            <tr>\n" +
                            "            </tr>\n" +
                            "        </thead>" +
                    "        <tbody>\n");

            for(Object k : System.getProperties().keySet())
            {
                String key = (String)k.toString();
                String value = System.getProperty(key);
                writer.write(
                        "<tr>\n" +
                        "            <th>\n" +
                        key +
                        "            </th>\n" +
                        "            <th>\n" +
                        value +
                        "            </th>\n" +
                        "        </tr>");
            }
            writer.write(
                    "</tbody>\n" +
                    "    </table>\n" +
                    "</body>");

            writer.close();

        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
