package uz.pdp.appgrpcclient.config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uz.pdp.appgrpcinterface.service.HelloWorldServiceGrpc;

@Configuration
public class GrpcConfiguration {
    @Bean
    public ManagedChannel managedChannel() {
        return ManagedChannelBuilder
                .forTarget("static://localhost:9090")
                .keepAliveWithoutCalls(true)
                .usePlaintext()
                .build();
    }

    @Bean
    public HelloWorldServiceGrpc.HelloWorldServiceBlockingStub blockingStub() {
        return HelloWorldServiceGrpc.newBlockingStub(managedChannel());
    }
}
