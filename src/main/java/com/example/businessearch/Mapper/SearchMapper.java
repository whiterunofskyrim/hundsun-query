package com.example.businessearch.Mapper;

import com.example.businessearch.pojo.Bank;
import com.example.businessearch.pojo.Client;
import com.example.businessearch.pojo.PurchaseResult;
import com.example.businessearch.pojo.RedemResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface SearchMapper {
    List<PurchaseResult> findAll(@Param("fundCode") String fundCode, @Param("clientId") String clientId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    //@Select("select * from sys_user where username like #{username} limit #{pageNum}, #{pageSize}")
    //List<PurchaseResult> selectPage(Integer pageNum, Integer pageSize, String username);


    Integer selectTotal(@Param("fundCode") String fundCode, @Param("clientId") String clientId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    List<PurchaseResult> findAllRedem(@Param("fundCode") String fundCode, @Param("clientId") String clientId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    Integer selectTotalRedem(@Param("fundCode") String fundCode, @Param("clientId") String clientId, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    List<Bank> findAllBank(@Param("bankAccount") String bankAccount, @Param("serialNumber") String serialNumber, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    Integer selectTotalBank(@Param("bankAccount") String bankAccount, @Param("serialNumber") String serialNumber, @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    PurchaseResult findPurchase(@Param("fundCode") String fundCode, @Param("clientId") String clientId);

    Integer deletePurchase(@Param("serial") String serial);

    RedemResult findRedem(@Param("fundCode") String fundCode, @Param("clientId") String clientId);

    Integer deleteRedem(@Param("serial") String serial);

    Integer insertBankSerial(@Param("serial") String serial, @Param("card") String card, @Param("money")BigDecimal money);

    void updateBankSerial(@Param("serial") String serial);

    Integer updateBank(@Param("card") String card, @Param("money")BigDecimal money);
}
