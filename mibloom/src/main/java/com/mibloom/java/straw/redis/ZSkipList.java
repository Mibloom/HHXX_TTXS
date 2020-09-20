package com.mibloom.java.straw.redis;

/**
 * @author LIPENGKE
 * @description:
 * @date 2020/9/18 22:18
 **/
public class ZSkipList {
    private ZSkipListNode head;
    private ZSkipListNode tail;
    private long length; // 跳跃表节点数量，表头节点不算在内
    private int level; // 跳跃表内，层数最大的节点的层数，表头节点层数不算在内
}
