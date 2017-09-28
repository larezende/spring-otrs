package libs.repository;

import libs.entity.Entity;

import java.util.Collection;

public interface ReadOnlyRepository<TE, T> {

    boolean contains(T id);

    Entity get(T id);

    Collection<TE> getAll();
}