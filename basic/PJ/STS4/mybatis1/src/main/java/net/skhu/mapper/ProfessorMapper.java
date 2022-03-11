package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Professor;

@Mapper
public interface ProfessorMapper {

    @Select("SELECT p.*, d.departmentName FROM professor p LEFT JOIN department d ON p.departmentId = d.id")
    List<Professor> findAll();
}

