package com.json.jsonextraction.Layout;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import lombok.Data;

@Data
public class JsonPatternLayout extends MessageConverter {

    public String convert(ILoggingEvent event) {
        String payloadFromClass1 = event.getMDCPropertyMap().get("postPayload");
        String payloadFromClass2 = event.getMDCPropertyMap().get("requestPayload");

        StringBuilder mergedJson = new StringBuilder();
        mergedJson.append("{");
        if (payloadFromClass1 != null) {
            mergedJson.append("\"postPayload\":").append(payloadFromClass1).append(",");
        }
        if (payloadFromClass2 != null) {
            mergedJson.append("\"requestPayload\":").append(payloadFromClass2);
        }
        mergedJson.append("}");

        return mergedJson.toString();
    }


}
