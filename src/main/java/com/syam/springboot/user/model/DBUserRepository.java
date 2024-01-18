package com.syam.springboot.user.model;

import com.syam.springboot.user.dao.DBUser;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RestResource(exported = false)
public interface DBUserRepository extends CassandraRepository<DBUser, String> {

    // DELETE

    void deleteByemail(String id);
//
    List<DBUser> findByemail(String email);
//
//    List<DBUser> findAllByid(int id);
}
