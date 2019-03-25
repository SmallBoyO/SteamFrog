package xyz.steamfrog.hello;

import java.util.concurrent.atomic.AtomicLong;

import com.bugsnag.Bugsnag;
import io.sentry.SentryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.sentry.context.Context;
import io.sentry.event.BreadcrumbBuilder;
import io.sentry.event.UserBuilder;

@RestController
public class GreetingController {

    @Autowired
    private Bugsnag bugsnag;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/sentry_test")
    public String sentryTest(){
        unsafeMethod();
        return "haha";
    }

    /**
     * An example method that throws an exception.
     */
    void unsafeMethod() {
        throw new UnsupportedOperationException("You shouldn't call this!");
    }
}
