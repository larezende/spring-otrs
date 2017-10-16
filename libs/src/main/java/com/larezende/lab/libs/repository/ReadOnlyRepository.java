package com.larezende.lab.libs.repository;

import com.larezende.lab.libs.entity.Entity;
import java.util.Collection;

public interface ReadOnlyRepository<TE, T> {

  boolean contains(T id);

  Entity get(T id);

  Collection<TE> getAll();
}