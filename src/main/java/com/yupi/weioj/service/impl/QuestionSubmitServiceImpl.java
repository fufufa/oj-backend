package com.yupi.weioj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.weioj.common.ErrorCode;
import com.yupi.weioj.exception.BusinessException;
import com.yupi.weioj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.weioj.model.entity.Question;
import com.yupi.weioj.model.entity.QuestionSubmit;
import com.yupi.weioj.model.entity.User;
import com.yupi.weioj.model.enums.QuestionSubmitLanguageEnum;
import com.yupi.weioj.model.enums.QuestionSubmitStatusEnum;
import com.yupi.weioj.service.QuestionService;
import com.yupi.weioj.service.QuestionSubmitService;
import com.yupi.weioj.mapper.QuestionSubmitMapper;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
* @author user
* @description 针对表【question_submit(题目提交)】的数据库操作Service实现
*/
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
    implements QuestionSubmitService{

    @Resource
    private QuestionService questionService;

    /**
     * 提交题目
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    @Override
    public long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser) {
        String language = questionSubmitAddRequest.getLanguage();
        QuestionSubmitLanguageEnum languageEnum = QuestionSubmitLanguageEnum.getEnumByValue(language);
        if(languageEnum == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "编程语言错误");
        }
        long questionId = questionSubmitAddRequest.getQuestionId();
        // 判断实体是否存在，根据类别获取实体
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 是否已点赞
        long userId = loginUser.getId();
        // 每个用户串行提交题目
        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setUserId(userId);
        questionSubmit.setQuestionId(questionId);
        questionSubmit.setCode(questionSubmitAddRequest.getCode());
        questionSubmit.setLanguage(questionSubmitAddRequest.getLanguage());
        // todo 设置初始状态
        questionSubmit.setStatus(QuestionSubmitStatusEnum.WAITING.getValue());
        questionSubmit.setJudgeInfo("{}");
        boolean save = this.save(questionSubmit);
        if(!save) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "输入数据失败");
        }
        return questionSubmit.getId();
    }

}




