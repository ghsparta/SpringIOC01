package com.demo;

import com.demo.domain.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface PersonMapper {
    Person selectPerson(int id);
    Person selectPersonByName(String name);
    Person selectPersonByIdAndName(@Param("id") int id,@Param("name")String name);
    //[arg1, arg0, param1, param2]
    //[name, id, param1, param2]

    Person selectPersonByInstance(Person p);
    Person selectPersonByMap(Map<String, Object> map);

    Person selectPersonByList(List list1);

    List<Person> selectPersons(int age);
    Map selectPerson();

    Person selectPersonByIdWithDetails(int id);

}
