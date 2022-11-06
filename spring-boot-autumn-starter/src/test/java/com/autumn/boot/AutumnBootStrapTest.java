package com.autumn.boot;

import com.autumn.context.support.AutumnCoordinate;
import com.autumn.context.support.repository.ExtensionRepository;
import org.junit.Test;

/**
 * @author shenke
 * @since 2022/11/5 13:05
 */
public class AutumnBootStrapTest {

    private ExtensionRepository extensionRepository;

    public void testGetPlugin() {
        AutumnCoordinate coordinate = new AutumnCoordinate(AutumnScenario.BUY, () -> "common");
        AccountValidatePlugin accountValidatePlugin
                = extensionRepository.getExtension(coordinate, AccountValidatePlugin.class);
        accountValidatePlugin.validatePassword();
    }

    @Test
    public void testInterfaces() {
        for (Class<?> in : AccountValidatePlugin.class.getInterfaces()) {
            System.out.println(in.getName());
        }
    }

}
