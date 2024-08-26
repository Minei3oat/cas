package org.apereo.cas.sms;

import org.apereo.cas.config.CasCoreWebAutoConfiguration;
import org.apereo.cas.config.CasMailjetEmailSenderAutoConfiguration;
import org.apereo.cas.notifications.sms.SmsSender;
import org.apereo.cas.test.CasTestExtension;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This is {@link MailjetSmsSenderTests}.
 *
 * @author Misagh Moayyed
 * @since 7.1.0
 */
@SpringBootTest(classes = {
    RefreshAutoConfiguration.class,
    WebMvcAutoConfiguration.class,
    EndpointAutoConfiguration.class,
    WebEndpointAutoConfiguration.class,
    CasCoreWebAutoConfiguration.class,
    CasMailjetEmailSenderAutoConfiguration.class
}, properties = {
    "cas.sms-provider.mailjet.bearer-access-token=test",
    "cas.sms-provider.mailjet.secret-key=test"
})
@Tag("SMS")
@ExtendWith(CasTestExtension.class)
class MailjetSmsSenderTests {
    @Autowired
    @Qualifier(SmsSender.BEAN_NAME)
    private SmsSender smsSender;

    @Test
    void verifyAction() throws Throwable {
        assertFalse(smsSender.send("123456678", "123456678", "Msg"));
    }
}
