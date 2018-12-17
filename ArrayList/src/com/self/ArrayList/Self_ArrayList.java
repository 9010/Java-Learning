package com.self.ArrayList;

public class Self_ArrayList <E> {
    private Object[] elementDate;
    private int size = 0;

    private static final int DEFAULT_CAPACITY = 10;  //基础容量为10

    private Object[] expansion(Object[] element){  //数组扩容
        Object[] objs = new Object[element.length + (element.length >> 1)];
        System.arraycopy(element, 0, objs, 0, element.length);

        return objs;
    }

    private void ifIndexIllegal(int index){  //索引范围检测，越界则抛出异常
        if(index < 0 || index >= size){
            throw new RuntimeException("index out of range");
        }

    }

    public Self_ArrayList(){  //默认构造函数
        elementDate = new Object[DEFAULT_CAPACITY];
    }

    public Self_ArrayList(int capacity){  //自定义初始容量构造函数
        if(capacity < 0){
            throw new RuntimeException("capacity should be bigger than 1");  //传入容量需要大于1
        }
        else if (capacity == 0){  //等于0则使用默认容量大小
            elementDate = new Object[DEFAULT_CAPACITY];
        }
        else{
            elementDate = new Object[capacity];
        }
    }

    public int size(){  //数组大小
        return size;
    }

    public boolean isEmpty(){  //判断是否空
        return (size == 0) ? true : false;
    }

    public void add(E element){  //向数组添加内容
        if(size == elementDate.length){ //检查数组数量是否足够，不够则扩容
            elementDate = expansion(elementDate);
        }
        elementDate[size++] = element;
    }

    public E get(int index){  //取出数组内容
        ifIndexIllegal(index);
        return (E)elementDate[index];
    }

    public void set(E element, int index){  //设定数组内容
        ifIndexIllegal(index);
        elementDate[index] = element;
    }

    public void remove(E element){ //移除操作
        int i;
        for (i = 0; i < size; i++){
            if (element.equals(get(i))){
                remove(i);
                break;
            }
        }
        if (i >= size){  //不存在返回错误
            System.out.println("No such element");
        }
    }

    public void remove(int index){  //重载移除操作，参数不同
        ifIndexIllegal(index);  //判断索引越界
        int numMove = size - index - 1;
        if(numMove > 0){
            System.arraycopy(elementDate, index + 1, elementDate, index, numMove);
        }
        elementDate[--size] = null;
    }

    @Override
    public String toString(){  //重载toString输出函数
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (int i = 0; i< size; i++){
            sb.append(elementDate[i] + ",");
        }

        sb.setCharAt(sb.length()-1,']');

        return sb.toString();  //打印出[a,b,c,]效果
    }

    public static void main(String[] args){
        Self_ArrayList<String> s1 = new Self_ArrayList<>();

        for(int i = 0;i < 30;i++){
            s1.add(""+i);
        }

        System.out.println(s1);

        s1.remove(6);
        System.out.println(s1);
    }
}
