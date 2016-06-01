package org.adani.starbuck.data.core.models;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "Page")
public class Page<T> {

    private static final int START_INDEX = 0;
    private static final int PAGE_LIMIT = 25;

    private int start;
    private int limit;
    private List<T> elements;

    public Page(){
        this(START_INDEX, PAGE_LIMIT, new ArrayList<>());
    }

    public Page(List<T> items){
        this(0, items.size(), items);
    }

    public Page(int start, int limit, List<T> items){
        this.start = start;
        this.limit = limit;
        elements = items;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<T> getElements() {
        return elements;
    }

    public void setElements(List<T> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
