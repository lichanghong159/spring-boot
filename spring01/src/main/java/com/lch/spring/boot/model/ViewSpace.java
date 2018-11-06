package com.lch.spring.boot.model;

import java.io.Serializable;

/**
 * <p></p>
 *
 * @author lichanghong     create by   2018/10/17 14:16
 **/
public class ViewSpace implements Serializable {
    private String viewName;

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    @Override
    public String toString() {
        return "ViewSpace{" +
                "viewName='" + viewName + '\'' +
                '}';
    }
}
