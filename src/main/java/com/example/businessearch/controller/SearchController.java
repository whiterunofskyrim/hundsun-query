package com.example.businessearch.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.businessearch.Mapper.SearchMapper;
import com.example.businessearch.pojo.PurchaseResult;
import com.example.businessearch.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import net.sf.json.JSONObject;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SearchController {

    @Autowired
    private HelloService helloService;


    @RequestMapping(value = "queries/purchase", produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> searchPurchase(@RequestBody JSONObject json) {
        System.out.println("json数据为 : " + json.toString());
        String fundCode = json.getString("fundCode");
        String clientId = json.getString("clientId");
        Integer pageNum = Integer.parseInt(json.getString("pageNum"));
        Integer pageSize = Integer.parseInt(json.getString("pageSize"));
        return helloService.findPage(pageNum, pageSize, fundCode, clientId);
    }

    @RequestMapping(value = "queries/redem", produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> searchRedem(@RequestBody JSONObject json) {
        System.out.println("json数据为 : " + json.toString());
        String fundCode = json.getString("fundCode");
        String clientId = json.getString("clientId");
        Integer pageNum = Integer.parseInt(json.getString("pageNum"));
        Integer pageSize = Integer.parseInt(json.getString("pageSize"));
        return helloService.findPageRedem(pageNum, pageSize, fundCode, clientId);
    }

    @RequestMapping(value = "queries/bank", produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> searchBank(@RequestBody JSONObject jsonObject) {
        String bankAccount = jsonObject.getString("bankAccount");
        String serialNumber = jsonObject.getString("serialNumber");
        Integer pageNum = Integer.parseInt(jsonObject.getString("pageNum"));
        Integer pageSize = Integer.parseInt(jsonObject.getString("pageSize"));
        return helloService.findPageBank(pageNum, pageSize, bankAccount, serialNumber);
    }

    @RequestMapping(value = "delete/purchase", produces = {"application/json;charset=UTF-8"})
    public JSONObject deletePurchase(@RequestBody JSONObject json) {

        String serial = json.getString("serial");
        return helloService.deletePurchase(serial);
    }

    @RequestMapping(value = "delete/redem", produces = {"application/json;charset=UTF-8"})
    public JSONObject deleteRedem(@RequestBody JSONObject json) {

        String serial = json.getString("serial");
        return helloService.deleteRedem(serial);
    }

    //充值
    @RequestMapping(value = "bank/topup", produces = {"application/json;charset=UTF-8"})
    public JSONObject bankTopup(@RequestBody JSONObject json) {

        String card = json.getString("bankAccount");
        String numeric = json.getString("numeric");
        BigDecimal money = new BigDecimal(numeric);
        return helloService.bankTopup(card, money);
    }
}