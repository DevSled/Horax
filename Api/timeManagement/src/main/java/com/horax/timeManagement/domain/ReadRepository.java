package com.horax.timeManagement.domain;

import java.util.List;

public interface ReadRepository<I, E> extends BasicRepository<I, E> {

    List<E> getAll();
}
