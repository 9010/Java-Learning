package com.self.LinkList;

import com.sun.corba.se.spi.ior.ObjectKey;

public class LinkList <E> {
    private Node first = null;
    private Node last = null;
    private int size = 0;

    private void ifIndexIllegal(int index){
        if (index < 0 || index > size -1){
            throw new RuntimeException("Index out of range");
        }
    }

    private Node getNode(int index){
        Node tmp = null;

        if (index <= (size>>1)){
            tmp = first;
            for (int i = 0; i < index; i++){
                tmp = tmp.getNext();
            }
        }
        else{
            tmp = last;
            for(int i = size - 1; i > index; i--){
                tmp = tmp.getPrevious();
            }
        }

        return tmp;
    }

    public void add(E obj){
        Node node = new Node(null, null, obj);

        if (first == null){
            first = node;
            last = node;
        }
        else{
            node.setPrevious(last);
            last.setNext(node);
            last = node;
        }
        size++;
    }

    public void add(int index, E obj){
        Node newNode = new Node(null, null, obj);
        if (index == 0){
            first.setPrevious(newNode);
            newNode.setNext(first);
            first = newNode;
        }
        else if (index == size){
            last.setNext(newNode);
            newNode.setPrevious(last);
            last = newNode;
        }
        else {
            ifIndexIllegal(index);
            Node tmp = getNode(index); //获取要插入的节点位置
            if (tmp != null) {
                newNode.setPrevious(tmp.getPrevious()); //设置新节点前后
                newNode.setNext(tmp);

                //将新节点插入位置
                tmp.getPrevious().setNext(newNode);
                tmp.setPrevious(newNode);
            }
        }
    }

    public E get(int index){
        ifIndexIllegal(index);
        Node tmp = getNode(index);
        return tmp!=null?(E)tmp.element:null;
    }

    public void remove(int index){
        ifIndexIllegal(index);

        Node tmp = getNode(index);
        if (tmp != null) {
            Node up = tmp.getPrevious();
            Node down = tmp.getNext();

            if (up != null) {
                up.setNext(down);
            }
            if (down != null) {
                down.setPrevious(up);
            }
            if (index == 0){
                first = down;
            }
            if (index == size -1){
                last = up;
            }
            size--;
        }
    }

    @Override
    public String toString(){
        Node tmp = first;
        StringBuilder s = new StringBuilder();
        s.append('[');
        while (tmp != null){
            s.append(tmp.getElement() + ",");
            tmp = tmp.getNext();
        }
        s.setCharAt(s.length() - 1, ']');
        return s.toString();
    }

    public static void main(String[] args){
        LinkList<String> list = new LinkList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");

        System.out.println(list);
        list.add(0, "123");
        System.out.println(list);
        list.add(0, "122");
        System.out.println(list);
    }
}
