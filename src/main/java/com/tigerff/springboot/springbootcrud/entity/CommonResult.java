package com.tigerff.springboot.springbootcrud.entity;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 这个类主要用于数据的输出，并且将状态码和提示的信息以及获取的信息进行了封装
 * 屌！！！
 * @param <T>
 */
@AllArgsConstructor
@NoArgsConstructor
//这两个代表全参数的构造函数和一个无参数的构造函数
@Data//就这一个等价于 等价于User里面的那么多get和set 以及toString
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
