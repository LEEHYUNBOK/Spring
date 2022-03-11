package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Student;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student findById(int id);

    @Select("SELECT s.*, d.departmentName " +
            "FROM student s LEFT JOIN department d ON s.departmentId = d.id")
    List<Student> findAll();

    @Insert("INSERT student (studentNumber, name, departmentId, year) " +
            "VALUES (#{studentNumber}, #{name}, #{departmentId}, #{year})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Student student);
}

