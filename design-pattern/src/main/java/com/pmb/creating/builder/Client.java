package com.pmb.creating.builder;

public class Client {
    public static void main(String[] args) {
        IphoneBuilder builder = new Iphone6sBuilder();
        IphoneDirector director = new Iphone6sDirector(builder);
        Iphone iphone = director.directIphone();
        iphone.photo();
        QueryParams queryParams = null;
        queryParams = QueryParams.newBuilder()
                .param1("p1")
                .param2("p2")
                .build();


        queryParams = queryParams.toBuild(queryParams)
                .param1("p1change")
                .param2("p2change")
                .build();
        queryParams.toString();
    }
}
