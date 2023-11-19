package uz.pdp.appgrpcclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appgrpcclient.service.HelloService;

@RestController
@RequiredArgsConstructor
@RequestMapping(HelloController.BASE_PATH)
public class HelloController {
    static final String BASE_PATH = "/api/hello";
    private final HelloService helloService;

    @GetMapping("/{name}")
    public HttpEntity<String> sayHello(@PathVariable String name) {
        return ResponseEntity.ok(helloService.sayHello(name));
    }
}
