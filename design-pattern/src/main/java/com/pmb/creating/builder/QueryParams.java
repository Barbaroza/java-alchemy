package com.pmb.creating.builder;

import java.util.Objects;

/**
 * 简单实用建造者模式
 * <p>
 * 注意与工厂模式的区别
 * 与构造体使用的区别
 * 与javabean模式的区别
 * <p>
 * 创建
 *
 * @author lvrui
 */
public class QueryParams {
    private final String param1;
    private final String param2;

    QueryParams(String param1, String param2) {
        this.param1 = param1;
        this.param2 = param2;
    }

    public String param1() {
        return this.param1;
    }

    public String param2() {
        return this.param2;
    }

    public QueryParams.Builder toBuild(QueryParams queryParams) {
        return new QueryParams.Builder(queryParams);
    }

    public static QueryParams.Builder newBuilder() {
        return new QueryParams.Builder();
    }

    public static class Builder {
        String param1;
        String param2;


        Builder() {
        }

        Builder(QueryParams queryParams) {
            this.param1 = queryParams.param1;
            this.param2 = queryParams.param2;
        }

        public QueryParams.Builder param1(String param1) {
            this.param1 = param1;
            return this;
        }

        public QueryParams.Builder param2(String param2) {
            this.param2 = param2;
            return this;
        }

        public final QueryParams build() {
            //TODO validate
            if (Objects.isNull(this.param1)) {
                param1 = "";
            }
            if (Objects.isNull(this.param2)) {
                param2 = "";
            }
            return new QueryParams(this.param1, this.param2);

        }
    }

}
