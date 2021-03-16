package com.test.datastructure.linkedlisk;

import cn.hutool.core.collection.CollectionUtil;

import java.util.Stack;

/**
 * @Description: 模拟有序列表
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/3/13 17:47
 * @UpdateDate: 2021/3/13 17:47
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //初始化一个有序集合
        SingleLinkedList linkedList = new SingleLinkedList();
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);

        System.out.println("反转之前");
        singleLinkedList.list();

        singleLinkedList.clear();

        singleLinkedList.list();

        singleLinkedList.addNodeByNo(hero1);
        singleLinkedList.addNodeByNo(hero4);
        singleLinkedList.addNodeByNo(hero2);
        singleLinkedList.addNodeByNo(hero3);
        singleLinkedList.addNodeByNo(hero3);
        singleLinkedList.list();

        System.out.println("反转之后");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();

        System.out.println("逆向打印单链表，不改变原有结构");
        reversetPrint(singleLinkedList.getHead());

        HeroNode hero5 = new HeroNode(4, "乌龟", "憨八龟");
        singleLinkedList.update(hero5);

        System.out.println("修改后：");
        singleLinkedList.list();

        singleLinkedList.remove(hero5);
        System.out.println("删除后：");
        singleLinkedList.list();
        singleLinkedList.addNodeByNo(hero5);
        System.out.println("再插入后：");
        singleLinkedList.list();

    }

    /**
     * 利用栈，逆向打印单链表
     * @param head
     */
    public static void reversetPrint(HeroNode head) {
        if(null == head || null == head.getNext()) {
            return;
        }
        //利用栈，逆向打印单链表
        Stack<HeroNode> stack = new Stack<>();
        HeroNode headNext = head.getNext();
        while (headNext != null) {
            //将数据压入栈中
            stack.push(headNext);
            headNext = headNext.getNext();
        }
        while (CollectionUtil.isNotEmpty(stack)) {
            //将数据从栈中取出
            System.out.println(stack.pop());
        }
    }

    /**
     * 反转单链表
     * @param heroNode
     * @return
     */
    public static void reverseList(HeroNode heroNode) {
        if(heroNode == null || heroNode.getNext() == null) {
            return;
        }

        HeroNode newNode = new HeroNode(0, "", "");
        //表示当前节点
        HeroNode next = heroNode.getNext();
        //临时变量
        HeroNode temp = null;
        while (next != null) {
            temp = next.getNext();
            next.setNext(newNode.getNext());
            newNode.setNext(next);
            next = temp;
        }
        heroNode.setNext(newNode.getNext());
    }

}

class SingleLinkedList {
    /**
     * 初始化头节点，此节点只作为头部，不为实际排名
     */
    private final HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 无序添加英雄
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        //添加英雄节点
        //设置中间节点
        HeroNode temp = head;
        while (true) {
            if(temp.getNext() == null) {
                temp.setNext(heroNode);
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 添加有序列表，根据英雄的No进行从小到大排序
     * @param heroNode
     */
    public void addNodeByNo(HeroNode heroNode) {
        HeroNode temp = head;
        boolean exist = false;
        while (true) {
            if(temp.getNext() == null) {
                break;
            } else if(temp.getNext().getNo() == heroNode.getNo()) {
                exist = true;
                break;
            } else if(temp.getNext().getNo() > heroNode.getNo()) {
                //如果当前节点的下一个节点的序号大于传递进来的数据序号，说明传入数据应该在当前节点和当前节点原来的下一个节点之间
                break;
            }
            //如果不满足条件，则继续判断当前节点的下一个节点的下一个节点是否满足条件
            temp = temp.getNext();
        }
        if(exist) {
            //如果存在该排名，则提示用户, 并且不再添加
            System.out.printf("该排名已经存在[%d]", heroNode.getNo());
            System.out.println();
            return;
        }
        heroNode.setNext(temp.getNext());
        temp.setNext(heroNode);
    }

    public void list() {
        if(head.getNext() == null) {
            System.out.println("链表为空~");
            return;
        }
        //打印当前的列表数据 从头节点的下一个节点开始打印（头节点不打印）
        HeroNode temp = head.getNext();
        //链表为空，不打印信息
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    /**
     * 根据NO修改数据
     * @param heroNode
     */
    public void update(HeroNode heroNode) {
        if(heroNode == null || head.getNext() == null) {
            System.out.println("链表或输入参数为空，无法修改");
            return;
        }
        HeroNode temp = head;
        while (temp.getNext() != null) {
            if(temp.getNext().getNo() == heroNode.getNo()) {
                heroNode.setNext(temp.getNext().getNext());
                temp.setNext(heroNode);
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 根据No删除节点
     * @param heroNode
     */
    public void remove(HeroNode heroNode) {
        if(heroNode == null || head.getNext() == null) {
            System.out.println("链表或输入参数为空，无法修改");
            return;
        }
        HeroNode temp = head;
        while (temp.getNext() != null) {
            if(temp.getNext().getNo() == heroNode.getNo()) {
                temp.setNext(temp.getNext().getNext());
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 清空链表
     */
    public void clear() {
        System.out.println("清空链表~");
        head.setNext(null);
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "head=" + head +
                '}';
    }
}

class HeroNode {
    /**
     * 英雄排名
     */
    private int no;
    /**
     * 英雄名称
     */
    private String name;
    /**\
     * 英雄别名
     */
    private String nickName;
    /**
     * 本英雄排名下一个英雄节点
     */
    private HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
