package com.example.demo2.config;

public class BranchContextHolder {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void setBranchContext(String dbname) {
        threadLocal.set(dbname);
    }

    public static String getBranchContext() {
        return threadLocal.get();
    }

    public static void clearBranchContext() {
        threadLocal.remove();
    }
}
