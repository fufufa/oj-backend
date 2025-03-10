package com.yupi.weioj.service;

import com.yupi.weioj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.weioj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.weioj.model.entity.User;

/**
* @author user
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2025-03-09 17:35:58
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest 题目创建信息
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);


}
