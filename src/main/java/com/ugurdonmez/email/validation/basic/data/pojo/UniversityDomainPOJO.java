package com.ugurdonmez.email.validation.basic.data.pojo;

/**
 * Store UniversityDomain json
 * 
 * ref: https://raw.githubusercontent.com/Hipo/university-domains-list/master/world_universities_and_domains.json
 * 
 * @author ugurdonmez
 */
public class UniversityDomainPOJO {
    
    private String alpha_two_code;
    private String country;
    private String domain;
    private String name;
    private String web_page;

    public UniversityDomainPOJO() {
    }

    public String getAlpha_two_code() {
        return alpha_two_code;
    }

    public void setAlpha_two_code(String alpha_two_code) {
        this.alpha_two_code = alpha_two_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeb_page() {
        return web_page;
    }

    public void setWeb_page(String web_page) {
        this.web_page = web_page;
    }
}
