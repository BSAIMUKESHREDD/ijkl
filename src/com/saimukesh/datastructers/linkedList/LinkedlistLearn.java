package com.saimukesh.datastructers.linkedList;


public class LinkedlistLearn {

   /*  LinkedlistLearn list = new LinkedlistLearn();
    list.add(23);
    list.add(42);*/

    private Node head;
    private  Node tail;
    private int size;

    public LinkedlistLearn(){
        this.size=0;
    }

//main decalration of a linkelist
    private class Node {
        private int  value;
        private  Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value,Node next) {
            this.value = value;
            this.next=next;
        }
    }



    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int val){
        if(tail==null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }



    public  void insert(int val,int index){
        if(index==0){
            insertFirst(val);
            return;
        }
        else if(index== size){
            insertLast(val);
            return;
        }
        else{

            Node temp = head;
            for(int i =0;i<index;i++){
                temp = temp.next;

            }
            Node  node = new Node(val,temp.next);
            temp.next= node;
            size++;

        }
    }

    public int deleteFirst(){
    int val = head.value;


        head = head.next;

        if(head==null){
            tail=null;
        }
size--;
        return val;
    }

    public int deleteLast(){

        if(size<=1) return deleteFirst();

            Node secondLast = get(size-2);;
            int val = tail.value;
            tail= secondLast;
            tail.next = null;
            size--;
            return val;
    }


    public  int deleteany(int index){
         if(index == 0) return deleteFirst();
         else if(index==size) return deleteLast();
         else{
             Node nodetoBeDeleted = get(index-1);
             int val = nodetoBeDeleted.next.value;
             nodetoBeDeleted.next=nodetoBeDeleted.next.next;
             return val;
         }

    }

    public Node get(int index){
        Node node = head;
        for(int i=0;i< index;i++){
            node=node.next;
        }
        return node;
    }

    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value+"...");
            temp =temp.next;
        }
    }
}
