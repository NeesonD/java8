package com.neeson.serialization;

import java.util.*;

/**
 * Created by daile on 2017/9/13.
 */
public class NLB {

    private static final Map<String, Integer> serverWeightMap = new HashMap(17);
    static Integer pos;

    static {
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.100", 1);
    }

    //并发吞吐量下降
    public static String testRoundRobin() {
        Map<String, Integer> serverMap = new HashMap<>();
        serverMap.putAll(serverWeightMap);
        Set<String> keySet = serverMap.keySet();
        List<String> keyList = new ArrayList<>();
        keyList.addAll(keySet);

        String server = atomPos(keyList);
        return server;

    }

    //并发量越大，越接近轮询算法
    public static String testRandom() {
        Map<String, Integer> serverMap = new HashMap<>(serverWeightMap);

        Set<String> keySet = serverMap.keySet();
        List<String> keyList = new ArrayList<>(keySet);

        Random random = new Random();
        int randomPos = random.nextInt(keyList.size());

        String server = keyList.get(randomPos);
        return server;
    }

    //保证相同客户端一直请求同一台服务器直到，服务器列表变更
    public static String testConsumerHash(String remoteip) {
        Map<String, Integer> serverMap = new HashMap<>(serverWeightMap);

        Set<String> keySet = serverMap.keySet();
        List<String> keyList = new ArrayList<>(keySet);

        int hasjCode = remoteip.hashCode();
        int serverListSize = keyList.size();
        int serverPos = hasjCode % serverListSize;
        return keyList.get(serverPos);
    }

    public static String testWeightRoundRobin() {
        Map<String, Integer> serverMap = new HashMap<>(serverWeightMap);

        Set<String> keySet = serverMap.keySet();
        Iterator<String> it = keySet.iterator();
        List<String> keyList = new ArrayList<>();

        while (it.hasNext()) {
            String server = it.next();
            Integer weight = serverMap.get(server);
            for (int i = 0; i < weight; i++) {
                keyList.add(server);
            }
        }

        String server = atomPos(keyList);
        return server;

    }

    public static String testWeightRandom() {
        Map<String, Integer> serverMap = new HashMap<>(serverWeightMap);

        Set<String> keySet = serverMap.keySet();
        Iterator<String> it = keySet.iterator();
        List<String> keyList = new ArrayList<>();
        while (it.hasNext()) {
            String server = it.next();
            Integer weight = serverMap.get(server);
            for (int i = 0; i < weight; i++) {
                keyList.add(server);
            }
        }

        Random random = new Random();
        int randomPos = random.nextInt(keyList.size());
        String server = keyList.get(randomPos);
        return server;
    }


    private static String atomPos(List<String> list) {
        String server = null;
        synchronized (pos) {
            if (pos >= list.size()) {
                pos = 0;
            }
            server = list.get(pos);
            pos++;
        }
        return server;
    }


}
