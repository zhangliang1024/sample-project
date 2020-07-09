# 列表页的标准写法

请参考代码 [ListViewSample.vue](/src/views/system-settings/ListViewSample.md)

## Take Away

* router 的配置中增加：
  ```json
    meta: {
      keepAlive: true
    }
  ```

* 使用 lzx-base-list-view 作为ListView的根组件
* lzx-base-list-view 中包含四个插槽
  * criteria 条件区
    * 使用 el-row / el-col 组件对条件区分列
    * 使用 lzx-cell 显示条件区的每一个条件
    * 将所有条件绑定到 $data.criteria
  * fullCriteria  完整的条件区，在点击 **更多条件** 后显示
    * 同上
  * default 结果区，用来显示查询结果
    * 使用 el-table 显示查询结果
  * addButton 按钮区，用于添加自定义按钮
    * 如果按钮对应的代码超过30行，将按钮对应的逻辑单独放置到一个 component 中
* 分页相关
  * 实现 gotoPage (pageNum, pageSize, updatePagination) 方法，并绑定到 lzx-base-list-view 组件的 goto-page 事件
  * 在 gotoPage 方法中
    * 调用远程接口获得数据
      * 获得远程数据后
        * 更新 UI
        * 调用 updatePagination 方法，更新分页组件