package com.yupi.weioj.judge;

import com.yupi.weioj.judge.strategy.DefaultJudgeStrategy;
import com.yupi.weioj.judge.strategy.JavaLanguageJudgeStrategy;
import com.yupi.weioj.judge.strategy.JudgeContext;
import com.yupi.weioj.judge.strategy.JudgeStrategy;
import com.yupi.weioj.model.dto.questionsubmit.JudgeInfo;
import com.yupi.weioj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext){
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return  judgeStrategy.doJudge(judgeContext);
    }
}
