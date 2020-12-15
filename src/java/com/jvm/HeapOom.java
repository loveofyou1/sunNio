package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description HeapOom
 * @Author sunlei19
 * @Date 2020/12/15 9:02
 * @Version 1.0
 */
public class HeapOom {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
