package com.ugurdonmez.parser.topdomains;

import java.io.IOException;
import java.io.PrintWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/** 
 * Simple main method to parse iana pages to get top level domains
 * 
 * @author ugurdonmez
 */
public class TopLevelDomainsDownloader {
    
    public static void main(String [] args) throws IOException {
        
        String url = "http://www.iana.org/domains/root/db";
        
        PrintWriter writerCountry = new PrintWriter("main/resources/country_domains.txt", "UTF-8");
        PrintWriter writerGeneric = new PrintWriter("main/resources/generic_domains.txt", "UTF-8");
        
        Document doc = Jsoup.connect(url).get();

        // get all tr elements
        Elements links = doc.select("tr");
        
        for (Element el : links) {
            String domain = el.child(0).select("a").text();
            String type = el.child(1).html();
            
            /*
            .able
            generic
            .abogado
            generic
            .abudhabi
            generic
            .ac
            country-code
            */
            
            if (type.equals("generic")) {
                // remove 
                writerGeneric.println(domain.substring(1));
            }
            
            if (type.equals("country-code")) {
                writerCountry.println(domain.substring(1));
            }
        }
        
        writerGeneric.close();
        writerCountry.close();
    }
    
}
