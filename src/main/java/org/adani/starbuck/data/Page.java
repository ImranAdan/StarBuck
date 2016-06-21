package org.adani.starbuck.data;

import java.util.List;

public final class Page<T> {

    private final int start;
    private final int limit;
    private final List<T> items;

    public Page(int start, int limit, List<T> items) {
        this.start = start;
        this.limit = limit;
        this.items = items;
    }

    public int getStart() {
        return start;
    }

    public int getLimit() {
        return limit;
    }

    public List<T> getItems() {
        return items;
    }

    public int size() {
        return items.size();
    }
}
