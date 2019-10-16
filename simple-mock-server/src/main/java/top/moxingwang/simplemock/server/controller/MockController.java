package top.moxingwang.simplemock.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mock")
public class MockController {

    @GetMapping("/string/{methodName}")
    public String mock(@PathVariable(value = "methodName") String methodName) {

        String content = "test";

        return content;
    }
}
