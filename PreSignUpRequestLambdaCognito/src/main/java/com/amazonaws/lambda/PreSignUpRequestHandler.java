package com.amazonaws.lambda;

import java.util.Map;

import com.amazonaws.lambda.thirdparty.com.google.gson.Gson;
import com.amazonaws.lambda.thirdparty.com.google.gson.GsonBuilder;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class PreSignUpRequestHandler implements RequestHandler<Object, Object> {

    @Override
    public Object handleRequest(Object requestObject, Context context) {
        context.getLogger().log("Input: " + requestObject.toString());

        Map requestObjectMap = (Map) requestObject;

        Map<String, Object> responseData = (Map) requestObjectMap.get("response");
        responseData.put("autoConfirmUser", true);
        responseData.put("autoVerifyEmail", true);
        responseData.put("autoVerifyPhone", false);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonResponse = gson.toJson(requestObject);
        context.getLogger().log("Response JSON: " + jsonResponse);
        
        context.getLogger().log(requestObject.toString());

        return requestObject;
    }

}
