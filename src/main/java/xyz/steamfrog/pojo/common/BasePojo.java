package xyz.steamfrog.pojo.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
@Slf4j
public class BasePojo {

    private static final ObjectMapper mapper = new ObjectMapper();

    public BasePojo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public Date addTime;

    public Date editTime;

    @Column(name = "is_delete")
    public Boolean delete;

    public void init(){
        this.setAddTime(new Date());
        this.setEditTime(new Date());
        this.setDelete(false);
    }

    @Override
    public String toString() {
        try{
            return mapper.writeValueAsString(this);
        }catch (Exception e){
            log.error("toString失败.",e);
            return "";
        }
    }
}
