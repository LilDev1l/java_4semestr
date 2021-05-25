package com.example.lab9.db;

import java.io.Serializable;

public interface Identified<PK extends Serializable> {

    /** Возвращает идентификатор объекта */
    public PK getId();
}

