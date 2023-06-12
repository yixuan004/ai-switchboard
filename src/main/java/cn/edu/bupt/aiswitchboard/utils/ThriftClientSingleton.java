package cn.edu.bupt.aiswitchboard.utils;

import cn.edu.bupt.aiswitchboard.client.ThriftClient;

public class ThriftClientSingleton {
    private static ThriftClient instance;

    private ThriftClientSingleton() {
        instance = new ThriftClient("127.0.0.1", 9744);
    }

    public static ThriftClient getInstance() {
        if (instance == null) {
            synchronized (ThriftClientSingleton.class) {
                if (instance == null) {
                    new ThriftClientSingleton();
                }
            }
        }
        return instance;
    }

}
