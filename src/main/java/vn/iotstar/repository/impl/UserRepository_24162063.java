package vn.iotstar.repository.impl;

import vn.iotstar.entity.User_24162063;
import vn.iotstar.repository.IUserRepository_24162063;

public class UserRepository_24162063 extends AbstractRepository_24162063 implements IUserRepository_24162063 {

    @Override
    public User_24162063 findByEmail(String email) {
        return query(em -> em.createQuery(
                        "SELECT u FROM User_24162063 u WHERE u.email = :email", User_24162063.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst()
                .orElse(null));
    }

    @Override
    public User_24162063 findById(int id) {
        return query(em -> em.find(User_24162063.class, id));
    }

    @Override
    public long count() {
        return query(em -> em.createQuery("SELECT COUNT(u) FROM User_24162063 u", Long.class)
                .getSingleResult());
    }

    @Override
    public void insert(User_24162063 user) {
        transaction(em -> em.persist(user));
    }

    @Override
    public void update(User_24162063 user) {
        transaction(em -> em.merge(user));
    }
}
