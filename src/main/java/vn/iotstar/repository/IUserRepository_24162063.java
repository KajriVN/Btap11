package vn.iotstar.repository;

import vn.iotstar.entity.User_24162063;

public interface IUserRepository_24162063 {

    User_24162063 findByEmail(String email);

    User_24162063 findById(int id);

    long count();

    void insert(User_24162063 user);

    void update(User_24162063 user);
}
