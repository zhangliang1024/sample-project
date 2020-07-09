/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package top.lzx.sample.svc.platform.entity.page;

import com.baomidou.mybatisplus.plugins.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: colin
 * @Date: 2019/2/20 13:42
 * @Description:
 * @Version: V1.0
 */
@Data
public class PageUtils implements Serializable {
	private static final long serialVersionUID = 1L;
	//总记录数
	private Integer totalCount;
	//每页记录数
	private Integer pageSize;
	//当前页数
	private Integer pageNum;
	//列表数据
	private List<?> list;
	
	/**
	 * 分页
	 * @param list        列表数据
	 * @param totalCount  总记录数
	 * @param pageSize    每页记录数
	 * @param pageNum    当前页数
	 */
	public PageUtils(List<?> list, Integer totalCount, Integer pageSize, Integer pageNum) {
		this.list = list;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.pageNum = pageNum;
	}

	/**
	 * 分页
	 */
	public PageUtils(Page<?> page) {
		this.list = page.getRecords();
		this.totalCount = page.getTotal();
		this.pageSize = page.getSize();
		this.pageNum = page.getCurrent();
	}

	public PageUtils(){}
}
