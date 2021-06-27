package com.example.FinalJavaProject.Controller;


import com.example.FinalJavaProject.Models.Covid19Info;
import com.example.FinalJavaProject.Models.Covid19InfoRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class CanvasjsChartData {

    public List<List<Map<Object, Object>>> getCanvasjsDataList(Iterable<Covid19Info> data) {
        Map<String, Integer> states = new HashMap<>();
        for(Covid19Info info : data) {
            if(states.containsKey(info.getState())) {
                int biggestNumber = Math.max(states.get(info.getState()), Integer.parseInt(info.getPostive()));
                states.remove(info.getState());
                states.put(info.getState(), biggestNumber);
            } else {
                states.put(info.getState(), Integer.parseInt(info.getPostive()));
            }
        }
        Map<Object,Object> map = null;
        List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
        List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
        for (Map.Entry<String, Integer> entry : states.entrySet()) {
            map = new HashMap<Object, Object>();
            map.put("label", entry.getKey());
            map.put("y", entry.getValue());
            dataPoints1.add(map);
        }
        dataPoints1.sort(Comparator.comparing(m -> ((Integer) m.get("y")), Comparator.nullsLast(Comparator.naturalOrder())));
        list.add(dataPoints1);
        return list;
    }
}