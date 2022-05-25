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

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    public JSONObject deletePurchase(@RequestParam String serial) {
        JSONObject jsonObject = new JSONObject();
        Integer integer = searchMapper.deletePurchase(serial);
        if (integer == 1) {
            jsonObject.put("res", "success");
        } else {
            jsonObject.put("res", "failed");
        }
        return jsonObject;
    }

    public JSONObject deleteRedem(@RequestParam String serial) {

        JSONObject jsonObject = new JSONObject();
        Integer integer = searchMapper.deleteRedem(serial);
        if (integer == 1) {
            jsonObject.put("res", "success");
        } else {
            jsonObject.put("res", "failed");
        }

        return jsonObject;
    }

    public JSONObject bankTopup(@RequestParam String card,
                                @RequestParam BigDecimal money){
        JSONObject json = new JSONObject();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        StringBuffer buf = new StringBuffer();
        String serial = format.format(calendar.getTime());
        buf.append(serial);
        buf.append("B");

        Integer integer = searchMapper.insertBankSerial(buf.toString(), card, money);
        searchMapper.updateBankSerial(buf.toString());

        Integer integer2 = searchMapper.updateBank(card, money);
        if (integer == 1 && integer2 == 1) {
            json.put("res", "success");
        } else {
            json.put("res", "failed");
        }


        return json;
    }
}
