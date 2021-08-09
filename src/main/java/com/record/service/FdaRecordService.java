package com.record.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
@Slf4j
public class FdaRecordService {

    private final WebClient webClient;

    @Autowired
    public FdaRecordService() {
        this.webClient = WebClient.create();
    }

    public String searchFdaRecords(String manufacturerName, Integer limit) {
        // We need to get the header value Link to perform another request when there are other results
        return webClient.get().uri("https://api.fda.gov/drug/drugsfda.json?search=openfda.manufacturer_name.exact:\"{manufacturerName}\"&limit={limit}", manufacturerName, limit)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
