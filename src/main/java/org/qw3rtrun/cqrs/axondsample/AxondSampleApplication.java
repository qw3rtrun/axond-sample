package org.qw3rtrun.cqrs.axondsample;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.ResetHandler;
import org.axonframework.eventhandling.tokenstore.TokenStore;
import org.qw3rtrun.cqrs.axondsample.api.cmd.IntroduceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AxondSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AxondSampleApplication.class, args);
    }

}

@Component
@ProcessingGroup("logger")
class Logger {

    @EventHandler
    public void on(Object e) {
        System.out.println(e);
    }

    @ResetHandler
    public void reset() {
        System.err.println("Logger reset");
    }
}

@RestController
class Controller {

    final private CommandGateway commands;

    public Controller(CommandGateway commands) {
        this.commands = commands;
    }

    @RequestMapping("/new/{name}")
    public String ok(@PathVariable("name") String name) {
        commands.send(new IntroduceProduct(name));
        return name;
    }
}
