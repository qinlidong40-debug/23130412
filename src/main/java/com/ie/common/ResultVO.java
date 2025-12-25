package com.ie.common;

import lombok.Data;

@Data
public class ResultVO {
    private Integer code; // 0=成功，1=失败
    private String msg;

    // 成功返回
    public static ResultVO success(String msg) {
        ResultVO vo = new ResultVO();
        vo.setCode(0);
        vo.setMsg(msg);
        return vo;
    }

    // 失败返回
    public static ResultVO fail(String msg) {
        ResultVO vo = new ResultVO();
        vo.setCode(1);
        vo.setMsg(msg);
        return vo;
    }
}