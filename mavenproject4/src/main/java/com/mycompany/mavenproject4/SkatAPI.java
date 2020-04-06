/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject4;

import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author sidad
 */
public class SkatAPI {
    // one instance, reuse

    private final OkHttpClient httpClient = new OkHttpClient();

    BowlingAL b = new BowlingAL();

    public static void main(String[] args) throws Exception {

        SkatAPI obj = new SkatAPI();

        System.out.println("Testing 1 - Send Http GET request");
        obj.sendGet();    
    }

    private void sendGet() throws Exception {

        Request request = new Request.Builder()
                .url("http://13.74.31.101/api/points").build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            JSONObject jsonObject = new JSONObject(response.body().string());

            //EXSTRACT THE ARRAY FROM JSON PAYLOAD
            JSONArray jsonArray = jsonObject.getJSONArray("points");

            //SAVES THE TOKEN, FOR POST METHOD
            String token = (String) jsonObject.get("token");

            int[][] test = new int[jsonArray.length()][2];

            // ADDING THE JSON ARRAY TO OUR OWN ARRAY 
            for (int i = 0; i < jsonArray.length(); i++) {
                for (int j = 0; j < jsonArray.getJSONArray(i).length(); j++) {

                    test[i][j] = (int) jsonArray.getJSONArray(i).get(j);

                }

            }
           //running the the bowling algorithm and pass it to sendpost method.
            sendPost(b.PointsSum(test), token);
        }

    }

    private void sendPost(String points, String token) throws Exception {

        // form parameters
        RequestBody formBody = new FormBody.Builder()
                .add("token", token)
                .add("points", points)
                .build();

        Request request = new Request.Builder()
                .url("http://13.74.31.101/api/points")
                .post(formBody)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // Get response body
            System.out.println(response.body().string());
        }

    }
}
