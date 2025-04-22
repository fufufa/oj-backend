package com.why.weioj.judge;

import com.why.weioj.judge.strategy.DefaultJudgeStrategy;
import com.why.weioj.judge.strategy.JavaLanguageJudgeStrategy;
import com.why.weioj.judge.strategy.JudgeContext;
import com.why.weioj.judge.strategy.JudgeStrategy;
import com.why.weioj.judge.codesandbox.model.JudgeInfo;
import com.why.weioj.model.entity.QuestionSubmit;
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
