package com.itheima.service;

import java.util.List;

import com.itheima.commons.Page;
import com.itheima.domain.Apply;
import com.itheima.domain.Customer;

//处理申请有关
public interface ApplyService {
	/**
	 * 生成申请
	 * @param apply
	 */
	void genApply(Apply apply);
	/**
	 * 根据客户查询申请次数
	 * @param customer
	 * @return
	 */
	int checkApplyCount(Customer customer);
	/**
	 * 检查客户是否有未关闭的申请
	 * @param customer
	 * @return
	 */
	boolean checkIsClosed(Customer customer);
	/**
	 * 查询所有未关闭的申请
	 * @param num 用户要看的页码，默认1
	 * @return 封装了所有分页信息的Page对象
	 */
	Page findAllNotClosedApplys(String num);
	/**
	 * 根据申请编号查询申请
	 * @param number
	 * @return
	 */
	Apply findApplyByNumber(String number);
	/**
	 * 更新申请信息
	 * @param apply
	 */
	void update(Apply apply);

}
