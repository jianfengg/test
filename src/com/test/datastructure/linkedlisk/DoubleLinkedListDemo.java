package com.test.datastructure.linkedlisk;

/**
 * @Description: 双向链表
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/3/16 11:22
 * @UpdateDate: 2021/3/16 11:22
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        //初始化一个有序集合
        DoubleLinkedList linkedList = new DoubleLinkedList();
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        //创建要给链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        //加入
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero4);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);

        System.out.println("反转之前");
        doubleLinkedList.list();

        doubleLinkedList.clear();

        doubleLinkedList.list();

        doubleLinkedList.addNodeByNo(hero1);
        doubleLinkedList.addNodeByNo(hero4);
        doubleLinkedList.addNodeByNo(hero2);
        doubleLinkedList.addNodeByNo(hero3);
        doubleLinkedList.addNodeByNo(hero3);
        doubleLinkedList.list();
/*

        System.out.println("反转之后");
        reverseList(doubleLinkedList.getHead());
        doubleLinkedList.list();

        System.out.println("逆向打印单链表，不改变原有结构");
        reversetPrint(doubleLinkedList.getHead());

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
*/

    }

}

class DoubleLinkedList {
    private final HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 在链表最后加入信息
     * @param node2
     */
    public void add(HeroNode2 node2) {
        HeroNode2 temp = head;
        while (true) {
            if(temp.getNext() == null) {
                node2.setPre(temp);
                temp.setNext(node2);
                break;
            }
            temp = temp.getNext();
        }
    }


    public void addNodeByNo(HeroNode2 node2) {
        HeroNode2 temp = head;
        boolean exist = false;
        while (true) {
            if(temp.getNext() == null) {
                break;
            } else if(temp.getNext().getNo() == node2.getNo()) {
                exist = true;
                break;
            } else if(temp.getNext().getNo() > node2.getNo()) {
                break;
            }
            temp = temp.getNext();
        }
        if(exist) {
            //如果存在该排名，则提示用户, 并且不再添加
            System.out.printf("该排名已经存在[%d]", node2.getNo());
            System.out.println();
            return;
        }
        assert temp.getNext() != null;
        temp.getNext().setPre(node2);
        node2.setNext(temp.getNext());
        node2.setPre(temp);
        temp.setNext(node2);
    }

    public void list() {
        if(head.getNext() == null) {
            System.out.println("链表为空~");
            return;
        }
        //打印当前的列表数据 从头节点的下一个节点开始打印（头节点不打印）
        HeroNode2 temp = head.getNext();
        //链表为空，不打印信息
        while (temp != null) {
            System.out.println(temp);
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
}

class HeroNode2 {
    /**
     * 英雄排名
     */
    private int no;
    /**
     * 英雄名称
     */
    private String name;
    /**
     * \
     * 英雄别名
     */
    private String nickName;
    /**
     * 本英雄排名下一个英雄节点
     */
    private HeroNode2 next;

    /**
     * 本英雄排名上一个英雄节点
     */
    private HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
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

    public HeroNode2 getNext() {
        return next;
    }

    public void setNext(HeroNode2 next) {
        this.next = next;
    }

    public HeroNode2 getPre() {
        return pre;
    }

    public void setPre(HeroNode2 pre) {
        this.pre = pre;
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

