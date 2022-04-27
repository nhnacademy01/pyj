package com.nhnacademy.jsp.domain;

import java.io.Serializable;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jsoup.Jsoup;

@NoArgsConstructor
@Setter
public class HtmlBeautifier implements Serializable {
    private String html;

    public String getHtml(){
        return Jsoup.parse(this.html).toString();
    }
}
