package com.example.market.api;

import com.example.market.service.DailyRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/invest")
@RequiredArgsConstructor
public class InvestApiController {

    private final DailyRecordService dailyRecordService;


}
