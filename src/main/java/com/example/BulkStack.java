package com.example;

import java.util.Collection;

public interface BulkStack<T> extends Stack<T> {
    void addAll(Collection<T> c); // Notice it works with Collection<T> now
}
