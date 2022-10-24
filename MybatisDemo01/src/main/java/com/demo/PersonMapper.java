package com.demo;

import com.demo.domain.Person;


public interface PersonMapper {
    public Person selectPerson(int id);
    Person selectPersonByName(String name);

}
