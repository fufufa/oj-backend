package com.why.weioj.judge.codesandbox;

import com.why.weioj.judge.codesandbox.impl.ExampleCodeSandbox;
import com.why.weioj.judge.codesandbox.impl.RemoteCodeSandbox;
import com.why.weioj.judge.codesandbox.impl.ThirdPartyCodeSandbox;

/**
 * 代码沙箱工厂
 */
public class CodeSandboxFactory {

    /**
     * 创建代码沙箱
     * @param type 沙箱类型
     * @return
     */
    public static CodeSandbox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }
}
