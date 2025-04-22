package com.why.weioj.judge.codesandbox;

import com.why.weioj.judge.codesandbox.model.ExecuteCodeRequest;
import com.why.weioj.judge.codesandbox.model.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeSandboxProxy implements CodeSandbox {

    private final CodeSandbox codeSandbox;

    public CodeSandboxProxy(CodeSandbox codeSandbox) {
        this.codeSandbox = codeSandbox;
    }

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("代理沙箱请求信息："+executeCodeRequest.toString());
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        log.info("代理沙箱响应："+executeCodeResponse.toString());
        return  executeCodeResponse;
    }
}
