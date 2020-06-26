package jp.co.internous.node.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.node.model.domain.dto.PurchaseHistoryDto;

@Mapper
public interface TblPurchaseHistoryMapper {
	long insert(Map<String, Object> parameter);
	
	List<PurchaseHistoryDto>findByUserId(@Param("userId") long userId);
	
	@Update("UPDATE tbl_purchase_history SET status = 0 WHERE user_id = #{userId}")
	long logicalDeleteByUserId(@Param("userId") long userId);
	
	
	
	
	

}
