package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Book;

@Mapper
public interface BookMapper {

	@Select("SELECT b.*, c.categoryName FROM book b LEFT JOIN category c On b.categoryId = c.id;")
	List<Book> findAll();
	
	@Select("SELECT b.*, c.categoryName FROM book b LEFT JOIN category c ON b.categoryId = c.id"
			+ " WHERE b.title LIKE #{name}")
	List<Book> findByTitle(String name);
	
	@Select("SELECT b.*, c.categoryName FROM book b LEFT JOIN category c ON b.categoryId = c.id"
			+ " WHERE b.id = #{id}")
	Book findById(int id);
	
	@Select("SELECT b.*, c.categoryName FROM book b LEFT JOIN category c ON b.categoryId = c.id"
			+ " WHERE c.id = #{id}")
	List<Book> findByCategoryId(int id);
	
	@Insert("INSERT book (title, categoryId, author, price) " + 
			"VALUES (#{title}, #{categoryId}, #{author}, #{price})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	void insert(Book book);
	
    @Update("UPDATE book SET title=#{title}, author=#{author}, " +
            " categoryId=#{categoryId}, price=#{price} WHERE id=#{id}")
    void update(Book book);
	
	@Delete("DELETE FROM book WHERE id=#{id}")
    void delete(int id);
}
