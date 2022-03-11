package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Person;

@Mapper
public interface PersonMapper {

    @Select("SELECT * FROM person WHERE id = #{id}")
    Person findById(int id);

    @Select("SELECT p.*, c.categoryName " +
            "FROM person p LEFT JOIN category c ON p.categoryId = c.id")
    List<Person> findAll();

    @Insert("INSERT person (name, categoryId, phone, sex, email) " +
            "VALUES (#{name}, #{categoryId}, #{phone}, #{sex}, #{email})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Person person);

    @Update("UPDATE person SET name=#{name}, " +
            " categoryId=#{categoryId}, phone=#{phone}, sex=#{sex}, email=#{email} WHERE id=#{id}")
    void update(Person person);

    @Delete("DELETE FROM person WHERE id=#{id}")
    void delete(int id);

}

