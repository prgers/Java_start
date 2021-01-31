package com.prger.utils;

public class Times {

    public interface Block {
        void execute();
    }

    public static void test(Block block) {

        block.execute();
        System.out.println("耗时:" + 100 + "s");
    }

}
