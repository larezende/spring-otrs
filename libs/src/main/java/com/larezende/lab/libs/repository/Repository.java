package com.larezende.lab.libs.repository;

public interface Repository<TE, T> extends ReadOnlyRepository<TE, T> {

  void add(TE entity);

  void remove(T id);

  void update(TE entity);
}