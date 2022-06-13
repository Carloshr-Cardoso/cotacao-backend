package com.carlosdev.cotacaobackend.service;


import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.ResponseBody;
import org.springframework.stereotype.Service;

@Service
public class CotacaoService {
    public String getCotacaoPorPeriodo(String moeda, String dataInicial, String dataFinal){
        try{
            String url = "https://economia.awesomeapi.com.br/json/daily/" + moeda + "/?start_date=" + dataInicial + "&end_date=" + dataFinal;
            //"https://economia.awesomeapi.com.br/json/daily/USD-BRL/?start_date=20180901&end_date=20180930"

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            ResponseBody responseBody = client.newCall(request).execute().body();

            return responseBody.string();

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
