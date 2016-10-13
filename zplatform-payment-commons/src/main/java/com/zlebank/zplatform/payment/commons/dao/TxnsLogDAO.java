/* 
 * TxnsLogDAO.java  
 * 
 * version TODO
 *
 * 2016年9月13日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.payment.commons.dao;

import com.zlebank.zplatform.payment.exception.PaymentRouterException;
import com.zlebank.zplatform.payment.pojo.PojoTxnsLog;
import com.zlebank.zplatform.payment.quickpay.bean.PayBean;

/**
 * Class Description
 *
 * @author guojia
 * @version
 * @date 2016年9月13日 下午5:31:41
 * @since 
 */
public interface TxnsLogDAO extends BaseDAO<PojoTxnsLog>{

	/**
	 * 保存交易流水信息
	 * @param txnsLog 交易流水pojo
	 */
	public void saveTxnsLog(PojoTxnsLog txnsLog);
	
	/**
	 * 根据交易流水号获取交易流水数据
	 * @param txnseqno 交易流水号
	 * @return 交易流水数据pojo
	 */
	public PojoTxnsLog getTxnsLogByTxnseqno(String txnseqno);
	
	/**
	 * 交易风险控制
	 * @param txnseqno 交易序列号
	 * @param merchId 合作机构
	 * @param subMerchId 商户号
	 * @param memberId 会员号
	 * @param busiCode 业务代码
	 * @param txnAmt 交易金额
	 * @param cardType 银行卡类型
	 * @param cardNo 银行卡号
	 */
	public void riskTradeControl(String txnseqno,String coopInsti,String merchNo,String memberId,String busiCode,String txnAmt,String cardType,String cardNo) throws PaymentRouterException;
	
	/**
     * 初始化支付方和中心应答信息
     * @param txnseqno 交易序列号
     */
	public void initretMsg(String txnseqno);
	
	/**
	 * 更新交易流水中银行卡信息
	 * @param txnseqno
	 * @param payBean
	 */
	public void updateBankCardInfo(String txnseqno,PayBean payBean);
}
