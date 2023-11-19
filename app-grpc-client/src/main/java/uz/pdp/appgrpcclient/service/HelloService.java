package uz.pdp.appgrpcclient.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.appgrpcinterface.service.HelloWorldServiceGrpc;
import uz.pdp.appgrpcinterface.service.Request;

@Service
@RequiredArgsConstructor
public class HelloService {
    private final HelloWorldServiceGrpc.HelloWorldServiceBlockingStub blockingStub;

    public String sayHello(String name) {
        final Request request = Request.newBuilder()
                .setName(name)
                .build();
        return blockingStub.sayHello(request).getMessage();
    }
}
