package com.nhnacademy.simplecurl;

import java.util.ArrayList;
import java.util.List;

public class ParseUrl {
    private String host;
    private int port;

    public ParseUrl() {
    }

    public ParseUrl(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    // ubuntu@nhn-academy-12:~$ curl -x  http://httpbin.org/get
    //{
    //  "args": {},
    //  "headers": {
    //    "Accept": "*/*",
    //    "Host": "httpbin.org",
    //    "User-Agent": "curl/7.68.0",
    //    "X-Amzn-Trace-Id": "Root=1-625f9b3e-7e65fefe4c7923c002dd6633"
    //  },
    //  "origin": "133.186.213.240",
    //  "url": "http://httpbin.org/get"
    //}

    public void parseUrl(String[] args) {
        this.host = args[args.length-1].split("//")[1].split("/")[0];
        this.port = 80;
    }

}
