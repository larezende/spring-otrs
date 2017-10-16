package com.larezende.lab.libs.service;

import com.larezende.lab.libs.repository.Repository;
import java.util.Collection;

public abstract class BaseService<TE, T> extends ReadOnlyBaseService<TE, T> {

  private Repository<TE, T> _repository;

  protected BaseService(Repository<TE, T> repository) {
    super(repository);
    _repository = repository;
  }

  public void add(TE entity) throws Exception {
    _repository.add(entity);
  }

  public Collection<TE> getAll() {
    return _repository.getAll();
  }
}