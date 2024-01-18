package com.syam.springboot.user.dao;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.*;

import java.io.Serializable;
import java.util.UUID;

@Table(value = "useryable")
@Data
public class DBUser implements Serializable {



    @CassandraType(type = CassandraType.Name.UUID)
    UUID ID;
    @Column("lastname")
    @CassandraType(type = CassandraType.Name.TEXT)
    String lastname;
    @Column("firstname")
    @CassandraType(type = CassandraType.Name.TEXT)
    String firstname;
    @PrimaryKey
    @Column("email")
    @CassandraType(type = CassandraType.Name.TEXT)
    String email;

    @Column("hide")
    @CassandraType(type = CassandraType.Name.BOOLEAN)
    boolean hide;
}