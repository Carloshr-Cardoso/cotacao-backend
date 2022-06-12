package com.carlosdev.cotacaobackend.controller;

import com.carlosdev.cotacaobackend.model.Cotacao;
import com.carlosdev.cotacaobackend.util.JsonBodyHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.List;

@RestController
@RequestMapping("/cotacao")
public class cotacaoController {

    @GetMapping("/inicial")
    public String getCotacao() {
        Response response = null;
        try{

            ObjectMapper mapper = new ObjectMapper();
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://economia.awesomeapi.com.br/json/daily/USD-BRL/?start_date=20180901&end_date=20180930")
                    .build(); // defaults to GET

            response = client.newCall(request).execute();

/*
            //Cotacao cotacao = mapper.readValue(response.body().byteStream(), Cotacao.class);

            List<Cotacao> cotacao = mapper.readValue(response.body().byteStream(), new TypeRef<List<Cotacao>>() {});

            //List<Cotacao> cotacao = response.getBody().as(new TypeRef<List<BookingID>>() {});

            System.out.println(cotacao.name);*/


            return response.body().string();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }



    }
}
