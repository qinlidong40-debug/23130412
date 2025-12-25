package com.ie.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@Data
@TableName("t_goods") // 对应数据库表名
public class Goods {
    @TableId(type = IdType.AUTO) // 主键自增
    private Integer id;
    private String gname; // 商品名称
    private Double gprice; // 商品价格
    private String producer; // 生产商
    private String gpicture; // 商品图片路径
}
