package com.example.businessearch.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.businessearch.Mapper.SearchMapper;
import com.example.businessearch.pojo.Bank;
import com.example.businessearch.pojo.PurchaseResult;
import com.example.businessearch.pojo.RedemResult;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HelloService {

    @Autowired
    private SearchMapper searchMapper;

    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam String fundCode,
                                        @RequestParam String clientId) {
        pageNum = (pageNum - 1) * pageSize;
        fundCode = "%" + fundCode + "%";
        clientId = "%" + clientId + "%";
        List<PurchaseResult> data = searchMapper.findAll(fundCode, clientId, pageNum, pageSize);
        Integer total = searchMapper.selectTotal(fundCode, clientId, pageNum, pageSize);
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }

    public Map<String, Object> findPageRedem(@RequestParam Integer pageNum,
                                             @RequestParam Integer pageSize,
                                             @RequestParam String fundCode,
                                             @RequestParam String clientId) {
        pageNum = (pageNum - 1) * pageSize;
        fundCode = "%" + fundCode + "%";
        clientId = "%" + clientId + "%";
        List<PurchaseResult> data = searchMapper.findAllRedem(fundCode, clientId, pageNum, pageSize);
        Integer total = searchMapper.selectTotalRedem(fundCode, clientId, pageNum, pageSize);
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }

    public Map<String, Object> findPageBank(@RequestParam Integer pageNum,
                                            @RequestParam Integer pageSize,
                                            @RequestParam String bankAccount,
                                            @RequestParam String serialNumber) {
        pageNum = (pageNum - 1) * pageSize;
        bankAccount = "%" + bankAccount + "%";

        List<Bank> data = searchMapper.findAllBank(bankAccount, serialNumber, pageNum, pageSize);
        Integer total = searchMapper.selectTotalBank(bankAccount, serialNumber, pageNum, pageSize);
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }

    public JSONObject deletePurchase(@RequestParam String fundCode,
                                     @RequestParam String clientId) {
        PurchaseResult purchaseResult = searchMapper.findPurchase(fundCode, clientId);
        JSONObject jsonObject = new JSONObject();

        if (purchaseResult.getPurchaseStatus().equals("申请中")) {
            searchMapper.deletePurchase(fundCode, clientId);
            jsonObject.put("status", "success");
        } else {
            jsonObject.put("status", "fail");

        }
        return jsonObject;
    }

    public JSONObject deleteRedem(@RequestParam String fundCode,
                                  @RequestParam String clientId) {

        JSONObject jsonObject = new JSONObject();
        RedemResult redemResult = searchMapper.findRedem(fundCode, clientId);
        if (redemResult.getRedemStatus().equals("申请中")) {
            searchMapper.deleteRedem(fundCode, clientId);
            jsonObject.put("status", "success");
        } else {
            jsonObject.put("status", "fail");

        }
        return jsonObject;
    }
}
