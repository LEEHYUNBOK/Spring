package net.skhu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    String fileName;
    int size;
    Date modifiedDate;
    String state;
    

    
    @ManyToOne
    @JoinColumn(name = "folderId")
    Folder folder;

}
