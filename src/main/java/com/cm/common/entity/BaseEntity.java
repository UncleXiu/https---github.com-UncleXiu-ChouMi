package com.cm.common.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

import static javax.accessibility.AccessibleRole.TABLE;

/**
 * @项目名： CM
 * @包名： com.cm.common.entity
 * @类名： BaseEntity
 * @类描述： 实体类基础父类
 * @时间： 2016-8-16
 * @编写者： 修峻青
 */
@MappedSuperclass
public class BaseEntity {

    /*主键ID*/
    @Id
    @GeneratedValue(generator = "RECORD_ID")
    @GenericGenerator( name = "RECORD_ID",strategy = "uuid2")
    @Column(name = "RECORD_ID",length = 40)
    private String ID;

    /*创建时间*/
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.DATE)
    private Date CreatTime = new Date(  );

    /*获取ID*/
    public String getID() {
        return ID;
    }

    /*设置ID*/
    public void setID(String ID) {
        this.ID = ID;
    }

    /*获取创建时间*/
    public Date getCreatTime() {
        return CreatTime;
    }

    /*设置创建时间*/
    public void setCreatTime(Date creatTime) {
        CreatTime = creatTime;
    }
}
