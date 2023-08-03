package me.liye;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ye.ly@shopastro-inc.com
 */
@RestController
public class TestController {
    @DubboReference
    TestService testService;

    @RequestMapping("/test")
    public Foo test() {
        return testService.foo();
    }
}
