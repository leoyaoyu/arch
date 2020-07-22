package com.leo.learn.arch.session7;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.Date;

public class ClientThread implements Runnable {

  private String url;
  private Integer executeTime;

  public ClientThread(String url, Integer executeTime) {
    this.url = url;
    this.executeTime = executeTime;
  }

  @Override
  public void run() {
    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    HttpGet httpGet = new HttpGet(url);
    CloseableHttpResponse response = null;
    Date start, end;
    long diff;
    for(int i = 0; i< executeTime + 1 ; i++) {
      start = new Date();
      try {
        response = httpClient.execute(httpGet);
        //HttpEntity responseEntity = response.getEntity();
        //System.out.println("响应状态为:" + response.getStatusLine());
      } catch (ClientProtocolException e) {
        e.printStackTrace();
      } catch (ParseException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        end = new Date();
        if(i > 0) {
          diff = end.getTime() - start.getTime();
          Counter.list.add(diff);
        }
        try {
          if (response != null) {
            response.close();
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    try {
      if (httpClient != null) {
        httpClient.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
