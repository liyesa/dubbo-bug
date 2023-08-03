package me.liye;

import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author ye.ly@shopastro-inc.com
 */
@DubboService
public class TestServiceImpl implements TestService {
    @Override
    public Foo foo() {
        Foo c = new Foo();
        c.setSuccess(false);
        c.setSuccess1(false);
        c.setSuccess2(false);
        c.setSuccess3(false);
        c.setMessage("success");
        return c;
    }
}
