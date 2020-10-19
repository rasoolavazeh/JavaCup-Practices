package ir.javacup.db;

import java.util.*;

public class AbstractRepository<U, T extends IEntity<U>> implements IRepository<U, T>{

    Map<U, T> data = new HashMap<>();
    IdGenerator<U> idGenerator;

    public AbstractRepository(IdGenerator<U> idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public void save(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("entity is null");
        }

        entity.setId(idGenerator.generate());
        data.put(entity.getId(), entity);
    }

    @Override
    public void update(T entity) {
        if (entity.getId() == null) {
            throw new IllegalArgumentException("entity.id is null");
        }

        if (!data.containsKey(entity.getId())) {
            throw new RuntimeException("key not found");
        }

        data.put(entity.getId(), entity);
    }

    @Override
    public T load(U id) {
        if (!data.containsKey(id)) {
            return null;
        }

        return data.get(id);
    }

    @Override
    public List<T> loadAll() {
        Collection<T> tmpVal = data.values();
        List<T> values = new ArrayList<>();
        for (T t : tmpVal) {
            values.add(t);
        }
        return values;
    }

    @Override
    public void delete(U id) {
        if (!data.containsKey(id)) {
            throw new RuntimeException("id not found");
        }

        data.remove(id);
    }

    @Override
    public void deleteAll() {
        data.clear();;
    }
}
