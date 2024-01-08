package com.syam.springboot.user.dao;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.*;

import java.io.Serializable;

@Table(value = "user")
@Data
public class DBUser implements Serializable {

    @PrimaryKey
    @CassandraType(type = CassandraType.Name.INT)
    int id;
    @Column("lastname")
    @CassandraType(type = CassandraType.Name.TEXT)
    String lastname;
    @Column("firstname")
    @CassandraType(type = CassandraType.Name.TEXT)
    String firstname;
    @Column("email")
    @CassandraType(type = CassandraType.Name.TEXT)
    String email;
}
