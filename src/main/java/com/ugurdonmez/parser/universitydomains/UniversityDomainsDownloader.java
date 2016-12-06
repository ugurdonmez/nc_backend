package com.ugurdonmez.parser.universitydomains;

import com.ugurdonmez.email.validation.basic.data.pojo.UniversityDomainPOJO;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

/**
 *
 * @author ugurdonmez
 */
public class UniversityDomainsDownloader {

    public static void main(String[] args) throws Exception {
        // https://raw.githubusercontent.com/Hipo/university-domains-list/master/world_universities_and_domains.json

        String json = readUrl("http://www.javascriptkit.com/"
                + "dhtmltutors/javascriptkit.json");

        Gson gson = new Gson();
        UniversityDomainPOJO [] array = (UniversityDomainPOJO[]) gson.fromJson(json, UniversityDomainPOJO[].class);

        PrintWriter universityDomains = new PrintWriter("resources/university_domains.txt", "UTF-8");
        
        for (UniversityDomainPOJO pj : array) {
            String [] splitted = pj.getDomain().split("\\.");
            universityDomains.println(splitted[0]);
        }
        
        universityDomains.close();
    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }

            return buffer.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

}
