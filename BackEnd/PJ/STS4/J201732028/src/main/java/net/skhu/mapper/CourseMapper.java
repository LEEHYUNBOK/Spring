package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Course;

@Mapper
public interface CourseMapper {
	@ResultMap("CourseWithProfessor")
	@Select("SELECT c.*, p.* " +
            "FROM course c JOIN professor p ON c.professorId = p.id ")
    List<Course> findAll();
}
