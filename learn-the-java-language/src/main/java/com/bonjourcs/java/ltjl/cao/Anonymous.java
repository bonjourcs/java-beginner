package com.bonjourcs.java.ltjl.cao;

/**
 * @author Liang Chenghao
 * Description: anonymous class
 * Date: 2018/3/29
 */
public class Anonymous {

    interface Greet {
        void greet();
        void greet(String name);
    }

    public void greet() {

        Greet englishGreet = new Greet() {

            String name = "KX";

            @Override
            public void greet() {
                greet(name);
            }

            @Override
            public void greet(String name) {
                System.out.println("Hello, " + name);
            }
        };

        englishGreet.greet();
    }

}
