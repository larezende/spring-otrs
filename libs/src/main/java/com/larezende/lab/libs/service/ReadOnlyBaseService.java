package com.larezende.lab.libs.service;


import com.larezende.lab.libs.repository.Repository;

public abstract class ReadOnlyBaseService<TE, T> {

  private Repository<TE, T> repository;

  ReadOnlyBaseService(Repository<TE, T> repository) {
    this.repository = repository;
  }
}