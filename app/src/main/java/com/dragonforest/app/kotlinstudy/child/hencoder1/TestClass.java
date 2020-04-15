package com.dragonforest.app.kotlinstudy.child.hencoder1;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * create by DragonForest at 2020/4/2
 */
public class TestClass {
    private static class CallInfo {
        private String data;
        private int callbackId;
        private String method;

        CallInfo(String handlerName, int id, Object[] args) {
            if (args == null) args = new Object[0];
            data = new JSONArray(Arrays.asList(args)).toString();
            callbackId = id;
            method = handlerName;
        }

        @Override
        public String toString() {
            JSONObject jo = new JSONObject();
            try {
                jo.put("method", method);
                jo.put("callbackId", callbackId);
                jo.put("data", data);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jo.toString();
        }
    }


    public void callHandler(String method, Object[] args) {

        CallInfo callInfo = new CallInfo(method, 1, args);

        evaluateJavascript(String.format("window._handleMessageFromNative(%s)", callInfo.toString()));

    }

    private void evaluateJavascript(String script) {
        Log.e("TEst","javascript:" + script);
    }

}
