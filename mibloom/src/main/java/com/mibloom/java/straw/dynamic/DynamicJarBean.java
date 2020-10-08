package com.mibloom.java.straw.dynamic;

import lombok.Data;

import java.net.URL;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/9/26 21:38
 **/
@Data
public class DynamicJarBean {
    private String className;
    private String version;
    private URL[] jarUrl;
}
