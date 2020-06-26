package jp.co.internous.node.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.internous.node.model.domain.dto.PurchaseHistoryDto;
import jp.co.internous.node.model.mapper.TblPurchaseHistoryMapper;
import jp.co.internous.node.model.session.LoginSession;

@Controller
@RequestMapping("/node/history")
public class PurchaseHistoryController {
	//LoginSessionをインスタンス化します。
	@Autowired
	private LoginSession loginSession;
	
	//TblPurchaseHistoryMapperをインスタンス化
	@Autowired
	TblPurchaseHistoryMapper purchaseHistoryMapper;
	
	@RequestMapping("/")
	public String index(Model m) {
		long userId = loginSession.getUserId();
		List<PurchaseHistoryDto> historyList = purchaseHistoryMapper.findByUserId(userId);
		
		m.addAttribute("historyList", historyList);
		m.addAttribute("loginSession", loginSession);
		return "purchase_history";
	}
	//デリート
	@RequestMapping("/delete")
	@ResponseBody
	public boolean delete() {
		long userId = loginSession.getUserId();
		long result = purchaseHistoryMapper.logicalDeleteByUserId(userId);
		
		return result > 0;
	}
}

