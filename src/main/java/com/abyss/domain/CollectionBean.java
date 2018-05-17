package com.abyss.domain;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Abyss on 2018/5/17.
 * description:
 */
public class CollectionBean {
    private List<String> list;
    private Set<String> set;
    private Map<String,String> map;
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "CollectionBean{" +
                "list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }
}
