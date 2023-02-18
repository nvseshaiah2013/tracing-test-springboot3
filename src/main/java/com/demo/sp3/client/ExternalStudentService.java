package com.demo.sp3.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "http://localhost:8002", name = "external-student-service")
public interface ExternalStudentService {

}
