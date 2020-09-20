package com.mibloom.java.straw.redis;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/9/18 22:01
 **/
public class ZSkipListNode {
    private ZSkipListLevel[] levels;
    private ZSkipListNode backWard;
    private double score;
    private SDS obj;

    private class ZSkipListLevel{
        private ZSkipListNode forWard;
        private int span;
    }
}
