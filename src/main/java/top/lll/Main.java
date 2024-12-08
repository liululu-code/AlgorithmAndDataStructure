package top.lll;

import top.lll.linearList.MyList;
import top.lll.linearList.impl.MyArrayListImpl;
import top.lll.linearList.impl.MyLinkedListImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyList<String> myArrayList = new MyLinkedListImpl<>();
        myArrayList.add("lll");
        myArrayList.add("yingzi");
        myArrayList.add(1, "xiaoXia");
        System.out.println(myArrayList);
        System.out.println(myArrayList.remove(0));
        System.out.println(myArrayList);
        myArrayList.set(1, "lll");
        System.out.println(myArrayList);
        System.out.println(myArrayList.contains("lll"));
        System.out.println(myArrayList.get(0));
        System.out.println(myArrayList.size());
        System.out.println(myArrayList.isEmpty());
        myArrayList.clean();
        System.out.println(myArrayList.isEmpty());

        List<String> myList = new ArrayList<>();
    }
}