package com.yupi.weioj.model.dto.questionsubmit;
import lombok.Data;
/**
 * 题目配置
 * */
@Data
public class JudgeInfo {
    /**
     * 程序执行信息
     */
    private  String message;
    /**
     * 内存(KB)
     */
    private  Long memory;
    /**
     * 消耗时间(ms)
     */
    private  Long time;


}
