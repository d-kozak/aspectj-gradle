package io.dkozak.aspectj.gradle;

public class Main {

    @Logged
    public static void main(String[] args) {
        foo(10);
        int baz = bar("ay caramba");
    }

    @Logged
    private static int bar(String input) {
        return input.length() / 2;
    }

    @Logged
    private static void foo(int x) {

    }


}
