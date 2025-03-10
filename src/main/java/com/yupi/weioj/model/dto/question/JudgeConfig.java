package com.yupi.weioj.model.dto.question;

import lombok.Data;

/**
 * 题目限制
 * */
@Data
public class JudgeConfig {
    /**
     * 时间限制(ms)
     */
    private  Long timeLimit;
    /**
     * 内存限制(kb)
     */
    private  Long memoryLimit;
    /**
     * 堆栈限制(ms)
     */
    private  Long stackLimit;

}
